package com.nhnent.edu.spring_core.config;

import org.springframework.context.annotation.Bean;
import com.nhnent.edu.spring_core.service.PackageMarker;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import com.nhnent.edu.spring_core.component.MemberService;
import com.nhnent.edu.spring_core.component.impl.MemberServiceImpl;
import com.nhnent.edu.spring_core.service.NotificationService;
import com.nhnent.edu.spring_core.service.impl.KakaoServiceImpl;

@Configuration
@ComponentScan("com.nhnent.edu.spring_core")
@Import(DatabaseConfig.class)
public class Config {
	
}