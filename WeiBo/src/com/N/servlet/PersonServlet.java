package com.N.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.N.dao.impl.*;
import com.N.dao.*;
import com.N.entity.*;

import java.util.*;

public class PersonServlet extends HttpServlet {
	public PersonServlet(){
		
	}
	public void init()throws ServletException{
		
	}
	public void destroy(){
		super.destroy();
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	String method=request.getParameter("method");
    	System.out.println(method);
    	
    	if("add".equals(method)){
    		add(request,response);
    	}else if ("login".equals(method)) 
    		login(request, response);
    	else if ("update".equals(method)) 
    		update(request, response);
    	else if ("addweibo".equals(method))
    		addweibo(request, response);
    	else if ("list".equals(method)) 
    		list(request, response);
    	else if ("delete".equals(method))
    		deleteweibo(request, response);
    	else if ("deletefriend".equals(method))
    		deletefriend(request, response);
    	
	}
	
	public void deletefriend(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String friend = request.getParameter("friend");
		int id = Integer.parseInt(request.getParameter("id"));
		FriendDao fdao = new FriendDaoImpl();
		PersonDao pdao = new PersonDaoImpl();
		Person p = null;
		WeiboDao wdao = new WeiboDaoImpl();
		List<Weibo>list = new ArrayList<Weibo>();
		List<String>friends = new ArrayList<String>();
		Pageroll pageroll = new Pageroll();
		try {
			int cnt = fdao.find(id, friend);
			fdao.delete(cnt);
			p = pdao.find(id);
			list = wdao.list(pageroll, id);
			friends = fdao.find(id);
			request.setAttribute("user", p);
			request.setAttribute("list", list);
			request.setAttribute("pageroll", pageroll);
			request.setAttribute("friends", friends);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		catch(SQLException e){
    		e.printStackTrace();
    	}
	}
	public void deleteweibo(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String text = new String(request.getParameter("txt").getBytes("ISO-8859-1"),"UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id+" "+text);
		Weibo w = new Weibo();
		WeiboDao wdao = new WeiboDaoImpl();
		Person p = new Person();
		PersonDao pdao = new PersonDaoImpl();
		List<Weibo>list = new ArrayList<Weibo>();
		Pageroll pageroll =  new Pageroll();
		FriendDao fdao = new FriendDaoImpl();
		List<String>friends = new ArrayList<String>();
		try {
			p = pdao.find(id);
			w = wdao.find(id, text);
			friends = fdao.find(id);
			wdao.delete(w.getTime(), w.getWeibo());
			list = wdao.list(pageroll, id);
			request.setAttribute("user", p);
			request.setAttribute("list", list);
			request.setAttribute("pageroll", pageroll);
			request.setAttribute("friends", friends);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}catch(SQLException e){
    		e.printStackTrace();
    	}
	}
	
	public void add(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
    	String name=request.getParameter("username");
    	String sex=request.getParameter("sex");
    	String birthday=request.getParameter("birthday");
    	String email = request.getParameter("email");
    	String passwd = request.getParameter("password");
    	String nickname = request.getParameter("nickname");
    	Person p = new Person(name, nickname, sex, passwd, birthday, email);
    	PersonDao dao=new PersonDaoImpl();
    	WeiboDao da = new WeiboDaoImpl();
    	Pageroll pageroll = new Pageroll();
    	FriendDao fdao = new FriendDaoImpl();
    	List<String>friends = new ArrayList<String>();
    	try{
    		List<Weibo>weibos = new ArrayList<Weibo>();
    		dao.add(p);
    		p = dao.find(name);
    		friends = fdao.find(p.getId());
    		weibos = da.list(pageroll, p.getId());
    		p = dao.find(p.getName());
    		request.setAttribute("user", p);
    		request.setAttribute("list", weibos);
    		request.setAttribute("pageroll", pageroll);
    		request.setAttribute("friends", friends);
    		request.getRequestDispatcher("index.jsp").forward(request, response);
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
    }
	
	public void list(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		
		WeiboDao da = new WeiboDaoImpl();
		List<Weibo>list = new ArrayList<Weibo>();
		Pageroll pageroll = new Pageroll();
		Person p=null;
		PersonDao dao = new PersonDaoImpl();
		FriendDao fdao = new FriendDaoImpl();
		List<String>friends = new ArrayList<String>();
		int id = Integer.parseInt(request.getParameter("id"));
		String currpage = request.getParameter("currpage");
		int cnt = Integer.parseInt(request.getParameter("cnt"));
		int cur = 1;
		if (currpage != null) {
			cur = Integer.parseInt(currpage);
		}
		
		try {
			p = dao.find(id);
			friends = fdao.find(id);
			if (cur <= 1)
				cur = 1;
			else if (cur >= cnt)
				cur = cnt==0?1:cnt;
			
			System.out.println("cur "+cur);
			pageroll.setCurrpage(cur);
			list = da.list(pageroll,id);
			request.setAttribute("user", p);
			request.setAttribute("friends", friends);
			request.setAttribute("list", list);
			request.setAttribute("pageroll", pageroll);
			System.out.println("list");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		catch(NumberFormatException e){
    		e.printStackTrace();
    	}
	}
	public void login(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String username = request.getParameter("username");
		String passwd = request.getParameter("password");
		Person p=null;
		PersonDao dao = new PersonDaoImpl();
		Pageroll pageroll = new Pageroll();
		List<Weibo>list = new ArrayList<Weibo>();
		WeiboDao da = new WeiboDaoImpl();
		List<String>friends = new ArrayList<String>();
		FriendDao fdao = new FriendDaoImpl();
		try {
			
			p = dao.find(username);
			pageroll.setCurrpage(1);
			list = da.list(pageroll, p.getId());
			friends = fdao.find(p.getId());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		catch(NumberFormatException e){
    		e.printStackTrace();
    	}
		
		if (p.getPasswd().equals(passwd) && p != null) {
			request.setAttribute("user", p);
			request.setAttribute("list", list);
			request.setAttribute("pageroll", pageroll);
			request.setAttribute("friends", friends);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else {
			System.out.println("No exist");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("username");
    	String sex=request.getParameter("sex");
    	String birthday=request.getParameter("birthday");
    	String email = request.getParameter("email");
    	String passwd = request.getParameter("password");
    	String nickname = request.getParameter("nickname");
    	
    	PersonDao dao = new PersonDaoImpl();
    	WeiboDao da = new WeiboDaoImpl();
    	
    	Pageroll pageroll = new Pageroll();
    	List<String>friends = new ArrayList<String>();
		FriendDao fdao = new FriendDaoImpl();
    	try {
    		List<Weibo>weibos = new ArrayList<Weibo>();
    		int id = dao.find(name).getId();
    		friends = fdao.find(id);
    		weibos = da.list(pageroll, id);
    		Person p = new Person(id, name, nickname, sex, passwd, birthday, email);
    		dao.update(p);
    		System.out.println(p.getSex());
    		request.setAttribute("user", p);
    		request.setAttribute("list", weibos);
    		request.setAttribute("pageroll", pageroll);
    		request.setAttribute("friends", friends);
			request.getRequestDispatcher("index.jsp").forward(request, response);
    	}
    	catch (SQLException e) {
			System.out.println("Loginservlet");
			e.printStackTrace();
		}
		
		catch(NumberFormatException e){
    		e.printStackTrace();
    	}
	}
	
	
	public void addweibo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text = request.getParameter("text");
		String Id = request.getParameter("id");
		
		int id = Integer.parseInt(Id);
		WeiboDao dao = new WeiboDaoImpl();
		PersonDao da = new PersonDaoImpl();
		Pageroll pageroll = new Pageroll();
		List<String>friends = new ArrayList<String>();
		FriendDao fdao = new FriendDaoImpl();
		try {
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//设置日期格式
			String tim = df.format(new Date());
			System.out.println("Current time: "+tim);
			Weibo w = new Weibo(id, text, tim);
			Person p = da.find(id);
			dao.add(w);
			friends = fdao.find(p.getId());
			request.setAttribute("user", p);
			request.setAttribute("list", dao.list(pageroll, id));
			request.setAttribute("pageroll", pageroll);
			request.setAttribute("friends", friends);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		catch (SQLException e) {
			System.out.println("Weiboservlet");
			e.printStackTrace();
		}
		catch(NumberFormatException e){
    		e.printStackTrace();
    	}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
