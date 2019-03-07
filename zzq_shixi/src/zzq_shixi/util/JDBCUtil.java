package zzq_shixi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class JDBCUtil {
	//数据库ip,端口，名字
	private static String adress="localhost:3306/shixi";
	
	private static Statement getConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String  url="jdbc:mysql://"+adress;
		String user="root";
		String password="123456";
		
		Connection conn= DriverManager.getConnection(url, user, password);
		System.out.println("链接数据库成功");
		
	 return conn.createStatement();
	}
	public static int Change(String sql) throws Exception {
		Statement stmt = getConnection();
		return stmt.executeUpdate(sql);
	}
	public static ResultSet QueryReturnResultSet(String sql) throws Exception {
		Statement stmt = getConnection();
		return stmt.executeQuery(sql);
	}
	public static Vector QueryReturnVector(String sql) throws Exception {
		Statement stmt = getConnection();
		ResultSet res = stmt.executeQuery(sql);
		Vector data = new Vector();
		while(res.next()) {
			Vector row_data = new Vector();
			String id = res.getString("id");
			String login_name = res.getString("LoginName");
			String name = res.getString("Name");
			String sex = res.getString("Sex");
			String regdate = res.getString("RegDate");
//			System.out.println(id);
			row_data.add(id);
			row_data.add(login_name);
			row_data.add(name);
			row_data.add(sex);
			row_data.add(regdate);
			
			data.add(row_data);//把一行数据加入到表格中
		}
		return data;
	}
	

}
