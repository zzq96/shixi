package zzq_shixi.view;
import java.awt.BorderLayout;
import zzq_shixi.util.JDBCUtil;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
public class LoginFrame extends JFrame implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("点击了确定按钮");
		
		String user_name=jtf_user_name.getText();
		String pwd=jtf_pwd.getText();
		//查询数据库的语句
		String sql = "select * from tbl_user where LoginName='"+user_name+"' and LoginPwd='"+pwd+"'";
//		The type of the expression must be an array type but it resolved to Vector
		ResultSet res = null;
		try {
			
			res = JDBCUtil.QueryReturnResultSet(sql);//得到查询结果的数量
		
			if(res.next())
			{
			
				System.out.println("密码正确");
				this.dispose();
				MainFrame mf=new MainFrame();
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "用户名和密码错误");
			} 
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}
	//一些组件
	JLabel jl_user_name=new JLabel("用户名");
	JTextField jtf_user_name=new JTextField();
	JLabel jl_pwd=new JLabel("密码");
	JPasswordField jtf_pwd=new JPasswordField();
	JButton jb_ok=new JButton("确认");
	
	public LoginFrame(){
		super.setSize(400, 300);
		super.setTitle("数据库用户登录");
		super.setLocationRelativeTo(null);
		super.setVisible(true);
		//
		
		
		Container container= super.getContentPane();
		container.setLayout(null);
		jb_ok.setBounds(250,200,120,40);//组件的位置及大小
		jl_user_name.setBounds(20, 30, 80, 40);
		jtf_user_name.setBounds(100, 30, 220, 40);

		jl_pwd.setBounds(20, 80, 80, 40);
		jtf_pwd.setBounds(100, 80, 220, 40);
		jb_ok.setBounds(150, 200, 100, 50);
		
		container.add(jl_user_name);
		container.add(jtf_user_name);
		container.add(jl_pwd);
		container.add(jtf_pwd);
		container.add(jb_ok);
		
		jtf_user_name.setText("admin");
		jtf_pwd.setText("123456");
		
		jb_ok.addActionListener(this);
	}

}
