package tn.esprit.spring.Controller;





import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import tn.esprit.spring.entity.ImageT;
import tn.esprit.spring.repository.ImageRep;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/pi")
public class ImageController {

	@Autowired
	ImageRep imageRepository;

	@PostMapping("/uploade")
	public ResponseEntity<?> uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {


		System.out.println("Original Image Byte Size - " + file.getBytes().length);

		ImageT img = new ImageT(file.getOriginalFilename(), file.getContentType(),

				compressBytes(file.getBytes()));

		imageRepository.save(img);

		return ResponseEntity.ok().build();

	}


	@GetMapping(path = { "/get/{imageName}" })
	public ImageT getImage(@PathVariable("imageName") String imageName) throws IOException {

		final Optional<ImageT> retrievedImage = imageRepository.findByName(imageName);

		ImageT img = new ImageT(retrievedImage.get().getName(), retrievedImage.get().getType(),

				decompressBytes(retrievedImage.get().getPicByte()));

		return img;

	}


	// compress the image bytes before storing it in the database

	public static byte[] compressBytes(byte[] data) {

		Deflater deflater = new Deflater();

		deflater.setInput(data);

		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

		byte[] buffer = new byte[1024];

		while (!deflater.finished()) {

			int count = deflater.deflate(buffer);

			outputStream.write(buffer, 0, count);

		}

		try {

			outputStream.close();

		} catch (IOException e) {

		}

		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();

	}


	// uncompress the image bytes before returning it to the angular application

	public static byte[] decompressBytes(byte[] data) {

		Inflater inflater = new Inflater();

		inflater.setInput(data);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

		byte[] buffer = new byte[1024];

		try {

			while (!inflater.finished()) {

				int count = inflater.inflate(buffer);

				outputStream.write(buffer, 0, count);

			}

			outputStream.close();

		} catch (IOException ioe) {

		} catch (DataFormatException e) {

		}

		return outputStream.toByteArray();

	}
}
