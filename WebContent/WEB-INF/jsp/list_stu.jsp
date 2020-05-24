<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>The Student List.....</h1>
<form action="${pageContext.request.contextPath }/delMoreStu" method="post">
	<input type="submit" value="more delete"/>
	<table border="1">
		<tr>
			<td><input type="checkbox"/></td>
			<td>student_id</td>
			<td>name</td>
			<td>semester</td>
			<td>operation</td>
		</tr>
		<c:forEach items="${page.list }" var="student">
			<tr>
				<td><input type="checkbox" name="student_ids" value="${student.student_id }"/></td>
				<td>${student.student_id }</td>
				<td>${student.name}</td>
				<td>${student.semester }</td>
	<td><a href="${pageContext.request.contextPath }/deleteStu?student_id=${student.student_id }">delete</a></td>
			</tr>
		</c:forEach>
<tr>
	<td>current${page.currentPage } page/total${page.totalPage }page</td>
	<td><a href="${pageContext.request.contextPath }/findAllPage?currentPage=1">the first page</a></td>
	<td>
	<!-- currentPage-1 -->
	<!-- if the currentPage is not the first page-->
<c:if test="${page.currentPage !=1}">
	<a href="${pageContext.request.contextPath }/findAllPage?currentPage=${page.currentPage-1}">the front page </a>
</c:if>
	<!-- currentPage+1 -->
	<!-- f the currentPage is not the last page -->
<c:if test="${page.currentPage != page.totalPage }">
	<a href="${pageContext.request.contextPath }/findAllPage?currentPage=${page.currentPage+1}">the next page </a>
</c:if>
	
	<a href="${pageContext.request.contextPath }/findAllPage?currentPage=${page.totalPage }">the last page</a>
	</td>
</tr>
	</table>
</form>	
</body>
</html>