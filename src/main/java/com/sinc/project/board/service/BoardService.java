package com.sinc.project.board.service;

import java.util.List;
import java.util.Map;

import com.sinc.project.board.model.vo.BoardVO;
import com.sinc.project.reply.model.vo.ReplyVO;

public interface BoardService {
	public List<BoardVO> getBoardList();
	public int	insertBoard(BoardVO board);
	public List<BoardVO> searchService(Map<String, String> map);
	public BoardVO boardDetail(BoardVO board);
	public int boardDelete(BoardVO board);
	public int boardUpdate(BoardVO board);
	public int replyInsert(ReplyVO reply);
	public List<ReplyVO> replylist(BoardVO board);
	public List<ReplyVO> replylist(ReplyVO board);
	public int replyRemove(ReplyVO reply);
}
