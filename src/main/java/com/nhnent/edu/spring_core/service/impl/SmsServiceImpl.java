package com.nhnent.edu.spring_core.service.impl;

import org.springframework.stereotype.Service;

import com.nhnent.edu.spring_core.service.NotificationService;

@Service("smsService")
public class SmsServiceImpl implements NotificationService {

	@Override
	public boolean sendNotification(String phoneNumber, String message) {
		
		System.out.println("Trying to send message via SMS. phoneNumber: " + phoneNumber);
		System.out.println("Success to send message");
		
		return true;
	}
	
}