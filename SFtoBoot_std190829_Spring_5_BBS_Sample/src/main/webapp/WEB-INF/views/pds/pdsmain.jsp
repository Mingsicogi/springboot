<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<table class="list_table" style="">
	<colgroup>
		<col width="50">
		<col width="100">
		<col width="300">
		<col width="50">
		<col width="50">
		<col width="50">
		<col width="100">
		<col width="50">
	</colgroup>
	<thead>
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>다운로드</th>
			<th>조회수</th>
			<th>다운수</th>
			<th>작성일</th>
			<th>삭제</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="pds" items="${pdsList }" varStatus="vs">
			<tr class="_hover_tr">
				<td>${pds.seq }</td>
				<td>${pds.id }</td>
				<td style="text-align: left;"><a
					href="<%=request.getContextPath() %>/pds/detail?seq=${pds.seq }">${pds.title }</a>
				</td>
				<td><input type="button" name="btnDown" value="다운로드"
					onclick="filedowns('${pds.filename}', '${pds.seq }');"></td>
				<td>${pds.readcount }</td>
				<td>${pds.downcount }</td>
				<td><font size="1">${pds.regdate }</font></td>
				<td><c:if test="${pds.id == login.id }">
						<img alt="" src="<%=request.getContextPath() %>/image/del.png"
							data_file_seq="${pds.seq }" class="btn_fileDelete">
					</c:if></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div class="bbsPagingNavWrap" align="center" style="margin: auto;">
	<ul class="pagingNav pagination">
		<c:choose>
			<c:when test="${PdsOrderOption.cond eq '4'}"><!-- 검색조건이 없는 경우에 네비게이션 -->
				<c:forEach var="i" begin="${PdsOrderOption.firstNavIndex }"
					end="${PdsOrderOption.lastNavIndex }" step="1">
					<li class="pagingNavItem page-item"><a class="page-link"
						href="#"><c:out value="${i}" /></a></li>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<c:forEach var="i" begin="${PdsOrderOption.firstNavIndex }"
					end="${PdsOrderOption.lastNavIndex }" step="1">
					<li class="pagingNavItemWithSearchCond"><c:out value="${i}" /></li>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</ul>
</div>
<div class="bbsListSearchConditions">
	<select id="cond">
		<option value="0" <c:out value="${PdsOrderOption.cond == '0'?'selected':'' }"/>>제목</option>
		<option value="1" <c:out value="${PdsOrderOption.cond == '1'?'selected':'' }"/>>내용</option>
		<option value="2" <c:out value="${PdsOrderOption.cond == '2'?'selected':'' }"/>>아이디</option>
		<option value="3" <c:out value="${PdsOrderOption.cond == '3'?'selected':'' }"/>>파일이름</option>
	</select> 
	<input type="text" id="keyword" value="${PdsOrderOption.keyword != ''?PdsOrderOption.keyword:'' }">
	<input type="button" id="btnSearch" value="검색">
</div>
<!-- 자료 업로드 버튼 -->
<div id="button_wrap">
	<span class="button blue">
		<button type="button" id="_btnAdd">자료추가</button>
	</span>
</div>

<!-- 다운로드 버튼 클릭 시 -->
<form name="file_Down" action="<%=request.getContextPath() %>/pds/downloadfile" method="post">
	<input type="hidden" name="filename">
	<input type="hidden" name="seq">
</form>

<input type="hidden" id="ctxPath" value="<%=request.getContextPath() %>">
<script type="text/javascript">
//파일 다운로드 버튼 클릭 이벤트
function filedowns(filename, seq){
	var doc = document.file_Down;
	doc.filename.value = filename;
	doc.seq.value = seq;
	doc.submit();
}

$(function(){
	var ctx = $("#ctxPath").val();
	
	//자료 업로드 버튼 이동 이벤트
	$("#_btnAdd").click(function(){
		location.href = $("#ctxPath").val() + "/pds/write";
	});
	
	//테이블 행 클릭 시 seq에 맞는 디테일 페이지로 이동
	$(".tblBbsTr").click(function(){
		var seq = $(this).children().eq(0).text().trim();
		location.href= ctx + "/pds/main?seq=" + seq;
	});
	
	//검색 조건이 없을 때 페이징 네비게이션
	$(".pagingNavItem").click(function(){
		location.href= ctx + '/pds/main?pageNum=' + $(this).text();
	});
	
	//검색 조건이 있을 때 페이징 네비게이션
	$(".pagingNavItemWithSearchCond").click(function(){
		var cond = $("#cond option:selected").val();
		var keyword = $("#keyword").val();
		location.href= ctx + '/pds/main?pageNum=' + $(this).text() + '&cond=' + cond + '&keyword=' + keyword; 
	});
	
	//검색버튼 클릭 시 조건에 맞는 검색페이지로 이동
	$("#btnSearch").click(function(){
		var cond = $("#cond option:selected").val();
		var keyword = $("#keyword").val();
		location.href= ctx + '/pds/main?pageNum=1&cond=' + cond + '&keyword=' + keyword; 
	});
});
</script>

</html>