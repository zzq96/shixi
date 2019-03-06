package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtil {
	
	//定义获得数据库连接的方法
	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		// 2用DriverManager驱动管理类获与数据库的连接对象connection
		// 此方法的三个参数分别表示数据库连接的url,用户名，密码
		String url = "jdbc:mysql://127.0.0.1:3306/ktvmanager";// 127.0.0.1表示mysql数据库所在的电脑Ip 3306表示数据库的监听端口号
																// ktvmanager表示mysql下建的数据库名
		String user = "root";
		String password = "jerry8023";
		return DriverManager.getConnection(url, user, password);

	}
	
	//定义执行insert,update,delete语句的方法
	public static  int inserOrUpdateOrDelete(String sql ) throws Exception {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		return stmt.executeUpdate(sql);
		
	}
	
	
	//定义执行查询语句的方法
	public static ResultSet query(String sql ) throws Exception {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		return stmt.executeQuery(sql);
	}
	

}
