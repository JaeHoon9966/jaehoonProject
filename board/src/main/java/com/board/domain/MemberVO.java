package com.board.domain;

import java.util.Date;

public class MemberVO {

	private int mem_num;
	
	private String user_id;
	
	private String user_pass;
	
	private String user_name;
	
	private Date reg_date;
	
	private String gender;
	
	private String hobby;
	
	private String sc_name;
	
	public String getSc_name() {
		return sc_name;
	}

	public void setSc_name(String sc_name) {
		this.sc_name = sc_name;
	}

	private int sc_num;
	
	public int getMem_num() {
		return mem_num;
	}
	
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	
	public String getUser_id() {
		return user_id;
	}
	
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public String getUser_pass() {
		return user_pass;
	}
	
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}
	
	public String getUser_name() {
		return user_name;
	}
	
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	public Date getReg_date() {
		return reg_date;
	}
	
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getHobby() {
		return hobby;
	}
	
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	public int getSc_num() {
		return sc_num;
	}
	
	public void setSc_num(int sc_num) {
		this.sc_num = sc_num;
	}
	
	@Override
	public String toString() {
		return "MemberVO [mem_num=" + mem_num + ", user_id=" + user_id + ", user_pass=" + user_pass + ", user_name="
				+ user_name + ", reg_date=" + reg_date + ", gender=" + gender + ", hobby=" + hobby + ", sc_num="
				+ sc_num + "]";
	}
}