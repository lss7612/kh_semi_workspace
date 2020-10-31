    
$(document).ready(function(){
	
	
	
	
    $('.content_title').click(function(){
    	
    	var note_no = $(this).parent().prev().eq(0).html()
    	location.href='receiveview?note_no='+note_no
    	
    	
    })
    
    $('.deleteAll').click(function(){
    	
    	if(!confirm('진짜로 삭제할거에요?')) return;
    	$('#deleteAll').submit();
    	
    })
	
    
    
})