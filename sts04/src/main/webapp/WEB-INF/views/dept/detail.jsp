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
	<input type="hidden" name="_method" value="put">
	<div class="form-group">
	    <label for="deptno">deptno</label>
	    <input type="text" class="form-control" value="${bean.deptno }" name="deptno" id="deptno" placeholder="deptno" readonly>
	</div>
	<div class="form-group">
	    <label for="dname">dname</label>
	    <input type="text" class="form-control" value="${bean.dname }" name="dname" id="dname" placeholder="dname" readonly>
	</div>
	<div class="form-group">
	    <label for="loc">loc</label>
	    <input type="text" class="form-control" value="${bean.loc }" name="loc" id="loc" placeholder="loc" readonly>
	</div>
	<button type="button" class="btn btn-primary">수정</button>
	<button type="submit" class="btn btn-primary">수정</button>
	<button type="reset" class="btn btn-default">취소</button>
	
</form>
<script type="text/javascript">
$('form button').eq(1).hide();
$('form button').eq(2).hide();
$('form button').eq(0).click(function(){
	$('form input').removeProp("readonly");
	$(this).css('display','none');
	$('form button').eq(1).show();
	$('form button').eq(2).show();
});

</script>
</body>
</html>










