package com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.UUID;

public class JdbcDemo4 {

	public static void main(String[] args) throws Exception {

		//// 1��������
		Class.forName("com.mysql.jdbc.Driver");

		// 2��DriverManager����������������ݿ�����Ӷ���connection
		// �˷��������������ֱ��ʾ���ݿ����ӵ�url,�û���������
		String url = "jdbc:mysql://127.0.0.1:3306/ktvmanager";// 127.0.0.1��ʾmysql���ݿ����ڵĵ���Ip 3306��ʾ���ݿ�ļ����˿ں�
																// ktvmanager��ʾmysql�½������ݿ���
		String user = "root";
		String password = "jerry8023";

		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println("���ݿ����ӳɹ�");

		// 3 ͨ��Connection������ִ��SQL����Statment����
		Statement stmt = conn.createStatement();
		// 4 ����Statement�� executeUpdate(String sql) ���ִ�� insert,update,delete�����
		// executeQuery(String sql ) ִ��select���

		Scanner sc = new Scanner(System.in);
		System.out.println("�������û���");
		String userName = sc.next();
		System.out.println("����������");
		String pwd = sc.next();

		// java����UUID�࣬���Բ���һ�����ظ����ַ���������Ϊ40

		String sql = "select *from tbl_user where loginName='"+userName+"' and loginPwd = '"+pwd+"' ";
		// ResultSet��ʾ��ѯ����������Ե��øö������ط���ȡ����ѯ���
		ResultSet rs = stmt.executeQuery(sql);// ����ֵres��ʾsql���Ӱ�������
		// rs.next();//����booleanֵ�������ж��Ƿ������ݣ�ÿ����һ�θ÷������α�
		// rs.getString("����");//ȡ��������Ӧ����ֵ�����rs.nextʹ��
		boolean flag = false;//Ĭ��Ϊ�٣��û���������֤�ı�־��
		
		
		while (rs.next()) {
			flag = true;
			// System.out.println("----------------------");
			String id = rs.getString("id");
			String loginName = rs.getString("loginName");
			String date = rs.getString("regDate");
			System.out.println("���Ϊ:" + id + " ��¼��:" + loginName + " ע������:" + date);
		}
		
		if (flag==true) {
			System.out.println("�û���������ȷ");
		}else {
			System.out.println("�û����������");
		}
		
		
		// 5 �ر�����
		conn.close();

	}
}
