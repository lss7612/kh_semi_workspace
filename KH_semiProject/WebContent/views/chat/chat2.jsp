<%@page import="java.util.ArrayList"%>
<%@page import="dto.SendMsgClient"%>
<%@page import="java.util.List"%>
<%@page import="dto.Chat"%>
<%@page import="dto.ChatUserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 에러페이지 -->
    <%@ page errorPage ="./errorPage.jsp" %>
    <% ChatUserInfo user = (ChatUserInfo) session.getAttribute("userinfo"); %>
    <% ChatUserInfo opponentUser = (ChatUserInfo) request.getAttribute("user1_info"); %>
    <% int chatting_no = (int)request.getAttribute("chatting_no"); %>
    <% String userIp = (String) session.getAttribute("userIp"); %>
    <% List<SendMsgClient> clist = new ArrayList<>(); %>
    <% clist = (List<SendMsgClient>) request.getAttribute("clist"); %>

<!DOCTYPE html>
<html>
<head>
<%	int userId = 0;
	if ( user.getUser_no() != 0 ){
		userId = user.getUser_no();
	}
	
	int oppId = 0;
	if (opponentUser.getUser_no() != 0 ){
		oppId = opponentUser.getUser_no();
	}
%>
<meta charset="UTF-8">
<title><%=opponentUser.getUser_name() %>님과 대화</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src ="/resources/js/httpRequest.js"></script>
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
<script type="text/javascript">
	//입력창에서 Enter를 누르면 호출되는 함수
	function pressEnter(){
	 	if(event.keyCode == 13){
	 		//공백일 경우에는 진행하지 않는다.
  			if( $('#chatContent').val() !=""){
  				//console.log("chatcontent가 공백이 아닙니다.")
  				sendMessage();
				//$('#chatContent').vla("");
				//$('#chatContent').blur();
				//$('#chatContent').empty();
  			} // 메시지 입력창이 빈칸일 경우 끝
 		$("#chatContent").val("");
		} // 엔터키를 입력했을 경우 끝
	}//pressEnter 함수 끝
  
	//Send 버튼을 누르면 호출되는 함수
	//#chatContent에 작성된 내용을 DB로 보내 저장한다.
	function sendMessage() {
		//회원번호를 세션에서 가져온다.
		var userNo = "<%=user.getUser_no() %>";
		//전달객체인 채팅방 번호를 가져온다.
		var roomNo = "<%=chatting_no %>";
	   	//#chatContent에서 값을 가져온다.
	   	var message = $('#chatContent').val();
	   	
	   	//채팅입력창안에 공백이거나 개행문자가 있을 경우 종료
// 		if ( message == "" || message =="\n"){
// 			return false;
// 		}
		
	   	//비동기방식으로 채팅내용을 db에 저장할수 있도록 한다.
	   	$.ajax({
	   		type: "POST"
	   		, url : "/chat/msgent"
	   		, data : {
	   			user0_no : userNo
	   			,chatting_no : roomNo
	   			,msg : message
	   		}
			, dataType: "json"
			, success : function (data){
				console.log("msgsend")
				console.log(data)
		   		console.log("AJAX 요청(db에 메세지 전달)성공");
		   		
		   	}
		   	, error : function (){
		   		console.log("AJAX 요청(db에 메시지 전달) 실패");
		   	}
	   	});//ajax설정 끝
	}//sendMessage 함수 끝
	
	
	//db에서 메세지 로드해오기.
	var msg_no = 0;
	function msgload( ){
		var roomNo = "<%=chatting_no %>";
		var userNo = "<%=user.getUser_no() %>";
		var userNo2 = "<%=opponentUser.getUser_no() %>";
		
		$.ajax({
			type:"POST"
			, url : "/chat/msgload"
			, data : {
				chatting_no : roomNo
				, user0_no : userNo
				, user1_no : userNo2
			}
			, dataType: "json"
			, success : function (data){
				console.log("AJAX요청 성공");
				console.log(data)
				//console.log(data.last);
				//console.log(msg_no);
				var clist = data.result;
				//console.log (clist[1][0].value);
				//console.log (clist[1][1].value);
				//console.log (clist[1][2].value);
				$('#chatList').empty();
				for (var i = 0; i<data.last; i++){
					console.log("반복문 안에 들어왔나요?");
					$('#chatList').append(clist[i][0].value);
					$('#chatList').append(clist[i][1].value);
					$('#chatList').append(clist[i][2].value);
					//msg_no = data.last;
				}
				$('#chatList').scrollTop($('#chatList')[0].scrollHeight);
				msg_no = data.last;
			}
			, error : function(){
				console.log("AJAX 연결 실패");
			}
		})//ajax설정 끝
	
		
	}//msgload 함수 끝
		
	function autoLoad(){
		setInterval(msgload, 2000);
	}
	
</script>
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
					<div id="chatList" class="portlet-body chat-widget" style="overflow-y: auto; width:auto; height: 600px;">
					</div>
					<div class="portlet-footer">
						<div class="row" style="height:90px;">
							<div class="form-group col-xs-10">
								<input type="text" id="chatContent" style="height : 80px;"  class="form-control" 
									onKeyDown="pressEnter()" maxlength="100" />
							</div>
							<div class="form-group col-xs-2">
								<!--<button type="button" class="btn btn-default pull-right" onclick="submitFunction();" onclick="sendMessage()">전송</button> -->
								<button type="button" class="btn btn-default pull-right" onclick="sendMessage()">전송</button>
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

<script type="text/javascript">  
	autoLoad();
	// 대화생성시되면 호출되는 문구
	//	- 첫 대화면 대화 시작 
	// ###님과 대화가 시작되었습니다.
	//	- 대화 이력이 있으면 기존대화를 불러온다.
	
	//첫 대화여부는 데이터베이스에서 채팅방에 대화가 있는지 확인한다.
	// servlet에서 객체로 전달을 받아온다.
	<% if( clist.size() == 0 ) { %>
		console.log("true");
		//	//대화 시작 안내 문구.
		$('#chatList').append('<div class="row">'+ '<strong>'
			+"<%=opponentUser.getUser_name() %>"+'</strong>'
			+"님과 대화가 시작되었습니다."+'</div>' +'<hr>');
		
	<% } else { %>
		//첫대화가 아니면 대화 객체의 리스트를 #chatlist에 자식요소로 추가한다.
		//리스트 반복실행실시.
		//	리스트에서 작성자 번호랑 나랑 일치하면 내가 작성한것으로 표시
		//		불일치하면 상대방이 작성한것으로 표시
		<% for(SendMsgClient s : clist) { %>
			$('#chatList').append( "<%=s.getWinfo() %>" );
			$('#chatList').append( "<%=s.getChatTime() %>" );
			$('#chatList').append( "<%=s.getMsgContent() %>" );
		<% } %>
	<% } %>


	  
	// 대화방을 나가면 나타나는 문구 설정
	// Disconnect 버튼을 누르면 호출되는 함수
	disconnBtn.onclick = function disconnect() {
		$('#chatlist').append('<div class="row">'+ '<strong>'
			+"<%=opponentUser.getUser_name() %>"+'</strong>'
			+"님과 대화가 종료되었습니다." +'</div><hr>');
	 }
	
	//스크롤바를 하단으로 고정하여 최근대화가 보이게 한다.
	$('#chatList').scrollTop($('#chatList')[0].scrollHeight);
</script>
 
</body>
</html>