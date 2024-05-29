<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../template/menu.jspf" %>
	<h1>입력페이지</h1>
	<form action="add2.kpc" method="post">
		<div>
			<label for="dname">dname</label>
			<input type="text" id="dname" name="dname"/>
		</div>
		<div>
			<label for="loc">loc</label>
			<select id="loc" name="loc">
				<option>서울</option>
				<option>대전</option>
				<option>대구</option>
				<option>부산</option>
				<option>광주</option>
			</select>
		</div>
		<button>입력</button>
		<button type="reset">취소</button>
		<button type="button" onclick="window.history.back();">뒤로</button>
	</form>
</body>
</html>








