package com.sinc.project.board.ctrl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sinc.project.board.model.vo.BoardVO;
import com.sinc.project.board.service.BoardService;
import com.sinc.project.reply.model.vo.ReplyVO;

@Controller
@RequestMapping("/board")
public class BoardCtrl {
	
	@Resource(name="boardS")
	private BoardService service;
	
	@RequestMapping("/listPage.sinc")
	public ModelAndView boardList() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/board/listPage");
		mv.addObject("list", service.getBoardList());
		return mv;
	}
	
	@RequestMapping(value="/register.sinc", method=RequestMethod.GET)
	public void register() {
		// 페이지 이름이 url과 동일한 경우는 void만 지정해줘도 /board/register.jsp로 이동함
	}
	
	// GET, POST방식으로 같은 URL로 보낼 수 있다.
	// @RequestMapping(value="/register.sinc", method=RequestMethod.POST)
	// 사이에 filter가 작동할 때는 충돌생기므로 이번 경우에서는 이용하면 안됨.
	@RequestMapping(value="/registerBoard.sinc", method=RequestMethod.POST)
	public String register(BoardVO board) {
		// insert문 실행
		int resultflag = service.insertBoard(board);
		if(resultflag != 0) {
			// 다시 select문 실행
			// return "/board/listPage.sinc";
			return "redirect:/board/listPage.sinc";
		}
		return "/register.sinc";
	}
	
	@RequestMapping("/search.sinc")
	@ResponseBody
	// SearchVO가 BoardVO를 상속받게 구현하면 유용성이 증가함.
	public List<BoardVO> search(String type, String keyword, HashMap<String, String> map){
		System.out.println("BoardCtrl search");
		System.out.println("type : " + type + ", keyword : " + keyword);
		map.put("type", type);
		map.put("keyword", keyword);
		return service.searchService(map);
	}
	
	@RequestMapping(value="/readPage.sinc", method=RequestMethod.GET)
	public String detail(BoardVO board, Model model) {
		System.out.println("BoardCtrl > detail");
		BoardVO detailboard = service.boardDetail(board);
		List<ReplyVO> list = service.replylist(board);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		detailboard.setReplylist(service.replylist(board));
		model.addAttribute("board", detailboard);
		return "/board/readPage";
	}
	
	@RequestMapping(value="/modifyPage.sinc", method=RequestMethod.GET)
	public String modifyPage(BoardVO board, Model model) {
		System.out.println("BoardCtrl > modifyPage");
		model.addAttribute("board", service.boardDetail(board));
		return "/board/modifyPage";
	}
	
	@RequestMapping(value="/removePage.sinc", method=RequestMethod.GET)
	public String delete(BoardVO board, Model model) {
		System.out.println("BoardCtrl > modify");
		int delete = service.boardDelete(board);
		if(delete == 0) {
			model.addAttribute("board", board);
			return "/board/readPage.sinc";
		}
		return "redirect:/board/listPage.sinc";
	}
	
	@RequestMapping(value="/modifyPage.sinc", method=RequestMethod.POST)
	public String modify(BoardVO board, Model model) {
		System.out.println("BorardCtrl > modify");
		int update = service.boardUpdate(board);
		if(update != 0) {
			return "redirect:/board/readPage.sinc?seq="+board.getSeq();
		}
		return null;
	}
	
	@RequestMapping(value="/replyInsert.sinc", method=RequestMethod.POST)
	public @ResponseBody List<ReplyVO> replyInsert(ReplyVO reply, BoardVO board) {
		System.out.println("BoardCtrl > replyInsert");
		int rinsert = service.replyInsert(reply);
		
		if(rinsert > 0) {
			System.out.println("reply insert success");
		}
		return service.replylist(reply);
	}
	
	@RequestMapping(value="/replyRemove.sinc", method=RequestMethod.POST)
	public @ResponseBody List<ReplyVO> replyRemove(ReplyVO reply) {
		System.out.println("BoartCtrl > replyRemove");
		System.out.println("rseq = " + reply.getRseq() + "bseq = " + reply.getBseq());
		int rdelete = service.replyRemove(reply);
		if(rdelete > 0) {
			System.out.println("reply delete success");
		}
		return service.replylist(reply);
	}
}
