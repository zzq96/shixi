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
		System.out.println("�����ȷ����ť");
		
		String user_name=jtf_user_name.getText();
		String pwd=jtf_pwd.getText();
		//��ѯ���ݿ�����
		String sql = "select * from tbl_user where LoginName='"+user_name+"' and LoginPwd='"+pwd+"'";
//		The type of the expression must be an array type but it resolved to Vector
		ResultSet res = null;
		try {
			
			res = JDBCUtil.QueryReturnResultSet(sql);//�õ���ѯ���������
		
			if(res.next())
			{
			
				System.out.println("������ȷ");
				this.dispose();
				MainFrame mf=new MainFrame();
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "�û������������");
			} 
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}
	//һЩ���
	JLabel jl_user_name=new JLabel("�û���");
	JTextField jtf_user_name=new JTextField();
	JLabel jl_pwd=new JLabel("����");
	JPasswordField jtf_pwd=new JPasswordField();
	JButton jb_ok=new JButton("ȷ��");
	
	public LoginFrame(){
		super.setSize(400, 300);
		super.setTitle("���ݿ��û���¼");
		super.setLocationRelativeTo(null);
		super.setVisible(true);
		//
		
		
		Container container= super.getContentPane();
		container.setLayout(null);
		jb_ok.setBounds(250,200,120,40);//�����λ�ü���С
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
