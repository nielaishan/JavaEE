package com.util.db;

import java.sql.*;
import java.util.List;
import com.N.dao.PersonDao;
import com.N.base.ResultSetHandler;
import com.N.dao.impl.PersonDaoImpl;
import com.N.entity.Person;

public class JdbcTemplete {
	
    //
	public int update(String sql, Object...args){
		System.out.println(sql);
		Connection conn = null; 
		PreparedStatement ps = null;
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			if(args!=null){
				for (int i = 0; i < args.length; i++) {
					ps.setObject(i+1, args[i]);  
				} 
			}
			return ps.executeUpdate();
		}catch(SQLException e){
			System.out.println("database update");
			e.printStackTrace();
			return -1;
		}finally{
				DBUtils.close(null, ps, conn);
		}
	}
	public Object query(String sql,ResultSetHandler handler,Object...args){
		System.out.println(sql);
		Connection conn  = null; 
		PreparedStatement ps = null;
		ResultSet rs = null;	
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			if(args!=null){
				for (int i = 0; i < args.length; i++) {
					ps.setObject(i+1, args[i]);
				}
			}
			rs = ps.executeQuery();
			return handler.doHandler(rs);
		} catch (SQLException e) {
				System.out.println("find");
				e.printStackTrace();
				return null;
		}
	}
}
