<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
	<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
	<title>게시물 조회</title>
	</head>
	<body>
		<h1>게시물 조회</h1>
		<form method="post">
			<label>제목 :</label>
			${view.title}<br />
			
			<label>작성자:</label>
			${view.user_name}<br />
			
			<label>내용:</label>
			${view.content}<br />
		</form>
 	<c:if test="${view.user_name != write.user_name}">
 		<p><button onclick="location.href='/controller/board/recommend?bo_num=${view.bo_num}'"> 추천하기 </button><p>
 	<!-- 로그인이 되어있고, 본인 글이 아닐경우에만 추천할 수 있도록 버튼을 출력 -->
 	</c:if>      
	<c:if test="${view.user_name == write.user_name}">
		<button onclick="location.href='/controller/board/modify?bo_num=${view.bo_num}'"> 게시물 수정  </button>
		<button onclick="location.href='/controller/board/delete?bo_num=${view.bo_num}'"> 게시물 삭제 </button>
	</c:if>
		<p><button onclick="location.href='/controller/board/list?num=1'"> 돌아가기 </button><p>
	</body>	
	
	<hr />
	<h2>[댓글창]</h2>	
	<ul>
	<c:forEach items="${reply}" var="reply">
		<li>
			<div>
				<p>${reply.user_name} / <fmt:formatDate value="${reply.reg_date}" pattern="yyyy-MM-dd" />
				<c:if test="${reply.user_name == member.user_name}">
				<button type="button" class="replyUpdate" data-re_num="${reply.re_num}">수정</button>
				<button onclick="location.href='/controller/reply/delete?re_num=${reply.re_num}&bo_num=${reply.bo_num}'">삭제</button>
				</c:if>
				</p>
				<p>
				<label>제목 :</label>
					${reply.title}
				</p>
				<p>
				<label>내용 :</label>
					${reply.content}
				</p>
			</div>
		</li>	
	</c:forEach>
	</ul>
	<hr />
	<div>
		<form method="post" action="/controller/reply/write">	
			<h2>[댓글 입력]</h2>
			<p>
			<label>작성자 :</label>
				${member.user_name} 
			</p>
			<p>
			<label>제목 :</label>
				<input type="text" name="title">
			</p>
			<p>
			<label>내용 :</label>
				<textarea rows="5" cols="50" name="content"></textarea>
			</p>
			<p>
				<input type="hidden" name="bo_num" value="${view.bo_num}">
				<button type="submit">댓글 작성</button>
			</p>
		</form>	
	</div>
	
	<script>
 	 $(".replyUpdate").click(function(){
		self.location = "/controller/reply/reply_modify?bo_num=${view.bo_num}" + "&re_num=" + $(this).attr("data-re_num");        
	});  
	</script>
</html>