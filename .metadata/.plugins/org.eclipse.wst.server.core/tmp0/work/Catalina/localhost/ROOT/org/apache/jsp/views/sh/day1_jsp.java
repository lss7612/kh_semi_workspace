/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.37
 * Generated at: 2020-11-04 01:32:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.sh;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class day1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = null;
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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/views/common/headerKKH.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write(".cal_top{\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    font-size: 30px;\r\n");
      out.write("  \r\n");
      out.write("    text-align : center;\r\n");
      out.write("    margin:  0 auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#sh{\r\n");
      out.write("\r\n");
      out.write("    font-size: 20px;\r\n");
      out.write("    margin:  0 auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".cal{\r\n");
      out.write("    text-align: center;    \r\n");
      out.write("}\r\n");
      out.write("table.calendar{\r\n");
      out.write("    border: 1px solid black;\r\n");
      out.write("    display: inline-table;\r\n");
      out.write("    text-align: left;\r\n");
      out.write("}\r\n");
      out.write("table.calendar td{\r\n");
      out.write("    vertical-align: top;\r\n");
      out.write("    border: 1px solid skyblue;\r\n");
      out.write("    width: 100px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(".modal_wrap{\r\n");
      out.write("        display: none;\r\n");
      out.write("        width: 500px;\r\n");
      out.write("        height: 500px;\r\n");
      out.write("        position: absolute;\r\n");
      out.write("        top:50%;\r\n");
      out.write("        left: 50%;\r\n");
      out.write("        margin: -250px 0 0 -250px;\r\n");
      out.write("        background:#eee;\r\n");
      out.write("        z-index: 2;\r\n");
      out.write("    }\r\n");
      out.write("    .black_bg{\r\n");
      out.write("        display: none;\r\n");
      out.write("        position: absolute;\r\n");
      out.write("        content: \"\";\r\n");
      out.write("        width: 100%;\r\n");
      out.write("        height: 100%;\r\n");
      out.write("        background-color:rgba(0, 0,0, 0.5);\r\n");
      out.write("        top:0;\r\n");
      out.write("        left: 0;\r\n");
      out.write("        z-index: 1;\r\n");
      out.write("    }\r\n");
      out.write("    .modal_close{\r\n");
      out.write("        width: 26px;\r\n");
      out.write("        height: 26px;\r\n");
      out.write("        position: absolute;\r\n");
      out.write("        top: -30px;\r\n");
      out.write("        right: 0;\r\n");
      out.write("    }\r\n");
      out.write("    .modal_close> a{\r\n");
      out.write("        display: block;\r\n");
      out.write("        width: 100%;\r\n");
      out.write("        height: 100%;\r\n");
      out.write("   \t   background:url(https://img.icons8.com/metro/26/000000/close-window.png);\r\n");
      out.write("        text-indent: -9999px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("window.onload = function() {\r\n");
      out.write("\r\n");
      out.write("function onClick() {\r\n");
      out.write("    document.querySelector('.modal_wrap').style.display ='block';\r\n");
      out.write("    document.querySelector('.black_bg').style.display ='block';\r\n");
      out.write("}   \r\n");
      out.write("function offClick() {\r\n");
      out.write("    document.querySelector('.modal_wrap').style.display ='none';\r\n");
      out.write("    document.querySelector('.black_bg').style.display ='none';\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("document.getElementById('modal_btn').addEventListener('click', onClick);\r\n");
      out.write("document.querySelector('.modal_close').addEventListener('click', offClick);\r\n");
      out.write("\r\n");
      out.write("};\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div class=\"cal_top\"> \r\n");
      out.write("        <a href=\"#\" id=\"movePrevMonth\"><span id=\"prevMonth\" class=\"cal_tit\">&lt;</span></a>\r\n");
      out.write("        <span id=\"cal_top_year\"></span>\r\n");
      out.write("        <span id=\"cal_top_month\"></span>\r\n");
      out.write("        <a href=\"#\" id=\"moveNextMonth\"><span id=\"nextMonth\" class=\"cal_tit\">&gt;</span></a>\r\n");
      out.write("     <button type='button' id=\"modal_btn\">스케줄 입력</button>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\r\n");
      out.write("        \r\n");
      out.write("    \r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"cal_tab\" class=\"cal\">\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("   \r\n");
      out.write("     \r\n");
      out.write("\t<div class=\"black_bg\"></div>\r\n");
      out.write("\t<div class=\"modal_wrap\">\r\n");
      out.write("    \t<div class=\"modal_close\"><a href=\"#\">close</a></div>\r\n");
      out.write("    \t\r\n");
      out.write("    \t<!-- 스케줄 모달창 이름 -->\r\n");
      out.write("    \t<div>\r\n");
      out.write("  \t\t스케줄 입력\r\n");
      out.write("    \t</div><br>\r\n");
      out.write("    \t<!-- 스케줄 입력 모달창 시작 -->\r\n");
      out.write("    \t\r\n");
      out.write("    \t스케줄 타입\r\n");
      out.write("    \t<br>\r\n");
      out.write("\t\t<input type=\"radio\" name=\"type\" value=\"개인\">개인\r\n");
      out.write("\t\t<input type=\"radio\" name=\"type\" value=\"공유\">공유\r\n");
      out.write("\t\t<hr>\r\n");
      out.write("    \t\r\n");
      out.write("    \t스케줄 이름\r\n");
      out.write("    \t<br>\r\n");
      out.write("\t\t<input type=\"text\" >\r\n");
      out.write("\t\t<hr>\r\n");
      out.write("    \t\r\n");
      out.write("    \t스케줄 내용\r\n");
      out.write("    \t<br>\r\n");
      out.write("\t\t<input type=\"text\" >\r\n");
      out.write("\t\t<hr>\r\n");
      out.write("    \t\r\n");
      out.write("    \t   스케줄 시작 일자<br>\r\n");
      out.write("\t\t<input type=\"date\" name=\"d\"value=\"2020-10-01\"/>\r\n");
      out.write("\t\t<hr>\r\n");
      out.write("\r\n");
      out.write("\t\t   스케줄 종료 일자<br>\r\n");
      out.write("\t\t<input type=\"date\" name=\"d\"value=\"2020-10-01\"/><br><br>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t<button type=\"submit\" value=\"입력 완료\">입력완료 </button>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("    \t</div>\r\n");
      out.write("\t\t<div>\r\n");
      out.write("    \t<div>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("\t    \r\n");
      out.write("    \r\n");
      out.write(" <br><br>\r\n");
      out.write(" \r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    \r\n");
      out.write("    var today = null;\r\n");
      out.write("    var year = null;\r\n");
      out.write("    var month = null;\r\n");
      out.write("    var firstDay = null;\r\n");
      out.write("    var lastDay = null;\r\n");
      out.write("    var $tdDay = null;\r\n");
      out.write("    var $tdSche = null;\r\n");
      out.write(" \r\n");
      out.write("    $(document).ready(function() {\r\n");
      out.write("        drawCalendar();\r\n");
      out.write("        initDate();\r\n");
      out.write("        drawDays();\r\n");
      out.write("        $(\"#movePrevMonth\").on(\"click\", function(){movePrevMonth();});\r\n");
      out.write("        $(\"#moveNextMonth\").on(\"click\", function(){moveNextMonth();});\r\n");
      out.write("    });\r\n");
      out.write("    \r\n");
      out.write("    //calendar 그리기\r\n");
      out.write("    function drawCalendar(){\r\n");
      out.write("        var setTableHTML = \"\";\r\n");
      out.write("        setTableHTML+='<table class=\"calendar\">';\r\n");
      out.write("        setTableHTML+='<tr><th>SUN</th><th>MON</th><th>TUE</th><th>WED</th><th>THU</th><th>FRI</th><th>SAT</th></tr>';\r\n");
      out.write("        for(var i=0;i<6;i++){\r\n");
      out.write("            setTableHTML+='<tr height=\"100\">';\r\n");
      out.write("            for(var j=0;j<7;j++){\r\n");
      out.write("                setTableHTML+='<td style=\"text-overflow:ellipsis;overflow:hidden;white-space:nowrap\">';\r\n");
      out.write("                setTableHTML+='    <div class=\"cal-day\"></div>';\r\n");
      out.write("                setTableHTML+='    <div class=\"cal-schedule\"></div>';\r\n");
      out.write("                setTableHTML+='</td>';\r\n");
      out.write("            }\r\n");
      out.write("            setTableHTML+='</tr>';\r\n");
      out.write("        }\r\n");
      out.write("        setTableHTML+='</table>';\r\n");
      out.write("        $(\"#cal_tab\").html(setTableHTML);\r\n");
      out.write("    }\r\n");
      out.write(" \r\n");
      out.write("    //날짜 초기화\r\n");
      out.write("    function initDate(){\r\n");
      out.write("        $tdDay = $(\"td div.cal-day\")\r\n");
      out.write("        $tdSche = $(\"td div.cal-schedule\")\r\n");
      out.write("        dayCount = 0;\r\n");
      out.write("        today = new Date();\r\n");
      out.write("        year = today.getFullYear();\r\n");
      out.write("        month = today.getMonth()+1;\r\n");
      out.write("        firstDay = new Date(year,month-1,1);\r\n");
      out.write("        lastDay = new Date(year,month,0);\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    //calendar 날짜표시\r\n");
      out.write("    function drawDays(){\r\n");
      out.write("        $(\"#cal_top_year\").text(year);\r\n");
      out.write("        $(\"#cal_top_month\").text(month);\r\n");
      out.write("        for(var i=firstDay.getDay();i<firstDay.getDay()+lastDay.getDate();i++){\r\n");
      out.write("            $tdDay.eq(i).text(++dayCount);\r\n");
      out.write("        }\r\n");
      out.write("        for(var i=0;i<42;i+=7){\r\n");
      out.write("            $tdDay.eq(i).css(\"color\",\"red\");\r\n");
      out.write("        }\r\n");
      out.write("        for(var i=6;i<42;i+=7){\r\n");
      out.write("            $tdDay.eq(i).css(\"color\",\"blue\");\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write(" \r\n");
      out.write("    //calendar 월 이동\r\n");
      out.write("    function movePrevMonth(){\r\n");
      out.write("        month--;\r\n");
      out.write("        if(month<=0){\r\n");
      out.write("            month=12;\r\n");
      out.write("            year--;\r\n");
      out.write("        }\r\n");
      out.write("        if(month<10){\r\n");
      out.write("            month=String(\"0\"+month);\r\n");
      out.write("        }\r\n");
      out.write("        getNewInfo();\r\n");
      out.write("        }\r\n");
      out.write("    \r\n");
      out.write("    function moveNextMonth(){\r\n");
      out.write("        month++;\r\n");
      out.write("        if(month>12){\r\n");
      out.write("            month=1;\r\n");
      out.write("            year++;\r\n");
      out.write("        }\r\n");
      out.write("        if(month<10){\r\n");
      out.write("            month=String(\"0\"+month);\r\n");
      out.write("        }\r\n");
      out.write("        getNewInfo();\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    function getNewInfo(){\r\n");
      out.write("        for(var i=0;i<42;i++){\r\n");
      out.write("            $tdDay.eq(i).text(\"\");\r\n");
      out.write("        }\r\n");
      out.write("        dayCount=0;\r\n");
      out.write("        firstDay = new Date(year,month-1,1);\r\n");
      out.write("        lastDay = new Date(year,month,0);\r\n");
      out.write("        drawDays();\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/views/common/footerKKH.jsp", out, false);
      out.write('\r');
      out.write('\n');
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
