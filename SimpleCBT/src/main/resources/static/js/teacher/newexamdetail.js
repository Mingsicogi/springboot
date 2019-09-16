/**
 * 
 */
$(function(){
	var amountOfScore = parseInt( $("#_amountOfScore").val() );		//총 점수
	var numberOfQuestions = parseInt( $("#_numberOfQuestions").val() );	//총 문항 수
	var limit_time = parseInt( $("#_limit_time").val() ); //시험 제한시간
	var scorePerQuestion = parseFloat( $("#_scorePerQuestion").val() );	//문항당 점수(초기값)
	var currAmountOfScore = scorePerQuestion * numberOfQuestions;	//현재 배분된 점수
	
	//총점-배점 초기값 설정
	//alert('총점:' + amountOfScore + ", 현재점수:" + currAmountOfScore )

	
	$("#scoreProgBar").attr("aria-valuemax", amountOfScore);
	$("#scoreProgBar").attr("aria-valuenow", currAmountOfScore);
	$("#scoreProgBar").css("width", (currAmountOfScore/amountOfScore)*100 + "%");
	
	$(".questionType2").hide();
	
	//배점 변경 시 총점-배점 재계산하여 프로그레스바 설정하는 함수
	$(".questionScore").change(function(){
		var newScore = parseFloat( $(this).val() );
		//alert( $(this).attr("id") );
		var currAmountOfScoreExceptThis = 0;
		for(i = 1 ; i < numberOfQuestions + 1 ; i++ ){
			
			if( $("#_questionScore" + i).attr("id") === $(this).attr("id") )
				continue;
			currAmountOfScoreExceptThis += parseFloat( $("#_questionScore" + i).val() );
		}
		
		if( (currAmountOfScoreExceptThis + newScore) > amountOfScore ){
			alert('총 점수 이상으로 설정할 수 없습니다. 현재 배분된 점수 : ' + currAmountOfScoreExceptThis  + ", 총 점수:" + amountOfScore);
		}else{
			$("#scoreProgBar").attr("aria-valuemax", amountOfScore);
			$("#scoreProgBar").attr("aria-valuenow", currAmountOfScore);
			$("#scoreProgBar").css("width", ((currAmountOfScoreExceptThis + newScore)/amountOfScore)*100 + "%");
		}
	});
});




//객관식-주관식 문제타입 변경 함수
function qtypeChange(i){
	var qtype1 = 'questionType1_' + i ;
	var qtype2 = 'questionType2_' + i ;
	
	var selected = $("#_questionType" + i).val();
	alert(i + '' + selected);
	if( selected === '객관식'){
		$("#" + qtype1).show();
		$("#" + qtype2).hide();
	}else{
		$("#" + qtype2).show();
		$("#" + qtype1).hide();
	}
}

//임시저장 함수. 해당 컴포넌트들을 모두 readonly로 전환
function savequestion( i ){
	$(".questionInputCmp" + i ).attr("readonly","readonly");
	$("#_question_saved_" + i ).val('true');
	$("#_save_content_" + i ).hide();
	$("#_mod_content_" + i ).show();
	allQuestionsDone();
}
//임시저장 내용을 다시 수정하기 위한 함수.
function modquestion( i ) {
	$(".questionInputCmp" + i ).removeAttr("readonly");
	$("#_question_saved_" + i ).val('false');
	$("#_save_content_" + i ).show();
	$("#_mod_content_" + i ).hide();
	allQuestionsDone();
}
//임시저장이 완료되거나 내용이 수정되었을 때, 최종제출버튼 활성화 비활성화 판단 함수
function allQuestionsDone(){
	var qs = $(".question_done");
	var save_count = 0;
	for( i = 0 ; i < qs.length ; i++ ){
		if( qs.eq(i).val() === 'true' ){
			save_count++;
		}
	}
	if( save_count === qs.length){
		$("#_btnSubmitFrm").removeAttr("disabled");
	}else{
		$("#_btnSubmitFrm").attr("disabled","disabled");
	}
	//progress bar 표현
	$("#_writeProgBar").css("width", (save_count/qs.length)*100 + "%");
}