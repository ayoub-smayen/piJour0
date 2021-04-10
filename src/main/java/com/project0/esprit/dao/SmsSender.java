package com.project0.esprit.dao;

import com.project0.esprit.entity.Colis;
import com.project0.esprit.payload.SmsRequest;

public interface SmsSender {

	void sendSms(SmsRequest smsRequest);
	void  sendSmg(Colis c);
	void sendString(String l , byte[] pic_p);
}

