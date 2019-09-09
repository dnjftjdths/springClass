package com.sinc.project.user.model.vo;

public class UserVO {
	private String 	id, pwd, name;
	private int		point;
	private String	imgsrc;
	
	public UserVO() {
		super();
	}
	public UserVO(String id, String pwd, String name, int point, String imgsrc) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.point = point;
		this.imgsrc = imgsrc;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getImgsrc() {
		return imgsrc;
	}
	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}
	@Override
	public String toString() {
		return "id : " + id + ", pwd : " + pwd + ", name : " + name + ", point : " + point + ", imgsrc : " + imgsrc;
	}
	
}
