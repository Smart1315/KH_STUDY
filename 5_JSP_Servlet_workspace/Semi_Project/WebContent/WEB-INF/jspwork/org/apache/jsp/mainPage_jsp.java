/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.38
 * Generated at: 2020-11-10 10:49:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import common.model.vo.ProductMain;
import java.util.ArrayList;
import product.model.vo.*;
import java.util.*;
import java.io.File;
import member.model.vo.Member;

public final class mainPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(6);
    _jspx_dependants.put("/WEB-INF/views/common/ad.jsp", Long.valueOf(1604579455592L));
    _jspx_dependants.put("/resources/globalVariable.jsp", Long.valueOf(1604494327421L));
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1604579455634L));
    _jspx_dependants.put("/WEB-INF/views/common/nav.jsp", Long.valueOf(1604579455644L));
    _jspx_dependants.put("/WEB-INF/views/common/footer.jsp", Long.valueOf(1604579455623L));
    _jspx_dependants.put("/WEB-INF/views/common/tom.jsp", Long.valueOf(1604579455662L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("product.model.vo");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("member.model.vo.Member");
    _jspx_imports_classes.add("common.model.vo.ProductMain");
    _jspx_imports_classes.add("java.io.File");
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	ArrayList<ProductMain> list = (ArrayList<ProductMain>) request.getAttribute("pList");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>로컬마켓</title>\r\n");
      out.write('\r');
      out.write('\n');

	String context = request.getContextPath();

      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\tvar context = \"");
      out.print( context );
      out.write("\";\r\n");
      out.write("</script>\r\n");
      out.write("<script src=\"");
      out.print( context );
      out.write("/resources/js/jquery-3.5.1.min.js\"></script>\r\n");
      out.write("<link rel = \"icon\" href = \"");
      out.print( context );
      out.write("/favicon.ico\">");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print( context );
      out.write("/resources/css/base.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print( context );
      out.write("/resources/css/content-area.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print( context );
      out.write("/resources/css/content.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print( context );
      out.write("/resources/css/mainpage.css\">\r\n");
      out.write("<style>\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("   <div class=\"wrap\">\r\n");
      out.write("      ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	Member loginMember = (Member)session.getAttribute("loginMember");
	String pImageName = null;
	if(loginMember != null && loginMember.getpImage() != null) {
		File f = new File(loginMember.getpImage());
		pImageName = f.getName();
	}

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>header</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print( context );
      out.write("/resources/css/header.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id='header'>\r\n");
      out.write("\t\t\t<a href=\"");
      out.print( context );
      out.write("/\"> \r\n");
      out.write("\t\t\t\t<img id='logo-img' alt=\"로컬마켓\" src=\"");
      out.print( context );
      out.write("/resources/images/rocket.png\"></a>\r\n");
      out.write("\t\t\t<a href=\"");
      out.print( context );
      out.write("/\"><span id=\"logo-text\">로켓</span></a>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t <form action=\"allSearch.all\" method=\"get\" class=\"AllSearchForm\">\r\n");
      out.write("       \t \t<div id=\"header-search\">\r\n");
      out.write("            <input type=\"text\" name=\"word\" placeholder=\"검색어를 입력하세요!\"> \r\n");
      out.write("            <button class=\"glyphicon glyphicon-search\" id=\"AllSearchBtn\"></button>\r\n");
      out.write("         \t</div>\r\n");
      out.write("         </form>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t");
 if(loginMember == null) { 
      out.write("\r\n");
      out.write("\t\t\t\t<div id=\"account\">\r\n");
      out.write("\t\t\t\t\t<form action=\"");
      out.print( context );
      out.write("/login.do\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t<div id=\"id-area\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" name=\"idInput\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<button type=\"submit\" id=\"login\" value=\"로그인\">로그인</button>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t\t<div id=\"pw-area\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"password\" class=\"form-control\" name=\"pwInput\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<button type=\"button\" id=\"signup\" value=\"회원가입\" onclick=\"location.href='");
      out.print( context );
      out.write("/joinForm.do'\">회원가입</button><br>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"button\" id=\"find\" value=\"ID/PW찾기\" onclick=\"findIDPW();\" style=\"float: right; width: 80px; font-weight:bold; border:none;\">\t\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t<div id=\"account_info\">\r\n");
      out.write("\t\t\t\t<div id=\"profileArea\">\r\n");
      out.write("\t\t\t\t");
 if(loginMember.getpImage() == null) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<label id=\"memberIcon\" class=\"glyphicon glyphicon-user\" style=\"top:15px; right: 30px;\"></label>\r\n");
      out.write("\t\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<img id=\"memberImg\" src=\"");
      out.print( context );
      out.write("/userProfile_uploadFiles/");
      out.print( pImageName );
      out.write("\">\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div id=\"membername\">");
      out.print( loginMember.getNickName() );
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div id=\"memberbtn\">\r\n");
      out.write("                  <button id='logoutBtn' onclick=\"location.href='");
      out.print( context );
      out.write("/logout.do'\">로그아웃</button>\r\n");
      out.write("                  <br>\r\n");
      out.write("                  <button id=\"myPageBtn\" onclick=\"location.href='");
      out.print( context );
      out.write("/myPage.do'\">마이페이지</button>\r\n");
      out.write("                  <br>\r\n");
      out.write("                  <button id=\"messageBtn\" onclick=\"location.href='");
      out.print( context );
      out.write("/message.do'\">쪽지함</button>\r\n");
      out.write("               </div>\r\n");
      out.write("               <div id=\"alarm\">\r\n");
      out.write("                  <button class=\"glyphicon glyphicon-bell\" onclick=\"location.href='");
      out.print( context );
      out.write("/receiveP.do'\"></button>\r\n");
      out.write("               </div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\t");
 if(loginMember != null) { 
      out.write("\r\n");
      out.write("\t\t\tvar openProfile = function(closeCallback) {\r\n");
      out.write("\t\t\t    var win = window.open('setProfileImgForm.do', 'setProfileImgForm', 'width=500, height=450');\r\n");
      out.write("\t\t\t    var interval = window.setInterval(function() {\r\n");
      out.write("\t\t\t        try {\r\n");
      out.write("\t\t\t            if (win == null || win.closed) {\r\n");
      out.write("\t\t\t                window.clearInterval(interval);\r\n");
      out.write("\t\t\t                closeCallback(win);\r\n");
      out.write("\t\t\t            }\r\n");
      out.write("\t\t\t        }\r\n");
      out.write("\t\t\t        catch (e) {\r\n");
      out.write("\t\t\t        }\r\n");
      out.write("\t\t\t    }, 1000);\r\n");
      out.write("\t\t\t    return win;\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tdocument.getElementById(\"profileArea\").onclick = function() {\r\n");
      out.write("\t\t\t\topenProfile(function(win) {\r\n");
      out.write("\t\t\t\t\tlocation.reload(true);\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\t");
 } else { 
      out.write("\r\n");
      out.write("      \tfunction findIDPW() {\r\n");
      out.write("      \t\twindow.open('findIDPWForm.do', 'findIDPWForm', 'width=500, height=135');\r\n");
      out.write("\t\t}\r\n");
      out.write("      \r\n");
      out.write("      ");
 } 
      out.write("\r\n");
      out.write("\t\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("      <div id=\"content-area\">\r\n");
      out.write("         ");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>nav</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print( context );
      out.write("/resources/css/nav.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("   <div id=\"nav\">\r\n");
      out.write("   \r\n");
      out.write("            <br>\r\n");
      out.write("            <br>\r\n");
      out.write("            \r\n");
      out.write("            <!-- ------------------------------------------------------------------------------------- -->\r\n");
      out.write("            <div id=\"menu-area\">\r\n");
      out.write("               <ul class=\"out-menu\">\r\n");
      out.write("                  <label class=\"glyphicon glyphicon-camera\"><div>중고물품</div></label>\r\n");
      out.write("                  <li><button onclick=\"location.href='");
      out.print( context );
      out.write("/list.pro'\">중고 물품보기</button></li>\r\n");
      out.write("                  ");
 if(loginMember != null) { 
      out.write("\r\n");
      out.write("                     <li><button onclick=\"location.href='");
      out.print( context );
      out.write("/registerForm.pro'\">중고 물품등록</button></li>\r\n");
      out.write("                    ");
 } 
      out.write("\r\n");
      out.write("               </ul>\r\n");
      out.write("               <ul class=\"out-menu\">\r\n");
      out.write("                  <label class=\"glyphicon glyphicon-tag\"><div>공동구매</div></label>\r\n");
      out.write("                  <li><button onclick=\"location.href='");
      out.print( context );
      out.write("/groupList.do'\">공동구매 목록조회</button></li>\r\n");
      out.write("                  ");
 if(loginMember != null && loginMember.getRankCode() == 99) { 
      out.write("\r\n");
      out.write("                  <li><button onclick=\"location.href='");
      out.print( context );
      out.write("/groupWriteForm.do'\">공동구매 물품등록</button></li> \r\n");
      out.write("\r\n");
      out.write("                  ");
 } 
      out.write("\r\n");
      out.write("               </ul>\r\n");
      out.write("               <ul class=\"out-menu menuBtn\" onclick=\"location.href='");
      out.print( context );
      out.write("/boardList.do'\">\r\n");
      out.write("                  <label class=\"glyphicon glyphicon-list\" class=\"menuBtn\"><div class=\"menuBtn\">자유게시판</div></label>\r\n");
      out.write("               </ul>\r\n");
      out.write("               ");
 if(loginMember != null && loginMember.getRankCode() == 99) { 
      out.write("\r\n");
      out.write("               <ul class=\"out-menu\">\r\n");
      out.write("                  <label class=\"glyphicon glyphicon-lock\"><div>관리자</div></label>\r\n");
      out.write("                  <li><button onclick=\"location.href='");
      out.print( context );
      out.write("/managerInfo.do'\">회원 정보 관리</li>\r\n");
      out.write("                  <li><button onclick=\"location.href='");
      out.print( context );
      out.write("/managerreport.do'\">신고 목록 관리</li>\r\n");
      out.write("               </ul>\r\n");
      out.write("               ");
 } 
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <hr>\r\n");
      out.write("            <!-- ------------------------------------------------------------------------------------- -->\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Top of this Month</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print( context );
      out.write("/resources/css/tom.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"tom\">\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<b>이달의 로켓왕!</b>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<table id=\"tom-table\">\r\n");
      out.write("\t\t\t<tr id=\"table-head\">\r\n");
      out.write("\t\t\t\t<th>No.</th>\r\n");
      out.write("\t\t\t\t<th>Name</th>\r\n");
      out.write("\t\t\t\t<th>거래 수</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<div id=\"loading\">\r\n");
      out.write("\t\t\t<img src=\"");
      out.print( context );
      out.write("/resources/images/loading.gif\"/>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("\t\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\turl: 'topOfMonth.do',\r\n");
      out.write("\t\ttype: 'post',\r\n");
      out.write("\t\tdata: {first: 1, last: 3},\r\n");
      out.write("\t\tsuccess: function(data) {\t\r\n");
      out.write("\t\t\tvar table = document.getElementById(\"tom-table\");\r\n");
      out.write("\t\t\tfor(var i in data) {\r\n");
      out.write("\t\t\t\tvar tr = document.createElement(\"tr\");\r\n");
      out.write("\t\t\t\tvar td1 = document.createElement(\"td\");\r\n");
      out.write("\t\t\t\ttd1.innerHTML = data[i].rank;\r\n");
      out.write("\t\t\t\tvar td2 = document.createElement(\"td\");\r\n");
      out.write("\t\t\t\ttd2.innerHTML = data[i].nickname;\r\n");
      out.write("\t\t\t\tvar td3 = document.createElement(\"td\");\r\n");
      out.write("\t\t\t\ttd3.innerHTML = data[i].count;\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\ttr.appendChild(td1);\r\n");
      out.write("\t\t\t\ttr.appendChild(td2);\r\n");
      out.write("\t\t\t\ttr.appendChild(td3);\r\n");
      out.write("\t\t\t\ttable.appendChild(tr);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t$('#tom-table').show();\r\n");
      out.write("\t\t\t$('#loading').hide();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("            <!-- ------------------------------------------------------------------------------------- -->\r\n");
      out.write("         </div>\r\n");
      out.write("         \r\n");
      out.write("         <script>\r\n");
      out.write("            $('.out-menu').click(function(){\r\n");
      out.write("               $(this).children().next().slideToggle();\r\n");
      out.write("            });\r\n");
      out.write("         </script>\r\n");
      out.write("         \r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("         \r\n");
      out.write("         <div id=\"content\">\r\n");
      out.write("            <div id=\"welcome\">\r\n");
      out.write("            <img src=\"resources/images/q2q2.jpg\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <br>\r\n");
      out.write("            <br>\r\n");
      out.write("            <br>\r\n");
      out.write("            \r\n");
      out.write("            <hr>\r\n");
      out.write("            \r\n");
      out.write("            <div id=\"mainpage1\">         \r\n");
      out.write("               <span id=\"Monthitle\">이번달 인기 상품</span>\r\n");
      out.write("               <div id=\"item-list\">\r\n");
      out.write("\t\t\t\t\t");
 for(ProductMain p : list) { 
      out.write("\r\n");
      out.write("\t\t               <div class=\"item\">\r\n");
      out.write("\t\t               \t\t<a href=\"javascript:void(0);\" onclick=\"productLink('");
      out.print( context );
      out.write("/pdetail.pro?option=0&pId=");
      out.print( p.getProductNum() );
      out.write("');\"> \r\n");
      out.write("\t\t               \t\t<img alt=\"상품\" src=\"");
      out.print( context );
      out.write("/product_uploadFiles/");
      out.print( p.getProductImage() );
      out.write("\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t<span>");
      out.print( p.getProductTitle() );
      out.write("</span> <span>");
      out.print( p.getProductPrice() );
      out.write("원</span>\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t               </div>\r\n");
      out.write("\t\t            ");
 } 
      out.write("\r\n");
      out.write("\t\t\t   </div>\r\n");
      out.write("              \r\n");
      out.write("            </div>\r\n");
      out.write("                \r\n");
      out.write("         </div>\r\n");
      out.write("      </div>\r\n");
      out.write("   </div>\r\n");
      out.write("   <div class=\"wrap\">\r\n");
      out.write("      ");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>footer</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print( context );
      out.write("/resources/css/footer.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<footer id=\"footer\">\r\n");
      out.write("\t<br>\r\n");
      out.write("\t(주) 로켓 대표 KIM LOCKET | 서울 강남구 테헤란로14길 6 남도빌딩 2층 <br>\r\n");
      out.write("   E-mail locket_manaer@locket.co.kr | Tel 02-6952-0337 \r\n");
      out.write("   \r\n");
      out.write("   </footer>\r\n");
      out.write("   \r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("   </div>\r\n");
      out.write("   ");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>advertise</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print( context );
      out.write("/resources/css/ad.css\">\r\n");
      out.write("<script src=\"");
      out.print( context );
      out.write("/resources/js/jquery-3.5.1.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("   \r\n");
      out.write("   <aside id=\"advertise\">\r\n");
      out.write("      <a href=\"#header\" id=\"topbt\">맨 위로▲</a>\r\n");
      out.write("      <h2>광고 배너</h2>\r\n");
      out.write("      <a href=\"http://iei.or.kr\" target=\"_blank\">\r\n");
      out.write("         <img id=\"adImg\" src=\"");
      out.print( context );
      out.write("/resources/images/kh.png\">\r\n");
      out.write("         <br>\r\n");
      out.write("         <b>kh정보교육원</b> \r\n");
      out.write("         <br>\r\n");
      out.write("      </a>\r\n");
      out.write("      <br>\r\n");
      out.write("      \r\n");
      out.write("      \r\n");
      out.write("      <a href=\"http://www.q-net.or.kr/man001.do?gSite=Q\" target=\"_blank\">\r\n");
      out.write("         <img id=\"adImg\" src=\"");
      out.print( context );
      out.write("/resources/images/QNET.JPG\">\r\n");
      out.write("         <br>\r\n");
      out.write("         <b>자격증 접수</b>\r\n");
      out.write("      </a>\r\n");
      out.write("      <br>\r\n");
      out.write("      \r\n");
      out.write("      <br><br>\r\n");
      out.write("   \r\n");
      out.write("      <a href=\"https://www.dataq.or.kr/www/main.do\" target=\"_blank\">\r\n");
      out.write("         <img id=\"adImg\" src=\"");
      out.print( context );
      out.write("/resources/images/KDATA.JPG\">\r\n");
      out.write("         <br>\r\n");
      out.write("         <b>데이터 자격 시험</b>\r\n");
      out.write("      </a>\r\n");
      out.write("      <br>\r\n");
      out.write("   </aside>\r\n");
      out.write("   \r\n");
      out.write("   <script>\r\n");
      out.write("      $(function() {\r\n");
      out.write("         adReset();\r\n");
      out.write("      });\r\n");
      out.write("      \r\n");
      out.write("      window.onresize = function() {\r\n");
      out.write("        adReset();     \r\n");
      out.write("      };\r\n");
      out.write("      \r\n");
      out.write("      window.onfocus = function() {\r\n");
      out.write("         adReset();\r\n");
      out.write("      }\r\n");
      out.write("      \r\n");
      out.write("      function adReset() {\r\n");
      out.write("         var width = window.outerWidth;\r\n");
      out.write("         var ad = document.getElementById(\"advertise\");\r\n");
      out.write("         if(width < 1591) {\r\n");
      out.write("             ad.style.position = \"relative\";\r\n");
      out.write("             ad.style.top = \"-80%\";\r\n");
      out.write("             ad.style.right = \"-15%\";\r\n");
      out.write("           } else {\r\n");
      out.write("             ad.style.position = \"fixed\";\r\n");
      out.write("             ad.style.top = \"30%\";\r\n");
      out.write("             ad.style.right = \"1%\";\r\n");
      out.write("           }        \r\n");
      out.write("      }\r\n");
      out.write("   </script>\r\n");
      out.write("   \r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("   \r\n");
      out.write("   <script>\r\n");
      out.write("   \t\tfunction productLink(path) {\r\n");
      out.write("\t\t\t");
 if(loginMember != null) { 
      out.write("\r\n");
      out.write("\t\t\t\tlocation.href = path;\r\n");
      out.write("\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\talert('로그인 후 조회가능합니다.');\r\n");
      out.write("\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("   </script>\r\n");
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
