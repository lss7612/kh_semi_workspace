<%@page import="dto.ChatUserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page errorPage ="./errorPage.jsp" %>
    <% ChatUserInfo user = (ChatUserInfo) session.getAttribute("userinfo"); %>
    <% ChatUserInfo opponentUser = (ChatUserInfo) request.getAttribute("opponentInfo"); %>
    <% String userIp = (String) session.getAttribute("userIp"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=opponentUser.getUser_name() %>님과 대화</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<style type="text/css">
@import url(../css/custom.css)

</style>
<style type="text/css">

#chatContent { word-break:break-all;}

</style>
</head>
<body>

<div class ="container bootstrap snippet">
	<div class="row">
		<div class="col-xs-12">
			<div class="portlet portlet-default">
				<div class="portlet-heading">
					<div class="portlet-title">
						<h4><i class="fa fa-circle text-green"></i>실시간 채팅창</h4>
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
<!-- 콘솔 메시지의 역할을 하는 로그 텍스트 에리어.(수신 메시지도 표시한다.) -->
<!-- <textarea id="messageTextArea" rows="10" cols="50"></textarea> -->
<br>
<!-- 메세지를 송신하는 버튼 -->
<!-- <input id="textMessage" onKeyDown="pressEnter()" type="text"> -->
<!-- <input id="sendBtn" onclick="sendMessage()"  -->
<!-- 	 value="전송" type="button"> -->
<!-- WebSocket 접속 종료하는 버튼 -->
<!-- <input id="disconnBtn" value="나가기" type="button"> -->
<!-- <input type="button" value="닫기" onclick="self.close();" /> -->

<script type="text/javascript">
	var webSocket = null;
  
    // 「WebSocketEx」는 프로젝트 명
    // 「broadsocket」는 호스트 명
    // WebSocket 오브젝트 생성 (자동으로 접속 시작한다. - onopen 함수 호출)
    webSocket = new WebSocket("ws://localhost:8088/broadsocket");
    
    // 콘솔 텍스트 에리어 오브젝트
    var messageTextArea = document.getElementById("chatlist");
    
    // WebSocket 서버와 접속이 되면 호출되는 함수
    webSocket.onopen = function(message) {
	    // 콘솔 텍스트에 메시지를 출력한다.
	    $('#chatlist').append('<div class="row">'+ 
				"<%=opponentUser.getUser_name() %>님과 대화가 시작되었습니다.\n" +
				'</div>' +'<hr>');
   	};
   
    // WebSocket 서버와 접속이 끊기면 호출되는 함수
    webSocket.onclose = function(message) {
		// 콘솔 텍스트에 메시지를 출력한다.
		$('#chatlist').append('<div class="row">'+ 
				"<%=opponentUser.getUser_name() %>님과 대화가 종료되었습니다." 
				+'</div>'+'<hr>');
   	};
   
    // WebSocket 서버와 통신 중에 에러가 발생하면 요청되는 함수
    webSocket.onerror = function(message) {
	    // 콘솔 텍스트에 메시지를 출력한다.
	    messageTextArea.value += "error...\n";
   	};
   
    /// WebSocket 서버로 부터 메시지가 오면 호출되는 함수
    webSocket.onmessage = function(message) {
	    // 콘솔 텍스트에 메시지를 출력한다.
	    console.log(message.data);
	    $('#chatlist').append(message.data);
	    //messageTextArea.value += message.data + "\n";
   	};
	  

    //입력창에서 Enter를 누르면 호출되는 함수
    function pressEnter(){
    	if(event.keyCode == 13){
    		sendMessage();
    	}
      	document.getElementByID("chatList").value="";
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
		
		if ( message == ""){
			return false;
		}
		
		console.log(message);
      	// 콘솔 텍스트에 메시지를 출력한다.
      	$('#chatlist').append("<div class='row userinfo'>" 
			+ userName + userDeptName + userPositionName + "</div>"); 
		$('#chatlist').append("<div class='row message'>"
			+ message + "</div>"+"<hr>");
		// messageTextArea.value += userName + userDeptName + userPositionName +"\n" 
			//+ message.value + "\n";
      
      // WebSocket 서버에 메시지를 전송(형식 「{{유저명}}메시지」)
      webSocket.send("{{"+ userNo + userName + userDeptName + userPositionName +"}}"+ message);
	<%--webSocket.send("{{" + '<%=user.getUser_name()%> / <%=user.getDept_name()%> / <%=user.getPosition_name()%>\n' + "}}" + message.value); --%>
      // 송신 메시지를 작성한 텍스트 박스를 초기화한다.
		$('#chatContent').val('');
      
      	var inp = document.getElementByID("chatList");
      	for (var i=0; i<inp.length; i++){
      		inp[i].value="";
      	}
      	//포커스 설정
      	document.getElementById("chatContent").focus();
		//$('#chatList').scrollTop($('#chatList')[0].scrollHeight);
    }
    
    // Disconnect 버튼을 누르면 호출되는 함수
    disconnBtn.onclick = function disconnect() {
      // WebSocket 접속 해제
      webSocket.close();
    }
    
  </script>
 
</body>
</html>