package tn.esprit.spring.Controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

@RestController
@RequestMapping("/pi")
public class ImageController {
	
	@Autowired
	ImageRep img;
	
	@PostMapping("/saveImage")
    Long uploadImage(@RequestParam("file") MultipartFile multipartImage) throws Exception {
        ImageT dbImage = new ImageT();
        dbImage.setName(multipartImage.getName());
        dbImage.setContent(multipartImage.getBytes());

        return img.save(dbImage)
            .getId();
    }
	
	@GetMapping(value = "/image/{imageId}", produces = MediaType.IMAGE_JPEG_VALUE)
	Resource downloadImage(@PathVariable("imageId") Long imageId) {
	    byte[] image = img.findById(imageId)
	      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
	      .getContent();

	    return new ByteArrayResource(image);
	}

}
