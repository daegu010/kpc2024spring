<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../template/header.jspf" %>
</head>
<body>
<%@ include file="../template/menu.jspf" %>
<p class="text-right"><a href="add" class="btn btn-primary" role="button">입력</a></p>
<table class="table">
	<thead>
		<tr>
			<th>사번</th>
			<th>부서명</th>
			<th>지역</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list }" var="bean">
		<c:url value="${bean.deptno }" var="detailLink"></c:url>
		<tr>
			<td><a href="${detailLink}">${bean.deptno }</a></td>
			<td><a href="${detailLink}">${bean.dname }</a></td>
			<td><a href="${detailLink}">${bean.loc }</a></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>











