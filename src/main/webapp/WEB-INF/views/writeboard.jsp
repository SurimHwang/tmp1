<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>WriteBoard</title>
</head>
<body>
	<h3>게시글 작성</h3>
	<form action="/insertboard" method="get" enctype="multipart/form-data">
	<table border="1">
	<tr>
		<th>NAME</th>
		<td><textarea rows="1" cols="60" name="bdName" readonly="readonly"><%String name = (String)session.getAttribute("userName");%><%=name %></textarea></td>
	</tr>
	<tr>
		<th>TITLE</th>
		<td><textarea rows="1" cols="60" name="bdTitle"></textarea></td>
	</tr>
	<tr>
		<th>CONTENT</th>
		<td><textarea rows="10" cols="60" name="bdContent"></textarea></td>
	</tr>
	<tr>
				<td width="60">업로드</td><td align="left">
				<input type="file" name="uploadFile"/></td>
			</tr>
	</table>
		<button type="submit" >저장</button>	
	</form>
	<button onclick="location='boardlist.do'" >목록</button>
</body>
</html>
