package com.sinc.project.board.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.project.board.model.sql.BoardDao;
import com.sinc.project.board.model.vo.BoardVO;
import com.sinc.project.reply.model.vo.ReplyVO;

@Service("boardS")
public class BoardServiceImpl implements BoardService{

	@Resource(name="boardD")
	private BoardDao dao;
	
	@Override
	public List<BoardVO> getBoardList() {
		System.out.println("BoardServiceImpl getBoardList");
		return dao.getBoardListRow();
	}

	@Override
	public int insertBoard(BoardVO board) {
		System.out.println("BoardServiceImpl insertBoard");
		return dao.insertBoardRow(board);
	}

	@Override
	public List<BoardVO> searchService(Map<String, String> map) {
		System.out.println("BoardService searchService");
		return dao.searchRow(map);
	}

	@Override
	public BoardVO boardDetail(BoardVO board) {
		System.out.println("BoardServiceImpl > boardDetail");
		return dao.boardDetailRow(board);
	}

	@Override
	public int boardDelete(BoardVO board) {
		System.out.println("BoardServiceImpl > boardDelete");
		return dao.boardDeleteRow(board);
	}

	@Override
	public int boardUpdate(BoardVO board) {
		System.out.println("BoardServiceImpl > boardUpdate");
		return dao.boardUpdateRow(board);
	}

	@Override
	public int replyInsert(ReplyVO reply) {
		System.out.println("BoardServiceImpl > replyInsert");
		return dao.replyInsertRow(reply);
	}

	@Override
	public List<ReplyVO> replylist(BoardVO board) {
		System.out.println("BoardServiceImpl > replylist");
		return dao.replyListRow(board);
	}

	@Override
	public List<ReplyVO> replylist(ReplyVO reply) {
		System.out.println("BoardServiceImpl > replylist");
		return dao.replyListRow(reply);
	}

	@Override
	public int replyRemove(ReplyVO reply) {
		System.out.println("BoardServiceImpl > replyRemove");
		return dao.replyRemoveRow(reply);
	}

	
}
