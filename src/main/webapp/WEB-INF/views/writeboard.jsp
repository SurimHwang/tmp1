<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<title>WriteBoard</title>
</head>
<body>
	<h3>게시글 작성</h3>

	<form action="/insertboard?" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
		<table border="1">
			<tr>
				<th>NAME</th>
				<td><textarea rows="1" cols="60" name="bdName"
						readonly="readonly"><%String name = (String) session.getAttribute("userName");%><%=name%></textarea></td>
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
				<td width="60">첨부파일</td>
				<td><div class="form-group" id="file-list">
					<a href="#this" onclick="addFile()">파일추가</a>
					<!-- <div class="file-group"><input type='file' name='uploadFile'>
						<a href='#this' name='file-delete'>삭제</a>
					</div> -->
					</div>
				</td>
			</tr>
		</table>
		<button type="submit">저장</button>
	</form>
	<button onclick="location='boardlist.do'">목록</button>

	﻿
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script type="text/javascript">
		    $(document).ready(function() {
			$("a[name='file-delete']").on("click", function(e) {
				e.preventDefault();
				deleteFile($(this));
			});
		})
		function addFile() {
			var str = "<div class='file-group'><input type='file' name='files'> <a href='#this' name='file-delete'>삭제</a></div>";
			$("#file-list").append(str);
			$("a[name='file-delete']").on("click", function(e) {
				e.preventDefault();
				deleteFile($(this));
			});
		}
		function deleteFile(obj) {
			obj.parent().remove();
		}
	</script>
</body>
</html>
