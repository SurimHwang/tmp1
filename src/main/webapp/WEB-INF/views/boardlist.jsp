<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>BoardList</title>
</head>
<body>
	<h3>게시판</h3>
	<table border="1">
		<col width="30px">
		<col width="80px">
		<col width="200px">
		<col width="100px">
		<tr>
			<th>No</th>
			<th>Name</th>
			<th>Title</th>
			<th>Date</th>
			
		</tr>
		<c:forEach items="${boardlist}" var="item">
			<tr>
				<td>${item.bno}</td>
				<td>${item.bdName}</td>
				<td><a href="selectone?bno=${item.bno}">${item.bdTitle}</a></td>
				<td>${item.bdDate}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" align="right">
				<a href="writeboard.do?userName=${userName}">글쓰기</a>
			</td>
		</tr>
	</table>
</body>
</html>
