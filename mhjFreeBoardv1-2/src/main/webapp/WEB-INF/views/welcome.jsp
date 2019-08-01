<%@page import="com.mhjFreeBoardv12.app.freeboard.vo.FreeboardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap, jQuery CDN -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"></link>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
<div hidden="">
<h3>Welcome! minhj Freeboard v1.2 with JSP 2019-07-24</h3>
<%
	//String msg = request.getAttribute("msg") + "";
	//out.println(msg);
	
	//FreeboardVO vo = (FreeboardVO)request.getAttribute("fbOne");
	//out.println(vo.toString());
%>
</div>

<div style="padding: 20px;">
<br><br>
<h3>팀 매칭</h3>
<br>
<h5>절차</h5>
<pre>
1. 5개의 팀 설정
  - 5명 : 1팀, 2팀
  - 6명 : 3팀, 4팀, 5팀
2. 각 팀에 팀장 랜덤으로 배치
3. 각 팀에 팀원 랜덤으로 배치
</pre>
<br>
팀장 명단(5명) : <br>
<input type="text" value="권동욱, 김연하, 민형준, 박일우, 송혜연" size="40">
<br>
팀원 명단(23명) : <br> 
<input type="text" value="강지은, 권주현, 김민수, 김민호, 김보경, 박유림, 박지은, 박지현, 변재민, 성지윤, 오혜주, 윤수진, 이보한, 이수빈, 이은영, 이재덕, 전인우, 정현아, 제갈우석, 조윤주, 진유정, 황다래, 황성연" size="600"/>
<br><br><br>
랜덤 추첨 사이트 : <a href="http://classtrip.mireene.com/everyselection_make_group.php">모두의 뽑기대장</a>
</div>


</div>

</body>
</html>