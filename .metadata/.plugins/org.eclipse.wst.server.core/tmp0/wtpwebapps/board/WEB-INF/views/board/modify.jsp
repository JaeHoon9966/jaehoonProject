<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시물 수정</title>
	</head>
	<body>
		<c:if test="${msg == null}">
		<form method="post">
			<label>제목</label>
			<input type="text" name="title" value="${view.title}" /><br />
	
			<label>내용</label>
			<textarea cols="50" rows="5" name="content"> ${view.content}</textarea><br />
			
			<p><button type="submit">완료</button>
		</form>
		</c:if>
			<p><button onclick="location.href='/controller/board/list?num=1'">돌아가기</button>
	</body>	
</html>