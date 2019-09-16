<%@page import="com.cbt.app.exams.model.ExamConditionDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String ctx = request.getContextPath();

	//문항 당 점수 초기값 선언
	int AOS = ((ExamConditionDTO)request.getAttribute("cond")).getAmountOfScore();
	int NOQ = ((ExamConditionDTO)request.getAttribute("cond")).getNumberOfQuestions();
	double scrPerQ = AOS/NOQ;
%>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/teacher/newexamdetail.js"></script>
<!-- 총점 -->
<input type="hidden" value="${cond.amountOfScore }" id="_amountOfScore">
<!-- 총 문항 수 -->
<input type="hidden" value="${cond.numberOfQuestions }" id="_numberOfQuestions">
<!-- 문항 당 점수(초기값) -->
<input type="hidden" value="<%=scrPerQ %>" id="_scorePerQuestion">  
<!-- 시험 제한시간 -->
<input type="hidden" value="${cond.limit_time }" id="_limit_time">

<div class="newexam_detail_main_wrap" style="width: 90%; margin:auto;">
	<div class="newexam_detail_nav_wrap">
	<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
	  <li class="nav-item">
	    <a class="nav-link active" id="pills-home-tab" data-toggle="pill" href="#pills-home" role="tab" aria-controls="pills-home" aria-selected="true">Home</a>
	  </li>
	  <c:forEach var="i" begin="0" end="${cond.numberOfQuestions-1 }" step="1">
	  	<li class="nav-item">
		    <a class="nav-link" id="pills-${i }-tab" data-toggle="pill" href="#pills-${i }" role="tab" aria-controls="pills-${i }" aria-selected="false">${i+1 }번</a>
		</li>
	  </c:forEach>
	  <li class="nav-item">
	    <a class="nav-link" id="pills-${i }-tab" data-toggle="pill" href="#pills-${i }" role="tab" aria-controls="pills-${i }" aria-selected="false">문제 추가 + </a>
	  </li>
	</ul>
	</div>
	<form action="<%=ctx %>/teacher/newexam/detail/save" method="get" id="exam_detail_frm">
	<div class="tab-content" id="pills-tabContent">
		<div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
			<table class="questions_item_table">
				<tr>				
				</tr>
				<tr>
					<td>
						<div class="card">
							<h1 class="card-header">출제 페이지</h1>
							<div class="card-body">
								<p class="lead">시험명 : ${cond.title }</p>
								<p class="lead">아래 주의사항에 따라 출제를 완료해 주세요.</p>
								<hr class="my-4">
								
								<p>문항 별로 문제를 작성해야 합니다.</p>
								<p>문항 별로 객관식 또는 주관식을 선택해야 합니다.</p>
								<p>문제 작성이 완료되면 문제작성 하단의 저장 버튼을 클릭하셔야 저장이 완료됩니다.</p>
								<p>배점의 총 합은 총 점수를 초과할 수 없습니다.</p>
								<p>&nbsp;&nbsp;&nbsp;&nbsp;-&nbsp;배점 현황은 화면 하단에 표시됩니다.</p>
								<p>모든 문제 작성이 완료되어야 최종 저장이 가능합니다.</p>
								<p>&nbsp;&nbsp;&nbsp;&nbsp;-&nbsp;출제 진척도는 화면 하단에 표시됩니다.</p>								
							</div>
						</div>
					</td>
				</tr>
			</table>
		</div>
		
		<c:forEach var="i" begin="0" end="${cond.numberOfQuestions-1 }" step="1">
		<div class="tab-pane fade" id="pills-${i }" role="tabpanel" aria-labelledby="pills-${i }-tab" style="margin:auto;">
			<%-- <div class="tab-pane fade" id="pills-${i }" role="tabpanel" aria-labelledby="pills-${i }-tab" align="center" style="margin:auto;"> --%>
				<div class="form-group">
					<div class="form-row">
						<div class="col-md-6">
							<h3>${i+1 }번 문제</h3>
							<input type="hidden" name="examSubList[${i }].seq_exam" value="${cond.seq }">
						</div>	
					</div>
			       <div class="form-row">
			         <div class="col-md-4">
			           <div class="form-label-group">
			           		<label for="selectQuestionType">객관식 / 주관식 선택</label>
			           		<select id="_questionType${i }" onchange="qtypeChange(${i });" class="form-control form-control-sm questionType questionInputCmp${i }">
								<option class="subject_option" value="객관식">객관식</option>
								<option class="subject_option" value="주관식">주관식</option>
							</select>
			           </div>
			         </div>
			         <div class="col-md-4">
			           <div class="form-label-group">
			           		<label for="_questionScore${i }">배점</label>
			           		<select id="_questionScore${i }" name="examSubList[${i }].score" class="form-control form-control-sm questionScore questionInputCmp${i }">
								<%
									//배점 초기값 = 총 점수/문항 수 (문서 상단에 선언)
									for(double scr = 0.5 ; scr < 10.5 ; scr = scr + 0.5){
										%>
										<option class="questionScore" value="<%=scr%>"<%=(scr==scrPerQ)?" selected":"" %>><%=scr%>점</option>
										<%
									}
								%>
							</select>
			           </div>
			         </div>
			         <div class="col-md-12">
			           <div class="form-label-group">
						<label for="questiontitle${i }">문제</label>
			             	<input type="text" id="questiontitle${i }" name="examSubList[${i }].title" class="form-control questionInputCmp${i }" placeholder="문제를 입력해 주세요.">
			             	<div class="invalid-feedback">
						    	문제를 입력해 주세요.
						    </div>
			           </div>
			         </div>
			       </div>
			       <div class="form-row">
			       		<!-- 문제 상세정보를 입력하는 공간 -->
			       		<textarea rows="10" cols="50" name="examSubList[${i }].content" style="display: none;"></textarea>
			       </div>
			       	<div class="questionType1" id="questionType1_${i }">
						<div class="form-row">
							<div class="col-md-10">
								<label for="ans_a_${i }">보기 1번</label>
								<input type="text" id="ans_a_${i }" name="examSubList[${i }].ans_a" class="form-control questionInputCmp${i }">
							</div>	
						</div>
						<div class="form-row">
							<div class="col-md-10">
								<label for="ans_b_${i }">보기 2번</label>
								<input type="text" id="ans_b_${i }" name="examSubList[${i }].ans_b" class="form-control questionInputCmp${i }">
							</div>	
						</div>
						<div class="form-row">
							<div class="col-md-10">
								<label for="ans_c_${i }">보기 3번</label>
								<input type="text" id="ans_c_${i }" name="examSubList[${i }].ans_c" class="form-control questionInputCmp${i }">
							</div>	
						</div>
						<div class="form-row">
							<div class="col-md-10">
								<label for="ans_c_${i }">보기 4번</label>
								<input type="text" id="ans_d_${i }" name="examSubList[${i }].ans_d" class="form-control questionInputCmp${i }">
							</div>	
						</div>
					</div>
					<div class="questionType2" id="questionType2_${i }">
						<div class="form-row">
							<div class="col-md-10">
								<label for="ans_sbj_${i }">주관식 답변</label>
								<input type="text" id="ans_sbj_${i }" name="examSubList[${i }].ans_sbj" class="form-control questionInputCmp${i }">
							</div>	
						</div>
					</div>
					<div class="form-row">
						<div class="col-md-10">
							<label for="_right_answer_${i }">정답</label>
							<input type="text" id="_right_answer_${i }" name="examSubList[${i }].right_answer" class="form-control questionInputCmp${i }">
						</div>	
					</div>
					<div class="form-row"><div class="col-md-10">&nbsp;</div></div>
					<div class="form-row">
						<div class="col-md-10">
							<input value="${i+1 }번 문제 저장" type="button" id="_save_content_${i }" onclick="savequestion(${i})" class="btn btn-primary">
							<input value="${i+1 }번 문제 수정" type="button" id="_mod_content_${i }" onclick="modquestion(${i})" class="btn btn-primary" style="display: none;">
							<input type="hidden" class="question_done" id="_question_saved_${i }" value="false">
						</div>	
					</div>
			     </div>			
			</div>				
	  </c:forEach>	  
	</div>
	</form>	
