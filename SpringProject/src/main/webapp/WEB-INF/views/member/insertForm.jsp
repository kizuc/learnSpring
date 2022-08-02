<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/insertForm.jsp</title>
</head>
<body>
<!-- action="member/insertPro" -->
<!-- http://localhost:8080/member/member/insertPro -->

<!-- action="/member/insertPro" -->
<!-- http://localhost:8080/member/insertPro -->

<!-- 프로젝트명 -->
<%-- action="<%=request.getContextPath() %>/member/insertPro" --%>
<!-- http://localhost:8080/myweb/member/insertPro -->
<form action="<%=request.getContextPath() %>/member/insertPro" method="post">
아이디 : <input type="text" name="id"><br>
비밀번호 : <input type="password" name="pass"><br>
이름 : <input type="text" name="name">
<input type="submit" value="회원가입">
</form>
</body>
</html>