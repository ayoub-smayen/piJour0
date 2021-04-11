package com.project0.esprit.service.impl;


import net.glxn.qrgen.javase.QRCode;
import org.springframework.stereotype.Service;
//import com.google.zxing.qrcode.encoder.QRCode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import com.project0.esprit.service.QRCodeService;

@Service
public class QRCodeServiceImpl implements QRCodeService {

	@Override
	public byte[] generate(String text, int width, int height) {
		
		
		
		
		
		
		
		
		try (ByteArrayOutputStream bos = QRCode.from(text).withSize(width, height).stream(); ) {

		      return bos.toByteArray();

		    } catch (IOException e) {
		      e.printStackTrace();
		      return null;
		    }
		/*try (ByteArrayOutputStream bos = QRCode.from(text).withSize(width, height).stream(); ) {
    
			
			
		      return bos.toByteArray();

		    } catch (IOException e) {
		      e.printStackTrace();
		      return null;
		    }*/
		//return null;
		 }

	@Override
	public void createQRImage(File qrFile, String qrCodeText, int size, String fileType)
			throws WriterException, IOException {
		// TODO Auto-generated method stub
		
		
		Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<>();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix byteMatrix = qrCodeWriter.encode(qrCodeText, BarcodeFormat.QR_CODE, size, size, hintMap);
		// Make the BufferedImage that are to hold the QRCode
		int matrixWidth = byteMatrix.getWidth();
		BufferedImage image = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
		image.createGraphics();

		Graphics2D graphics = (Graphics2D) image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, matrixWidth, matrixWidth);
		// Paint and save the image using the ByteMatrix
		graphics.setColor(Color.BLACK);

		for (int i = 0; i < matrixWidth; i++) {
			for (int j = 0; j < matrixWidth; j++) {
				if (byteMatrix.get(i, j)) {
					graphics.fillRect(i, j, 1, 1);
				}
			}
		}
		ImageIO.write(image, fileType, qrFile);
	}

	@Override
	public byte[] generateQRCode(String data, int width, int height) throws IOException, WriterException {
		 QRCodeWriter qrCodeWriter = new QRCodeWriter();
		   BitMatrix bitMatrix = qrCodeWriter.encode( data, BarcodeFormat.QR_CODE, width, height );
		   byte[] png;
		   try (ByteArrayOutputStream baos = new ByteArrayOutputStream())
		   {
		     MatrixToImageWriter.writeToStream( bitMatrix, "PNG", baos );
		     png = baos.toByteArray();
		   }
		   return png;
	}

	@Override
	public String[] generateQRCodePicture(String data, int width, int height) throws WriterException, IOException {
		 byte[] png = this.generateQRCode( data, width, height );
		   // generate random uuid as file name and save it using Backendless File service
		   String uuid = UUID.randomUUID().toString();
		 
		   String path =   "qr_codes"+ uuid + ".png"+ png ;
		   //Backendless.Files.saveFile
				  
		   // create record in database where we save original data, and a link to generated file
		   Map<String, Object> record = new HashMap<>();
		   record.put( "data", data );
		   record.put( "file", path );
		   Map<String, Object> result = null;
				   //Backendless.Data.of( "qr_codes" ).save( record );
		   // return response with objectId and file path
		   return new String[] { (String) result.get( "objectId" ), path };
		 //}
	}
		
	//}

}
