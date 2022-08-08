package com.itwillbs.dao;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.itwillbs.domain.MemberDTO;
//DB 작업하는 곳
public class MemberDAOImpl implements MemberDAO{
	
	// 멤버변수 
//	private DataSource dataSource;
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	// set 메서드
	@Inject
	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
		simpleJdbcTemplate=new SimpleJdbcTemplate(dataSource);
	}
	
	String insertMember="insert into members(id,pass,name,date) values(?,?,?,?)";
	@Override
	public void insertMember(MemberDTO memberDTO) {
		System.out.println("MemberDAOImpl insertMember()");
		// 디비작업
		simpleJdbcTemplate.update(insertMember, memberDTO.getId(),memberDTO.getPass(),memberDTO.getName(),memberDTO.getDate());
		
	}

	
	// 메서드 정의
//	public void insertMember(MemberDTO memberDTO) {
//		System.out.println("MemberDAOImpl insertMember()");
//	}
}
