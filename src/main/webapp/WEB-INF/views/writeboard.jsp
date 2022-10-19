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
	<div style="width:100%; display:flex; flex-direction: column; align-items:center;">
		<h3>게시글 작성</h3>
		<form action="/insertboard?" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
			<table border="1">
				<tr>
					<th>BNO</th>
					<td>${nextBno}</td>
				</tr>
				<tr>
					<th>NAME</th>
					<td><input name="bdName"  style="width:443px" readonly="readonly" value="<%String name = (String) session.getAttribute("userName");%><%=name%>"></td>
				</tr>
				<tr>
					<th>TITLE</th>
					<td><input name="bdTitle" type="text" style="width:443px"></td>
				</tr>
				<tr>
					<th>CONTENT</th>
					<td><textarea rows="10" cols="60" name="bdContent"></textarea></td>
				</tr>
				<tr>
					<td width="60">첨부파일</td>
					<td>
						<div class="form-group" id="file-list">
							<button type="button" onclick="javascript:addFile()">파일추가</button>
						</div>
					</td>
				</tr>
			</table>
			</br>
			<button type="submit" style="float:right">저장</button>
			<button type="button" onclick="location='boardlist.do'" style="float:right">목록</button>
		</form>
	</div>
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
