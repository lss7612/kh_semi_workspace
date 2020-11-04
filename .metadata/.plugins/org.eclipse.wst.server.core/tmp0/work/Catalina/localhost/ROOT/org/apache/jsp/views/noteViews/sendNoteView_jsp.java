/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.37
 * Generated at: 2020-11-04 07:46:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.noteViews;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import dto.note.NoteList;
import dto.addr.AddrView;

public final class sendNoteView_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("dto.note.NoteList");
    _jspx_imports_classes.add("dto.addr.AddrView");
    _jspx_imports_classes.add("java.util.Date");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
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
      			null, true, 8192, true);
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
      out.write("    \r\n");
      out.write("    \r\n");
 NoteList list = (NoteList)request.getAttribute("noteList"); 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"https://code.jquery.com/jquery-2.2.4.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/views/noteViews/resource/sendNoteView.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/views/noteViews/resource/noteView.css\"></link>\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/views/common/headerKKH.jsp", out, false);
      out.write("\r\n");
      out.write("<div class=\"content-wrapper\">\r\n");
      out.write("\r\n");
      out.write("<br>\r\n");
      out.write("<h1 style=\"text-align:center;\">보낸 쪽지 보기</h1>\r\n");
      out.write("<hr>\r\n");
      out.write("\r\n");
 String sender_name =  list.getSender_name();
      out.write('\r');
      out.write('\n');
 String sender_DeptName = list.getSenderDept_name(); 
      out.write('\r');
      out.write('\n');
 String sender_PositionName = list.getPosition(); 
      out.write('\r');
      out.write('\n');
 
      out.write('\r');
      out.write('\n');
 String send_date = list.getSend_date(); 
      out.write('\r');
      out.write('\n');
 List<AddrView> receivers =  list.getReceivers();
      out.write('\r');
      out.write('\n');
 String note_article = list.getNote_article(); 
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"view_content_wrap\">\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"content_title\">\r\n");
      out.write("\t\t<span class=\"note_no0\">");
      out.print( list.getNote_no() );
      out.write("</span>\r\n");
      out.write("\t\t<h3>");
      out.print( list.getNote_title() );
      out.write("</h3>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"content_sub_title\">\r\n");
      out.write("\t\t<div class=\"content_sub_title_1\">\r\n");
      out.write("\t\t\t<span class=\"user_name\">보낸사람: <span>");
      out.print(sender_DeptName +"/"+sender_PositionName+"/"+ sender_name  );
      out.write("</span></span>\r\n");
      out.write("\t\t\t<span class=\"send_date\" style=\"float:right;\">보낸시간:");
      out.print( "("+ send_date	+")" );
      out.write("</span>\r\n");
      out.write("\t\t</div>\t\t\r\n");
      out.write("\t\t<div class=\"content_sub_title2\">\r\n");
      out.write("\t\t\t<span class=\"receiver\">받는사람:</span>\r\n");
      out.write("\t\t\t");
 for (int i = 0; i < list.getReceivers().size(); i++) {
      out.write("\r\n");
      out.write("\t\t\t<span class=\"receiver");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print( receivers.get(i).getDept_name()+"/"+ receivers.get(i).getPosition_name()+"/"+ receivers.get(i).getUser_name()  );
      out.write("</span>\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"content_article\">");
      out.print( note_article );
      out.write("</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"button\">\r\n");
      out.write("\t\t<span class=\"cursor reply\" style=\"display:none\">답장</span>\r\n");
      out.write("\t\t<span class=\"cursor delete\">삭제</span>\r\n");
      out.write("\t\t<span class=\"cursor toReceivedNoteList\">받은쪽지함으로</span>\r\n");
      out.write("\t\t<span class=\"cursor toSendNoteList\">보낸쪽지함으로</span>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/views/noteViews/buttons.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/views/common/footerKKH.jsp", out, false);
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
