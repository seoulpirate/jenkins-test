<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="user" value="${userVO}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 결과 창</title>
</head>
<body>
	<ul>
		<li>이름 : ${user.username}</li>
		<li>나이 : ${user.age}</li>
		<li>아이디 : ${user.userid}</li>
	</ul>
</body>
</html>