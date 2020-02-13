<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 폼</title>
</head>
<body>
	<form action="/biz/register" method="post">
		Name : <input type="text" name="username" /><br />
		Age : <input type="number" name="age" /><br /> 
		ID : <input type="text" name="userid" /><br /> 
		<input type="submit" value="가입하기" />
	</form>
</body>
</html>