<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:requestEncoding value="utf-8"/>   

<jsp:useBean id="nows" class="java.util.Date"/>

<div style="width: 100%; height: 53px; border-bottom: 1px solid #5e5e5e;">
	<div style="width: 100%; height: 100%; clear: both; display: inline-block;">
		<div id="_title_image" style="width:30%; float:left; display: inline;">
			<img alt="" src="<%=request.getContextPath() %>/image/bbslogo1.jpg" style="height: 53px;">
		</div>
		<div id="_title_today" style="width:70%; float:left; text-align: right;">
			<div style="position: relative; top: 27px;">
				<c:choose>
					<c:when test="${empty login  }">
						<a href="<%=request.getContextPath() %>/login">[로그인]</a>
					</c:when>
					<c:otherwise>
						<form action="<%=request.getContextPath() %>/logout" id="_frmLogout">
							<input type="hidden" name="contextPath" value="<%=request.getAttribute("javax.servlet.forward.context_path") %>">
							<input type="hidden" name="servletPath" value="<%=request.getAttribute("javax.servlet.forward.servlet_path") %>">
							<input type="hidden" name="uniCode" value="<%=java.net.URLDecoder.decode( (request.getAttribute("javax.servlet.forward.query_string") + "" )) %>">
							<a title="로그아웃" onclick="document.getElementById('_frmLogout').submit();">[로그아웃]</a>
						</form>
						[${login.name }]님 환영합니다.
						<fmt:formatDate value="${nows }" var="now" pattern="yyyy/MM/dd"/>
						${now }
					</c:otherwise>
				</c:choose>				
			</div>
		</div>
	</div>
</div>
