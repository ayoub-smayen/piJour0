package com.project0.esprit.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project0.esprit.config.TwilioConfiguration;
import com.project0.esprit.dao.SmsSender;
import com.project0.esprit.entity.Colis;
import com.project0.esprit.payload.SmsRequest;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;


@Service("twilio")
public class TwilioSmsSender implements SmsSender{

	private static final Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSender.class);

    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    
    public void sendSms(SmsRequest smsRequest) {
        if (isPhoneNumberValid(smsRequest.getPhoneNumber())) {
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
            String message = smsRequest.getMessage();
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();
            LOGGER.info("Send sms {}", smsRequest);
        } else {
            throw new IllegalArgumentException(
                    "Phone number [" + smsRequest.getPhoneNumber() + "] is not a valid number"
            );
        }

    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        // TODO: Implement phone number validator
        return true;
    }


	@Override
	public void sendSmg(Colis c) {
		   if (isPhoneNumberValid("+21629966019")) {
	            PhoneNumber to = new PhoneNumber("+21629966019");
	            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
	            String message = c.getAdress();
	            MessageCreator creator = Message.creator(to, from, message);
	            creator.create();
	            LOGGER.info("Send sms {}", c);
	        } else {
	            throw new IllegalArgumentException(
	                    "Phone number [" + c.getNumtel() + "] is not a valid number"
	            );
	        }

		
	}


	@Override
	public void sendString(String l, byte[] pic_p) {
		// TODO Auto-generated method stub
		 if (isPhoneNumberValid("+21629966019")) {
		 PhoneNumber to = new PhoneNumber("+21629966019");
         PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
         String message = l;
         MessageCreator creator = Message.creator(to, from, message);
         creator.create();
         LOGGER.info("Send sms {}", l);
     } else {
         throw new IllegalArgumentException(
                 "Phone number [" + l + "] is not a valid number"
         );
     }
		
	}
}

