package com.sinc.project.reply.model.vo;

public class ReplyVO {
	private int rseq;
	private String rwriter;
	private String rcontent;
	private String rregdate;
	private int bseq;
	
	public ReplyVO() {
		super();
	}
	
	public ReplyVO(int rseq, String rwriter, String rcontent, String rregdate, int bseq) {
		super();
		this.rseq = rseq;
		this.rwriter = rwriter;
		this.rcontent = rcontent;
		this.rregdate = rregdate;
		this.bseq = bseq;
	}

	public int getRseq() {
		return rseq;
	}
	public void setRseq(int rseq) {
		this.rseq = rseq;
	}
	public String getRwriter() {
		return rwriter;
	}
	public void setRwriter(String rwriter) {
		this.rwriter = rwriter;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public String getRregdate() {
		return rregdate;
	}
	public void setRregdate(String rregdate) {
		this.rregdate = rregdate;
	}
	public int getBseq() {
		return bseq;
	}
	public void setBseq(int bseq) {
		this.bseq = bseq;
	}

	@Override
	public String toString() {
		return "[ReplyVO] : rseq = " + rseq + ", rwriter = " + rwriter + ", rcontent = " + rcontent + ", rregdate = " + rregdate + ", bseq = " + bseq;
	}
	
	
}
