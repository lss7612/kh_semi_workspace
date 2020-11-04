/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.37
 * Generated at: 2020-11-04 01:38:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.chat;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import dto.chat.SendMsgClient;
import java.util.List;
import dto.chat.Chat;
import dto.common.UserInfo;

public final class chat2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("dto.common.UserInfo");
    _jspx_imports_classes.add("dto.chat.SendMsgClient");
    _jspx_imports_classes.add("dto.chat.Chat");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"./errorPage.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- 에러페이지 -->\r\n");
      out.write("    \r\n");
      out.write("    ");

    	UserInfo user = (UserInfo) session.getAttribute("userinfo");
    
      out.write("\r\n");
      out.write("    ");

    	UserInfo opponentUser = (UserInfo) request.getAttribute("user1_info");
    
      out.write("\r\n");
      out.write("    ");
 int chatting_no = (int)request.getAttribute("chatting_no"); 
      out.write("\r\n");
      out.write("    ");
 String userIp = (String) session.getAttribute("userIp"); 
      out.write("\r\n");
      out.write("    ");
 List<SendMsgClient> clist = new ArrayList<>(); 
      out.write("\r\n");
      out.write("    ");
 clist = (List<SendMsgClient>) request.getAttribute("clist"); 
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
	int userId = 0;
	if ( user.getUser_no() != 0 ){
		userId = user.getUser_no();
	}
	
	int oppId = 0;
	if (opponentUser.getUser_no() != 0 ){
		oppId = opponentUser.getUser_no();
	}

      out.write("\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>");
      out.print(opponentUser.getUser_name() );
      out.write("님과 대화</title>\r\n");
      out.write("<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-2.2.4.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src =\"/resources/js/httpRequest.js\"></script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("#chatContent{\r\n");
      out.write("\theight : 300x;\r\n");
      out.write("\twidth : 1000px;\r\n");
      out.write("\tborder : 1px solid;\r\n");
      out.write("\tfont-size : 14px;\r\n");
      out.write("\tborder-radius : 4px;\r\n");
      out.write("\tpadding : 8px;\r\n");
      out.write("\tresize : none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t//입력창에서 Enter를 누르면 호출되는 함수\r\n");
      out.write("\tfunction pressEnter(){\r\n");
      out.write("\t \tif(event.keyCode == 13){\r\n");
      out.write("\t \t\t//공백일 경우에는 진행하지 않는다.\r\n");
      out.write("  \t\t\tif( $('#chatContent').val() !=\"\"){\r\n");
      out.write("  \t\t\t\t//console.log(\"chatcontent가 공백이 아닙니다.\")\r\n");
      out.write("  \t\t\t\tsendMessage();\r\n");
      out.write("\t\t\t\t//$('#chatContent').vla(\"\");\r\n");
      out.write("\t\t\t\t//$('#chatContent').blur();\r\n");
      out.write("\t\t\t\t//$('#chatContent').empty();\r\n");
      out.write("  \t\t\t} // 메시지 입력창이 빈칸일 경우 끝\r\n");
      out.write(" \t\t$(\"#chatContent\").val(\"\");\r\n");
      out.write("\t\t} // 엔터키를 입력했을 경우 끝\r\n");
      out.write("\t}//pressEnter 함수 끝\r\n");
      out.write("  \r\n");
      out.write("\t\r\n");
      out.write("\t//Send 버튼을 누르면 호출되는 함수\r\n");
      out.write("\t//#chatContent에 작성된 내용을 DB로 보내 저장한다.\r\n");
      out.write("\tfunction sendMessage() {\r\n");
      out.write("\t\t//회원번호를 세션에서 가져온다.\r\n");
      out.write("\t\tvar userNo = \"");
      out.print(user.getUser_no() );
      out.write("\";\r\n");
      out.write("\t\t//전달객체인 채팅방 번호를 가져온다.\r\n");
      out.write("\t\tvar roomNo = \"");
      out.print(chatting_no );
      out.write("\";\r\n");
      out.write("\t   \t//#chatContent에서 값을 가져온다.\r\n");
      out.write("\t   \tvar message = $('#chatContent').val();\r\n");
      out.write("\t   \t\r\n");
      out.write("\t   \t//채팅입력창안에 공백이거나 개행문자가 있을 경우 종료\r\n");
      out.write("// \t\tif ( message == \"\" || message ==\"\\n\"){\r\n");
      out.write("// \t\t\treturn false;\r\n");
      out.write("// \t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t   \t//비동기방식으로 채팅내용을 db에 저장할수 있도록 한다.\r\n");
      out.write("\t   \t$.ajax({\r\n");
      out.write("\t   \t\ttype: \"POST\"\r\n");
      out.write("\t   \t\t, url : \"/chat/msgent\"\r\n");
      out.write("\t   \t\t, data : {\r\n");
      out.write("\t   \t\t\tuser0_no : userNo\r\n");
      out.write("\t   \t\t\t,chatting_no : roomNo\r\n");
      out.write("\t   \t\t\t,msg : message\r\n");
      out.write("\t   \t\t}\r\n");
      out.write("\t\t\t, dataType: \"json\"\r\n");
      out.write("\t\t\t, success : function (data){\r\n");
      out.write("\t\t\t\tconsole.log(\"msgsend\")\r\n");
      out.write("\t\t\t\tconsole.log(data)\r\n");
      out.write("\t\t   \t\tconsole.log(\"AJAX 요청(db에 메세지 전달)성공\");\r\n");
      out.write("\t\t   \t\t\r\n");
      out.write("\t\t   \t}\r\n");
      out.write("\t\t   \t, error : function (){\r\n");
      out.write("\t\t   \t\tconsole.log(\"AJAX 요청(db에 메시지 전달) 실패\");\r\n");
      out.write("\t\t   \t}\r\n");
      out.write("\t   \t});//ajax설정 끝\r\n");
      out.write("\t}//sendMessage 함수 끝\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t//db에서 메세지 로드해오기.\r\n");
      out.write("\tvar msg_no = ");
      out.print(clist.size() );
      out.write(";\r\n");
      out.write("\tfunction msgload( ){\r\n");
      out.write("\t\tvar roomNo = \"");
      out.print(chatting_no );
      out.write("\";\r\n");
      out.write("\t\tvar userNo = \"");
      out.print(user.getUser_no() );
      out.write("\";\r\n");
      out.write("\t\tvar userNo2 = \"");
      out.print(opponentUser.getUser_no() );
      out.write("\";\r\n");
      out.write("\t\tconsole.log(msg_no);\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype:\"POST\"\r\n");
      out.write("\t\t\t, url : \"/chat/msgload\"\r\n");
      out.write("\t\t\t, async : false\r\n");
      out.write("\t\t\t, data : {\r\n");
      out.write("\t\t\t\tchatting_no : roomNo\r\n");
      out.write("\t\t\t\t, user0_no : userNo\r\n");
      out.write("\t\t\t\t, user1_no : userNo2\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t, dataType: \"json\"\r\n");
      out.write("\t\t\t, success : function (data){\r\n");
      out.write("\t\t\t\tconsole.log(\"AJAX요청 성공\");\r\n");
      out.write("\t\t\t\tconsole.log(data)\r\n");
      out.write("\t\t\t\t//console.log(data.last);\r\n");
      out.write("\t\t\t\t//console.log(msg_no);\r\n");
      out.write("\t\t\t\tvar clist = data.result;\r\n");
      out.write("\t\t\t\t//console.log (clist[1][0].value);\r\n");
      out.write("\t\t\t\t//console.log (clist[1][1].value);\r\n");
      out.write("\t\t\t\t//console.log (clist[1][2].value);\r\n");
      out.write("\t\t\t\t//$('#chatList').empty();\r\n");
      out.write("\t\t\t\tif( msg_no < data.last){\r\n");
      out.write("\t\t\t\t\tfor (msg_no; msg_no<data.last; msg_no++){\r\n");
      out.write("\t\t\t\t\t\tconsole.log(\"반복문 안에 들어왔나요?\");\r\n");
      out.write("\t\t\t\t\t\t$('#chatList').append(clist[msg_no][0].value);\r\n");
      out.write("\t\t\t\t\t\t$('#chatList').append(clist[msg_no][1].value);\r\n");
      out.write("\t\t\t\t\t\t$('#chatList').append(clist[msg_no][2].value);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tmsg_no = data.last;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t$('#chatList').scrollTop($('#chatList')[0].scrollHeight);\r\n");
      out.write("\t\t\t\tmsg_no = data.last;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t, error : function(){\r\n");
      out.write("\t\t\t\tconsole.log(\"AJAX 연결 실패\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t})//ajax설정 끝\r\n");
      out.write("\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t}//msgload 함수 끝\r\n");
      out.write("\t\t\r\n");
      out.write("\tfunction autoLoad(){\r\n");
      out.write("\t\tsetInterval(msgload, 2000);\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class =\"container bootstrap snippet\">\r\n");
      out.write("\t<div class=\"row\">\r\n");
      out.write("\t\t<div class=\"col-xs-12\">\r\n");
      out.write("\t\t\t<div class=\"portlet portlet-default\">\r\n");
      out.write("\t\t\t\t<div class=\"portlet-heading\">\r\n");
      out.write("\t\t\t\t\t<div class=\"portlet-title\">\r\n");
      out.write("\t\t\t\t\t\t<h4><i class=\"fa fa-circle text-green\"></i>");
      out.print(opponentUser.getUser_name() );
      out.write("님과 대화</h4>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"clearfix\"></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div id=\"chat\" class=\"panel-collaps collapse in\">\r\n");
      out.write("\t\t\t\t\t<!-- 콘솔 메시지의 역할을 하는 div태그.(수신 메시지도 표시한다.) -->\r\n");
      out.write("\t\t\t\t\t<div id=\"chatList\" class=\"portlet-body chat-widget\" style=\"overflow-y: auto; width:auto; height: 600px;\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"portlet-footer\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"row\" style=\"height:90px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-group col-xs-10\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" id=\"chatContent\" style=\"height : 80px;\"  class=\"form-control\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\tonKeyDown=\"pressEnter()\" maxlength=\"100\" />\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-group col-xs-2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<!--<button type=\"button\" class=\"btn btn-default pull-right\" onclick=\"submitFunction();\" onclick=\"sendMessage()\">전송</button> -->\r\n");
      out.write("\t\t\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-default pull-right\" onclick=\"sendMessage()\">전송</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input id=\"disconnBtn\" value=\"나가기\" type=\"button\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"clear-fix\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\t\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">  \r\n");
      out.write("\tautoLoad();\r\n");
      out.write("\t// 대화생성시되면 호출되는 문구\r\n");
      out.write("\t//\t- 첫 대화면 대화 시작 \r\n");
      out.write("\t// ###님과 대화가 시작되었습니다.\r\n");
      out.write("\t//\t- 대화 이력이 있으면 기존대화를 불러온다.\r\n");
      out.write("\t\r\n");
      out.write("\t//첫 대화여부는 데이터베이스에서 채팅방에 대화가 있는지 확인한다.\r\n");
      out.write("\t// servlet에서 객체로 전달을 받아온다.\r\n");
      out.write("\t");
 if( clist.size() == 0 ) { 
      out.write("\r\n");
      out.write("\t\tconsole.log(\"true\");\r\n");
      out.write("\t\t//\t//대화 시작 안내 문구.\r\n");
      out.write("\t\t$('#chatList').append('<div class=\"row\">'+ '<strong>'\r\n");
      out.write("\t\t\t+\"");
      out.print(opponentUser.getUser_name() );
      out.write("\"+'</strong>'\r\n");
      out.write("\t\t\t+\"님과 대화가 시작되었습니다.\"+'</div>' +'<hr>');\r\n");
      out.write("\t\t\r\n");
      out.write("\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t//첫대화가 아니면 대화 객체의 리스트를 #chatlist에 자식요소로 추가한다.\r\n");
      out.write("\t\t//리스트 반복실행실시.\r\n");
      out.write("\t\t//\t리스트에서 작성자 번호랑 나랑 일치하면 내가 작성한것으로 표시\r\n");
      out.write("\t\t//\t\t불일치하면 상대방이 작성한것으로 표시\r\n");
      out.write("\t\t");
 for(SendMsgClient s : clist) { 
      out.write("\r\n");
      out.write("\t\t\t$('#chatList').append( \"");
      out.print(s.getWinfo() );
      out.write("\" );\r\n");
      out.write("\t\t\t$('#chatList').append( \"");
      out.print(s.getChatTime() );
      out.write("\" );\r\n");
      out.write("\t\t\t$('#chatList').append( \"");
      out.print(s.getMsgContent() );
      out.write("\" );\r\n");
      out.write("\t\t");
 } 
      out.write('\r');
      out.write('\n');
      out.write('	');
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t  \r\n");
      out.write("\t// 대화방을 나가면 나타나는 문구 설정\r\n");
      out.write("\t// Disconnect 버튼을 누르면 호출되는 함수\r\n");
      out.write("\tdisconnBtn.onclick = function disconnect() {\r\n");
      out.write("\t\t$('#chatlist').append('<div class=\"row\">'+ '<strong>'\r\n");
      out.write("\t\t\t+\"");
      out.print(opponentUser.getUser_name() );
      out.write("\"+'</strong>'\r\n");
      out.write("\t\t\t+\"님과 대화가 종료되었습니다.\" +'</div><hr>');\r\n");
      out.write("\t }\r\n");
      out.write("\t\r\n");
      out.write("\t//스크롤바를 하단으로 고정하여 최근대화가 보이게 한다.\r\n");
      out.write("\t$('#chatList').scrollTop($('#chatList')[0].scrollHeight);\r\n");
      out.write("</script>\r\n");
      out.write(" \r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
