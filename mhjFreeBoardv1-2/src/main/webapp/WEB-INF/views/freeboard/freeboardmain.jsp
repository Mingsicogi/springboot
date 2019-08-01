<%@page import="com.mhjFreeBoardv12.app.freeboard.vo.FreeboardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Freeboard Main</title>

<!-- Bootstrap, jQuery CDN -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"></link>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet"></link>

<!-- Custom js, css -->
<script type="text/javascript" src="/resources/js/freeboard/freeboardmain.js"></script>


<link rel="stylesheet" type="text/css" href="/resources/css/freeboard/freeboardmain.css"></link>

</head>
<body id="mainBody">
	<!-- Main Header Bar Menu -->
	<div id="mainHeaderBar">
		<div id="mainHeaderBarMenu">
			<a href=""><span>menu 1</span></a>
			<a href=""><span>menu 2</span></a>
			<a href=""><span>menu 3</span></a>
			<a href=""><span>menu 4</span></a>
			<a href=""><span>menu 5</span></a>
			<a href=""><span>menu 6</span></a>
			<a href=""><span>menu 7</span></a>
		</div>
	</div>
	<!-- Main Header -->
	<div id="mainHeader">
		<h1>Free Board</h1>
	</div>

	<!-- Main Body -->
	<div id="mainContainer">
		<!-- Contents View -->
		<div id="mainContentsView">
			<div id="mainContentsList">
				<table id="tblMainContentList" class="table table-hover">
				    <colgroup>
        				<col width="60px"/>
        				<col width="320px"/>
        				<col width="100px"/>
        				<col width="180px"/>
        				<col width="70px"/>
				    </colgroup>
					<tr>
						<th>No</th>	
						<th>Title</th>	
						<th>Writer</th>	
						<th>Date</th>	
						<th>Hit</th>
					</tr>
					<%
						List<FreeboardVO> lst = (List<FreeboardVO>)request.getAttribute("postList");
						
						int i = 0;
						for(FreeboardVO vo : lst){
							out.println("<tr>");
							out.println("<td>" + vo.getSeq() + "</td>");
							out.println("<td><a href=\"/freeboard/postdetail?seq=" + vo.getSeq() + "\">" + vo.getTitle() + "</a></td>");
							out.println("<td>" + vo.getId() + "</td>");
							out.println("<td>" + vo.getWdate().toLocaleString() + "</td>");
							out.println("<td>" + vo.getReadcount() + "</td>");
							out.println("</tr>");
							i++;
							if(i>9) break;
						}
					%>
				</table>
				<a class="btn pull-right" style="border: solid 1px; margin-right: 5px;">Write</a>
			</div>
		</div>

		<!-- Side view in container -->
		<div id="mainSideView">
			<!-- Sign in and Sign up  -->
			<div id="mainAccountView">
				<!-- Button for open modal view Attribute : data-target, data-toggle-->
				<button id="btnMainSignin" type="button" class="btn btn-primary"
					data-toggle="modal" data-target="#signinModal">Sign in</button>
				<!-- <input id="btnMainSignin" type="button" value="Sign in" onclick="echoTest()"> -->
				<br><br> 
				<a onclick="echoTest()" href="">Find ID/PW</a>	&nbsp;&nbsp;&nbsp;&nbsp; 
				<a href="" data-toggle="modal" data-target="#signupModal">Sign up here!</a>
			</div>
			<!-- Show category  -->
			<div id="mainCategoryView">mainCategory</div>
		</div>
	</div>
	
	<!-- 로그인 모달 폼 -->
	<jsp:include page="../account/signinmodal.jsp"></jsp:include>
	
	<!-- 회원가입 모달 폼 -->
	<jsp:include page="../account/signupmodal.jsp"></jsp:include>
</body>
</html>