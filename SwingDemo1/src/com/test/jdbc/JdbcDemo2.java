package com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import java.util.UUID;

public class JdbcDemo2 {

	
	public static void main(String[] args) throws Exception {
		
		////1��������
		Class.forName("com.mysql.jdbc.Driver");
		
		//2��DriverManager����������������ݿ�����Ӷ���connection
			//�˷��������������ֱ��ʾ���ݿ����ӵ�url,�û���������
		String url = "jdbc:mysql://127.0.0.1:3306/ktvmanager";// 127.0.0.1��ʾmysql���ݿ����ڵĵ���Ip   3306��ʾ���ݿ�ļ����˿ں�
																//ktvmanager��ʾmysql�½������ݿ���
		String user = "root";
		String password="jerry8023";
			
		Connection conn =   DriverManager.getConnection(url, user, password);
		System.out.println("���ݿ����ӳɹ�");
		
		//3 ͨ��Connection������ִ��SQL����Statment����
		Statement stmt =   conn.createStatement();
		//4 ����Statement�� executeUpdate(String sql) ���ִ�� insert,update,delete�����
						 //executeQuery(String sql ) ִ��select���
		Scanner sc = new Scanner(System.in);
		System.out.println("�������û���");
		String userName =  sc.next();
		System.out.println("����������");
		String pwd = sc.next();
		
		
		//java����UUID�࣬���Բ���һ�����ظ����ַ���������Ϊ40
		String id =     UUID.randomUUID().toString();
		
		
		String sql = "insert into tbl_user (id,loginName,loginPwd,regDate) values('"+id+"','"+userName+"','"+pwd+"',now())";
		System.out.println("�������ݿ�ִ�е�SQL���Ϊ:"+sql);
		//sql  = "delete from tbl_user where id=3";
		int res = stmt.executeUpdate(sql);//����ֵres��ʾsql���Ӱ�������
		System.out.println("sql���Ӱ�������:"+res);
		
		//5 �ر�����
		conn.close();
		
		
	}
}
