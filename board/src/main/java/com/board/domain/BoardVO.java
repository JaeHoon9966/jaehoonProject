package com.board.domain;

import java.util.Date;

public class BoardVO {

	private int bo_num;

	private String title;
	
	private String content;
	
	private Date reg_date;
	
	private String view_cnt;
	
	private String recommend;
	
	private String notice_yn;
	
	private String user_name;
	
	private int mem_num;
	
	private int cnt;
	
	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getUser_name() {
		return user_name;
	}
	
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	public int getBo_num() {
		return bo_num;
	}
	
	public void setBo_num(int bo_num) {
		this.bo_num = bo_num;
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
	
	public Date getReg_date() {
		return reg_date;
	}
	
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
	public String getView_cnt() {
		return view_cnt;
	}
	
	public void setView_cnt(String view_cnt) {
		this.view_cnt = view_cnt;
	}
	
	public String getRecommend() {
		return recommend;
	}
	
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	
	public String getNotice_yn() {
		return notice_yn;
	}
	
	public void setNotice_yn(String notice_yn) {
		this.notice_yn = notice_yn;
	}
	
	public int getMem_num() {
		return mem_num;
	}
	
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
}
