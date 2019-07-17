package com.nhnent.edu.spring_core.component;

import com.nhnent.edu.spring_core.domain.Member;

public interface MemberService {
	
	boolean subscribe(Member member);
	
	void init();
	void destroy();
	
}