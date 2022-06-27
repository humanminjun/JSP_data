<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Login</title>
</head>
<body>
<form method="post" action="testLogin.jsp">
	<Label for="userid">아이디 :</Label>
	<input type ="text" name="id" id="userid"><br>
	 
	<Label for="userpwd">암&nbsp;&nbsp;호 :</Label>
	<input type ="password" name="pwd" id="userpwd"><br>
	
	<input type="submit" value="로그인">
</form>
</body>
</html>