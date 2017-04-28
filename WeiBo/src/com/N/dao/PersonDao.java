package com.N.dao;
import com.N.entity.*;
import java.sql.*;

public interface PersonDao {
	public void add(Person p)throws SQLException;
	public void update(Person p)throws SQLException;
	public void delete(int id) throws SQLException;
	public Person find(String name)throws SQLException;
	public Person find(int id)throws SQLException;
}
