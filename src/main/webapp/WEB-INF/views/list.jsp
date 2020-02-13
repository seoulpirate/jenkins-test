<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member List</h1>
	<table border='1'>
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>나이</th>
				<th>성별</th>
				<th>거주지</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${userlist}" var="user">
				<tr>
					<td><a href="/biz/view/${user.userid}">${user.userid}</a></td>
					<td>${user.username}</td>
					<td>${user.age}</td>
					<td>${user.gender }</td>
					<td>${user.city }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>