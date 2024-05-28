<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../template/menu.jspf" %>
	<h1>dept list page</h1>
	<table>
		<thead>
			<tr>
				<th>부서번호</th>
				<th>부서명</th>
				<th>지역</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="bean">
			<tr>
				<td><a href="#">${bean.deptno }</a></td>
				<td><a href="#">${bean.dname }</a></td>
				<td><a href="#">${bean.loc }</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="add.kpc">입력</a>
</body>
</html>






