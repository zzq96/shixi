package com.view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame  implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//事件处理代码写在此处。。
		System.out.println("点击了按钮");
		//拿到文本中的用户名:调用JtextFiled的getText()方法
		String userName =  jtfUserName.getText();
		System.out.println("用户名为:"+userName);
		String pwd = jtfPwd.getText();
		System.out.println("密码为:"+pwd);
		
		
		
		//如输入的用户为admin,密码为123456，则认为登录成功
		if ("admin".equals(userName) && "123456".contentEquals(pwd)) {
			System.out.println("用户名密码正确");
			//关闭当前登录窗体(调用dispolse()方法)，创建一新的窗体
			super.dispose();
			//创建新窗体
			MainFrame mf = new MainFrame();//打开了新界面
		}else {
			JOptionPane.showMessageDialog(null, "用户名或密码错误");//弹出确认对话框
		}
		
	}
	
	JButton jbOK = new JButton("确定");//表示创建一个按钮对象
	JLabel jlbUserName = new JLabel("用户名:");
	JTextField jtfUserName = new JTextField("admin");	
	
	JLabel jlbPwd = new JLabel("密   码:");
	JPasswordField jtfPwd = new JPasswordField("123456");	
	
	
	public LoginFrame() {//构造方法
		//调用JFrame中提供的方法设置窗体属性
		//可以使用super.方式调用
		super.setSize(400, 300);//创建400*300的窗体
		super.setTitle("用户登录");
		//super.setLocation(600, 300);//设置窗体相对于屏幕左上角的偏移量
		super.setLocationRelativeTo(null);//窗体居中显示
		
		//super.setResizable(false);//不允许改变窗体
		//JFrame是顶级容器,获得顶级容器内置的中间容器，再往中间容器添加组件
		Container container =   super.getContentPane();
		//调用container的add就可以添加组件（前提是将组件创建出来,常用组件有JButton,JTextField...）
		//container的默认布局管理是BorderLayout(边界布局)，将界面分为东西南北中五个区域
		//可以将container的布局管理器设置为空布局(调用setLayOut(null)),由组件自身调用setBounds(int x ,int y,int widht,int height)方法决定组件摆放在界面的哪个位置
		container.setLayout(null);
		jbOK.setBounds(250,200,120,40);//组件的位置及大小
		jlbUserName.setBounds(20, 30, 80, 40);
		jtfUserName.setBounds(100, 30, 220, 40);
		
		jlbPwd.setBounds(20, 80, 80, 40);
		jtfPwd.setBounds(100, 80, 220, 40);
		
		//将组件加入到容器中
		container.add(jbOK);
		container.add(jlbUserName);
		container.add(jtfUserName);
		container.add(jlbPwd);
		container.add(jtfPwd);		
		super.setVisible(true);//设置窗体可见
		
		//给组件注册监听器
		jbOK.addActionListener(this);
	}


	
}
