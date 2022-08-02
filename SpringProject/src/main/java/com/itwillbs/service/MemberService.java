package com.itwillbs.service;

import com.itwillbs.domain.MemberDTO;

public interface MemberService {
	// 곧통된 틀을 정의
	// 추상메서드(메서드 틀을 정의) 이걸 상속받은 클래스들은 똑같은 메서드를~
	public void insertMember(MemberDTO memberDTO);
	
	
	
}
