package zzq_shixi.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;;


public class insert {
	public static void main(String args[]) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String  url="jdbc:mysql://localhost:3306/shixi";
		String user="root";
		String password="123456";
		
		Connection conn= DriverManager.getConnection(url, user, password);
		System.out.println("链接数据库成功");
		
		Statement stmt = conn.createStatement();
		String sql = "insert into tbl_user (LoginName,LoginPwd,regDate) values('wzy','1234567',now())";
		int res = stmt.executeUpdate(sql);
		System.out.println("影响了"+res+"行");
		
	}

}
