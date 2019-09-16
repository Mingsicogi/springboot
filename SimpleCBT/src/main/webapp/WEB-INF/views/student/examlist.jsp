<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%String ctx = request.getContextPath();%>
<!DOCTYPE html>
<html>

<div class="exam_list_wrap">
	<table class="table table-hover">
		<thead>
		<tr>
			<th scope="col">#</th>
			<th scope="col">과목 이름</th>
			<th scope="col">시험 이름</th>
			<th scope="col">응시 여부</th>
		</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${empty subjectList }">
					<tr><td colspan="4">수강 중인 과목이 없습니다.</td></tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${subjectList }" var="sbj" varStatus="i" step="1">
						<c:forEach items="${examList }" var="exam" varStatus="j">
							<c:if test="${sbj.seq == exam.subject }">
								<tr>
									<c:choose>
										<c:when test="${j.count == 1 }"><td>${i.count }</td><td>${sbj.subject }</td></c:when>
										<c:otherwise><td></td><td></td></c:otherwise>
									</c:choose>
									<td>${exam.title }</td>
									<td>
										<%-- <c:choose>
											<c:when test="${not empty examResult[exam.seq] }">응시 완료</c:when>
											<c:otherwise>미응시</c:otherwise>
										</c:choose> --%>
									</td>
								</tr>
							</c:if>							
						</c:forEach>						
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<tr>
			</tr>
		</tbody>		
	</table>

	<div class="form-row">
		<div class="col-md-4 mb-3">
			<label for="validationDefault01">교과목</label>
			<!-- 해당 학생이교수가 수업중인 과목의 목록을 보여줌 -->
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
</div>

</html>