<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>SelectOne</title>
</head>
<body>
<h3> 게시글 보기 </h3>
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
	<!-- 댓글 시작 -->
	<ul>
		<li>
			<div>
				<p>첫번째 댓글 작성자</p>
				<p>첫번째 댓글</p>
			</div>
		</li>
		<li>
			<div>
				<p>두번째 댓글 작성자</p>
				<p>두번째 댓글</p>
			</div>
		</li>
		<li>
			<div>
				<p>세번째 댓글 작성자</p>
				<p>세번째 댓글</p>
			</div>
		</li>
	</ul>
	
	<div>
	<form action="/insertreply" method="get">
		<p>
		<label>댓글</label><br/>
		 <label>작성자</label>
		 <input type="text" name="rpWriter" value=<%String name = (String)session.getAttribute("userName");%><%=name %> readonly="readonly">
		</p>
		<p>
		<textarea rows="5" cols="50" name="rpContent"></textarea>
		</p>
		<p>
		<button type="submit">작성</button>
		</p>
	</form>
	</div>
	<!-- 댓글 끝 -->
</body>
</html>

      