package com.nhnent.edu.spring_core.component.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nhnent.edu.spring_core.component.MemberService;
import com.nhnent.edu.spring_core.domain.Member;
import com.nhnent.edu.spring_core.repository.NotiLogDao;
import com.nhnent.edu.spring_core.service.NotificationService;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private NotificationService smsService;
	
	@Autowired
	@Qualifier("kakaoService")
	private NotificationService kakaoService;
	
	@Autowired
	private NotiLogDao notiLogDao;


	@Override
	public boolean subscribe(Member member) {
		
		if (member == null) {
			throw new IllegalArgumentException("Member is null");
		}
		
        if (member.getPhoneNumber() != null && !member.getPhoneNumber().isEmpty()) {
            smsService.sendNotification(member.getPhoneNumber(), "Success to Subscribe");
            
            int logId = notiLogDao.insertLog(member, "sms");
            System.out.println(notiLogDao.getLog(logId));
        }

        if (member.getPhoneNumber() != null && !member.getPhoneNumber().isEmpty()) {
            kakaoService.sendNotification(member.getPhoneNumber(), "Success to Subscribe");
            
            int logId = notiLogDao.insertLog(member, "kakao");
            System.out.println(notiLogDao.getLog(logId));
        }
		
		return true;
	}

	@Override
	public void init() {
		System.out.println("Member Inited");
	}

	@Override
	public void destroy() {
		System.out.println("Member destroyed");
	}
	
}
