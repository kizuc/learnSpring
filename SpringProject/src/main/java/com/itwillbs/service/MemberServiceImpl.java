package com.itwillbs.service;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.dao.MemberDAOImpl;
import com.itwillbs.domain.MemberDTO;

public class MemberServiceImpl implements MemberService{
	// 처리 작업하는 파일 

	@Override
	public void insertMember(MemberDTO memberDTO) {
		System.out.println("MemberServiceImpl insertMember()");
//		2. MemberServiceImpl 부모인터페이스 MemberDAOImpl 객체생성
		// 부모 = 자식
		MemberDAO memberDAO=new MemberDAOImpl() ;
		// 메서드 호출
		memberDAO.insertMember(memberDTO);
		
	}
	// 메서드 정의
//	public void insertMember(MemberDTO memberDTO) {
//		System.out.println("MemberServiceImpl insertMember()");
//		// MemberDAOImpl 객체생성
//		MemberDAOImpl memberDAOImpl = new MemberDAOImpl();
//		// 메서드 호출
//		memberDAOImpl.insertMember(memberDTO);
//	}
	
	
	
}
