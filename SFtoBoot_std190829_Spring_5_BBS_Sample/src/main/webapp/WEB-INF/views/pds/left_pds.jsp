<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ctx = request.getContextPath();
%>
<div class="menu_table">
	<ul style="width: 100%;">
		<li class="title">자료실</li>
		<li class="subtitle">자료실</li>
		<li class="menu_item">
			<a href="<%=ctx %>/pds/main" title="자료목록">자료목록</a>
		</li>
		<li class="menu_item">
			<a href="<%=ctx %>/pds/write" title="자료추가">자료추가</a>
		</li>
	</ul>
</div>