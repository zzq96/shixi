package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtil {
	
	//���������ݿ����ӵķ���
	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		// 2��DriverManager����������������ݿ�����Ӷ���connection
		// �˷��������������ֱ��ʾ���ݿ����ӵ�url,�û���������
		String url = "jdbc:mysql://127.0.0.1:3306/ktvmanager";// 127.0.0.1��ʾmysql���ݿ����ڵĵ���Ip 3306��ʾ���ݿ�ļ����˿ں�
																// ktvmanager��ʾmysql�½������ݿ���
		String user = "root";
		String password = "jerry8023";
		return DriverManager.getConnection(url, user, password);

	}
	
	//����ִ��insert,update,delete���ķ���
	public static  int inserOrUpdateOrDelete(String sql ) throws Exception {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		return stmt.executeUpdate(sql);
		
	}
	
	
	//����ִ�в�ѯ���ķ���
	public static ResultSet query(String sql ) throws Exception {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		return stmt.executeQuery(sql);
	}
	

}
