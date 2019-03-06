package com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcDemo1 {

	
	public static void main(String[] args) throws Exception {
		
		////1加载驱动
		
	
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
		
		String sql = "";//"insert into tbl_user (id,loginName,loginPwd,regDate) values('3','test','123456',now())";
		sql  = "delete from tbl_user where id=3";
		int res = stmt.executeUpdate(sql);//返回值res表示sql语句影响的行数
		System.out.println("sql语句影响的行数:"+res);
		
		//5 关闭连接
		conn.close();
		
		
	}
}
