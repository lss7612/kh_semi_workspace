/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.37
 * Generated at: 2020-11-04 02:16:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.noteViews;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dto.note.NotePaging;

public final class sendNoteBinList_005fpaging_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("dto.note.NotePaging");
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
      out.write("    \r\n");
 NotePaging paging = (NotePaging) request.getAttribute("paging"); 
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("ul.pagination {\r\n");
      out.write("\tlist-style: none;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("}\r\n");
      out.write("ul.pagination li {\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\twidth: 20px;\r\n");
      out.write("    border: 1px solid #ccc;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("}\r\n");
      out.write("ul.pagination li a {\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\tcolor: black;\r\n");
      out.write("}\r\n");
      out.write("ul.pagination li.active a {\r\n");
      out.write("\tcolor: red;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"text-center\">\r\n");
      out.write("<ul class=\"pagination\">\r\n");
      out.write("\r\n");
      out.write("\t<!-- 첫 페이지로 가기 -->\r\n");
      out.write("\t");
	if( paging.getCurPage() != 1 ) { 
      out.write("\r\n");
      out.write("\t<li><a href=\"/note/sendnotebin\">&larr;</a></li>\r\n");
      out.write("\t");
	} 
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 이전 페이지로 가기 -->\r\n");
      out.write("\t");
	if( paging.getCurPage() != 1 ) { 
      out.write("\r\n");
      out.write("\t<li><a href=\"/note/sendnotebin?curPage=");
      out.print(paging.getCurPage()-1 );
      out.write("\">&lt;</a></li>\r\n");
      out.write("\t");
	} 
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- 페이징 리스트 -->\r\n");
      out.write("\t");
	for(int i=paging.getStartPage(); i<=paging.getEndPage(); i++) { 
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t");
		if( i == paging.getCurPage() ) { 
      out.write("\r\n");
      out.write("\t<li class=\"active\"><a href=\"/note/sendnotebin?curPage=");
      out.print(i );
      out.write('"');
      out.write('>');
      out.print(i );
      out.write("</a></li>\r\n");
      out.write("\t");
		} 
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t");
		if( i != paging.getCurPage() ) { 
      out.write("\r\n");
      out.write("\t<li><a href=\"/note/sendnotebin?curPage=");
      out.print(i );
      out.write('"');
      out.write('>');
      out.print(i );
      out.write("</a></li>\r\n");
      out.write("\t");
		} 
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t");
	} 
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 다음 페이지로 가기 -->\r\n");
      out.write("\t");
	if( paging.getCurPage() != paging.getTotalPage() ) { 
      out.write("\r\n");
      out.write("\t<li><a href=\"/note/sendnotebin?curPage=");
      out.print(paging.getCurPage()+1 );
      out.write("\">&gt;</a></li>\r\n");
      out.write("\t");
	} 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 마지막 페이지로 가기 -->\r\n");
      out.write("\t");
	if( paging.getCurPage() != paging.getTotalPage() ) { 
      out.write("\r\n");
      out.write("\t<li><a href=\"/note/sendnotebin?curPage=");
      out.print(paging.getTotalPage() );
      out.write("\">&rarr;</a></li>\r\n");
      out.write("\t");
	} 
      out.write("\r\n");
      out.write("</ul>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
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
