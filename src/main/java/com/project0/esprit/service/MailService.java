
package com.project0.esprit.service;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.project0.esprit.entity.UserSendMail;
import com.project0.esprit.repository.ImageRepository;
import com.project0.esprit.repository.ProductRepository;
import com.project0.esprit.datentity.User;
import com.project0.esprit.entity.ImageT;
import com.project0.esprit.entity.Product1;
@Service
public class MailService {

	
	private JavaMailSender javaMailSender;

	
	@Autowired
	ProductRepository imageRepository;
	/**
	 * 
	 * @param javaMailSender
	 */
	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	/**
	 * 
	 * @param user
	 * @throws MailException
	 */
	
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

	public void sendEmail(UserSendMail user) throws MailException {

		/*
		 * This JavaMailSender Interface is used to send Mail in Spring Boot. This
		 * JavaMailSender extends the MailSender Interface which contains send()
		 * function. SimpleMailMessage Object is required because send() function uses
		 * object of SimpleMailMessage as a Parameter
		 */

		SimpleMailMessage mail = new SimpleMailMessage();
		
		mail.setTo(user.getEmailAddress());
		mail.setSubject("Pi");
		mail.setText("Java spring boot Project consomi Tusni");

		/*
		 * This send() contains an Object of SimpleMailMessage as an Parameter
		 */
		javaMailSender.send(mail);
	}
	public void sendEmail2(User user) throws MailException {

		/*
		 * This JavaMailSender Interface is used to send Mail in Spring Boot. This
		 * JavaMailSender extends the MailSender Interface which contains send()
		 * function. SimpleMailMessage Object is required because send() function uses
		 * object of SimpleMailMessage as a Parameter
		 */

		SimpleMailMessage mail = new SimpleMailMessage();
		
		mail.setTo(user.getEmail());
		mail.setSubject("consomiTunsi");
		mail.setText("hello to  consomi Tusni");

		/*
		 * This send() contains an Object of SimpleMailMessage as an Parameter
		 */
		javaMailSender.send(mail);
	}
	/**
	 * This function is used to send mail that contains a attachment.
	 * 
	 * @param user
	 * @throws MailException
	 * @throws MessagingException
	 * @throws javax.mail.MessagingException 
	 */
	public void sendEmailWithAttachment(UserSendMail user) throws MailException, MessagingException, MessagingException {

		MimeMessage message = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		 List<Product1> imgs= (List<Product1>) imageRepository.findAll();
		 
		 
		 
		 

		helper.setTo(user.getEmailAddress());
		helper.setSubject("PI dev consomi tunsi");
		helper.setText("Please find the attached document below.  producting  eyouta happy day for you by  ur freind ayoub :) , ");

		
		ClassPathResource classPathResource = new ClassPathResource("Attachment.pdf");
		
		for (Product1 im : imgs) {
			final InputStreamSource fileStreamSource = new ByteArrayResource(decompressBytes(im.getProductImg()));
			helper.addAttachment(im.getProductname(), fileStreamSource);
		}
		//helper.addAttachment(classPathResource.getFilename(), classPathResource);

		javaMailSender.send(message);
	}

}
