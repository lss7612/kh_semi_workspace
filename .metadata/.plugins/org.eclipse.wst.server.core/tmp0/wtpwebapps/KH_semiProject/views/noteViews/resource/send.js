  $(document).ready(function () {
    $('.none').css('display', 'none');

    $('#dept').change(function () {
      $('.none').css('display', 'none');
      var dept = document.getElementById('dept');
      var selected = dept.options[dept.selectedIndex].value;
      /* console.log(selected)*/
      /*alert(selected)*/  
      
      if (selected == 'select'){
    	  $('#dept ~ select').removeClass('view');
          $('#dept ~ select').addClass('none');
      }
      if (selected == 'man') {
        $('#selectMan').toggle();
        if ($('#selectMan').hasClass('none')) {
          $('#selectMan').removeClass('none');
          $('#dept ~ select').removeClass('view');
          $('#dept ~ select').addClass('none');
          $('#selectMan').addClass('view');
        } else {
          $('#selectMan').addClass('none');
          $('#selectMan').removeClass('view');
        }
      } else if (selected == 'hr') {
        $('#selectHr').toggle();
        if ($('#selectHr').hasClass('none')) {
          $('#selectHr').removeClass('none');
          $('#dept ~ select').removeClass('view');
          $('#dept ~ select').addClass('none');
          $('#selectHr').addClass('view');
        } else {
          $('#selectHr').addClass('none');
          $('#selectHr').removeClass('view');
        }
      } else if (selected == 'acc') {
        $('#selectAcc').toggle();
        if ($('#selectAcc').hasClass('none')) {
          $('#selectAcc').removeClass('none');
          $('#dept ~ select').removeClass('view');
          $('#dept ~ select').addClass('none');
          $('#selectAcc').addClass('view');
        } else {
          $('#selectAcc').addClass('none');
          $('#selectAcc').removeClass('view');
        }
      } else if (selected == 'sal') {
        $('#selectSal').toggle();
        if ($('#selectSal').hasClass('none')) {
          $('#selectSal').removeClass('none');
          $('#dept ~ select').removeClass('view');
          $('#dept ~ select').addClass('none');
          $('#selectSal').addClass('view');
        } else {
          $('#selectSal').addClass('none');
          $('#selectSal').removeClass('view');
        }
      } else if (selected == 'addr') {
        $('#selectAddr').toggle();
        if ($('#selectAddr').hasClass('none')) {
          $('#selectAddr').removeClass('none');
          $('#dept ~ select').removeClass('view');
          $('#dept ~ select').addClass('none');
          $('#selectAddr').addClass('view');
        } else {
          $('#selectAddr').addClass('none');
          $('#selectAddr').removeClass('view');
        }
      } else if (selected == 'dev') {
        $('#selectDev').toggle();
        if ($('#selectDev').hasClass('none')) {
          $('#selectDev').removeClass('none');
          $('#dept ~ select').removeClass('view');
          $('#dept ~ select').addClass('none');
          $('#selectDev').addClass('view');
        } else {
          $('#selectDev').addClass('none');
          $('#selectDev').removeClass('view');
        }
      }
    });

    let cntTest = $('#receiver:last-child').val();
    console.log(cntTest)
    
    let cnt = 0;
    $('#add').click(function () {
      /*console.log('clicked');
      console.log($('.view > option:selected').val());*/
      
      if($('.view > option:selected').val()==undefined){
    	  alert('부서를 먼저 선택하세요')
    	  return
	  }
      
      for(var i=-15; i < cnt; i++){
    	  console.log('start')
    	  console.log($('.view>option:selected').val())
    	  console.log($('.receivers').eq(i).val())
    	  if($('.receivers').eq(i).val()==null){
    		  continue;
    		  cnt++;
    	  }
    	  if($('.view>option:selected').val()==$('.receivers').eq(i).val()){
    	  alert('이미 선택한 수신인입니다.')
    	  
    	  return
    	  }
    	  
      }
      
      var user_no = $('.view > option:selected').val();
      console.log(user_no);

      $('#receiver').append(
        '<input type ="text" readonly="readonly" width="30px;" name="receiver' 
		  +cnt +'" style="display:none;"class="receivers" value="' +
		  $('.view > option:selected').val() +'">'
      );
      
      
      console.log($('.view>option:selected').text())
      var numSelect = document.getElementById("select");
      
      
	  $('#receiver').append(
    	'<span style="border:1px solid grey;">'+$('.view>option:selected').text() +'</span>'
      )
      
      cnt++;
    });
  });
