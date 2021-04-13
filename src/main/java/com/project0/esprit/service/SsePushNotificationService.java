package com.project0.esprit.service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.project0.esprit.entity.Product1;
import com.project0.esprit.repository.ProductRepository;

@Service
@EnableScheduling
public class SsePushNotificationService {

	final DateFormat DATE_FORMATTER = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
	final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();
	
	
	@Autowired
	
	private ProductRepository prodrep;
	
	

	public void addEmitter(final SseEmitter emitter) {
		emitters.add(emitter);
	}

	public void removeEmitter(final SseEmitter emitter) {
		emitters.remove(emitter);
	}

	@Async
	@Scheduled(fixedRate = 5000)
	public void doNotify() throws IOException {
		
		List<Product1> prod = prodrep.findAll();
		List<SseEmitter> deadEmitters = new ArrayList<>();
		emitters.forEach(emitter -> {
			try {
				for(Product1  p:  prod ) {
					
					emitter.send(SseEmitter.event()
							.data(DATE_FORMATTER.format(new Date()) + " : " + UUID.randomUUID().toString()));
					emitter.send(SseEmitter.event()
							.data(DATE_FORMATTER.format(p.getCreatedAt()) + " : " + UUID.randomUUID().toString()  +  " : " + p.getBrand() + " " +  p.getCodebar() +  " : " + p.getProductdescription()
							+  "<img [src]= 'data:image/jpeg;base64,' + " + p.getProductImg().toString() + "/>"
									));
					
				}
				
			} catch (Exception e) {
				deadEmitters.add(emitter);
			}
		});
		emitters.removeAll(deadEmitters);
	}

}
