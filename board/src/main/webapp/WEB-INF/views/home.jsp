<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Home</title>
	</head>
	<body>
		<form role="form" method="post" autocomplete="off" action="member/login">
			<p>
				<label for="userId">아이디</label>
	  			<input type="text" id="user_id" name="user_id" />
	 		</p>
			<p>
	 			<label for="userPass">비밀번호</label>
	 			<input type="password" id="user_pass" name="user_pass" />
			</p>
			<p>
				<button type="submit">로그인</button>
			</p>
		</form>
			<p><button onclick="location.href='/controller/member/register'">회원가입</button></p>
		<c:if test="${msg == false}">
			<p style="color:#f00;">로그인에 실패했습니다. 아이디 비번을 다시 입력하세요</p>
		</c:if>
	</body>
</html>
