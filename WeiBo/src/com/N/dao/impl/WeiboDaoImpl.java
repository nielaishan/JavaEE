package com.N.dao.impl;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.N.base.ResultSetHandler;
import com.N.dao.*;
import com.N.entity.*;
import com.util.db.*;

public class WeiboDaoImpl implements WeiboDao {
	private JdbcTemplete jdbctemplete;
	public WeiboDaoImpl() {
		jdbctemplete = new JdbcTemplete();
	}
	@Override
	public void add(Weibo w) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into weibolist(id, weibo, tim) Values(?, ?, ?)";
		System.out.println("weiboadd"+sql);
		jdbctemplete.update(sql, w.getId(), w.getWeibo(), w.getTime());
	}

	@Override
	public void update(Weibo w) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update weibo set weibo=? where tim=? and ";
		jdbctemplete.update(sql, w.getWeibo(), w.getTime(), w.getId());
	}

	@Override
	public void delete(String tim, String text) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from weibolist where weibo=? and tim=?";
		jdbctemplete.update(sql, text, tim);
	}

	@Override
	public Weibo find(int id, String text)throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select id, weibo, tim from weibolist where id=? and weibo=?";
		return (Weibo)jdbctemplete.query(sql, new ResultSetHandler() { 
	        public Object doHandler(ResultSet rs)throws SQLException {	
	        	System.out.println("database ask");
	        	Weibo w = null;
		        if(rs.next()) {
				    w = new Weibo();
				    w.setId(Integer.parseInt(rs.getString(1))); 
				    w.setWeibo(rs.getString(2));
				    w.setTime(rs.getString(3));
		        }
		        System.out.println("database ask");
		        return w;   
		    }
		}, id, text);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Weibo> findall(final int id) throws SQLException{
		// TODO Auto-generated method stub
		String sql = "select id,weibo,tim from weibolist where id=?";
		return (List<Weibo>)jdbctemplete.query(sql, new ResultSetHandler() {
			public Object doHandler(ResultSet rs) throws SQLException {
			    List<Weibo> weibos = new ArrayList<Weibo>();
			    Weibo w = null;
			    while(rs.next()){
				    w = new Weibo();
				    w.setId(rs.getInt(1));
			        w.setWeibo(rs.getString(2));
			        w.setTime(rs.getString(3));
			        weibos.add(w);
			    }
			    return weibos;
		    }
	    }, id);
	}
	
	@Override
	public List<Weibo> list(Pageroll pageroll, int id) throws SQLException {
		String sql1 = "select count(*) from weibolist where id=?";
		String sql2 = "select id, weibo, tim from weibolist where id = ? order by tim desc limit ?, ?";
		Integer cnt = (Integer)jdbctemplete.query(sql1, new ResultSetHandler() {
			public Object doHandler(ResultSet rs) throws SQLException {
				if (rs.next()) {
					Integer cnt = rs.getInt(1);
					return cnt;
				}
				return null;
			}
		}, id);
		pageroll.setTatalcnt(cnt);
		System.out.println("currpage: "+pageroll.getCurrpage());
		@SuppressWarnings("unchecked")
		List<Weibo> list = (List<Weibo>)jdbctemplete.query(sql2, new ResultSetHandler(){
			public Object doHandler(ResultSet rs) throws SQLException {
				List<Weibo> list = new ArrayList<Weibo>();
				Weibo w = null;
				while (rs.next()) {
					w = new Weibo();
					w.setId(rs.getInt(1));
					w.setWeibo(rs.getString(2));
					w.setTime(rs.getString(3));
					list.add(w);
				}
				return list;
			}
		},id, (pageroll.getCurrpage()-1)*(pageroll.getPagesize()), pageroll.getPagesize());
		System.out.println((pageroll.getCurrpage()-1)*(pageroll.getPagesize())+" "+pageroll.getPagesize());
		return list;
	}
}
