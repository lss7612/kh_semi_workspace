<%@page import="java.util.List"%>
<%@page import="dto.Chat"%>
<%@page import="socket.BroadSocket2"%>
<%@page import="dto.ChatUserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 에러페이지 -->
    <%@ page errorPage ="./errorPage.jsp" %>
    <% ChatUserInfo user = (ChatUserInfo) session.getAttribute("userinfo"); %>
    <% ChatUserInfo opponentUser = (ChatUserInfo) request.getAttribute("user1_info"); %>
    <% int chatting_no = (int)request.getAttribute("chatting_no"); %>
    <% String userIp = (String) session.getAttribute("userIp"); %>
    <% List<Chat> clist = (List<Chat>) request.getAttribute("chatlist"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=opponentUser.getUser_name() %>님과 대화</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<style type="text/css">

</style>
<style type="text/css">
#chatContent{
	height : 300x;
	width : 1000px;
	border : 1px solid;
	font-size : 14px;
	border-radius : 4px;
	padding : 8px;
	resize : none;
}

</style>
</head>
<body>

<div class ="container bootstrap snippet">
	<div class="row">
		<div class="col-xs-12">
			<div class="portlet portlet-default">
				<div class="portlet-heading">
					<div class="portlet-title">
						<h4><i class="fa fa-circle text-green"></i><%=opponentUser.getUser_name() %>님과 대화</h4>
					</div>
					<div class="clearfix"></div>
				</div>
				<div id="chat" class="panel-collaps collapse in">
					<!-- 콘솔 메시지의 역할을 하는 div태그.(수신 메시지도 표시한다.) -->
					<div id="chatlist" class="portlet-body chat-widget" style="overflow-y: auto; width:auto; height: 600px;">
					</div>
					<div class="portlet-footer">
						<div class="row" style="height:90px;">
							<div class="form-group col-xs-10">
								<textarea id="chatContent" style="height : 80px;"  class="form-control" 
									onKeyDown="pressEnter()" maxlength="100"></textarea>
							</div>
							<div class="form-group col-xs-2">
								<!--<button type="button" class="btn btn-default pull-right" onclick="submitFunction();" onclick="sendMessage()">전송</button> -->
								<button type="button" class="btn btn-default pull-right" 
								onclick="sendMessage()">전송</button>
								<input id="disconnBtn" value="나가기" type="button" />
								<div class="clear-fix"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>	
	</div>
</div>


<br />
<!-- 채팅방 구현을 위해 WEBSOCKET을 포기한다.... -->
<script type="text/javascript">  
// 대화생성시되면 호출되는 문구
//	- 첫 대화면 대화 시작 안내
//	>> ###님과 대화가 시작되었습니다.
//	- 대화 이력이 있으면 기존대화를 불러온다.

//첫 대화여부는 데이터베이스에서 채팅방에 대화가 있는지 확인한다.
// servlet에서 객체로 전달을 받아온다.
<% if( clist != null ){ %>
	//첫대화가 아니면 대화 객체의 리스트를 #chatlist에 자식요소로 추가한다.
	//리스트 반복실행실시.
	//	리스트에서 작성자 번호랑 나랑 일치하면 내가 작성한것으로 표시
	//		불일치하면 상대방이 작성한것으로 표시
<% } else { %>
	//대화 시작 안내 문구.
	$('#chatlist').append('<div class="row">'+ '<strong>'
		+"<%=opponentUser.getUser_name() %>"+'</strong>'
		+"님과 대화가 시작되었습니다."+'</div>' +'<hr>');
<% } %>
  

 
//상대방이 입력한 메세지를 나에게 나타나는 모습 설정
/// WebSocket 서버로 부터 메시지가 오면 호출되는 함수
webSocket.onmessage = function(message) {
	// 콘솔 텍스트에 메시지를 출력한다.
	console.log(message.data);
	$('#chatlist').append(message.data);
	//messageTextArea.value += message.data + "\n";
};
 

//입력창에서 Enter를 누르면 호출되는 함수
//	enter : 전송
//	shift + enter : 줄바꿈
function pressEnter(){
 	if(event.keyCode == 13){
 		if( !event.shiftkey){
  			if( $('#chatContent').val !=""){
  				sendMessage();
				//$('#chatContent').vla("");
				//$('#chatContent').blur();
				$('#chatContent').empty();
  			} // 메시지 입력창이 빈칸일 경우 끝
		} // shift가 눌렸을 경우 끝 
	} // 엔터키를 입력했을 경우 끝
   	//document.getElementByID("chatList").value="";
}
  
// Send 버튼을 누르면 호출되는 함수
function sendMessage() {
	// 유저정보(이름/부서/직급)텍스트 박스 오브젝트를 취득
	var userName ="<%=user.getUser_name()%> /";
	var userDeptName = " <%=user.getDept_name()%> /";
	var userPositionName= " <%=user.getPosition_name() %>";
	var userNo = "<%=user.getUser_no() %>";
   	// 송신 메시지를 작성하는 텍스트 박스 오브젝트를 취득
   	var message = $('#chatContent').val();
	//var message = document.getElementById("textMessage");

	if ( message == "" || message =="\n"){
		return false;
	}

	//console.log(message);

   	// chatlist에 작성한 메세지를 나타낸다.
   	//내정보 출력
   	$('#chatlist').append("<div class='row userinfo'><strong>" 
		+ userName + userDeptName + userPositionName + "</strong></div>"); 
   	//메시지 출력
	$('#chatlist').append("<div class='row message'>"
		+ message + "</div><hr>");
    
	//메시지를 작성전송 하고 텍스트 박스를 초기화한다.
	$('#chatContent').val("");
	console.log($('#chatContent').val());
	$('#chtContent').blur();
   	//포커스 설정
   	//document.getElementById("chatContent").focus();
	$('#chatList').scrollTop($('#chatList')[0].scrollHeight);
}
  
// 대화방을 나가면 나타나는 문구 설정
// Disconnect 버튼을 누르면 호출되는 함수
disconnBtn.onclick = function disconnect() {
	$('#chatlist').append('<div class="row">'+ '<strong>'
		+"<%=opponentUser.getUser_name() %>"+'</strong>'
		+"님과 대화가 종료되었습니다." +'</div><hr>');
 }
 
</script>
 
</body>
</html>