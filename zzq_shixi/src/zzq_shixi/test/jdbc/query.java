package zzq_shixi.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;;


public class query {
	public static void main(String args[]) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String  url="jdbc:mysql://localhost:3306/shixi";
		String user="root";
		String password="123456";
		
		Connection conn= DriverManager.getConnection(url, user, password);
		System.out.println("�������ݿ�ɹ�");
		
		Statement stmt = conn.createStatement();
		String sql = "select * from tbl_user";
		ResultSet res = stmt.executeQuery(sql);
//		System.out.println("Ӱ����"+res+"��");
		//System.out.println(res.next());
		while(res.next()){
			System.out.println(res.getString("id"));
		}
		
	}

}