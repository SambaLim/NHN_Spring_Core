package com.nhnent.edu.spring_core.component.impl;

import org.springframework.stereotype.Service;

import com.nhnent.edu.spring_core.component.MemberService;
import com.nhnent.edu.spring_core.domain.Member;
import com.nhnent.edu.spring_core.repository.NotiLogDao;
import com.nhnent.edu.spring_core.service.NotificationService;

@Service
public class MemberServiceImpl implements MemberService {
	
    private final NotificationService notificationService;

    private final NotiLogDao notiLogDao;


    public MemberServiceImpl(NotificationService notificationService, NotiLogDao notiLogDao) {
        this.notificationService = notificationService;
        this.notiLogDao = notiLogDao;
    }


    @Override
    public boolean subscribe(Member member) {
        if (member == null)
            throw new IllegalArgumentException("Member is null");

        if (member.getPhoneNumber() != null && !member.getPhoneNumber().isEmpty()) {
            notificationService.sendNotification(member.getPhoneNumber(), "Success to Subscribe");
            int logId = notiLogDao.insertLog(member, notificationService.getType());
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
