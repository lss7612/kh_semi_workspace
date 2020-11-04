$('document').ready(function(){

	$('.selectAllCheckbox').change(function(){
		
		if($('.selectAllCheckbox').is(':checked')){
			console.log('yes')
			$("input[type=checkbox]").prop("checked",true);
			
		} else{
			console.log('no')
			$("input[type=checkbox]").prop("checked",false);
		}
		
	})
	
})
