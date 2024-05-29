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
	<h1>상세페이지</h1>
	<form action="add2.kpc" method="post">
		<div>
			<label for="deptno">deptno</label>
			<input type="text" id="deptno" name="deptno" value="${bean.deptno }" readonly="readonly"/>
		</div>
		<div>
			<label for="dname">dname</label>
			<input type="text" id="dname" name="dname" value="${bean.dname }" readonly/>
		</div>
		<div>
			<label for="loc">loc</label>
			<select id="loc" name="loc">
				<option ${bean.loc eq "서울" ? "selected":"" }>서울</option>
				<option ${bean.loc eq "대전" ? "selected":"" }>대전</option>
				<option ${bean.loc eq "대구" ? "selected":"" }>대구</option>
				<option ${bean.loc eq "부산" ? "selected":"" }>부산</option>
				<option ${bean.loc eq "광주" ? "selected":"" }>광주</option>
			</select>
		</div>
		<button>입력</button>
		<button type="reset">취소</button>
		<button type="button" onclick="window.history.back();">뒤로</button>
	</form>
</body>
</html>








