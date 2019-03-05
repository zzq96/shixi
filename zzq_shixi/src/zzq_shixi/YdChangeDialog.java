package zzq_shixi;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class YdChangeDialog extends JDialog implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("点击了确定按钮");
		
		
	}
	JLabel jl_number=new JLabel("编号");
	JTextField jtf_number=new JTextField();
	JLabel jl_name=new JLabel("姓名");
	JTextField jtf_name=new JTextField();
	JLabel jl_phone=new JLabel("联系方式");
	JTextField jtf_phone=new JTextField();
	
	JButton jb_ok=new JButton("确认修改");
	public YdChangeDialog(){
		super.setSize(400, 300);
		super.setTitle("修改信息");
		super.setLocationRelativeTo(null);
		super.setVisible(true);
		//
		Container container= super.getContentPane();
		container.setLayout(null);
		jl_number.setBounds(20, 30, 80, 40);
		jtf_number.setBounds(100, 30, 220, 40);

		jl_name.setBounds(20, 80, 80, 40);
		jtf_name.setBounds(100, 80, 220, 40);
		
		jl_phone.setBounds(20, 130, 80, 40);
		jtf_phone.setBounds(100, 130, 220, 40);
		
		jb_ok.setBounds(150, 200, 100, 50);
		
		container.add(jl_number);
		container.add(jtf_number);
		container.add(jl_name);
		container.add(jtf_name);
		container.add(jb_ok);
		container.add(jl_phone);
		container.add(jtf_phone);
		
		
		jtf_number.setText("admin");
		jtf_name.setText("123456");
		
		jb_ok.addActionListener(this);
	}

}
