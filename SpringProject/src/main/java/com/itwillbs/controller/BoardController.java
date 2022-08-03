package com.itwillbs.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.BoardDTO;
import com.itwillbs.service.BoardService;

@Controller
public class BoardController {
	
	// BoardServiceImpl 부모 인터페이스 BoardService 멤버변수
	private BoardService boardService;

	// set 메서드(왜 생략이 됐는지 이해)
	@Inject
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	
	
	// 가상주소 시작점 http://localhost:8080/myweb/board/write
	// => /board/write => board/insertForm.jsp 이동
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String write() {
		// 주소 변경없이 이동
		// WEB-INF/views/board/writeForm.jsp 이동
		
		return "board/writeForm";
	}
	
	@RequestMapping(value = "/board/wirtePro", method = RequestMethod.GET)
	public String writePro(BoardDTO boardDTO) {
		System.out.println("BoardController writePro()");
		// 부모 인터페이스 BoardService 자식클래스 BoardServiceImpl
		// void insertBoard(BoardDTO boardDTO) 메서드 정의
		// 부모 인터페이스 BoardDAO 자식클래스 BoardDAOImpl
		// void insertBoard(BoardDTO boardDTO) 메서드 정의
		
		// BoardService = BoardServiceImpl 객체생성
		// 메서드 호출
		
		return "redirect:/board/list";
	}
}
