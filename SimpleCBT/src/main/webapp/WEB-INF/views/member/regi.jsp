<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>
<!DOCTYPE html>
<html>
<head>
<tiles:insertAttribute name="header"/>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/member/regi.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<div id="signup_wrap" style="width: 70%; margin: auto; margin-top: 200px;">
<div class="card card-register mx-auto mt-5">
  <div class="card-header">
  	<c:choose>
		<c:when test="${memberType == 2  }">
			교수자 회원가입
		</c:when>
		<c:otherwise>
			학생 회원가입
		</c:otherwise>
	</c:choose>	
  </div>
  <div class="card-body">
    <form id="frmRegistration" action="#" method="post">
      <div class="form-group">
        <div class="form-row">
          <div class="col-md-6">
            <div class="form-label-group">
            	<label for="firstName">아이디</label>
             	<input type="text" id="inputIdInSignup" name="id" class="form-control" placeholder="아이디를 입력하세요" required="required" autofocus="autofocus">
             	<div class="valid-feedback">
		        	사용 가능한 아이디입니다.
		      	</div>
             	<div class="invalid-feedback">
			    	사용할 수 없는 아이디입니다.
			    </div>
            </div>
          </div>
          <div class="col-md-6">
            <div class="form-label-group">
				<label for="lastName">성함</label>
              	<input type="text" id="inputName" name="name" class="form-control" placeholder="성함을 입력하세요" required="required">
              	<div class="valid-feedback">
		        	사용 가능한 성함입니다.
		      	</div>
             	<div class="invalid-feedback">
			    	사용할 수 없는 성함입니다.
			    </div>
            </div>
          </div>
        </div>
      </div>
      <div class="form-group">
        <div class="form-label-group">
        	<label for="inputEmail">Email 주소</label>
          	<input type="email" id="inputEmailInSignup" name="email" class="form-control" placeholder="Email 주소를 입력하세요" required="required">
        	<div class="valid-feedback">
	        	사용할 수 있는 이메일입니다.
	      	</div>
            <div class="invalid-feedback">
		    	사용할 수 없는 이메일입니다.
		    </div>
        </div>
      </div>
      <div class="form-group">
        <div class="form-row">
          <div class="col-md-6">
            <div class="form-label-group">
            	<label for="inputPassword">비밀번호</label>
	            <input type="password" id="inputPw1InSignup" name="pw" class="form-control" placeholder="비밀번호를 입력하세요" required="required">
	            <div class="valid-feedback">
		        	사용 가능한 비밀번호입니다.
		      	</div>
             	<div class="invalid-feedback">
			    	비밀번호는 5자 이상으로 입력해주세요.
			    </div>
            </div>
          </div>
          <div class="col-md-6">
            <div class="form-label-group">
            	<label for="confirmPassword">비밀번호 확인</label>
              	<input type="password" id="inputPw2InSignup" class="form-control" placeholder="비밀번호를 다시 입력하세요" required="required">
            	<div class="valid-feedback">
		        	비밀번호가 일치합니다.
		      	</div>
             	<div class="invalid-feedback">
			    	두 비밀번호가 일치하지 않습니다.
			    </div>
            </div>
          </div>
          <c:if test="${memberType == 2  }">
			  <div class="col-md-6">
	            <div class="form-label-group">
	            	<label for="inputTeacherNumber">교수자 고유번호 입력</label>
	              	<input type="text" id="inputTeacherNum" name="teacherNum" class="form-control" placeholder="발급받은 교수자 번호를 입력하세요" required="required">
	            </div>
	          </div>
		  </c:if>
		  	<c:choose>
				<c:when test="${memberType == 2  }">
					<input type="hidden" name="auth" value="2">
				</c:when>
				<c:otherwise>
					<input type="hidden" name="auth" value="3">
				</c:otherwise>
			</c:choose>
        </div>
      </div>
      <input type="button" class="btn btn-primary btn-block" value="회원가입" id="btnConfirm"/>
    </form>
    
  </div>
</div>
</div>

</body>
</html>