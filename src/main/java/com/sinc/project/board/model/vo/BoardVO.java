package com.sinc.project.board.model.vo;

import java.util.List;

import com.sinc.project.reply.model.vo.ReplyVO;

public class BoardVO {
	private int 	seq;
	private	String	title, content, writer, regdate;
	private	int		viewcnt;
	private List<ReplyVO> replylist;
	
	public List<ReplyVO> getReplylist() {
		return replylist;
	}

	public void setReplylist(List<ReplyVO> replylist) {
		this.replylist = replylist;
	}

	public BoardVO() {
		super();
	}
	
	public BoardVO(int seq, String title, String content, String writer, String regdate, int viewcnt) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
		this.viewcnt = viewcnt;
	}

	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	@Override
	public String toString() {
		return "sea : " + seq + ", title : " + title + ", content : " + content 
				+ ", writer : " + writer + ", viewcnt : " + viewcnt;
	}
	
	
}
