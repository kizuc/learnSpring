package com.itwillbs.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberDTO;
import com.itwillbs.service.MemberService;
import com.itwillbs.service.MemberServiceImpl;

@Controller
public class MemberController {
	// 스프링 객체 생성 방식
	// DI(Dependency Injection 의존관계 주입) 간접적으로 객체를 생성하는 방법 - 자바의 큰 개념
	// 의존관계 : 객체 생성한다~ => 클래스와 클래스의 관계가 의존관계(필요로 하는 관계)
	// 주입 : xml에서 객체를 생성해서 필요로 하는 곳으로 set메서드를 통해 전달시켜준다는 의미
//	MemberServiceImpl과 MemberController는 아무 관계도 아닌 클래스인데 객체를 생성하고 싶을 때 의존관계
	
	// xml에서 객체 생성한 주소값을 저장할 변수를 정의 => 멤버변수 MemberService 부모 인터페이스 저장
//	MemberService memberService=newMemberServiceImpl()
//	부모인터페이스 변수로 업캐스팅돼서 부모 인터페이스에 전달되게끔, private으로 은닉
	
//	xml에서 객체 생성해서 set메서드로 생성한 거 전달하면 부모가 받는
	@Inject
	private MemberService memberService;
//	아래   생성자를 통해 memberService로 간접적으로 전달
	
	// 생성자 (초기값을 memberService 객체 생성한 값으로 받기)
//	@Inject
//	public MemberController(MemberService memberService) {
//		this.memberService= memberService;
//	}
	
	// set메서드로 객체 생성한 값 받게끔 // memberService객체 생성한 값 받기
	@Inject
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
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
//		MemberService memberService=new MemberServiceImpl() ;
		// 메서드호출
//		memberService.insertMember(memberDTO);
		
//	3. 객체 생성 new MemberServiceImpl()를 스프링파일 xml에서 생성을 하고
//		자바파일에서 필요하면 스프링파일에서 객체 생성한 값을 전달(스프링파일 하나만 수정하면 모든 파일이 수정되게끔)
//		메서드 안에서 객체 생성하지 않고 멤버변수 단에서 객체 생성
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
