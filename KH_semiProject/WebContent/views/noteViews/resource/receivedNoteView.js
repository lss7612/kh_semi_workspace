$('document').ready(function(){

	
	$('.delete').click(function(){
		
		var note_no = $('.note_no0').html()
		if(!confirm('진짜로 삭제하실거에요??')) return;
		location.href='/note/receivednotedelete?note_no0='+note_no
	
	})
	
	$('.toReceivedNoteList').click(function(){
	
		location.href="/note/received"
		
	})
	
	$('.toSendNoteList').click(function(){
		
		location.href="/note/sent"
			
	})
	
	
})

