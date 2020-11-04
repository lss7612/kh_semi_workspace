/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.37
 * Generated at: 2020-11-04 01:33:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.addrViews;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import dto.addr.AddrView;
import dto.addr.AddrParam;
import java.util.List;

public final class view_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("dto.addr.AddrView");
    _jspx_imports_classes.add("dto.addr.AddrParam");
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
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
 List<AddrView>
  list = (List<AddrView
    >) request.getAttribute("list"); 
      out.write("\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/views/common/headerKKH.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <title>주소록</title>\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\" src=\"/resources/js/httpRequest.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"/views/addrViews/resource/view.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"/views/noteViews/resource/selectAll.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"/views/addrViews/resource/view.css\"></link>\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("<div class=\"content-wrapper\">\r\n");
      out.write("        <h1>주소록</h1>\r\n");
      out.write("        <hr />\r\n");
      out.write("          <article>\r\n");
      out.write("            <div id=\"search\">\r\n");
      out.write("              <form action=\"/address/search\" method=\"GET\">\r\n");
      out.write("                <input type=\"text\" class=\"keyword\"name=\"keyword\"><button class=\"search\">검색</button>\r\n");
      out.write("                <select class=\"classification\" name=\"classification\">\r\n");
      out.write("                  <option value=\"userid\">아이디</option>\r\n");
      out.write("                  <option value=\"username\" selected=\"selected\">이름</option>\r\n");
      out.write("                  <option value=\"dept\">부서</option>\r\n");
      out.write("                  <option value=\"position\">직급</option>\r\n");
      out.write("                  <option value=\"cellphone\">전화번호</option>\r\n");
      out.write("                </select>\r\n");
      out.write("              </form>\r\n");
      out.write("            </div>\r\n");
      out.write("            <hr>\r\n");
      out.write("              <div id=\"list\">\r\n");
      out.write("              <form id=\"sendNote\" action=\"/note/send\" method=\"GET\">\r\n");
      out.write("            <table>\r\n");
      out.write("              <thead>\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <th><input type=\"checkbox\" class=\"selectAllCheckbox\"/></th>\r\n");
      out.write("                  <th><span>사번</span></th>\r\n");
      out.write("                  <th><span name=\"dept\" class=\"ASC\">부서</span></th>\r\n");
      out.write("                  <th><span name=\"position\" class=\"ASC\">직급</span></th>\r\n");
      out.write("                  <th><span name=\"username\" class=\"content_title ASC\">이름</span></th>\r\n");
      out.write("                  <th><span name=\"userid\" class=\"ASC\">아이디</span></th>\r\n");
      out.write("                  <th>휴대전화</th>\r\n");
      out.write("                </tr>\r\n");
      out.write("              </thead>\r\n");
      out.write("                <tbody>\r\n");
      out.write("                ");
 for (int i = 0; i < list.size(); i++) { 
      out.write("\r\n");
      out.write("                  <tr class=\"\">\r\n");
      out.write("                    <td><input type=\"checkbox\" name=\"receiver_no");
      out.print(i);
      out.write("\" value=\"");
      out.print(list.get(i).getUser_no());
      out.write("\"></td>\r\n");
      out.write("                    <td class=\"user_no\">");
      out.print(list.get(i).getUser_no());
      out.write("</td>\r\n");
      out.write("                    <td class=\"dept_name\">");
      out.print(list.get(i).getDept_name() );
      out.write("</td>\r\n");
      out.write("                    <td class=\"position_name\">");
      out.print(list.get(i).getPosition_name() );
      out.write("</td>\r\n");
      out.write("                    <td class=\"user_name\">\r\n");
      out.write("                    \t<span class=\"users\">");
      out.print(list.get(i).getUser_name() );
      out.write("</span>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td class=\"user_id\">");
      out.print(list.get(i).getUser_id());
      out.write("</td>\r\n");
      out.write("                    <td class=\"cellphone_no\">");
      out.print(list.get(i).getCellphone_no() );
      out.write("</td>\r\n");
      out.write("                    <td><span class=\"chat\">채팅하기</span></td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("                  ");
 } 
      out.write("\r\n");
      out.write("                </tbody>\r\n");
      out.write("              </table>\r\n");
      out.write("              </form>\r\n");
      out.write("            </div>\r\n");
      out.write("            <hr>\r\n");
      out.write("       \t\t<button class=\"sendNote\">쪽지보내기</button>\r\n");
      out.write("          </article>\r\n");
      out.write("           ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/views/addrViews/paging.jsp", out, false);
      out.write("\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
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
