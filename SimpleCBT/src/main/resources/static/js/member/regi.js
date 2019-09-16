/**
 * 
 */

$(function(){
	//context path
	var ctx = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	
	//값 초기화. 회원가입 버튼 비활성화
	$("#btnConfirm").prop("disabled",true);
	var idOk = false;
	var pw1Ok = false;
	var pw2Ok = false;
	var nameOk = false;
	var emailOk = false;
	var isOk = false;	
	
	//정규식 활용 id 체크(영소문자+숫자 5자 이상)
	$("#inputIdInSignup").keyup(function(){	
		
		//배열 초기화
		var viewData = {};		
		var inputTxt = $("#inputIdInSignup").val();
		//data[키] = 밸류
		viewData["id"] = inputTxt;
		
		var chkOnlyEngNum = /^[a-zA-Z0-9_-]{5,15}$/;

		if( chkOnlyEngNum.test( inputTxt ) || inputTxt.length > 4){
			//정규식 조건을 통과한 경우
			$("#signupWarn").text( '　' );	
			//Ajax 활용 ID 중복체크, 중복이 아니면? true = 사용가능 ID			
			var varIsNotDupId = false;
			//초기값 valid 적용
			$("#inputIdInSignup").removeClass("is-invalid");
			$("#inputIdInSignup").addClass("is-valid");
			$.ajax({
				type: "POST"
				, async: false
				, contentType:'application/json'
				, url: ctx + '/regi/findid'
				, datatype: "json"
				, data: JSON.stringify(viewData)
				, success: function( data ){

					if( data === '0' ){
						//컨트롤러에서 넘어온 결과가 0인 경우 사용 가능한 아이디로 판단
						//alert('ok data 트루라고 했다');
						$("#inputIdInSignup").removeClass("is-invalid");
						$("#inputIdInSignup").addClass("is-valid");
						varIsNotDupId = true;
						idOk = true;
						$("#signupWarn").text( '　' );			
						isOk = allOk( idOk, pw1Ok, pw2Ok, nameOk, emailOk );
						if( isOk == true ){
							$("#btnConfirm").prop("disabled",false);
						}
						$("#chkAllOk").text(idOk + ', ' + pw1Ok + ', ' + pw2Ok + ', ' + nameOk + ', ' + emailOk + '마지막 idOk:' + isOk );
					}else{
						//중복된 ID인 경우
						$("#inputIdInSignup").removeClass("is-valid");
						$("#inputIdInSignup").addClass("is-invalid");
						idOk = false;
						$("#chkAllOk").text(idOk + ', ' + pw1Ok + ', ' + pw2Ok + ', ' + nameOk + ', ' + emailOk + '마지막 idOk:' + isOk );
						$("#signupWarn").text( '중복된 ID입니다. 다른 ID를 입력해 주세요.' );
						$("#btnConfirm").prop("disabled",true);
					}
					
				}, error: function( error ){
					alert('error : ' + error);
				}
			});					
		}else{
			//조건에 맞지 않는 경우
			idOk = false;
			$("#btnConfirm").prop("disabled",true);
			$("#inputIdInSignup").removeClass("is-valid");
			$("#inputIdInSignup").addClass("is-invalid");
		}
	});
	
	//이름 길이 체크. 2자~20자까지
	$("#inputName").keyup(function(){
		var inputLen = $("#inputName").val().length;
		var chkBlank = /\s/g;
		var chkResult = chkBlank.test( $("#inputName").val() );
		
		//길이에 맞지 않거나 공백이 포함되어 있는 경우
		if((inputLen < 2 || inputLen > 20) || chkResult ){			
			nameOk = false;			
			$("#btnSignupInSignupModal").prop("disabled",true);
			
			$("#inputName").removeClass("is-valid");
			$("#inputName").addClass("is-invalid");
		}else{			
			nameOk = true;
			$("#signupWarn").text( '　' );
			isOk = allOk( idOk, pw1Ok, pw2Ok, nameOk, emailOk );
			if( isOk == true ){
				$("#btnConfirm").prop("disabled",false);
			}			
			$("#inputName").removeClass("is-invalid");
			$("#inputName").addClass("is-valid");
		}
	});
	
	//PW 길이 체크
	$("#inputPw1InSignup").keyup(function(){
		if( $("#inputPw1InSignup").val().length < 5 ){
			pw1Ok = false;
			$("#btnSignupInSignupModal").prop("disabled",true);
			$("#inputPw1InSignup").removeClass("is-valid");
			$("#inputPw1InSignup").addClass("is-invalid");
		}else{
			pw1Ok = true;
			$("#signupWarn").text( '　' );			
			isOk = allOk( idOk, pw1Ok, pw2Ok, nameOk, emailOk );
			if( isOk == true ){
				$("#btnConfirm").prop("disabled",false);
			}
			$("#chkAllOk").text(idOk + ', ' + pw1Ok + ', ' + pw2Ok + ', ' + nameOk + ', ' + emailOk + '마지막 idOk:' + isOk );
			$("#inputPw1InSignup").removeClass("is-invalid");
			$("#inputPw1InSignup").addClass("is-valid");
		}
	});
	
	//PW 확인 체크
	$("#inputPw2InSignup").keyup(function(){
		var pw1 = $("#inputPw1InSignup").val();
		var pw2 = $("#inputPw2InSignup").val();
		if( pw1 == pw2 ){
			pw2Ok = true;			
			$("#signupWarn").text( '　' );			
			isOk = allOk( idOk, pw1Ok, pw2Ok, nameOk, emailOk );
			if( isOk == true ){
				$("#btnConfirm").prop("disabled",false);
			}
			$("#chkAllOk").text(idOk + ', ' + pw1Ok + ', ' + pw2Ok + ', ' + nameOk + ', ' + emailOk + '마지막 idOk:' + isOk );
			$("#inputPw2InSignup").removeClass("is-invalid");
			$("#inputPw2InSignup").addClass("is-valid");
		}else{
			pw2Ok = false;
			$("#btnSignupInSignupModal").prop("disabled",true);
			$("#inputPw2InSignup").removeClass("is-valid");
			$("#inputPw2InSignup").addClass("is-invalid");
		}
	});
	
	//E-mail 체크
	$("#inputEmailInSignup").keyup(function(){
		var inputTxt = $("#inputEmailInSignup").val();
		var chkEmail = /^[a-zA-Z0-9]+@([a-zA-Z0-9]{1,10})\.([a-zA-Z]{1,10})+$/;
		if( chkEmail.test(inputTxt) ){
			emailOk = true;
			$("#signupWarn").text( '　' );
			isOk = allOk( idOk, pw1Ok, pw2Ok, nameOk, emailOk );
			if( isOk == true ){
				$("#btnConfirm").prop("disabled",false);
			}
			//$("#chkAllOk").text(idOk + ', ' + pw1Ok + ', ' + pw2Ok + ', ' + nameOk + ', ' + emailOk);
			$("#inputEmailInSignup").removeClass("is-invalid");
			$("#inputEmailInSignup").addClass("is-valid");
		}else{
			emailOk = false;
			$("#btnSignupInSignupModal").prop("disabled",true);
			$("#inputEmailInSignup").removeClass("is-valid");
			$("#inputEmailInSignup").addClass("is-invalid");
		}
	});
	
	//회원가입 버튼 클릭 이벤트
	$("#btnConfirm").click(function(){
		$("#frmRegistration").attr("action", ctx + "/regi/insert")
		$("#frmRegistration").submit();
	});
});

function allOk( ok1, ok2, ok3, ok4, ok5 ){
	if( ok1 && ok2 && ok3 && ok4 && ok5 ){
		return true;
	}else{
		return false;
	}
}