package com.sinc.project.board.model.sql;

import java.util.List;
import java.util.Map;

import com.sinc.project.board.model.vo.BoardVO;
import com.sinc.project.reply.model.vo.ReplyVO;

public interface BoardDao {
	public List<BoardVO> getBoardListRow();
	public int			insertBoardRow(BoardVO board);
	public List<BoardVO>	searchRow(Map<String, String> map);
	public BoardVO boardDetailRow(BoardVO board);
	public int boardDeleteRow(BoardVO board);
	public int boardUpdateRow(BoardVO board);
	public int replyInsertRow(ReplyVO reply);
	public List<ReplyVO> replyListRow(BoardVO board);
	public List<ReplyVO> replyListRow(ReplyVO reply);
	public int replyRemoveRow(ReplyVO reply);
}
