package com.project0.esprit.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.project0.esprit.service.impl.SsseServiceimpl;
@RestController
@RequestMapping("api")
public class SseEmitterResource {

	@Autowired
    private SsseServiceimpl sseService;

    @GetMapping("/v1/sse/subscription")
    public SseEmitter subscribe() throws IOException {

        SseEmitter emitter = new SseEmitter();

        sseService.add(emitter);
        emitter.onCompletion(() -> sseService.remove(emitter));

        return emitter;
    }

    @GetMapping("/v1/sse/producer/test/{data}")
    public String produce(@PathVariable String data) {

        sseService.getSsEmitters().forEach((SseEmitter emitter) -> {
            try {
                emitter.send(data, MediaType.APPLICATION_JSON);
            } catch (IOException e) {
                emitter.complete();
                sseService.remove(emitter);
                e.printStackTrace();
            }
        });
        return data;
    }
}
