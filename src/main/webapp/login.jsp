<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>Login</title>
</head>
<body>
	<h3>로그인</h3>
	<form action="/login" method="get">
		이메일 : <input name="email" type="text" /> <br /> 
		이름 : <input name="userName" type="text" /><br />
		<button type="submit">로그인</button>
	</form>
	<form action="/signuppage.do" method="post">
		<button>회원가입 페이지</button>
	</form>

</body>
</html>

