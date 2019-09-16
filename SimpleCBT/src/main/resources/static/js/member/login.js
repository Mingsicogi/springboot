/**
 * 
 */

$(function(){
	var ctx = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	
	//로그인 버튼 클릭 이벤트
	$("#btnLogin").click(function(){
		//입력 ID값
		var inputId = $("#txtId").val();
		var inputPw = $("#txtPw").val();
		//모든 공백 체크 정규식, 공백포함되어있으면 true
		var regExp = /\s/g;
		var testResult = regExp.test( inputId );
		
		if( testResult === true || inputId.length < 1 ){
			alert('아이디에 공백을 입력할 수 없습니다.');
		}else{
			testResult = regExp.test( inputPw );
			if( testResult === true || inputPw.length < 1 ){
				alert('비밀번호에 공백을 입력할 수 없습니다.');	
			}else{
				//배열 초기화
				var viewData = {};
				//data[키] = 밸류
				viewData["id"] = inputId;
				viewData["pw"] = inputPw;
				
				$.ajax({
					contentType:'application/json',
					dataType:'json',
					url: ctx + '/do',
					type:'post',
					async: false,
					data:JSON.stringify(viewData),
					success:function(resp){
						//alert(resp);
						if( resp === 1 ){
							alert('환영합니다 관리자님.');
							location.href= '/admin/main';
						}else if(resp === 2){
							
							location.href= '/teacher/main';
						}else if( resp === 3 ){
							location.href= '/student/main';
						}else{
							alert('계정 정보가 올바르지 않습니다. 다시 시도해 주세요.');
						}
					},
					error:function(){
						alert('계정 정보가 올바르지 않습니다. 다시 시도해 주세요.');
					}
				});		
			}
		}		
		//alert('입력값:' + inputId + ',  정규식:' + regExp + ',  결과 : ' + testResult);
	});
	
	//cookie를 찾는 부분
	var userId = $.cookie("userId");
	if(userId != null){
		//alert('cookie exist');
		$("#txtId").val(userId);
		$("#chk_save_id").attr("checked", "checked");
	}else{
		//alert("cookie doesn't exist");		
	}
	
	//쿠키 저장 체크박스 클릭 이벤트
	$("#chk_save_id").click(function(){
		if( $(this).is(":checked") ){
			if( $("#txtId").val().trim() === ""){
				$(this).prop("checked", false);
			}else{//쿠키이름, 저장데이터, 조건(유효기한7일, root경로-모든 경로에서 접근 가능 해당)
				$.cookie("userId", $("#txtId").val().trim(), {expires:7, path:'/'} );
			}
		}else{//체크를 해제하면 쿠키삭제(=기한을 0으로 설정)
			$.removeCookie("userId", {path:'/'} );
		}
	});
	
	//아이디 입력 이벤트 쿠키확인
	$("#txtId").keyup(function(){
		if( $("#chk_save_id").is(":checked") ){
			$.cookie("userId", $("#txtId").val().trim(), {expires:7, path:'/'} );
		}else{//체크를 해제하면 쿠키삭제(=기한을 0으로 설정)
			$.removeCookie("userId", {path:'/'} );			
		}
	});
	
	//회원가입 버튼 클릭 이벤트
	$("#btnSignup").click(function(){
		location.href="regi";
	});
});
