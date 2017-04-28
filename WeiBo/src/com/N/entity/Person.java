package com.N.entity;
import java.util.*;

public class Person {
	private int id;
	private String name;
	private String nickname;
	private String sex;
	private String passwd;
	private String birthday;
	private String email;
	private String img;
	
	public Person() {
		
	}
	
	public Person(int _id, String _na, String _nickname, String _sex, String _p, String _b, String _e) {
		name = _na;
		id = _id;
		nickname = _nickname;
		sex = _sex;
		passwd = _p;
		birthday = _b;
		email = _e;
	}
	
	public Person(String _na, String _nickname, String _sex, String _p, String _b, String _e) {
		name = _na;
		nickname = _nickname;
		sex = _sex;
		passwd = _p;
		birthday = _b;
		email = _e;
	}
	
	public Person(Person p, String path) {
		this.birthday = p.getBirthday();
		this.email = p.getEmail();
		this.id = p.getId();
		this.name = p.getName();
		this.nickname = p.getNickname();
		this.passwd = p.getPasswd();
		this.sex = p.getSex();
		this.img = path;
	}

	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
