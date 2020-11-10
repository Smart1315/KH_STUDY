package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberPwdUpdateServlet
 */
@WebServlet(urlPatterns = "/updatePwd.me", name = "MemberPwdUpdateServlet")
public class MemberPwdUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberPwdUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		
		String userId = ((Member)(request.getSession().getAttribute("loginUser"))).getUserId();
		String userPwd = request.getParameter("userPwd");
		String newPwd = request.getParameter("newPwd");
		
		Member myInfo = new Member(userId, userPwd);
		
		int result = new MemberService().updatePwd(myInfo, newPwd);
		
		String page = null;
		if(result > 0) {
			page = "/myPage.me";
		} else {
			page = "WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "비밀번호 수정에 실패했습니다. 현재 비밀번호를 확인하세요.");
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
