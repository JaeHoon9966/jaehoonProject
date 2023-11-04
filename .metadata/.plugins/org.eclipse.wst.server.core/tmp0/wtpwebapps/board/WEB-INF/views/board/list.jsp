<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시물 목록</title>
	</head>
	<body>
	<c:if test="${member != null}">
		<p>${member.user_name} 님 환영합니다</p>
		<p><button onclick="location.href='/controller/member/logout'">로그아웃</button><p>		
		<p><button onclick="location.href='/controller/member/mem_list'">회원 목록</button></p>

		<table border="1">
	 		<thead>
  				<tr> 
 		  			<th>번호</th>
   					<th>제목</th>
   					<th>등록일</th>
   					<th>작성자</th>
   					<th>조회</th>
   					<th>추천</th>
  				</tr>
 			</thead>
	 		 <tbody>
	 			<c:forEach items="${list}" var="info">
				<tr>
					<td>${info.notice_yn eq 'Y' ? '[공지]' : info.bo_num}</td>
					<td>
						<a href="/controller/board/view?bo_num=${info.bo_num}">${info.title} 
						<c:if test="${info.cnt > 0}">
						<span style="color:red;">( ${info.cnt} )</span>
						</c:if>
						</a>
					</td>
					<td>
						<fmt:formatDate value="${info.reg_date}" pattern="yyyy-MM-dd" />
					</td>
					<td>${info.user_name}</td>
					<td>${info.view_cnt}</td>
					<td>${info.recommend}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<div>
			<c:if test="${prev}">
				<span>
				[ <a href="/controller/board/list?num=${startPageNum - 1}">이전</a> ]
				</span>
			</c:if>
			<c:forEach begin="${startPageNum}" end="${endPageNum}" var="num">
				<span>
					<c:if test="${select != num}">
					<a href="/controller/board/list?num=${num}">${num}</a>
					</c:if>
					
					<c:if test="${select == num}">
					<b>${num}</b>
					</c:if> 
				</span>
			</c:forEach>
			<c:if test="${next}">		
 				<span>
 					[ <a href="/controller/board/list?num=${endPageNum + 1}">다음</a> ]
 				</span>
			</c:if>
		</div>
		
		<p><button onclick="location.href='/controller/board/write'">게시물 작성</button></p>
	</c:if>
	</body>	
</html>