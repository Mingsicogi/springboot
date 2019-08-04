/**
 * freeboard index page
 * templates/freeboard/index.html
 */
function echoTest(){
	alert('echo');
}

$(function(){
    $("#btnPop").click(function(){
        $('layerpop.modal').modal();
    })
    
    var headerBarMenuState = true;
    $("#mainHeaderBarMenu a").mouseenter(function(){
    	$(this).animate({ opacity: "0.8" }, 200);
    });
    
    $("#mainHeaderBarMenu a").mouseleave(function(){
    	$(this).animate({ opacity: "1.0" }, 200);    	
    });
});
