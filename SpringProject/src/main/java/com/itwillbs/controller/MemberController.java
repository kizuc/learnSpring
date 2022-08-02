package com.itwillbs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberDTO;
import com.itwillbs.service.MemberService;
import com.itwillbs.service.MemberServiceImpl;

@Controller
public class MemberController {

	// 가상주소 시작점 http://localhost:8080/myweb/member/insert
	// => /member/insert => member/insertForm.jsp 이동
	@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
	public String insert() {
		// 주소 변경없이 이동
		// WEB-INF/views/member/insertForm.jsp 이동
		
		return "member/insertForm";
	}
	
	// 가상주소 http://localhost:8080/myweb/member/insertPro
	// method="post"
	@RequestMapping(value = "/member/insertPro", method = RequestMethod.POST)
	public String insertPro(MemberDTO memberDTO) {
		// 회원가입 처리 작업	MemberController => MemberServiceImpl => MemberDAOImpl
		System.out.println("MemberController insertPro()");
//		insertPro(HttpServletRequest request)
//		String id = request.getParameter("id");
//		String pass = request.getParameter("pass");
//		String name = request.getParameter("name");
//		
//		// request를 MemberDTO 객체생성해 set호출 값을 저장
//		MemberDTO memberDTO=new MemberDTO();
//		memberDTO.setId(id);
//		memberDTO.setPass(pass);
//		memberDTO.setName(name);

		// insertPro(MemberDTO memberDTO) => 전제 : insertForm.jsp 태그이름과 MemberDTO의 멤버변수 이름이 일치해야한다.
		// 그럼 자동으로 폼에 내용이 MemberDTO에 저장된다.
		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getPass());
		System.out.println(memberDTO.getName());
		
		// 패키지 com.itwillbs.controller	MemberController
		// 패키지 com.itwillbs.service	MemberServiceImpl
		// 패키지 com.itwillbs.dao	 	MemberDAOImpl
		// 패키지 com.itwillbs.domain	 	MemberDTO
		
		
//	1. MemberServiceImpl 객체생성
//		MemberServiceImpl memberServiceImpl = new MemberServiceImpl();
//		메서드 호출
//		memberServiceImpl.insertMember(memberDTO);
		
//	2. MemberServiceImpl 부모인터페이스 객체생성 - 자식만 수정하게끔(수정을 최소화)
		// 부모 = 자식 (업캐스팅)
		MemberService memberService=new MemberServiceImpl() ;
		// 메서드호출
		memberService.insertMember(memberDTO);
		
		// 주소 변경하면서 이동(하는 방식) redirect:로그인가상주소 => 로그인 화면으로 이동
		return "redirect:/member/login";
	}
	
	
	// 가상주소 시작점 http://localhost:8080/myweb/member/login
	// => /member/login => member/loginForm.jsp 이동
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String login() {
		return "member/loginForm";
	}
	
	@RequestMapping(value = "/member/loginPro", method = RequestMethod.POST)
	public String loginPro() {
		System.out.println("MemberController loginPro()");
		
		return "redirect:/member/main";
	}
	
	
	// => /member/main => member/main.jsp 이동
	@RequestMapping(value = "/member/main", method = RequestMethod.GET)
	public String main() {
		return "member/main";
	}
	
	// => /member/info => member/info.jsp 이동
	@RequestMapping(value = "/member/info", method = RequestMethod.GET)
	public String info() {
		return "member/info";
	}
	
	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
	public String update() {
		return "member/updateForm";
	}
	@RequestMapping(value = "/member/updatePro", method = RequestMethod.POST)
	public String updatePro() {
		System.out.println("MemberController loginPro()");
		
		return "redirect:/member/main";
	}

	@RequestMapping(value = "member/delete", method = RequestMethod.GET)
	public String delete() {
		return "member/deleteForm";
	}
	
	@RequestMapping(value = "/member/deletePro", method = RequestMethod.POST)
	public String deletePro() {
		System.out.println("MemberController deletePro()");
		
		return "redirect:/member/main";
	}
	
	@RequestMapping(value = "member/list", method = RequestMethod.GET)
	public String list() {
		return "member/list";
	}

}
