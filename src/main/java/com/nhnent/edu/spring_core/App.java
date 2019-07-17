package com.nhnent.edu.spring_core;

import com.nhnent.edu.spring_core.component.MemberService;
import com.nhnent.edu.spring_core.config.Config;
import com.nhnent.edu.spring_core.domain.Member;
import com.nhnent.edu.spring_core.service.NotificationService;
import com.nhnent.edu.spring_core.service.impl.KakaoServiceImpl;
import com.nhnent.edu.spring_core.service.impl.SmsServiceImpl;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
    	
    	try(AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class)) {

    		MemberService memberService = applicationContext.getBean(MemberService.class);
    		memberService.subscribe(new Member("임성호", "01036155931"));    		
    		
    	}
    	
    	
    }
}
