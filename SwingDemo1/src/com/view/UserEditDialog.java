package com.view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.util.JDBCUtil;

/**
 * 用户管理话框
 * @author Administrator
 *
 */
public class UserEditDialog extends JDialog  implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//事件处理代码写在此处。。
		System.out.println("点击了按钮");
		//拿到文本中的用户名:调用JtextFiled的getText()方法
		String id =  jtfNumber.getText();//获得编号
		String name = jtfName.getText();//姓名
		String sex = jtfSex.getText();//性别
		String sql = "update tbl_user set name='"+name+"' ,sex='"+sex+"' where id='"+id+"' ";
		try {
			int res = JDBCUtil.inserOrUpdateOrDelete(sql);
			userManagerDialog.initTableData();
			JOptionPane.showMessageDialog(null, "修改成功");
			this.dispose();//关闭当前的界面
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "修改失败，系统错误");
		}
		
		
	}
	
	JButton jbOK = new JButton("确定");//表示创建一个按钮对象
	JLabel jlbNumber = new JLabel("编号:");
	JTextField jtfNumber = new JTextField();	
	
	JLabel jlbName = new JLabel("姓名:");
	JTextField jtfName = new JTextField();
	
	JLabel jlbSex = new JLabel("性别");
	JTextField jtfSex = new JTextField();
	
	
	UserManagerDialog userManagerDialog ;
	
	public UserEditDialog(UserManagerDialog umd ) {//构造方法.表示创建UserEditDialog类对象时，必需传入一个UserManagerDialog对象
		this.userManagerDialog = umd;//把参数赋给成员变量，目的是在其它方法中可以引用该参数
		//调用JFrame中提供的方法设置窗体属性
		//可以使用super.方式调用
		super.setSize(400, 300);//创建400*300的窗体
		super.setTitle("修改用户信息");
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
		
		jlbNumber.setBounds(20, 30, 80, 40);
		jtfNumber.setBounds(100, 30, 220, 40);
		
		jlbName.setBounds(20, 80, 80, 40);
		jtfName.setBounds(100, 80, 220, 40);
		
		jlbSex.setBounds(20, 130, 80, 40);
		jtfSex.setBounds(100, 130, 220, 40);
		
		//将组件加入到容器中
		container.add(jbOK);
		container.add(jlbNumber);
		container.add(jtfNumber);
		container.add(jlbName);
		container.add(jtfName);	
		container.add(jlbSex);
		container.add(jtfSex);
		super.setVisible(true);//设置窗体可见
		
		//给组件注册监听器
		jbOK.addActionListener(this);
	}


	
}
