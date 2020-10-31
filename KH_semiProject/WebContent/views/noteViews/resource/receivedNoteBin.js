    
$(document).ready(function(){
	
	
	
	
    $('.content_title').click(function(){
    	
    	var note_no = $(this).parent().prev().eq(0).html()
    	location.href='/note/receivedNoteBinView?note_no='+note_no
    	
    	
    })
    
    $('.restoreAll').click(function(){
    	
    	if(!confirm('진짜로 복구하실거에요??')) return;
    	$('#restoreAll').submit();
    	
    })
	
    
    
})