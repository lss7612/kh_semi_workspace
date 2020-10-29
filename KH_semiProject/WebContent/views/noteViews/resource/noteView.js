$('document').ready(function(){

	
	$('.delete').click(function(){
		
		console.log($('.note_no').html())
		var note_no = $('.note_no').html()
		location.href='/note/sendnotedelete?note_no='+note_no
		
	
	})
	
	
	
	
})

