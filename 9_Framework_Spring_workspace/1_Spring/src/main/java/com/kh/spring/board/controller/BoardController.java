package com.kh.spring.board.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.kh.spring.board.model.exception.BoardException;
import com.kh.spring.board.model.service.BoardService;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.PageInfo;
import com.kh.spring.board.model.vo.Reply;
import com.kh.spring.common.Pagination;
import com.kh.spring.member.model.vo.Member;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService bService;
	
	@RequestMapping("blist.bo")
	public ModelAndView boardList(@RequestParam(value = "page", required = false) Integer page, ModelAndView mv) {
		
		int currentPage = 1;
		if(page != null) {
			currentPage = page;
		}
		
		int listCount = bService.getListCount();
		
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		
		ArrayList<Board> list = (ArrayList<Board>) bService.selectList(pi);
		
		if(list != null) {
			mv.addObject("list", list);
			mv.addObject("pi", pi);
			mv.setViewName("boardListView");
		} else {
			throw new BoardException("게시글 전체 조회에 실패했습니다.");
		}
		
		return mv;
	}
	
	@RequestMapping("binsertView.bo")
	public String boardInsertView() {
		return "boardInsertForm";
	}
	
	@RequestMapping("binsert.bo")
	public String boardInsert(@ModelAttribute Board b, @RequestParam("uploadFile") MultipartFile uploadFile, HttpServletRequest request) {
		
//		System.out.println(b);
//		System.out.println(uploadFile);
		// 첨부파일이 있고 없고는 MultipartFile의 객체가 null이냐 아니야로 따지는 게 아니라
		// MultipartFile 안에 있는 메소드 getOriginalFilename()으로 판별 가능
		// 첨부 파일이 있을 때 : 실제 파일 이름
		// 첨부 파일이 없을 때 : 
		
		if(uploadFile != null && !uploadFile.isEmpty()) { // 첨부파일이 있다면
			String renameFileName = saveFile(uploadFile, request);
			
			if(renameFileName != null) {
				b.setRenameFileName(renameFileName);
				b.setOriginalFileName(uploadFile.getOriginalFilename());
			}
		}
		
		int result = bService.insertBoard(b);
		
		if(result > 0) {
			return "redirect:blist.bo";
		} else {
			throw new BoardException("게시글 등록에 실패했습니다.");
		}
	}

	public String saveFile(MultipartFile file, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		// 웹 서버 contextPath를 불러와 폴더의 경로를 받아옴(webapp 하위의 resources 폴더)
		
		String savePath = root + "\\buploadFiles";
		
		File folder = new File(savePath);
		if(!folder.exists()) {
			folder.mkdirs();
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String originFileName = file.getOriginalFilename();
		String renameFileName = sdf.format(new Date(System.currentTimeMillis())) + "." + originFileName.substring(originFileName.lastIndexOf(".") + 1);
		
		String renamePath = folder + "\\" + renameFileName;
		
		try {
			file.transferTo(new File(renamePath));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return renameFileName;
	}
	
	@RequestMapping("bdetail.bo")
	public ModelAndView boardDetail(@RequestParam("bId") int bId, @RequestParam("page") int page, ModelAndView mv) {
		
		Board board = bService.selectBoard(bId);
		
		if(board != null) {
			mv.addObject("board", board)
			  .addObject("page", page)
			  .setViewName("boardDetailView");
		} else {
			throw new BoardException("게시글 상세보기를 실패했습니다.");
		}
		
		return mv;
	}
	
	@RequestMapping("bupView.bo")
	public ModelAndView boardUpdateView(@RequestParam("bId") int bId, @RequestParam("page") int page, ModelAndView mv) {
		Board board = bService.selectBoard(bId);
		
		if(board != null) {
			mv.addObject("board", board)
			  .addObject("page", page)
			  .setViewName("boardUpdateForm");
		} else {
			throw new BoardException("게시글 상세보기를 실패했습니다.");
		}
		
		return mv;
	}
	
	@RequestMapping("bupdate.bo")
	public ModelAndView boardUpdate(@ModelAttribute Board b, @RequestParam("reloadFile") MultipartFile reloadFile, @RequestParam("page") int page, HttpServletRequest request, ModelAndView mv) {
		
		if(reloadFile != null && !reloadFile.isEmpty()) { // 새로 변경할 파일이 있다면
			if(b.getRenameFileName() != null) { // 기존에 넣었던 파일이 있다면
				deleteFile(b.getRenameFileName(), request);
			}
			
			String renameFileName = saveFile(reloadFile, request);
			
			if(renameFileName != null) {
				b.setRenameFileName(renameFileName);
				b.setOriginalFileName(reloadFile.getOriginalFilename());
			}
		}
		
		int result = bService.updateBoard(b);
		
		if(result > 0) {
			mv.addObject("page", page)
			  .addObject("bId", b.getbId())
			  .setViewName("redirect:bdetail.bo");
		} else {
			throw new BoardException("게시글 수정에 실패했습니다.");
		}
		
		return mv;
	}
	
	public void deleteFile(String fileName, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		
		String savePath = root + "\\buploadFiles";
		
		File f = new File(savePath + "\\" + fileName);
		if(f.exists()) {
			f.delete();
		}
	}
	
	@RequestMapping("bdelete.bo")
	public String boardDelete(@RequestParam("bId") int bId) {
		
		int result = bService.deleteBoard(bId);
		
		if(result > 0) {
			return "redirect:blist.bo";
		} else {
			throw new BoardException("게시글 삭제에 실패했습니다.");
		}
	}
	
	@RequestMapping("addReply.bo")
	@ResponseBody
	public String addReply(@ModelAttribute Reply r, HttpSession session) {
		Member loginUser = (Member)session.getAttribute("loginUser");
		String rWriter = loginUser.getId();
		
		r.setrWriter(rWriter);
		
		int result = bService.insertReply(r);
		
		if(result > 0) {
			return "success";
		} else {
			throw new BoardException("댓글 등록에 실패했습니다.");
		}
	}
	
	@RequestMapping("rList.bo")
	@ResponseBody
	public void getReplyList(@RequestParam("bId") int bId, HttpServletResponse response) {
		ArrayList<Reply> rList = (ArrayList<Reply>) bService.selectReplyList(bId);
		
		response.setContentType("application/json; charset=UTF-8");
//		Gson gson = new Gson();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		try {
			gson.toJson(rList, response.getWriter());
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("topList.bo")
	public void boardTopList(HttpServletResponse response) {
		ArrayList<Board> list = (ArrayList<Board>) bService.selectTopList();
		
		response.setContentType("application/json; charset=UTF-8");
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		try {
			gson.toJson(list, response.getWriter());
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
