package board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import board.model.service.BoardService;
import board.model.vo.Attachment;
import board.model.vo.Board;
import common.MyFileRenamePolicy;
import member.model.vo.Member;

/**
 * Servlet implementation class ThumbnailInsertServlet
 */
@WebServlet("/insert.th")
public class ThumbnailInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThumbnailInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		
//		String title = request.getParameter("title");
//		System.out.println(title);
		// encType이 multipart/form-data이기 때문에 request.getParameter로 값을 받을 수 없음
		// cos.jar 를 추가하여 진행 <== 파일도 받고 다른 값들도 받아주는 역할
		
		// encType이 multipart/form-date로 전송되었는지 확인
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 1024 * 1024 * 10; // 10Mbyte로 전송파일 용량 제한
			String root = request.getSession().getServletContext().getRealPath("/");
			String savePath = root + "thumbnail_uploadFiles\\";
			
			File f = new File(savePath);
			if(!f.exists()) {
				f.mkdirs();
			}
			
			// DefaultFileRenamePolicy : 같은 파일 명이 존재하는지 검사하고 있을 경우 파일 명 뒤에 숫자를 붙여 구분
			// aaa.zip aaa1.zip aaa2.zip
			// MultipartRequest multiRequest = new MultipartRequest(requset, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			String title = multiRequest.getParameter("title");
			String content = multiRequest.getParameter("content");
			String bWriter = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
			
			ArrayList<String> saveFiles = new ArrayList<String>(); // 바뀐 파일의 이름을 저장할 ArrayList
			ArrayList<String> originFiles = new ArrayList<String>(); // 원본 파일의 이름을 저장할 ArrayList
		
			Enumeration<String> files = multiRequest.getFileNames(); // 폼에서 전송된 파일 리스트의 이름 반환
			while(files.hasMoreElements()) {
				String name = files.nextElement(); // 전송 순서 역순으로 가져옴
				
				if(multiRequest.getFilesystemName(name) != null) { // MyRenamePolicy의 rename메소드에서 작성한 내용대로 rename이 된 파일
					saveFiles.add(multiRequest.getFilesystemName(name));
					originFiles.add(multiRequest.getOriginalFileName(name));
				}
			}
			
			Board b = new Board();
			b.setBoardTitle(title);
			b.setBoardContent(content);
			b.setBoardWriter(bWriter);
			b.setBoardType(2);
			b.setCategory("10");
			
			ArrayList<Attachment> fileList = new ArrayList<Attachment>();
			for(int i = originFiles.size() - 1; i >= 0; i--) {
				Attachment at = new Attachment();
				at.setFilePath(savePath);
				at.setOriginName(originFiles.get(i));
				at.setChangeName(saveFiles.get(i));
				
				if(i == originFiles.size() - 1) {
					at.setFileLevel(0);
				} else {
					at.setFileLevel(1);
				}
				
				fileList.add(at);
			}
			
			int result = new BoardService().insertThumbnail(b, fileList);
			
			if(result > 0) {
				response.sendRedirect("list.th");
			} else {
				for(int i = 0; i < saveFiles.size(); i++) {
					File failedFile = new File(savePath + saveFiles.get(i));
					failedFile.delete();
				}
				
				request.setAttribute("msg", "사진 게시판 등록에 실패하였습니다.");
				request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
