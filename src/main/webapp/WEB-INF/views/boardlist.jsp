<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>BoardList</title>
</head>
<body>
	<div class="wrapper">
		<p><h2>게시판</h2>${userName}님 안녕하세요!&nbsp;&nbsp;&nbsp;<button onclick="location.href='../../login.jsp'">로그인 페이지</button></p>
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
					<button onclick="location.href='writeboard.do?userName=${userName}'">글쓰기</button>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
<style type="text/css">
	.wrapper{
		text-align: center;
	}
	table{
		margin-left:auto;
		margin-right:auto;
	}
</style>
