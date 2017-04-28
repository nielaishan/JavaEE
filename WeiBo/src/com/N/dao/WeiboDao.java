package com.N.dao;

import java.sql.SQLException;
import java.util.*;

import com.N.entity.*;

public interface WeiboDao {
	public void add(Weibo w)throws SQLException;
	public void update(Weibo p)throws SQLException;
	public void delete(String tim, String text) throws SQLException;
	public Weibo find(int id, String text)throws SQLException;
	public List<Weibo> findall(int id)throws SQLException;
	public List<Weibo> list(Pageroll pageroll, int id) throws SQLException;
}
