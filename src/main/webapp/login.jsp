<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Login</title>
</head>
<body>
	<h3>로그인</h3>
	<form action="/login_ok.jsp" method="post">
		이메일 : <input name="email" type="text"/> <br/> 
		이름 : <input name="userName" type="text"/><br/>
		<button type="submit">로그인</button>
	</form>
	<form action="signup.jsp" method="post">
		<button>회원가입</button>
	</form>