package com.board.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.domain.MemberVO;
import com.board.domain.SchoolVO;
import com.board.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Inject
	private MemberService service;
	
	@Autowired
	BCryptPasswordEncoder passEncoder;
	
	// 회원 가입 get
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void getRegister(MemberVO vo , Model model) throws Exception {	
		List<SchoolVO> scList = service.scList();
		model.addAttribute("scList", scList);
	}
	
	// 회원 가입 post
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postRegister(MemberVO vo) throws Exception {
		
		vo.setUser_pass(passEncoder.encode(vo.getUser_pass()));
		
		service.register(vo);
		return "redirect:/";		
	}
		
	// 로그인 get
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void getLogin() throws Exception {		
		
	}	
		
	// 로그인 post
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(MemberVO vo, HttpServletRequest req , RedirectAttributes rttr) throws Exception {
 		HttpSession session = req.getSession();
		MemberVO login = service.login(vo); 
		
		boolean passMatch = passEncoder.matches(vo.getUser_pass(), login.getUser_pass());
		
		if(login != null && passMatch) {
			session.setAttribute("member", login);
		} else {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
			return "redirect:/";
		}  	   
		
		return "redirect:/board/list?num=1";
	}
	
	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate();	   
		return "redirect:/";
	}
	
	// 아이디 중복확인
	@ResponseBody
    @RequestMapping(value = "/idCheck")
    public int idCheck(MemberVO vo) throws Exception {
    	int count = 0;	
    	if(vo.getUser_id() != null) {
    		count = service.idCheck(vo);
    	}
    	
        return count;    
    }
	
	// 회원 목록 + 검색
	@RequestMapping(value = "/mem_list", method = RequestMethod.GET)
	public void getMemberList(HttpServletRequest req, Model model, @RequestParam(value = "searchType", required = false, defaultValue = "") String searchType, @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword) throws Exception {
		List<MemberVO> list = service.memberList(searchType, keyword);
		model.addAttribute("mem_list", list);
		model.addAttribute("searchType", searchType);
		model.addAttribute("keyword", keyword);
	}
}

