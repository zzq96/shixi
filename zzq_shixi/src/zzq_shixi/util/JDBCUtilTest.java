package zzq_shixi.util;

import java.sql.ResultSet;

public class JDBCUtilTest {
	public static void main(String args[]) throws Exception {
		String sql1 = "Select * from tbl_user";
		ResultSet res1=JDBCUtil.Query(sql1);
		
		while(res1.next()) {
			System.out.println("���:"+res1.getString("id")+",����:"+res1.getString("LoginName"));
		}
		
		String sql2 = "insert into tbl_user (id,LoginName,LoginPwd,regDate) values('11','zzh','12312',now())";
		int res2=JDBCUtil.Change(sql2);
		System.out.println("Ӱ�죺"+res2);

	}
}
