package com.sinc.project.board.model.sql;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sinc.project.board.model.vo.BoardVO;
import com.sinc.project.reply.model.vo.ReplyVO;

@Repository("boardD")
public class BoardDaoImpl implements BoardDao {

	@Resource(name="sqlSession")
	private SqlSession session;
	
	@Override
	public List<BoardVO> getBoardListRow() {
		System.out.println("BoardDaoImpl getBoardListRow");
		return session.selectList("com.sinc.board.boardlist");
	}

	@Override
	public int insertBoardRow(BoardVO board) {
		System.out.println("BoardDaoImpl insertBoardRow");
		return session.insert("com.sinc.board.insertBoard", board);
	}

	@Override
	public List<BoardVO> searchRow(Map<String, String> map) {
		System.out.println("BoardDaoImpl searchRow");
		return session.selectList("com.sinc.board.searchAjax", map);
	}

	@Override
	public BoardVO boardDetailRow(BoardVO board) {
		System.out.println("BoardDaoImpl > boardDetailRow");
		return session.selectOne("detailselect", board);
	}

	@Override
	public int boardDeleteRow(BoardVO board) {
		System.out.println("BoardDaoImpl > boardDeleteRow");
		return session.delete("boarddelete", board);
	}

	@Override
	public int boardUpdateRow(BoardVO board) {
		System.out.println("BoardDaoImpl > boardUpdateRow");
		return session.update("boardupdate", board);
	}

	@Override
	public int replyInsertRow(ReplyVO reply) {
		System.out.println("BoardDaoImpl > replyInsertRow");
		return session.insert("replyinsert", reply);
	}

	@Override
	public List<ReplyVO> replyListRow(BoardVO board) {
		System.out.println("BoardDaoImpl > replyListRow");
		return session.selectList("replyselect_b", board);
	}

	@Override
	public List<ReplyVO> replyListRow(ReplyVO reply) {
		System.out.println("BoardDaoImpl > replyListRow");
		return session.selectList("replyselect_r", reply);
	}

	@Override
	public int replyRemoveRow(ReplyVO reply) {
		System.out.println("BoardDaoImpl > replyRemoveRow");
		return session.delete("replydelete", reply);
	}

}
