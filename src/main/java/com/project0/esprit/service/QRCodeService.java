package com.project0.esprit.service;

import java.io.File;
import java.io.IOException;

import com.google.zxing.WriterException;

public interface QRCodeService {
	byte[] generate(String text, int width, int height);
	
	 void createQRImage(File qrFile, String qrCodeText, int size, String fileType)
			throws WriterException, IOException;
	 public String[] generateQRCodePicture( String data, int width, int height ) throws WriterException, IOException;
	 public byte[] generateQRCode( String data, int width, int height ) throws IOException, WriterException;
}
