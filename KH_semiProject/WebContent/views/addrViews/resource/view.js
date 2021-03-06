window.onload = function () {
  /* ajaxToServer(); */

  $("span[name='userid']").click(function () {
    console.log('clicked');
    $(this).toggleClass('ASC');
    if ($(this).hasClass('ASC')) {
      var isASC = 'ASC';
      var arrayCondition = 'userid';
      postArrayCondition(isASC, arrayCondition);
    } else {
      var isASC = 'DESC';
      var arrayCondition = 'userid';
      postArrayCondition(isASC, arrayCondition);
    }
  });
  $("span[name='username']").click(function () {
    console.log('clicked');
    $(this).toggleClass('ASC');
    if ($(this).hasClass('ASC')) {
      var isASC = 'ASC';
      var arrayCondition = 'username';
      postArrayCondition(isASC, arrayCondition);
    } else {
      var isASC = 'DESC';
      var arrayCondition = 'username';
      postArrayCondition(isASC, arrayCondition);
    }
  });
  $("span[name='dept']").click(function () {
    console.log('clicked');
    $(this).toggleClass('ASC');
    if ($(this).hasClass('ASC')) {
      var isASC = 'ASC';
      var arrayCondition = 'dept';
      postArrayCondition(isASC, arrayCondition);
    } else {
      var isASC = 'DESC';
      var arrayCondition = 'dept';
      postArrayCondition(isASC, arrayCondition);
    }
  });
  $("span[name='position']").click(function () {
    console.log('clicked');
    $(this).toggleClass('ASC');
    if ($(this).hasClass('ASC')) {
      var isASC = 'ASC';
      var arrayCondition = 'position';
      postArrayCondition(isASC, arrayCondition);
    } else {
      var isASC = 'DESC';
      var arrayCondition = 'position';
      postArrayCondition(isASC, arrayCondition);
    }
  });


  //sendNote기능
  $('.sendNote').click(function () {
    if (!confirm('쪽지를 보내시겠습니까?')) return;
    $('#sendNote').submit();
  });
  //chatting기능
  $('.chat').click(function () {
    if (!confirm('채팅을 시작하시겠습니까?')) return;
    var user_no = $(this).parent().prev().prev().prev().prev().prev().prev().eq(0).html();

    location.href = '/chat/room?selectUserNo=' + user_no;
  });
};

function postArrayCondition(isASC, arrayCondition) {
  var params = 'arrayCondition=' + arrayCondition + '&isASC=' + isASC;
  sendRequest('POST', '/address/view', params, getArrayCondition);
}

function getArrayCondition() {
  if (httpRequest.readyState == 4) {
    if (httpRequest.status == 200) {
      console.log('정상응답');
    } else {
      console.log('AJAX요청/응답 에러');
    }
  }
}
