package com.project0.esprit.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.project0.esprit.dao.SmsSender;
import com.project0.esprit.entity.Colis;
import com.project0.esprit.payload.SmsRequest;


@org.springframework.stereotype.Service
public class Service {

	private final SmsSender smsSender;

    @Autowired
    public Service(@Qualifier("twilio") TwilioSmsSender smsSender) {
        this.smsSender = smsSender;
    }

    public void sendSms(SmsRequest smsRequest) {
        smsSender.sendSms(smsRequest);
    }
    public void sendMsg(Colis c) {
    	smsSender.sendSmg(c);;
    	
    }
    
    public void sensStringsms(String cad, byte[] p) {
    	smsSender.sendString(cad,p);
    }
}
