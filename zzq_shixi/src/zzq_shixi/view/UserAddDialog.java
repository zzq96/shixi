package zzq_shixi.view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import javax.swing.*;

import zzq_shixi.util.JDBCUtil;
public class UserAddDialog extends JDialog implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("点击了确定按钮");
		String user_name = jtf_user_name.getText();
		String name = jtf_name.getText();
		String pwd = jtf_pwd.getText();
		
		String id = UUID.randomUUID().toString().replace("-", "");
		String sql ="insert into tbl_user (id, LoginName, LoginPwd,Name,RegDate) values('"+id+"','"+user_name+"','"+pwd+"','"+name+"',now());";
		try {
			int res = JDBCUtil.Change(sql);
			umd.InitTable();
			JOptionPane.showMessageDialog(null, "插入成功");
			this.dispose();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "插入失败，稍后再说");
		}
		
		
		
	}
	JLabel jl_user_name=new JLabel("用户名");
	JTextField jtf_user_name=new JTextField();
//	JLabel jl_pwd=new JLabel("密码");
//	JTextField jtf_pwd=new JTextField();
	JLabel jl_name=new JLabel("姓名");
	JTextField jtf_name=new JTextField();
	JLabel jl_pwd=new JLabel("密码");
	JTextField jtf_pwd=new JTextField();
	
	UserManagerDialog umd = null;
	
	JButton jb_ok=new JButton("确认修改");
	public UserAddDialog(UserManagerDialog umd){
		this.umd = umd;
		
		super.setSize(400, 300);
		super.setTitle("修改信息");
		super.setLocationRelativeTo(null);
		super.setVisible(true);
		//
		Container container= super.getContentPane();
		container.setLayout(null);
		jl_user_name.setBounds(20, 30, 80, 40);
		jtf_user_name.setBounds(100, 30, 220, 40);

		jl_name.setBounds(20, 80, 80, 40);
		jtf_name.setBounds(100, 80, 220, 40);
		
		jl_pwd.setBounds(20, 130, 80, 40);
		jtf_pwd.setBounds(100, 130, 220, 40);
		
		jb_ok.setBounds(150, 200, 100, 50);
		
		container.add(jl_user_name);
		container.add(jtf_user_name);
		container.add(jl_name);
		container.add(jtf_name);
		container.add(jb_ok);
		container.add(jl_pwd);
		container.add(jtf_pwd);
		
		
//		jtf_user_name.setText("admin");
//		jtf_name.setText("123456");
		
		jb_ok.addActionListener(this);
	}

}
