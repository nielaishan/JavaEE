package com.util.db;

import java.sql.*;
public class DBUtils {
	public final static String URL = "jdbc:mysql://127.0.0.1:3306/mysqltest?characterEncoding=utf8&useSSL=true";
	public final static String USERNAME = "root";
	public final static String PASSWORD = "201314";
	public final static String DRIVER = "com.mysql.jdbc.Driver";
	
	private DBUtils(){
		
	}
	
	static{
		try{
			Class.forName(DRIVER);	
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
		    conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			System.out.println("database no connection");
		    e.printStackTrace();
		}
		    return conn;
	}

	public static void close(ResultSet rs,Statement state,Connection conn){
		try {
			if (rs!=null) rs.close();
		    if (state!=null) state.close();
		    if (conn!=null) conn.close();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	}

}
