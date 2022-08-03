package com.itwillbs.service;

import javax.inject.Inject;

import com.itwillbs.dao.BoardDAO;
import com.itwillbs.domain.BoardDTO;

public class BoardServiceImpl implements BoardService{

	//멤버변수
	private BoardDAO boardDAO;
	
	//set메서드
	@Inject
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	@Override
	public void insertBoard(BoardDTO boardDTO) {
		System.out.println("BoardServiceImpl insertBoard()");
		boardDAO.insertBoard(boardDTO);
	}

}
