package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;
import board.model.vo.PageInfo;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/list.bo")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 게시글 전체 개수를 먼저 구한 후 페이지 번호에 따라 그 때 그 때 게시물들을 가져올 예정
		BoardService bService = new BoardService();
		
		// 페이징 처리 변수
		int listCount; // 총 게시글 개수
		int currentPage; // 현재 페이지
		int pageLimit; // 한 페이지에 표시될 페이지 수
		int boardLimit; // 한 페이지에 보일 게시글 최대 개수
		int maxPage; // 전체 페이지 중 가장 마지막 페이지
		int startPage; // 페이징이 된 페이지 중 시작 페이지
		int endPage; // 페이징이 된 페이지 중 마지막 페이지
		
		listCount = bService.getListCount();
		
		currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		pageLimit = 10;
		boardLimit = 10;
		
		// maxPage 계산
		maxPage = (int) Math.ceil((double) listCount / boardLimit);
		
		// startPage 계산
		startPage = pageLimit * ((currentPage - 1) / pageLimit) + 1;
		
		// endPage 계산
		endPage = startPage + pageLimit - 1;
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, boardLimit, maxPage, startPage, endPage);
		ArrayList<Board> list = bService.selectList(pi);
		
		String page = null;
		if(list != null) {
			page = "WEB-INF/views/board/boardList.jsp";
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
		} else {
			page = "WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "게시판 조회에 실패하였습니다.");
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
