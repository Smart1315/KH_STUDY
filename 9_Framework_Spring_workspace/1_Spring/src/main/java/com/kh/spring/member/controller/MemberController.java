package com.kh.spring.member.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kh.spring.member.model.exception.MemberException;
import com.kh.spring.member.model.service.MemberService;
import com.kh.spring.member.model.vo.Member;

@SessionAttributes("loginUser")
@Controller
public class MemberController {
	
	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService mService;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;

	/* 파라미터 전송 받는 방법 */
	// 1. HttpServletRequest를 통해 전송받기(JSP/Servlet방식)
//	@RequestMapping("/login.me")
//	public void login(HttpServletRequest request) {
//		String id = request.getParameter("id");
//		String pwd = request.getParameter("pwd");
//		
//		System.out.println("id : " + id);
//		System.out.println("pwd : " + pwd);
//	}
	
	// 2. @RequestParam 어노테이션 방식
//	@RequestMapping("/login.me")
//	public void login(@RequestParam("id") String id, @RequestParam("pwd") String pwd) {
//		System.out.println("id : " + id);
//		System.out.println("pwd : " + pwd);
//	}
	
	// 3. @RequestParam 어노테이션 생략
//	@RequestMapping("login.me")
//	public void login(String id, String pwd) {
//		System.out.println("id : " + id);
//		System.out.println("pwd : " + pwd);
//	}
	
	// 4. @ModelAttribute
//	@RequestMapping("login.me")
//	public void login(@ModelAttribute Member m) {
//		System.out.println("id : " + m.getId());
//		System.out.println("pwd : " + m.getPwd());
//	}
	
	// 5. @ModelAttribute 어노테이션 생략
//	@RequestMapping("login.me")
//	public void login(Member m) {
//		System.out.println("id : " + m.getId());
//		System.out.println("pwd : " + m.getPwd());
		
//		MemberService mService = new MemberServiceImpl();
//		System.out.println(mService.hashCode());
		// 1. 클래스 명 바꿔보기 ->
		// 2. 해시코드 출력
		
//		Member loginUser = mService.memberLogin(m);
//		
//	}
	
	/* 요청 후 전달하고자 하는 데이터가 있을 경우 */
	// 1. Model객체 사용 : 맵 혈식(key, value), scope는 request
//	@RequestMapping("login.me")
//	public String login(Member m, HttpSession session, Model model) {
//		
//		Member loginUser = mService.memberLogin(m);
//		
//		if(loginUser != null) {
//			session.setAttribute("loginUser", loginUser);
//			return "redirect:home.do";
//		} else {
////			request.setAttribute("message", "내용");
//			model.addAttribute("message", "로그인에 실패했습니다.");
////			requset.getRequestDispatcher("path").forward(requset, response);
//			return "../common/errorPage";
//		}
//		
//	}
	
	// 2. ModelAndView객체 사용
	// Model(Map 형식(key, value) + View(RequestDispatcher처럼 forward할 페이지 정보 담음)
//	@RequestMapping("login.me")
//	public ModelAndView login(Member m, HttpSession session, ModelAndView mv) {
//		
//		Member loginUser = mService.memberLogin(m);
//		
//		if(loginUser != null) {
//			session.setAttribute("loginUser", loginUser);
//			mv.setViewName("redirect:home.do");
//		} else {
//			mv.addObject("message", "로그인에 실패했습니다.");
//			mv.setViewName("../common/errorPage");
//		}
//		
//		return mv;
//	}
	
	// 로그아웃용 컨트롤러1
//	@RequestMapping("logout.me")
//	public String logout(HttpSession session) {
//		session.invalidate();
//		
//		return "redirect:home.do";
//	}
	
