package com.util;

import java.sql.ResultSet;

public class TestJdbcUtil {

	public static void main(String[] args) throws Exception {
		String sql = "delete from tbl_user where id='2'";
		int res = JDBCUtil.inserOrUpdateOrDelete(sql);
		System.out.println(res);
		
		System.out.println("--------------------");
		String sql2 = "select * from tbl_user";
		ResultSet rs =  JDBCUtil.query(sql2);
		while(rs.next()) {
			System.out.println(rs.getString("loginName"));
		}

	}

}
