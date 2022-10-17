<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>SelectOne</title>
</head>
<body>
	<h3>게시글 보기</h3>
	<form action="/updateboard" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<table border="1">
			<tr>
				<th>BNO</th>
				<td><input type="hidden" name="bno" value="${board.bno}">${board.bno}</td>
			</tr>
			<tr>
				<th>NAME</th>
				<td>${board.bdName}</td>
			</tr>
			<tr>
				<th>TITLE</th>
				<td><input value="${board.bdTitle}" size="58" name="bdTitle"></td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td><textarea rows="10" cols="60" name="bdContent">${board.bdContent}</textarea></td>
			</tr>
			<tr>
				<th>FILE</th>
				<td>
					<div class="form-group file-group" id="file-list">
						<div class="file-add">
							<a href="#this" onclick="addFile()"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>파일추가</a>
						</div>
						<c:forEach items="${files}" var="file">
							<div class="file-input">
								<span class="glyphicon glyphicon-camera" aria-hidden="true"></span>
								<a href="fileDownload.do?fno=${file.fno}">${file.orgFileName}</a>
							  	<%-- <input type="hidden" name="FILE_${file.fno}" value="true"> --%>
							
								<a href='javascript:;' onClick="fnDelFile(${file.fno})" name='file-delete'>삭제</a>
							</div>
						</c:forEach>
					</div>
				</td>
			</tr>
		</table>
		<button type="submit">수정</button>
	</form>
	<a href="deleteboard.do?title=${board.bdTitle}&bno=${board.bno}">삭제</a>&nbsp;&nbsp;
	<button onclick="location='boardlist.do'">목록</button>

	<!-- 댓글 시작 -->
	<ul>
		<c:forEach items="${reply}" var="reply">
			<li>
				<div>
					<form action="/replyModify" method="get">
						<input type="hidden" name="rno" value="${reply.rno}"> 
						<input type="hidden" name="bno" value="${reply.bno}">
						<p>${reply.rpWriter}|${reply.rpDate}</p>
						<textarea rows="5" cols="50" name="rpContent">${reply.rpContent}</textarea>
						<button type="submit">수정</button>
						<button formaction="/replyDelete" type="submit">삭제</button>
					</form>
				</div>
			</li>
		</c:forEach>
	</ul>

	<form action="/replyWrite" method="get">
		<p>
			<label>댓글</label><br /> <label>작성자</label> <input type="text"
				name="rpWriter"
				value=<%String name = (String) session.getAttribute("userName");%>
				<%=name%> readonly="readonly">
		</p>
		<p>
			<textarea rows="5" cols="50" name="rpContent"></textarea>
		</p>
		<p>
			<input type="hidden" name="bno" value="${board.bno}">
			<button type="submit">작성</button>
		</p>
	</form>
	<!-- 댓글 끝 -->
	
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
		function fnDelFile(id){
			console.log(id);
			
			$("a[name='file-delete']").on("click", function(e) {
				e.preventDefault();
				deleteFile($(this));
			}); 
			 
			$.ajax({
				url : "/request_ajax",
				type : "post",
				data : { 
					fno : id
				},
				
				success : function(data){
					console.log(data);
				}
			});
		}
	</script>
</body>
</html>