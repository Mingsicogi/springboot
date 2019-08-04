<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/tests/jsregularexpressiontest.js"></script>
</head>
<body>
<h1>Regular Expression test</h1>

공백 포함불가 <a id="regex1"></a> <br>
<input type="text" id="txt1" placeholder="이거 잘 안됨...">
<input type="text" id="result1" size="50">
<br>
핸드폰번호 체크 <a id="regex2"></a><br> 
<input type="text" id="txt2">
<input type="text" id="result2" size="50">
<br>
숫자만 입력 가능 <a id="regex3"></a><br>
<input type="text" id="txt3">
<input type="text" id="result3" size="50">
<br>
한글, 영문만 입력 가능 <a id="regex4"></a> <br>
<input type="text" id="txt4">
<input type="text" id="result4" size="50">
<br>
이메일만 입력 가능<a id="regex5"></a> <br>
<input type="text" id="txt5">
<input type="text" id="result5" size="50">
<br>
8자리 이하 특수문자만 입력 가능<a id="regex6"></a> <br>
<input type="text" id="txt6">
<input type="text" id="result6" size="50">
<br>


단어찾기 I, my, me, mine \b(I|my|me|mine)\b
</body>
</html>