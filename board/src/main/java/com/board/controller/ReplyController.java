package com.board.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.domain.BoardVO;
import com.board.domain.MemberVO;
import com.board.domain.ReplyVO;
import com.board.service.BoardService;
import com.board.service.ReplyService;

@Controller
@RequestMapping("/reply/*")
public class ReplyController {

	@Inject
	private ReplyService service;
	
	@Inject
	private BoardService boardService;
	
	// 댓글 목록
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getList(@RequestParam("bo_num") int bo_num, HttpServletRequest req, Model model) throws Exception {	
		HttpSession session = req.getSession();
		MemberVO voMem = (MemberVO) session.getAttribute("member");
		List<ReplyVO> list = service.list(bo_num);
		model.addAttribute("list", list);
		model.addAttribute("write" , voMem);
	}
	
	// 댓글 작성
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void getWrite(HttpServletRequest req, Model model) throws Exception {
		HttpSession session = req.getSession();
		MemberVO voMem = (MemberVO) session.getAttribute("member");
		
		model.addAttribute("write" , voMem);
	}
	
	// 댓글 작성
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String postWrite(ReplyVO vo, HttpServletRequest req, Model model) throws Exception {
		HttpSession session = req.getSession();
		MemberVO voMember = (MemberVO) session.getAttribute("member");
		
		vo.setMem_num(voMember.getMem_num());
					
		service.write(vo);
		return "redirect:/board/view?bo_num="+vo.getBo_num();
	}
	
	// 댓글 수정
	@RequestMapping(value = "/reply_modify", method = RequestMethod.GET)
	public void getModify(@RequestParam("bo_num") int bo_num , @RequestParam("re_num") int re_num, HttpServletRequest req, Model model) throws Exception {
		HttpSession session = req.getSession();
		BoardVO vo = boardService.view(bo_num);
		MemberVO voMem = (MemberVO) session.getAttribute("member");
		List<ReplyVO> replyList = service.list(bo_num);
		ReplyVO reply = service.view(re_num);
		
		model.addAttribute("view" , vo);
		model.addAttribute("write" , voMem);
		model.addAttribute("reply" , reply);
		model.addAttribute("replyList" , replyList);
	
	}

	// 댓글 수정
	@RequestMapping(value = "/reply_modify", method = RequestMethod.POST)
	public String postModify(ReplyVO vo, HttpServletRequest req, Model model) throws Exception {
		HttpSession session = req.getSession();
		MemberVO voMember = (MemberVO) session.getAttribute("member");
		
		vo.setMem_num(voMember.getMem_num());
		
		service.modify(vo);
		return "redirect:/board/view?bo_num="+vo.getBo_num();
	}
	
	// 댓글 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String getDelete(ReplyVO vo ,@RequestParam("re_num") int re_num, @RequestParam("bo_num") int bo_num) throws Exception {
		service.delete(vo);
		
		vo.setBo_num(vo.getBo_num());
		return "redirect:/board/view?bo_num="+vo.getBo_num();
	}
		
}

