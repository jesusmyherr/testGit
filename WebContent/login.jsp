<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login in</title>
</head>
<body>
 	<form action="${pageContext.request.contextPath }/login" method="post">
 		username:<input type="text" name="username"/>
 		<br>
 		password:<input type="text" name="password"/>
 		<br>
 		<input type="submit" value="submit"/> 	
 	</form>
</body>
</html>