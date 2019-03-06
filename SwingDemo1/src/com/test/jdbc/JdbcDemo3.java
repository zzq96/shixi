package com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.UUID;



public class JdbcDemo3 {

	
	public static void main(String[] args) throws Exception {
		
		////1加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2用DriverManager驱动管理类获与数据库的连接对象connection
			//此方法的三个参数分别表示数据库连接的url,用户名，密码
		String url = "jdbc:mysql://127.0.0.1:3306/ktvmanager";// 127.0.0.1表示mysql数据库所在的电脑Ip   3306表示数据库的监听端口号
																//ktvmanager表示mysql下建的数据库名
		String user = "root";
		String password="jerry8023";
			
		Connection conn =   DriverManager.getConnection(url, user, password);
		System.out.println("数据库连接成功");
		
		//3 通过Connection创建可执行SQL语句的Statment对象
		Statement stmt =   conn.createStatement();
		//4 调用Statement的 executeUpdate(String sql) 语句执行 insert,update,delete等语句
						 //executeQuery(String sql ) 执行select语句
		
		
		
		String sql = "select * from  tbl_user ";
		System.out.println("交给数据库执行的SQL语句为:"+sql);
		
		//ResultSet表示查询结果集，可以调用该对象的相关方法取出查询结果
		ResultSet rs =  stmt.executeQuery(sql);//返回值res表示sql语句影响的行数
		// rs.next();//返回boolean值，用于判断是否有数据，每调用一次该方法，游标
		  //rs.getString("列名");//取出列名对应的列值，配合rs.next使用
		
		while(rs.next()) {
			//System.out.println("----------------------");
			String id = rs.getString("id");
			String loginName = rs.getString("loginName");
			String date = rs.getString("regDate");
			System.out.println("编号为:"+id  +" 登录名:"+loginName +" 注册日期:"+date);
			
		}
		
		//5 关闭连接
		conn.close();
		
		
	}
}
