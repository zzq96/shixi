package com.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String btnText = e.getActionCommand();
		
		if ("用户管理".equals(btnText)) {
			///弹出用户管理界面
			UserManagerDialog ud = new UserManagerDialog();
		}else if ("预定管理".equals(btnText)) {
			//点击预定管理按钮，弹出YdManagerDialog界面
			YdManagerDialog yd = new YdManagerDialog();
		}
	
	}
	
	
	JButton jbGKKD = new JButton("顾客开单");
	JButton jbYDGL = new JButton("预定管理");
	JButton jbBKJZ = new JButton("宾客结账");

	JButton jbYHGL = new JButton("用户管理");
	
	JButton jbCenter = new JButton("暂时放在中间部分的按钮");
	
	public MainFrame() {
		super.setTitle("XXXX管理系统");
		//最大化显示窗体
		super.setSize(800, 300);
		super.setExtendedState(JFrame.MAXIMIZED_BOTH);//最大化显示窗体
		
		//得到JFrame的中间容器
		Container container =   super.getContentPane();
		//调用container的add就可以添加组件（前提是将组件创建出来,常用组件有JButton,JTextField...）
		//container的默认布局管理是BorderLayout(边界布局)，将界面分为东西南北中五个区域
		
		//创建中间容器:JPanel,将组件(按钮)加到Jpanel中
		JPanel jpNorth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jpNorth.add(jbGKKD);
		jpNorth.add(jbYDGL);
		jpNorth.add(jbBKJZ);
		jpNorth.add(jbYHGL);
		
		
		//将中中间容器添加到container中
		container.add(jpNorth,BorderLayout.NORTH);
		container.add(jbCenter,BorderLayout.CENTER);
	
		
		super.setVisible(true);
		
		//注册监听器
		jbYDGL.addActionListener(this);
		jbYHGL.addActionListener(this);
	}


}
