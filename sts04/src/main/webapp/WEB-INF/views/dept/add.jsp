<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../template/header.jspf" %>
</head>
<body>
<%@ include file="../template/menu.jspf" %>
<form method="post">
	<div class="form-group">
	    <label for="dname">dname</label>
	    <input type="text" class="form-control" value="${bean.dname }" name="dname" id="dname" placeholder="dname">
	</div>
	<div class="form-group">
	    <label for="loc">loc</label>
	    <input type="text" class="form-control" value="${bean.loc }" name="loc" id="loc" placeholder="loc">
	</div>
	<button class="btn btn-primary">입력</button>
	<button type="reset" class="btn btn-default">취소</button>
	<button type="button" class="btn btn-default" onclick="history.back();">뒤로</button>
</form>
</body>
</html>










