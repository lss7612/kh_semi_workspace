<%@page import="java.util.ArrayList"%>
<%@page import="dto.chat.SendMsgClient"%>
<%@page import="java.util.List"%>
<%@page import="dto.chat.Chat"%>
<%@page import="dto.common.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 에러페이지 -->
    <%@ page errorPage ="./errorPage.jsp" %>
    <%
    	UserInfo user = (UserInfo) session.getAttribute("userinfo");
    %>
    <%
    	UserInfo opponentUser = (UserInfo) request.getAttribute("user1_info");
    %>
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
<script type="text/javascript" src ="/resources/js/httpRequest.js"></script>
<!--헤더-->
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="/resources/plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Tempusdominus Bbootstrap 4 -->
  <link rel="stylesheet" href="/resources/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="/resources/plugins/icheck-bootstrap/icheck-bootstrap.min.css">

  <!-- Theme style -->
  <link rel="stylesheet" href="/resources/dist/css/adminlte.css">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="/resources/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="/resources/plugins/daterangepicker/daterangepicker.css">
  <!-- summernote -->
  <link rel="stylesheet" href="/resources/plugins/summernote/summernote-bs4.css">
  
  <link rel="stylesheet" href="/resources/css/style.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
  <script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>


<style type="text/css">
html{
  margin : 0px 0px;
}

#chatContent{
	height : 200x;
	width : 400px;
	border : 1px solid;
	font-size : 14px;
	border-radius : 4px;
	padding : 8px;
	resize : none;
}

#chatList{
  height : 270px;
  width : 450px;
  overflow-y: auto; 
}

#chatList::-webkit-scrollbar{
  width : 5px;
}
#chatList::-webkit-scrollbar-thumb{
  border-radius : 10px;
  background-color : #ccc;
}
#chatList::-webkit-scrollbar-track{
  display:none;
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
	var msg_no = <%=clist.size() %>;
	function msgload( ){
		var roomNo = "<%=chatting_no %>";
		var userNo = "<%=user.getUser_no() %>";
		var userNo2 = "<%=opponentUser.getUser_no() %>";
		console.log(msg_no);
		$.ajax({
			type:"POST"
			, url : "/chat/msgload"
			, async : false
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
				//$('#chatList').empty();
				if( msg_no < data.last){
					for (msg_no; msg_no<data.last; msg_no++){
						console.log("반복문 안에 들어왔나요?");
						console.log(clist);
						$('#chatList').append(clist[msg_no][0].value);
						$('#chatList').append(clist[msg_no][1].value);
						$('#chatList').append(clist[msg_no][2].value);
						$('#chatList').append(clist[msg_no][3].value);
						$('#chatList').scrollTop($('#chatList')[0].scrollHeight);
					}
					msg_no = data.last;
				}
				msg_no = data.last;
			}
			, error : function(){
				console.log("AJAX 연결 실패");
			}
		})//ajax설정 끝
	
		
	}//msgload 함수 끝
		
	function autoLoad(){
		setInterval(msgload, 10000);
	}
	
</script>
</head>



<body>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper" id="fuck">
    <!-- DIRECT CHAT -->
    <div class="card direct-chat direct-chat-warning">
      <div class="card-header">
        <h3 class="card-title">
        	<input type="button" id="goChatHome" value="홈으로" />
			<%=opponentUser.getUser_name() %>님과 대화</h3>
      </div>
      <!-- /.card-header -->
      <!-- 채팅창 안에 -->
      <div id="topChat" class="card-body">
        <!-- Conversations are loaded here -->
        <div id="chatList" class="direct-chat-messages">
          <!-- Message. Default to the left -->
<!--           <div id="fromMsg" class="direct-chat-msg"> -->
<!--             <div id="fromMsgInfo" class="direct-chat-infos clearfix"> -->
<!--               <span id="fromMsgInfoName" class="direct-chat-name float-left">김과장</span> -->
<!--               <span id="fromMsgInfoTime" class="direct-chat-timestamp float-right">23 Jan 2:00 pm</span> -->
<!--             </div> -->
<!--             /.direct-chat-infos -->
<!--             <img class="direct-chat-img-lh" src="dist/img/user1-128x128.jpg" alt="message user image"> -->
<!--             /.direct-chat-img -->
<!--             <div id = "fromMsgContent" class="direct-chat-text"> -->
<!--              		딴짓말고 일 좀 하게 //받는 사람 채팅메시지 -->
<!--             </div> -->
<!--             /.direct-chat-text -->
<!--           </div> -->
<!--           /.direct-chat-msg -->

<!--           Message to the right -->
<!--           <div id="toMsg" class="direct-chat-msg right"> -->
<!--             <div id="toMsgInfo" class="direct-chat-infos clearfix"> -->
<!--               <span id="toMsgInfoName" class="direct-chat-name float-right">김사원</span> -->
<!--               <span id="toMsgInfoTime" class="direct-chat-timestamp float-left">23 Jan 2:05 pm</span> -->
<!--             </div> -->
<!--             /.direct-chat-infos -->
<!--             <img class="direct-chat-img-rh" src="dist/img/user3-128x128.jpg" alt="message user image"> -->
<!--             /.direct-chat-img -->
<!--             <div id="toMsgInfoName" class="direct-chat-text"> -->
<!--               		시른데??? //보내는 사람 채팅메시지 -->
<!--             </div> -->
<!--             /.direct-chat-text -->
<!--           </div> -->
          <!-- /.direct-chat-msg -->
        </div>
        <!--/.direct-chat-messages-->

        <!-- /.direct-chat-pane -->
      </div><!-- //채팅창 안에  -->
      <!-- /.card-body -->
      <div class="card-footer">
        <form action="#" method="post">
          <div class="input-group">
           
            <input id="chatContent" type="text" name="message" onKeyDown="pressEnter()" placeholder="메시지를 입력하세요" class="form-control">
            <span class="input-group-append">
              <button type="button" class="btn btn-warning" onclick="submitFunction();" onclick="sendMessage()" >보내기</button>
            </span>
          </div>
        </form>
      </div>
      <!-- /.card-footer-->
    </div>
    <!--/.direct-chat -->
</div>
<!-- /.content-wrapper -->

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
	<% for(SendMsgClient s : clist) { 
		if(s.getUser_no() == user.getUser_no() ) { %>
		console.log("내가 보냄")
		$('#chatList').append( "<%=s.getWinfo() %>" );
		$('#chatList').append( "<%=s.getChatTime()%>" );
		$('#chatList').append( "<%=s.getProfile_img() %>" );
		$('#chatList').append( "<%=s.getMsgContent()%>");
	<%	} else { %>				
		console.log("상대가 보냄")
 		$('#chatList').append( "<%=s.getWinfo() %>" );
		$('#chatList').append( "<%=s.getChatTime() %>" );
		$('#chatList').append( "<%=s.getProfile_img() %>" );
		$('#chatList').append( "<%=s.getMsgContent() %>" );
	<%	} %>
	<% } %>
	<% } %>
	  
	// 채팅 홈으로 이동하는 버튼
	$('#goChatHome').on('click',function(){
		location.href='/chathome';
	})
	
	//스크롤바를 하단으로 고정하여 최근대화가 보이게 한다.
	$('#chatList').scrollTop($('#chatList')[0].scrollHeight);
</script>




</body>
</html>