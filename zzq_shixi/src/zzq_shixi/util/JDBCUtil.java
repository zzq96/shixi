package zzq_shixi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtil {
	//���ݿ�ip,�˿ڣ�����
	private static String adress="localhost:3306/shixi";
	
	private static Statement getConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String  url="jdbc:mysql://"+adress;
		String user="root";
		String password="123456";
		
		Connection conn= DriverManager.getConnection(url, user, password);
		System.out.println("�������ݿ�ɹ�");
		
	 return conn.createStatement();
	}
	public static int Change(String sql) throws Exception {
		Statement stmt = getConnection();
		return stmt.executeUpdate(sql);
	}
	public static ResultSet Query(String sql) throws Exception {
		Statement stmt = getConnection();
		return stmt.executeQuery(sql);
	}

}
