package com.nhnent.edu.spring_core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nhnent.edu.spring_core.domain.Member;
import com.nhnent.edu.spring_core.service.MemberService;
import com.nhnent.edu.spring_core.service.NotificationService;

@Service
public class MemberServiceImpl implements MemberService {
	
/*	@Autowired
	private NotificationService smsService;
	
	@Autowired
	@Qualifier("kakaoService")
	private NotificationService kakaoService;*/
	
	private NotificationService smsService;
	private NotificationService kakaoService;
	
	public MemberServiceImpl(NotificationService smsService, NotificationService kakaoService) {
		this.smsService = smsService;
		this.kakaoService = kakaoService;
	}

	@Override
	public boolean subscribe(Member member) {
		
		if (member == null) {
			throw new IllegalArgumentException("Member is null");
		}
		
        if (member.getPhoneNumber() != null && !member.getPhoneNumber().isEmpty()) {
            smsService.sendNotification(member.getPhoneNumber(), "Success to Subscribe");
        }

        if (member.getPhoneNumber() != null && !member.getPhoneNumber().isEmpty()) {
            kakaoService.sendNotification(member.getPhoneNumber(), "Success to Subscribe");
        }
		
		return true;
	}
	
}