package com.itwillbs.dao;

import com.itwillbs.domain.MemberDTO;

public class MemberDAOImpl implements MemberDAO{
	// DB 작업하는 곳
	public void insertMember(MemberDTO memberDTO) {
		System.out.println("MemberDAOImpl insertMember()");
	}
	
	// 메서드 정의
//	public void insertMember(MemberDTO memberDTO) {
//		System.out.println("MemberDAOImpl insertMember()");
//	}
}
