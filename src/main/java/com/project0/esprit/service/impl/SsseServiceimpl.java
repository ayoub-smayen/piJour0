package com.project0.esprit.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.project0.esprit.service.SseService;


@Service
public class SsseServiceimpl implements SseService {

	 private final List<SseEmitter> emitters = new ArrayList<SseEmitter>();

	    @Override
	    public boolean add(SseEmitter sseEmitter) {
	        return this.emitters.add(sseEmitter);
	    }

	    @Override
	    public boolean remove(SseEmitter sseEmitter) {
	        return this.emitters.remove(sseEmitter);
	    }

	    @Override
	    public List<SseEmitter> getSsEmitters() {
	        return this.emitters;
	    }


}
