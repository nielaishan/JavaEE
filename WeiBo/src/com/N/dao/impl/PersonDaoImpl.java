package com.N.dao.impl;

import java.sql.*;
import com.util.db.JdbcTemplete;
import com.N.base.ResultSetHandler;
import com.N.dao.PersonDao;
import com.N.entity.Person;


public class PersonDaoImpl implements PersonDao{
	private JdbcTemplete jdbcTemplete;
	
	public PersonDaoImpl(){
		jdbcTemplete = new JdbcTemplete();
	}
	
	public void add(Person p)throws SQLException{
	    String sql = "insert into person(name,sex,nickname,birthday,email,passwd,img)values(?,?,?,?,?,?,?)";
	    System.out.println(sql);
	    jdbcTemplete.update(sql, p.getName(),p.getSex(),p.getNickname(), p.getBirthday(), p.getEmail(), p.getPasswd(), p.getImg());
	}
	
	public void update(Person p)throws SQLException{
		String sql = "update Person set name=?,sex=?,nickname=?,birthday=?,email=?,passwd=?,img=? where id=?";
		jdbcTemplete.update(sql, p.getName(),p.getSex(),p.getNickname(), p.getBirthday(), p.getEmail(), p.getPasswd(),p.getImg(), p.getId());
	}
	
	public void delete(int id)throws SQLException{
		String sql = "delete from Person where id=?";
		jdbcTemplete.update(sql, id);
	}
	
	public Person find(final String name)throws SQLException{
		String sql = "select id, name, nickname, birthday, sex, passwd,email,img from Person where name=?";
		return (Person)jdbcTemplete.query(sql, new ResultSetHandler() { 
	        public Object doHandler(ResultSet rs)throws SQLException {	
	        	Person p = null;
		        if(rs.next()) {
				    p = new Person();
				    p.setId(Integer.parseInt(rs.getString(1))); 
				    p.setName(rs.getString(2));
			        p.setNickname(rs.getString(3)); 
			        p.setBirthday(rs.getString(4));
			        p.setSex(rs.getString(5));
			        p.setPasswd(rs.getString(6));
			        p.setEmail(rs.getString(7));
			        p.setImg(rs.getString(8));
		        }
		        return p;   
		    }
		}, name);
	}
	public Person find(final int id)throws SQLException{
		String sql = "select id, name, nickname, birthday, sex, passwd,email,img from Person where id=?";
		return (Person)jdbcTemplete.query(sql, new ResultSetHandler() { 
	        public Object doHandler(ResultSet rs)throws SQLException {	
	        	System.out.println("database ask");
	        	Person p = null;
		        if(rs.next()) {
				    p = new Person();
				    p.setId(Integer.parseInt(rs.getString(1))); 
				    p.setName(rs.getString(2));
			        p.setNickname(rs.getString(3)); 
			        p.setBirthday(rs.getString(4));
			        p.setSex(rs.getString(5));
			        p.setPasswd(rs.getString(6));
			        p.setEmail(rs.getString(7));
			        p.setImg(rs.getString(8));
		        }
		        System.out.println("database ask");
		        return p;   
		    }
		}, id);
	}
}
