package com.N.dao;
import java.util.*;
import java.sql.*;

public interface FriendDao {
	public List<String>find(int id) throws SQLException;
	public int find(int id, String f_name) throws SQLException;
	public void delete(int cnt) throws SQLException;
}
