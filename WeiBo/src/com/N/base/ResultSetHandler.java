package com.N.base;
import java.sql.*;
public interface ResultSetHandler {
	public Object doHandler(ResultSet rs) throws SQLException;
	
}
