<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>Login</title>
</head>
<body>
	<div style="margin-top:50px; text-align: center;">
		<h3>로그인</h3>
		<form action="/login" method="get" style="display:inline-block;">
			이메일 : <input name="email" type="text" /> <br /> 
			이름 : <input name="userName" type="text" /><br />
			<br/>
			<button type="submit">완료</button>
			<button type="button" onclick="location='/signuppage.do'" formmethod="post">회원가입 페이지</button>
		</form>
	</div>
</body>
</html>
