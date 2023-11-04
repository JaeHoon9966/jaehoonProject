<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원 목록</title>
	</head>
	<body>
	<c:if test="${member != null}">
		<p>${member.user_name} 님 환영합니다</p>		
		<p><button onclick="location.href='/controller/member/logout'">로그아웃</button><p>
		<p><button onclick="location.href='/controller/board/list?num=1'">게시판 목록</button></p>

	<div>
		<select name="searchType">
			<option value="user_name" ${searchType eq 'user_name' ? 'selected' : ''}>이름</option>
			<option value="sc_name" ${searchType eq 'sc_name' ? 'selected' : ''}>학교</option>
			<option value="hobby" ${searchType eq 'hobby' ? 'selected' : ''}>취미</option>
		</select>
  		<input type="text" name="keyword" value="${keyword}" />
  		<button type="button" id="searchBtn">검색</button>
	</div>
		<p>
		<table border="1">
	 		<thead>
  				<tr> 
 		  			<th>이름</th>
   					<th>아이디</th>
   					<th>성별</th>
   					<th>취미</th>
   					<th>가입일</th>
   					<th>학교</th>
  				</tr>
 			</thead>
	 		 <tbody> 
	 			<c:forEach items="${mem_list}" var="info">
				<tr>
					<td>${info.user_name}</td>
					<td>${info.user_id}</td>
						<td>
						<c:choose>
							<c:when test="${info.gender eq 'M'}">
							남자
							</c:when>
							<c:when test="${info.gender eq 'W'}">
							여자
							</c:when>
						</c:choose>
					</td>
					<td>${info.hobby eq 'N' ? '선택 안함' : info.hobby}</td>
					<td>
						<fmt:formatDate value="${info.reg_date}" pattern="yyyy-MM-dd" />
					</td>
					<td>${empty info.sc_name ? '선택 안함' : info.sc_name}</td>
				</tr>
				</c:forEach>		
			</tbody>
		</table>
	</c:if>
	
	<script>
	document.getElementById("searchBtn").onclick = function () {
		    
		let searchType = document.getElementsByName("searchType")[0].value;
		let keyword =  document.getElementsByName("keyword")[0].value;
		location.href = "/controller/member/mem_list?" + "&searchType=" + searchType + "&keyword=" + keyword;
	};
	</script>

	</body>	
</html>