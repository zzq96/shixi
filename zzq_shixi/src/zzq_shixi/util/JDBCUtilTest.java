package zzq_shixi.util;

import java.sql.ResultSet;
import java.util.Vector;

public class JDBCUtilTest {
	public static void main(String args[]) throws Exception {
		String sql = "Select * from tbl_user";
		Vector res=JDBCUtil.QueryReturnVector(sql);
		
		for(int i=0;i<res.size();i++) {
			for(int j=0;j<((Vector) res.get(i)).size();j++){
				System.out.println(((Vector) res.get(i)).get(j)+" ");
			}
			System.out.println();
		}
		
//		String sql2 = "insert into tbl_user (id,LoginName,LoginPwd,regDate) values('11','zzh','12312',now())";
//		int res2=JDBCUtil.Change(sql2);
//		System.out.println("Ӱ�죺"+res2);

	}
}
