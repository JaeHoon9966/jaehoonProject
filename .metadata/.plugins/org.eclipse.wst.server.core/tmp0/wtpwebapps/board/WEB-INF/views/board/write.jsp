<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시물 작성</title>
	</head>
	<body>
		<form method="post">		
			<input type="checkbox" id="notice_yn" name="notice_yn" onchange="notice_yn(this);" />
			<label for="notice_yn" >공지글 설정</label><br />
					<label>제목</label>
			<input type="text" name="title" /><br />
					<label>내용</label>
			<textarea cols="50" rows="5" name="content"></textarea><br />
			<button type="submit">작성</button>		
		</form>
	</body>	
		<p><button onclick="location.href='/controller/board/list?num=1'"> 돌아가기 </button><p>
	
	<script type="text/javascript">
		function notice_yn(obj) {
			var checked = obj.checked;	
			if(checked) {
				obj.value = "Y";
			}else{
				obj.value = "N";
			}
		}
	</script>
</html>