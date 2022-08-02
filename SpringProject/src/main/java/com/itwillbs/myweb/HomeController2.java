package com.itwillbs.myweb;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 주소매핑 가능!
@Controller
public class HomeController2 {

	
	// 주소는 자동으로 뽑아옴 뽑아온 주소가 /home2랑 같으냐~
	@RequestMapping(value = "/home2", method = RequestMethod.GET)
	public String home2(Locale locale, Model model) {
		// 주소 변경 없이 이동하는 방식
		return "home2";
	}
	
	@RequestMapping(value = "/home3", method = RequestMethod.GET)
	public String home3() {
		
		return "home3";
	}
	
	
}
