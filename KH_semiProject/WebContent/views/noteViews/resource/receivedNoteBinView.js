$('document').ready(function(){

	
	$('.restore').click(function(){
		console.log('clicked')
		var note_no = $('.note_no0').html()
		
		if(!confirm('진짜로 복구하실거에요??')) return;
		location.href='/note/receivednoterestore?note_no0='+note_no
	
	})
	
	$('.toReceivedNoteList').click(function(){
	
		location.href="/note/received"
		
	})
	
	$('.toSendNoteList').click(function(){
		
		location.href="/note/sent"
			
	})
	
	
})

