package com.N.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.N.base.ResultSetHandler;
import com.N.dao.FriendDao;
import com.util.db.*;

public class FriendDaoImpl implements FriendDao {
	private JdbcTemplete jdbctemplete;
	public FriendDaoImpl() {
		jdbctemplete = new JdbcTemplete();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> find(int id) throws SQLException {
		String sql = "select id,f_name from friend where id=?";
		return (List<String>)jdbctemplete.query(sql, new ResultSetHandler() { 
	        public Object doHandler(ResultSet rs)throws SQLException {	
	        	List<String>friends = new ArrayList<String>();
	        	String s=null;
		        while (rs.next()) {
		        	s = new String();
		        	s = rs.getString(2);
		        	friends.add(s);
		        }
		        return friends;   
		    }
		}, id);
	}
	
	@Override
	public int find(int id, String f_name) throws SQLException {
		String sql = "select cnt from friend where id=? and f_name=?";
		return (Integer) jdbctemplete.query(sql, new ResultSetHandler() { 
	        public Object doHandler(ResultSet rs)throws SQLException {	
	        	int cnt = 1;
		        if (rs.next())
		        	cnt = rs.getInt(1);
		        return cnt;   
		    }
		}, id, f_name);
	}
	public void delete(int cnt) throws SQLException {
		String sql = "delete from friend where cnt=?";
		jdbctemplete.update(sql, cnt);
	}
}
