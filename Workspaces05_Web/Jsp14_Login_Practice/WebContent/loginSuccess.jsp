<%@page import="com.ncs.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
	setTimeout(function() {
		location.href='index.jsp';
	}, 3000);
</script>
<h2>Hello Spring!</h2>
로그인 성공!!
</body>
</html>