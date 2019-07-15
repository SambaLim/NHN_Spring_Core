package com.nhnent.edu.spring_core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.nhnent.edu.spring_core.service.NotificationService;
import com.nhnent.edu.spring_core.service.impl.KakaoServiceImpl;

@Configuration
@ComponentScan("com.nhnent.edu.spring_core")
public class Config {
/*
    @Bean
    public NotificationService notificationService() {
    	return new KakaoServiceImpl();
    }
*/
}