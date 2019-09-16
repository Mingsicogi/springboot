<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
private String title;
	private String subject;
	private String limit_time;
<form action="listtest" method="post">
	<input type="text" name="examlist[0].title" value="1번">
	<input type="text" name="examlist[0].subject" value="국어">
	<input type="text" name="examlist[0].limit_time" value="30">
		
	
	<input type="text" name="examlist[1].title" value="2번">
	<input type="text" name="examlist[1].subject" value="영어">
	<input type="text" name="examlist[1].limit_time" value="60">
	
	<input type="text" name="examlist[2].title" value="3번">
	<input type="text" name="examlist[2].subject" value="수학">
	<input type="text" name="examlist[2].limit_time" value="100">
	<input type="submit" value="ggg">
</form>
</body>
</html>