/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.38
 * Generated at: 2020-11-05 13:15:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.group;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import group.model.vo.*;
import member.model.vo.Member;
import shipping_address.model.vo.*;
import java.util.ArrayList;

public final class apply_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/resources/globalVariable.jsp", Long.valueOf(1604494327421L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("group.model.vo");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("shipping_address.model.vo");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("member.model.vo.Member");
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

   Group g = (Group) request.getAttribute("group");
   /* Member loginMember = (Member) session.getAttribute("loginMember"); */
   Member buyMember = (Member)request.getAttribute("buyMember");
   ArrayList<Shipping_address> list = (ArrayList<Shipping_address>)request.getAttribute("list");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-1.12.4.min.js\"></script>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>공동구매 신청</title>\r\n");
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
      out.write("<link\r\n");
      out.write("   href=\"https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap\"\r\n");
      out.write("   rel=\"stylesheet\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("   href=\"");
      out.print(context);
      out.write("/resources/css/apply.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("   <div align=\"center\" id=\"applyFrame\">\r\n");
      out.write("\r\n");
      out.write("      <h2>공동구매 신청</h2>\r\n");
      out.write("\r\n");
      out.write("      <table>\r\n");
      out.write("         <tr>\r\n");
      out.write("            <td class=\"tax\">상품 명 :</td>\r\n");
      out.write("            <td align=\"center\">");
      out.print(g.getGroupTitle());
      out.write("</td>\r\n");
      out.write("         </tr>\r\n");
      out.write("         <tr>\r\n");
      out.write("            <td class=\"tax\">구매수량 :</td>\r\n");
      out.write("            <td><input type=\"number\" name=\"amount\" id=\"amount\" min='1'\r\n");
      out.write("               value=\"1\"></td>\r\n");
      out.write("         </tr>\r\n");
      out.write("         <tr>\r\n");
      out.write("            <td class=\"tax\">가격 :</td>\r\n");
      out.write("            <td align=\"center\">");
      out.print(g.getPrice());
      out.write("</td>\r\n");
      out.write("         </tr>\r\n");
      out.write("         <tr>\r\n");
      out.write("            <td class=\"tax\">배송지 :</td>\r\n");
      out.write("            <!-- 배송지명 select 드롭다운 선택 시 하단에 주소뜨게하기 -->\r\n");
      out.write("            <td><select id=\"deli\">\r\n");
      out.write("                  ");
 if(list != null) { 
      out.write("\r\n");
      out.write("                     ");
 for(Shipping_address sa : list) { 
      out.write("\r\n");
      out.write("                     <option>");
      out.print( sa.getAdderss() );
      out.write("</option>\r\n");
      out.write("                     ");
 } 
      out.write("\r\n");
      out.write("                  ");
 } 
      out.write("\r\n");
      out.write("            </select></td>\r\n");
      out.write("         </tr>\r\n");
      out.write("         <tr>\r\n");
      out.write("            <th class=\"tax\" style=\"margin-top: 12px;\">합계 :</th>\r\n");
      out.write("            <th><p id=\"totalPrice\">");
      out.print(g.getPrice());
      out.write("</p></th>\r\n");
      out.write("         </tr>\r\n");
      out.write("      </table>\r\n");
      out.write("\r\n");
      out.write("      <br>\r\n");
      out.write("      <br>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"btns\" align=\"center\">\r\n");
      out.write("         <button onclick=\"requestPay();\">결제하기</button>\r\n");
      out.write("         <input type=\"button\" id=\"cancelBtn\" onclick=\"self.close();\"\r\n");
      out.write("            value=\"취소하기\">\r\n");
      out.write("      </div>\r\n");
      out.write("   </div>\r\n");
      out.write("\r\n");
      out.write("   <script>\r\n");
      out.write("      $(function(){\r\n");
      out.write("         $('#amount').click(function(){\r\n");
      out.write("            var totalPrice = $('#amount').val() * \"");
      out.print(g.getPrice());
      out.write("\";\r\n");
      out.write("            $('#totalPrice').text(totalPrice);\r\n");
      out.write("         });\r\n");
      out.write("      });            \r\n");
      out.write("   </script>\r\n");
      out.write("\r\n");
      out.write("   <script>\r\n");
      out.write("      var gNum = ");
      out.print( g.getGroupNum() );
      out.write(";\r\n");
      out.write("      var buyMemberId = '");
      out.print( buyMember.getId() );
      out.write("';\r\n");
      out.write("      function requestPay(){\r\n");
      out.write("    \t window.resizeTo(1000, 750);\r\n");
      out.write("    \t  \r\n");
      out.write("         var amount = $('#amount').val() * \"");
      out.print(g.getPrice());
      out.write("\";\r\n");
      out.write("                        \r\n");
      out.write("         var name = \"");
      out.print(g.getGroupTitle());
      out.write("\";\r\n");
      out.write("         var buyer_name = \"");
      out.print(buyMember.getNickName());
      out.write("\";\r\n");
      out.write("         var buyer_phone = \"");
      out.print(buyMember.getPhone());
      out.write("\";\r\n");
      out.write("         var buyer_email = \"");
      out.print(buyMember.getEmail());
      out.write("\";\r\n");
      out.write("         var buyer_addr = $('#deli').val();\r\n");
      out.write("\r\n");
      out.write("         var merchant_uid;\r\n");
      out.write("         \r\n");
      out.write("         $.ajax({\r\n");
      out.write("            url : \"apply.do\",\r\n");
      out.write("            type : \"post\",\r\n");
      out.write("            success : function(merchant_uid) {\r\n");
      out.write("               if (merchant_uid != \"\") {\r\n");
      out.write("                  payment(amount, name, buyer_name, buyer_email, buyer_phone, buyer_addr, merchant_uid);\r\n");
      out.write("               } else {\r\n");
      out.write("                  alert(\"결제 실패\");\r\n");
      out.write("               }\r\n");
      out.write("            },\r\n");
      out.write("            error : function() {\r\n");
      out.write("               alert(\"ajax 통신 실패\");\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("         });\r\n");
      out.write("\r\n");
      out.write("      }\r\n");
      out.write("\r\n");
      out.write("      function payment(amount, name, buyer_name, buyer_email, buyer_phone, buyer_addr, merchant_uid) {\r\n");
      out.write("         var IMP = window.IMP;\r\n");
      out.write("         IMP.init(\"imp55592976\"); // 가맹점 식별코드 (고유코드)\r\n");
      out.write("\r\n");
      out.write("         IMP.request_pay({ // param\r\n");
      out.write("            pg : \"html5_inicis\", // 이니시스 결제방식\r\n");
      out.write("            pay_method : \"card\", // 무통장 입금\r\n");
      out.write("\r\n");
      out.write("            merchant_uid : merchant_uid, // 결제 고유 식별번호\r\n");
      out.write("            amount : amount, // 결제 금액\r\n");
      out.write("            name : name, // 주문 대상\r\n");
      out.write("            buyer_name : buyer_name, // 주문자이름\r\n");
      out.write("            buyer_email: buyer_email,      // 주문자 이메일\r\n");
      out.write("            buyer_tel: buyer_phone,         // 주문자 연락처\r\n");
      out.write("            buyer_addr: buyer_addr\r\n");
      out.write("\r\n");
      out.write("         }, function(rsp) { // callback\r\n");
      out.write("            if (rsp.success) {\r\n");
      out.write("               // ajax call -> DB에 저장\r\n");
      out.write("               // --> call success callback\r\n");
      out.write("               \r\n");
      out.write("               var msg = '결제가 완료되었습니다.';\r\n");
      out.write("               msg += '\\n고유ID : ' + rsp.imp_uid;\r\n");
      out.write("               msg += '\\n상점 거래ID : ' + rsp.merchant_uid;\r\n");
      out.write("               msg += '결제 금액 : ' + rsp.paid_amount;\r\n");
      out.write("               msg += '카드 승인번호 : ' + rsp.apply_num;\r\n");
      out.write("\r\n");
      out.write("               alert(msg);\r\n");
      out.write("               \r\n");
      out.write("               $.ajax({\r\n");
      out.write("                  url: \"applySuccess.do\",\r\n");
      out.write("                  type: \"post\",\r\n");
      out.write("                  data: {\r\n");
      out.write("                     gNum: gNum,\r\n");
      out.write("                     buyMemberId: buyMemberId,\r\n");
      out.write("                     buyer_addr: buyer_addr,\r\n");
      out.write("                     amount: rsp.paid_amount,\r\n");
      out.write("                     merchantUID: rsp.merchant_uid\r\n");
      out.write("                     },\r\n");
      out.write("                  async: false,\r\n");
      out.write("                  success: function(data) {\r\n");
      out.write("                     console.log(data.result);\r\n");
      out.write("                     if(data.result > 0) {\r\n");
      out.write("                        alert('결제내역 저장완료');\r\n");
      out.write("                        location.href=\"");
      out.print( context );
      out.write("/buy_list.do\";\r\n");
      out.write("                     } else {\r\n");
      out.write("                        alert('결제내역 저장실패');\r\n");
      out.write("                     }\r\n");
      out.write("                     self.close();\r\n");
      out.write("                  },\r\n");
      out.write("                  error: function() {\r\n");
      out.write("                     console.log('에러');\r\n");
      out.write("                  }\r\n");
      out.write("               });\r\n");
      out.write("            } else {\r\n");
      out.write("               var msg = '결제에 실패하였습니다.';\r\n");
      out.write("               msg += '에러내용 : ' + rsp.error_msg;\r\n");
      out.write("            }\r\n");
      out.write("            window.resizeTo(800, 500);\r\n");
      out.write("         });\r\n");
      out.write("        \r\n");
      out.write("      }\r\n");
      out.write("   </script>\r\n");
      out.write("\r\n");
      out.write("   <script type=\"text/javascript\"\r\n");
      out.write("      src=\"https://service.iamport.kr/js/iamport.payment-1.1.5.js\"></script>\r\n");
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