</div>

<div class="total_stat_wrap" style="width: 90%; margin:auto;">
	<div class="form-row"><div class="col-md-10">&nbsp;<hr></div></div>	
	<div class="form-row"><div class="col-md-10">&nbsp;</div></div>
	<div class="form-row">
		<div class="col-md-10">
			<h3>출제 현황</h3>
		</div>
	</div>
	<div class="form-row"><div class="col-md-10">&nbsp;</div></div>
	<div class="form-row">
		<div class="col-md-10">
			<label for="scoreProgBar">배분된 점수 / 총 점수</label>
			<div class="progress">
				<div id="scoreProgBar" class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 45%">
					<span class="sr-only">45% Complete</span>
				</div>
			</div>
		</div>
	</div>
	<div class="form-row"><div class="col-md-10">&nbsp;</div></div>
	<div class="form-row">
		<div class="col-md-10">
			<label for="_writeProgBar">출제 진척도</label>
			<div class="progress">
				<div id="_writeProgBar" class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 0%">
					<span class="sr-only">45% Complete</span>
				</div>
			</div>
		</div>
	</div>
	<div class="form-row"><div class="col-md-10">&nbsp;</div></div>
	<div class="form-row">
		<div class="col-md-10">
			<label for="_btnSubmitFrm">최종 저장</label><br>
			<input type="button" class="btn btn-primary" id="_btnSubmitFrm" value="출제 내용 제출" onclick="$('#exam_detail_frm').submit();" disabled="disabled">
		</div>
	</div>
</div>

<br><br><br><br><br><br>
${cond }

<script type="text/javascript">
$(function(){
	
});
</script>

</html>