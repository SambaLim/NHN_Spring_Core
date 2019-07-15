package com.nhnent.edu.spring_core;

import com.nhnent.edu.spring_core.config.Config;
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
    	//classicalStyle();
    	//dependencyInjectionStyle();
    	
    	try(AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class)) {
    		NotificationService kakaoService = applicationContext.getBean("kakaoService", NotificationService.class);
    		kakaoService.sendNotification("01036155931", "Welcome to KAKAO Service");
    		
    		NotificationService smsService = applicationContext.getBean("smsService", NotificationService.class);
    		smsService.sendNotification("01036155931", "Welcome to SMS Service");
    	}
    	
    }
    
/*    private static void classicalStyle() {
    	
    	// 원래는 new를 해줘서 실행함
    	NotificationService notificationService = new SmsServiceImpl();
        notificationService.sendNotification("01036155931", "Welcome to WAVUS Service");
    }
    
    private static void dependencyInjectionStyle() {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class)) {
            NotificationService notificationService = applicationContext.getBean(NotificationService.class);
            notificationService.sendNotification("01036155931", "Welcome to WAVUS Service");
        }
    }*/
}
