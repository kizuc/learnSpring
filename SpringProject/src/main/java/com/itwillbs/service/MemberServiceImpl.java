package com.itwillbs.service;

import javax.inject.Inject;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.dao.MemberDAOImpl;
import com.itwillbs.domain.MemberDTO;

public class MemberServiceImpl implements MemberService{
	// 처리 작업하는 파일 
	
	// 멤버변수(부모 인터페이스 변수)
	private MemberDAO memberDAO;

	// 직접적으로 전달되지 않고 set메서드로 전달
	@Inject
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public void insertMember(MemberDTO memberDTO) {
		System.out.println("MemberServiceImpl insertMember()");
//	2. MemberServiceImpl 부모인터페이스 MemberDAOImpl 객체생성
		// 부모 = 자식
//		MemberDAO memberDAO=new MemberDAOImpl() ;
		// 메서드 호출
//		memberDAO.insertMember(memberDTO);
		
//	3. 객체생성 new MemberDAOImpl()를 스프링파일 xml에서 생성을 하고
//			자바파일에서 필요하면 스프링파일에서 객체생성한 값을 전달
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