	// 3. session에 저장할 때 @SessionAttributes 사용
	// model에 attribute가 추가될 때 자동으로 키 값을 찾아 세션에 등록
//	@RequestMapping("login.me")
//	public String login(Member m, Model model) {
//		
//		Member loginUser = mService.memberLogin(m);
//		
//		if(loginUser != null) {
//			model.addAttribute("loginUser", loginUser);
//			return "redirect:home.do";
//		} else {
////			model.addAttribute("message", "로그인에 실패했습니다.");
////			return "../common/errorPage";
//			throw new MemberException("로그인에 실패했습니다.");
//		}
//	}
	
	// 로그아웃용 컨트롤러2
	@RequestMapping("logout.me")
	public String logout(SessionStatus status) {
		status.setComplete();
		
		return "redirect:home.do";
	}
	
	@RequestMapping("enrollView.me")
	public String enrollView() {
		logger.debug("회원등록페이지");
		return "memberJoin";
	}
	
	@RequestMapping("minsert.me")
	public String memberInsert(@ModelAttribute Member m, @RequestParam("post") String post,
														 @RequestParam("address1") String address1,
														 @RequestParam("address2") String address2) {
		
//		System.out.println(m);
//		System.out.println(post + "/" + address1 + "/" + address2);
		m.setAddress(post + "/" + address1 + "/" + address2);
		
		// JSP/Servlet : SHA-512
		// Spring : Bcrypt암호화방식
		
		String encPwd = bcrypt.encode(m.getPwd());
//		System.out.println(encPwd);
		m.setPwd(encPwd);
		
		int result = mService.insertMember(m);
		
		if(result > 0) {
			return "redirect:home.do";
		} else {
			throw new MemberException("회원가입에 실패했습니다.");
		}
	}
	
	// 회원가입 후 로그인
	@RequestMapping("login.me")
	public String login(Member m, Model model) {
		
		Member loginUser = mService.memberLogin(m);
		
		if(loginUser != null && bcrypt.matches(m.getPwd(), loginUser.getPwd())) {
			model.addAttribute("loginUser", loginUser);
			logger.info(loginUser.getId());
			return "redirect:home.do";
		} else {
//			model.addAttribute("message", "로그인에 실패했습니다.");
//			return "../common/errorPage";
			throw new MemberException("로그인에 실패했습니다.");
		}
	}
	
	@RequestMapping("myinfo.me")
	public String memberInfo() {
		return "mypage";
	}
	
	@RequestMapping("mupdateView.me")
	public String memberUpdateView() {
		return "memberUpdateForm";
	}
	
	@RequestMapping("mupdate.me")
	public String memberUpdate(@ModelAttribute Member m, Model model, @RequestParam("post") String post,
														 			  @RequestParam("address1") String address1,
														 			  @RequestParam("address2") String address2) {
		m.setAddress(post + "/" + address1 + "/" + address2);
		
		int result = mService.updateMember(m);
		
		if(result > 0) {
			model.addAttribute("loginUser", m);
			return "redirect:myinfo.me";
		} else {
			throw new MemberException("회원정보 수정에 실패했습니다.");
		}
		
		
	}
	
	@RequestMapping("mpwdUpdateView.me")
	public String memberPwdUpdateView() {
		return "memberPwdUpdateForm";
	}
	
	@RequestMapping("mPwdUpdate.me")
	public String memberPwdUpdate(@SessionAttribute("loginUser") Member m, @RequestParam("pwd") String pwd, @RequestParam("newPwd1") String newPwd) {
		
		if(bcrypt.matches(pwd, m.getPwd())) {
			m.setPwd(bcrypt.encode(newPwd));
			int result = mService.updateMemberPwd(m);
			if(result > 0) {
				return "redirect:myinfo.me";
			} else {
				throw new MemberException("비밀번호 수정에 실패하였습니다.");
			}
		} else {
			throw new MemberException("현재 비밀번호가 일치하지 않습니다.");
		}
	}
	
	@RequestMapping("dupid.me")
	public void idDUplicateCheck(@RequestParam("id") String id, HttpServletResponse response) {
		boolean isUsable = mService.checkIdDup(id) == 0 ? true : false;
		
		try {
			response.getWriter().print(isUsable);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
