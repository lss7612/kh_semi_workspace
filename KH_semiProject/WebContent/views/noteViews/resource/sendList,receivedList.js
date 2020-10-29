    
$(document).ready(function(){
	
	
	
	
    $('.content_title').click(function(){
    	
    	var note_no = $(this).parent().prev().eq(0).html()
    	location.href='view?note_no='+note_no
    	
    	
    })
    
    $('.deleteAll').click(function(){
    	
    	
    	
    })
	
})