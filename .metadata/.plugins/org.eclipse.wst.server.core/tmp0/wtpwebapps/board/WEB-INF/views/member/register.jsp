<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
	<head>
	<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
	<title>회원가입</title> 
	</head>
	<body>*는 필수 입력
		<form name="frm" method="post" autocomplete="off" onsubmit="return memReg(this);">
 		<p>
			<label for="user_id">* 아이디</label>
  			<input type="text" id="user_id" name="user_id" />
			<input type="button" value="중복확인" onclick="idCheck()">
 		</p>  
 		<p>
			<label for="user_pass">* 패스워드</label>
			<input type="password" name="user_pass" id="user_pass"/>
 		</p>
 		<p>
			<label for="user_pass">* 패스워드 확인</label>
			<input type="password" id="user_pass2"/>
 		</p>
 		<p>
			<label>* 닉네임</label>
			<input type="text" id="user_name" name="user_name"/>
 		</p>
 		<p>
			<label>* 성별</label>
			<input type="radio" id="gender1" name="gender" value="M">남
			<input type="radio" id="gender2" name="gender" value="W">여
		</p>
		<p>
			<label>[선택] 취미</label>
			<input type="checkbox" id="hobby1" name="hobby" value="농구">
			<label for="hobby1">농구</label>
			<input type="checkbox" id="hobby2" name="hobby" value="축구">
			<label for="hobby2">축구</label>
			<input type="checkbox" id="hobby3" name="hobby" value="탁구">
			<label for="hobby3">탁구</label>
			<input type="checkbox" id="hobby4" name="hobby" value="야구">
			<label for="hobby4">야구</label>
			<input type="checkbox" id="hobby5" name="hobby" value="볼링">
			<label for="hobby5">볼링</label>
		</p>
		<p>
			<label>[선택] 학교</label>
			<select id="sc_num" name="sc_num">
				<option selected value = 0>선택</option>
				<c:forEach items="${scList}" var="info">
					<option value="${info.sc_num}">${info.sc_name}</option>
				</c:forEach>
			</select>
		</p>
 		<p>
   			<button type="submit" id="submit" disabled="disabled">가입</button>  
 		</p>
 		</form>
 		<p>
			<button onclick="location.href='/controller/'">돌아가기</button>
 		</p>
 	</body>
	
	<script>
		function memReg(obj) {
	
		if (obj.user_pass.value.length == 0) {
			alert("패스워드를 입력하세요");
			obj.user_pass.focus();
			return false;
	    }
		
		if (obj.user_pass2.value.length == 0) {
			alert("패스워드확인을 입력하세요");
			obj.user_pass2.focus();
			return false;
	    }
		
		if (obj.user_pass.value != obj.user_pass2.value) {
			alert("비밀번호가 일치하지 않습니다.");
			obj.user_pass2.value = "";
			obj.user_pass2.focus();
			return false;
		} 
		
		if (obj.user_name.value == '') {
	        alert("닉네임을 작성해 주세요");
	        obj.user_name.focus();
	        return false;
	    }
		
		if (obj.gender.value == '') {
	        alert("성별을 선택해 주세요");
	        obj.gender1.focus();
	        return false;
	    }	
		if (confirm("회원가입을 하시겠습니까?")){
			alert("회원가입이 되었습니다")
			//$("#frm").submit();
			return true;
		} else {
			return false;
		}
	}	
	
	function idCheck() {
	    
	    var user_id = $("#user_id").val();
	    
	    if(user_id.replace(/ /g, "") == "") { 
	        alert("아이디에는 공백이 들어갈 수 없습니다.");        
	    } else {             
	        if(user_id.replace(/ /g, "").length > 0) {
	            $.ajax({
	                type : 'POST', 
	                data: {
	                	"user_id" : user_id
	                },
	                url: "/controller/member/idCheck",
	                success: function(count) {
	                    if(count > 0) {
	                        alert("해당 아이디 존재");    
	                        $("#submit").attr("disabled", false);
	                        window.location.reload();
	                    } else {
	                        alert("사용가능 아이디");
	                        $("#user_id").attr("readonly","readonly");
	                        $("#submit").removeAttr("disabled");
	                    }            
	                },
	                error: function(xhr, status, error) {
	                    alert("아이디를 입력해주세요..");
	                }        
	            });
	        } else {
	            alert("아이디를 입력해주세요...");
	        }        
	    }
	}
    </script>
</html>