<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<tiles:insertAttribute name="header"/>

</head>
<body>

<div id="body_wrap">
	<div id="main_wrap">
		<tiles:insertAttribute name="topinfo"/>
		<tiles:insertAttribute name="topmenu"/>
	</div>
	
	<div id="middle_wrap">
		<div id="content_wrap">
			<%-- <div id="content_title_wrap">
				<div class="title">${doc_title }</div>
			</div> --%>
			<tiles:insertAttribute name="main"/>
		</div>
	</div>
	
	<div id="footer_wrap">
		<tiles:insertAttribute name="footer"/>
	</div>
</div>

<script type="text/javascript">
function getContextPath(){
	return '<%=request.getContextPath() %>';
}
$(document).ready(function(){
	
});
</script>

</body>
</html>