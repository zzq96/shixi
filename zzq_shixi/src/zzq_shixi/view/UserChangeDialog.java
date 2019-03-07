package zzq_shixi.view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import zzq_shixi.util.JDBCUtil;
public class UserChangeDialog extends JDialog implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("点击了确定按钮");
		String name = jtf_name.getText();
		String sex = jtf_sex.getText();
		String id= jtf_id.getText();
		String sql = "update tbl_user set name='"+name+"',sex='"+sex+"' where id='"+id+"'";
		try {
			int res = JDBCUtil.Change(sql);
			umd.InitTable();
			JOptionPane.showMessageDialog(null, "修改成功");
			this.dispose();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "修改失败，请稍后再试");
		}
		
	}
	JLabel jl_id=new JLabel("编号");
	JTextField jtf_id=new JTextField();
	JLabel jl_name=new JLabel("姓名");
	JTextField jtf_name=new JTextField();
	JLabel jl_sex=new JLabel("性别");
	JTextField jtf_sex=new JTextField();
	UserManagerDialog umd = null;
	
	JButton jb_ok = new JButton("确认修改");
	public UserChangeDialog(UserManagerDialog umd){
		this.umd = umd;
		super.setSize(400, 300);
		super.setTitle("修改信息");
		super.setLocationRelativeTo(null);
		super.setVisible(true);
		//
		Container container= super.getContentPane();
		container.setLayout(null);
		jl_id.setBounds(20, 30, 80, 40);
		jtf_id.setBounds(100, 30, 220, 40);
//		jtf_id.is();//将id设为不可改

		jl_name.setBounds(20, 80, 80, 40);
		jtf_name.setBounds(100, 80, 220, 40);
		
		jl_sex.setBounds(20, 130, 80, 40);
		jtf_sex.setBounds(100, 130, 220, 40);
		
		jb_ok.setBounds(150, 200, 100, 50);
		
		container.add(jl_id);
		container.add(jtf_id);
		container.add(jl_name);
		container.add(jtf_name);
		container.add(jb_ok);
		container.add(jl_sex);
		container.add(jtf_sex);
		
		
//		jtf_id.setText("admin");
//		jtf_name.setText("123456");
		
		jb_ok.addActionListener(this);
	}

}
