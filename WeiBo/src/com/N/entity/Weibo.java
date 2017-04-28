package com.N.entity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Weibo {
	private int id;
	private String weibo;
	private String time;
	public Weibo() {
		
	}
	public Weibo(int _id, String w, String tim) {
		id = _id;
		weibo = w;
		time = tim; 
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getWeibo() {
		return weibo;
	}
	
	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
