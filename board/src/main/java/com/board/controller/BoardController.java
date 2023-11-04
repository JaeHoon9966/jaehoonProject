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
@RequestMapping("/board/*")
public class BoardController {

	@Inject
	private BoardService service;
	
	@Inject
	private ReplyService replyService;
	
	// 게시물 목록
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getList(HttpServletRequest req, Model model, @RequestParam("num") int num) throws Exception {
		
		int replyCount = replyService.count();
		int count = service.count();
		int postNum = 10;
		int pageNum = (int)Math.ceil((double)count/postNum);
		int displayPost = (num - 1) * postNum;
		int pageNum_cnt = 10;
		int endPageNum = (int)(Math.ceil((double)num / (double)pageNum_cnt) * pageNum_cnt);
		int startPageNum = endPageNum - (pageNum_cnt - 1);
		int endPageNum_tmp = (int)(Math.ceil((double)count / (double)pageNum_cnt));
		
		if(endPageNum > endPageNum_tmp) {
			endPageNum = endPageNum_tmp;
		}
		
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * pageNum_cnt >= count ? false : true;
		
		List<BoardVO> list = service.list(displayPost, postNum);
		model.addAttribute("list", list);
		model.addAttribute("replyCount", replyCount);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("startPageNum",startPageNum);
		model.addAttribute("endPageNum",endPageNum);
		model.addAttribute("prev",prev);
		model.addAttribute("next",next);
		model.addAttribute("select",num);
	}
	
	// 게시물 작성
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void getWrite(HttpServletRequest req, Model model) throws Exception {
		HttpSession session = req.getSession();
		MemberVO voMem = (MemberVO) session.getAttribute("member");
		
		model.addAttribute("write" , voMem);
	}
	
	// 게시물 작성
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String postWrite(BoardVO vo, HttpServletRequest req, Model model) throws Exception {
		HttpSession session = req.getSession();
		MemberVO voMember = (MemberVO) session.getAttribute("member");
		
		vo.setMem_num(voMember.getMem_num());
			
		if ( vo.getNotice_yn() == null ) {
			vo.setNotice_yn("N");
		} else {
			vo.setNotice_yn("Y");
		}
					
		service.write(vo);
		return "redirect:/board/list?num=1";
	}
		
	// 게시물 조회
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void getView(@RequestParam("bo_num") int bo_num, Model model ,HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		BoardVO vo = service.view(bo_num);
		MemberVO voMem = (MemberVO) session.getAttribute("member");
		
		// 추천
		service.viewCnt(bo_num);	
		
		// 댓글 조회
		List<ReplyVO> reply = replyService.list(bo_num);
		
		model.addAttribute("view" , vo);
		model.addAttribute("write" , voMem);
		model.addAttribute("reply" , reply);
	}
	
	// 게시물 수정
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void getModify(@RequestParam("bo_num") int bo_num, Model model) throws Exception {
		BoardVO vo = service.view(bo_num);
		
		model.addAttribute("view" , vo);
	}

	// 게시물 수정
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String postModify(BoardVO vo, HttpServletRequest req, Model model) throws Exception {
		HttpSession session = req.getSession();
		MemberVO voMember = (MemberVO) session.getAttribute("member");
		
		vo.setMem_num(voMember.getMem_num());
		
		service.modify(vo);
		return "redirect:/board/list?num=1"; 
	}
	
	// 게시물 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String getDelete(@RequestParam("bo_num") int bo_num) throws Exception {
		service.delete(bo_num);
		return "redirect:/board/list?num=1";
	}
		
	// 게시물 추천
    @RequestMapping("/recommend")
    public String recommend (@RequestParam("bo_num") int bo_num, BoardVO vo, HttpServletRequest req, Model model) throws Exception {
    	HttpSession session = req.getSession();
		MemberVO voMember = (MemberVO) session.getAttribute("member");
		vo.setMem_num(voMember.getMem_num());
		service.recommend(bo_num);  	   	
    
		model.addAttribute("view" , vo);
    	return "redirect:/board/list?num=1"; 
	}
}

