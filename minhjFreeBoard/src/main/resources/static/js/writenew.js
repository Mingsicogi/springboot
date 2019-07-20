/**
 * 
 */
$(function(){
	$("#btnSavePost").click(function(){
		var formObj = $("#formWriteNewPost");
	
		console.log('id : ' + $("input[name=txtWriter]").val());
		console.log('title : ' + $("input[name=txtTitle]").val());
		console.log('content : ' + $("textarea[name=txtContent]").val());
		
		formObj.attr("action", "/freeboard.writenew.savepost");
		formObj.submit;
	});
});