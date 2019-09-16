<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%String ctx = request.getContextPath();%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="/teacher/main">STUDENT</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="<%=ctx %>/teacher/main">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          	시험관리
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
        <div class="dropdown-divider"></div>
        	<!-- 시험목록 조회 페이지로 이동 -->
          <a class="dropdown-item" href="<%=ctx %>/student/examlist">시험목록</a>
           <!-- 성적통계 페이지로 이동 -->
          <a class="dropdown-item" href="<%=ctx %>/student/grades">성적관리</a>          
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          	학사관리
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
        <div class="dropdown-divider"></div>
           <!-- 수강이력을 조회할 수 있는 페이지로 이동 -->
          <a class="dropdown-item" href="#">수강이력</a>        
        </div>
      </li>
    </ul>
	<nav class="navbar navbar-light bg-light">
		<c:choose>
			<c:when test="${curruser.auth != 3 }">
				<script type="text/javascript">
					alert('학습자로 로그인해주세요.');
					location.href="/login/main";
				</script>
			</c:when>
			<c:otherwise>
				<ul class="navbar-nav mr-auto">
			      <li class="nav-item">			      
			      	<form action="<%=request.getContextPath() %>/logout" id="_frmLogout">
					<input type="hidden" name="contextPath" value="<%=request.getAttribute("javax.servlet.forward.context_path") %>">
					<input type="hidden" name="servletPath" value="<%=request.getAttribute("javax.servlet.forward.servlet_path") %>">
					<input type="hidden" name="uniCode" value="<%=java.net.URLDecoder.decode( (request.getAttribute("javax.servlet.forward.query_string") + "" )) %>">
					<input type="submit" class="btn btn-light align-middle" value="로그아웃">
					</form>
			      </li>
			      <li class="nav-item align-middle">
			      		[${curruser.name }]님 환영합니다.
			      		<fmt:formatDate value="${nows }" var="now" pattern="yyyy/MM/dd"/>
						${now }
			      </li>
			    </ul>
				
				
				
			</c:otherwise>
		</c:choose>	
	</nav>
  </div>
</nav>