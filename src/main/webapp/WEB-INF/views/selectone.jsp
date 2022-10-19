<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>SelectOne</title>
</head>
<body>
	<div class="wrap">
		<div class="box">
			<h3>게시글 보기</h3>
			<br/>
		</div>
		<div class="box" style="float:left">
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
				<button type="button" onclick="location='deleteboard.do?title=${board.bdTitle}&bno=${board.bno}'" style="float:right">삭제</button>
				<button type="submit" style="float:right">수정</button>
				<button type="button" onclick="location='boardlist.do'" style="float:right;">목록</button>
			</form>
			
		</div>
		
			<!-- 댓글 시작 -->
		<div class="box" style="float:left;">	
				<ul class="replyClass" >
					<c:forEach items="${reply}" var="reply" varStatus="status">
						<form action="/replyModify" method="get">
							<li style="list-style-position:inside;">
								<input type="hidden" name="rno" value="${reply.rno}"> 
								<input type="hidden" name="bno" value="${reply.bno}">
								${reply.rpWriter}|${reply.rpDate}<br>
								<p id="${status.count}" style="margin-left:100px;">${reply.rpContent}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" onclick="hideReply(${status.count})">수정</button><button formaction="/replyDelete" type="submit" >삭제</button></p>
								<textarea rows="4" cols="50" style="display:none" id="txt${status.count}" name="rpContent">${reply.rpContent}</textarea>
								<button style="display:none" id="upbtn${status.count}" type="submit">수정완료</button>
								<button type="button" id="cancelbtn${status.count}" style="display:none" onclick="location='selectone?bno=${board.bno}'">취소</button>
							</li>
						</form>
					</c:forEach>
				</ul>
		
			<form action="/replyWrite" method="get">
				<br/>
				<p>
					<label>댓글 작성자</label> <input type="text"
						name="rpWriter"
						value=<%String name = (String) session.getAttribute("userName");%>
						<%=name%> readonly="readonly">
				</p>
				<p>
					<textarea rows="5" cols="50" name="rpContent"></textarea>
				</p>
				<p>
					<input type="hidden" name="bno" value="${board.bno}">
					<button type="submit" style="float:right">작성</button>
				</p>
			</form>
			<!-- 댓글 끝 -->
		</div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("a[name='file-delete']").on("click", function(e) {
				e.preventDefault();
				deleteFile($(this));
			}); 
		})

		function hideReply(id){	
			var pTag = document.getElementById(id);
			pTag.style.display="none";
			
			var txtArea = document.getElementById("txt"+id);
			txtArea.style.display="";
			
			var upbtn = document.getElementById("upbtn"+id);
			upbtn.style.display="";
			
			var ccbtn = document.getElementById("cancelbtn"+id);
			ccbtn.style.display="";
		}
	
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
<style>
	 .wrap{
           /*  height: 100%; */
            width: 100%;
            display: flex;
            flex-direction: column;
            align-items: center;
            /* justify-content: center; */
        }
        .box{
             /* flex-basis: 300px; */
            /* height: 100px; */
            /* border: 1px solid black; */
           /*  text-align: center; */
        }
</style>
</html>