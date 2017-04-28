package com.N.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;

//import src.com.ren.base.PageRoll;
import com.N.dao.*;
import com.N.dao.impl.*;
import com.N.entity.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.*;
public class FileServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
		String method="post";
		if("1".equals(flag)){
			/*
			FileUploadServlet f = new FileUploadServlet();
			String path = f.uploadFile(request,response,"/image");
			System.out.println("file");
			String user = request.getParameter("id");
			PersonDao dao = new PersonDaoImpl();
			Person p = new Person(user, path);
			
			try{
				p = 
				dao.updatepic(p);
				Person q = dao.findById(user);
				System.out.println(q);
				request.setAttribute("Person",q);
				request.getRequestDispatcher("main.jsp").forward(request,response);
				//response.sendRedirect(request.getContextPath()+"/PersonServlet?method=list");
			}catch(SQLException e){
				e.printStackTrace();
			}
			*/
		}else{
			/*String rootPath = request.getSession().getServletContext()
				.getRealPath("./");
			System.out.println("file");
			System.out.println(rootPath);*/
			FileUploadServlet f = new FileUploadServlet();
			String path = f.uploadFile(request,response,"/image");
			System.out.println("file");
			int id = 1;
			System.out.println(path);
			PersonDao dao = new PersonDaoImpl();
			Person p = new Person();
			List<Weibo>list = new ArrayList<Weibo>();
			List<String>friends = new ArrayList<String>();
			WeiboDao wdao = new WeiboDaoImpl();
			FriendDao fdao = new FriendDaoImpl();
			Pageroll pageroll = new Pageroll();
			
			/*System.out.println(p);*/
			try{
				p = dao.find(id);
				Person p1 = new Person(p, path);
				list = wdao.list(pageroll, p.getId());
				friends = fdao.find(1);
				request.setAttribute("user",p1);
				request.setAttribute("list", list);
				request.setAttribute("friends", friends);
				request.setAttribute("pageroll", pageroll);
				request.getRequestDispatcher("index.jsp").forward(request,response);
			
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("Welcome to Servlet");  
		doPost(request,response);
	}
	
}
