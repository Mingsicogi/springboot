<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Welcome! minhj Freeboard v1.2 with JSP 2019-07-24</h3>
<%
	String msg = request.getAttribute("msg") + "";
	out.println(msg);
%>
</body>
</html>