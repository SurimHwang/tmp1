<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>SignUp</title>
</head>
<body>
	<div style="text-align: center; margin-top:50px">
	 	<h3>회원가입</h3>
		<form action="/signUp" method="get">
			이메일 : <input name="email" type="text" /> <br /> 
			이름 : <input name="userName" type="text" /><br/>
			<br/>
			<button type="submit">완료</button>
			<button type="button" onclick="location.href='login.jsp'">뒤로</button>
		</form>
	</div>