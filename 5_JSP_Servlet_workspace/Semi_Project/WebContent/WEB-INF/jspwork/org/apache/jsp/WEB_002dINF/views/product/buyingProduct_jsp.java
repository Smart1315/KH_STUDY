/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.38
 * Generated at: 2020-11-05 15:35:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import member.model.vo.Member;

public final class buyingProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("member.model.vo.Member");
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

	Member loginMember = (Member)session.getAttribute("loginMember");
	int pId = (int)request.getAttribute("pId");
	String writer = (String)request.getAttribute("www");
	int price = (int)request.getAttribute("price");
	
	String writerId = (String)request.getAttribute("wId");
	String pTitle = (String)request.getAttribute("pTitle");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>거래 신청하기</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print( request.getContextPath() );
      out.write("/resources/css/buyingProduct.css\">\r\n");
      out.write("<script type=\"text/JavaScript\" src=\"");
      out.print( request.getContextPath() );
      out.write("/resources/js/jquery-3.5.1.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<h2 align=\"center\">거래 신청하기</h2>\r\n");
      out.write("\t\r\n");
      out.write("\t<br>\r\n");
      out.write("\t\r\n");
      out.write("\t<form action=\"");
      out.print( request.getContextPath() );
      out.write("/buyingP.do\" method=\"post\" id=\"buyingProduct\" name=\"buyingProductForm\" onsubmit=\"return send();\">\t\t\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"pId\" value=\"");
      out.print( pId );
      out.write("\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"writerId\" value=\"");
      out.print( writerId );
      out.write("\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"userId\" value=\"");
      out.print( loginMember.getId() );
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t신청인 : <input type=\"text\" name=\"user\" value=\"");
      out.print( loginMember.getNickName() );
      out.write("\" readonly> <br><br>\r\n");
      out.write("\t\t상품명 : <input type=\"text\" name=\"pTitle\" value=\"");
      out.print( pTitle );
      out.write("\"><br><br>\r\n");
      out.write("\t\t가격  : <input type=\"text\" value=\"");
      out.print( price );
      out.write("원\" readonly> <br><br>\r\n");
      out.write("\t\t판매자 : <input type=\"text\" name=\"receiver\" value=\"");
      out.print( writer );
      out.write("\" readonly> <br><br>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<input type=\"checkbox\" id=\"allow\"> 가격과 상품 상태를 모두 확인했으며, <br>\r\n");
      out.write("\t\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;게시자에게 거래를 신청합니다.    \r\n");
      out.write("\t\t<br><br>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"btns\">\r\n");
      out.write("\t\t\t<input id=\"okayBtn\" type=\"button\" onclick=\"checkfield();\" value=\"신청하기\">\r\n");
      out.write("\t\t\t<input type=\"button\" id=\"cancelBtn\" onclick=\"self.close();\" value=\"취소하기\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\tfunction checkfield(){\r\n");
      out.write("\t        var no = 0;\r\n");
      out.write("\t        for(var i=0; i< buyingProductForm.elements.length; i++) {\r\n");
      out.write("\t           var check = buyingProductForm.elements[i];\r\n");
      out.write("\t           if(check.checked == true) {\r\n");
      out.write("\t              no++;\r\n");
      out.write("\t           }\r\n");
      out.write("\t        }\r\n");
      out.write("\t        \r\n");
      out.write("\t        if(no == 0){\r\n");
      out.write("\t           alert('확인 체크를 해주세요.');\r\n");
      out.write("\t           return;\r\n");
      out.write("\t        }\r\n");
      out.write("\t        buyingProductForm.submit();\r\n");
      out.write("        }\r\n");
      out.write("\t\t\r\n");
      out.write("\t</script>\r\n");
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
