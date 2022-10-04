<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>SelectOne</title>
</head>
<body>
<form action="/updateboard" method="get">
	<table border="1">
		<tr>
			<th>NAME</th>
			<td>${board.bdName}</td>
		</tr>
		<tr>
			<th>TITLE</th>
			<td><textarea rows="1" cols="60" readonly="readonly" name="bdTitle">${board.bdTitle}</textarea></td>
		</tr>
		<tr>
			<th>CONTENT</th>
			<td><textarea rows="10" cols="60" name="bdContent">${board.bdContent}</textarea></td>
		</tr>
	</table>
	<button type="submit" formmethod="get">수정</button>
	</form>
	<a href="deleteboard.do?title=${board.bdTitle}">삭제</a>&nbsp;&nbsp;
	<button onclick="location='boardlist.do'">목록</button>
	
</body>
</html>

      