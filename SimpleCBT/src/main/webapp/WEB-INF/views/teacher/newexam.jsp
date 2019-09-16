<%@page import="com.cbt.app.exams.model.SubjectDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%String ctx = request.getContextPath();
  Date today = new Date();%>
<!DOCTYPE html>
<html>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<div class="newexam_main_wrap" style="width: 90%; margin:auto;">
	<h3>새 시험 등록</h3>
	<div class="newexam_input_details">
		<!-- 시험내용 선택. 시험제목, 제한시간, 문항 수, 총점, 시작일, 종료일 -->
		<form action="/teacher/newexam/detail" method="post">
			<input type="hidden" name="teacher" value="${curruser.seq }">
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<label for="validationDefault01">교과목</label>
					<!-- 해당 교수가 수업중인 과목의 목록을 보여줌 -->
					<select id="_subject" name="subject" class="form-control form-control-sm">
						<c:choose>
							<c:when test="${not empty subjectlist }">
								<c:forEach items="${subjectlist }" var="sbj">
									<option class="subject_option" value="${sbj.seq }">${sbj.subject }</option>
								</c:forEach>								
							</c:when>
							<c:otherwise>
								<option class="subject_option" value="0">진행중인 강의가 없습니다.</option>
							</c:otherwise>
						</c:choose>
					</select>
					<select id="_subject_serial" name="subject_serial" class="form-control form-control-sm" style="display: none;">
						<c:choose>
							<c:when test="${not empty subjectlist }">
								<c:forEach items="${subjectlist }" var="sbj">
									<option class="subject_option" value="${sbj.subject_serial }">${sbj.subject }</option>
								</c:forEach>								
							</c:when>
							<c:otherwise>
								<option class="subject_option" value="0">진행중인 강의가 없습니다.</option>
							</c:otherwise>
						</c:choose>
					</select>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-6 mb-3">
					<label for="validationDefault02">시험제목</label> 
					<input type="text" class="form-control" id="_title" name="title" placeholder="예)2018 영어 중간고사" required>
				</div>				
			</div>
			<div class="form-row">
				<div class="col-md-2 mb-3">
					제한시간
					<div class="input-group-prepend">
						<select id="_limit_time" name="limit_time" class="form-control form-control-sm">
							<c:forEach var="i" begin="30" end="300" step="30">
								<option value="${i }">${i }분</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="col-md-2 mb-3">
					문항 수 
					<div class="input-group-prepend">
						<select id="_numberOfQuestions" name="numberOfQuestions" class="form-control form-control-sm">
							<c:forEach var="i" begin="1" end="150" step="1">
								<option value="${i }">${i }문항</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="col-md-2 mb-3">
					총점
					<div class="input-group-prepend">
						<select id="_amountOfScore" name="amountOfScore" class="form-control form-control-sm">
							<c:forEach var="i" begin="5" end="100" step="1">
								<option value="${i }">${i }점</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>			
			
			<div class="form-row">
				<div class="col-md-3 mb-3">
					시험 시작일
					<div class="input-group-prepend">			                
	                	<input type="text" id="_startdate" name="sdate" class="form-control">
					</div>
				</div>
				<div class="col-md-3 mb-3">
					시험 종료일
					<div class="input-group-prepend">
						<input type="text" id="_enddate" name="edate" class="form-control">
					</div>
				</div>
			</div>
			<!-- 진행 중인 강의가 없으면 버튼 비활성화 -->
			<button class="btn btn-primary" type="submit" <%=(((List<SubjectDTO>)request.getAttribute("subjectlist")).size() < 1)?"disabled='disabled'":"" %>>Submit form</button>
		</form>
	</div>
</div>
<script type="text/javascript">
$(function() {	
	var dow = ['일','월','화','수','목','금','토'];	
	$("#_startdate").datepicker( {
		dateFormat: "yy/mm/dd"
		,dayNamesMin: ['일','월','화','수','목','금','토']
		,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
		,onSelect: function( d ){
			var arr = d.split('/');
			$("#_startdate").val( arr[0].trim() + '/' + arr[1].trim() + '/' + arr[2].trim() );
			
			var endDate = $('#_enddate');
			var startDate = $(this).datepicker('getDate');
			var minDate = $(this).datepicker('getDate');
			endDate.datepicker('setDate', minDate);
			startDate.setDate(startDate.getDate() + 30);
			endDate.datepicker('option', 'maxDate', startDate);
			endDate.datepicker('option', 'minDate', minDate);
		}
	} );
    
    $("#_enddate").datepicker( {
		dateFormat: "yy/mm/dd"
		,dayNamesMin: ['일','월','화','수','목','금','토']
		,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
		,onSelect: function( d ){
			var arr = d.split('/');
			$("#_enddate").val( arr[0].trim() + '/' + arr[1].trim() + '/' + arr[2].trim() );
			
			$("#_startdate").datepicker( "option", "maxDate", d );
		}
	} );

});
</script>


</html>