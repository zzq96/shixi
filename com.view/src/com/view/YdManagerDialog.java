package com.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * 预定管理界面
 * @author Administrator
 *
 */
public class YdManagerDialog extends JDialog implements ActionListener {
	
	@Override
	//参数ActionEvent e 代表事件对象，可以通过该对象获得事件源的信息
	//	 通过调用e.getActionCommand()方法可以获得按钮上的文本信息(删除，修改)
	public void actionPerformed(ActionEvent e) {
		
		String buttonText = e.getActionCommand();
		System.out.println("点击的按钮为:"+buttonText);
		
		if ("删除".contentEquals(buttonText)) {//表示点击了删除按钮，执行删除对应的业务逻辑
			int rowIndex = table.getSelectedRow();
			System.out.println("选中的行索引为:"+rowIndex);
			if (rowIndex==-1) {
				JOptionPane.showMessageDialog(null, "请选择要删除的数据");
			}else {
				
				Object number =  table.getValueAt(rowIndex, 0);//获得编号（第rowIndex行 第1列的值）
				System.out.println("编号为:"+number);
				
				Object name =  table.getValueAt(rowIndex, 1);//获得姓名（第rowIndex行 第1列的值）
				System.out.println("姓名为:"+name);
				
				Object phone =  table.getValueAt(rowIndex, 2);//获得手机号（第rowIndex行 第1列的值）
				System.out.println("电话为:"+phone);
				
				//连接数据，删除数据库对应的数据，重新加载表格数据。。
			}
			
			
		}else if ("修改".contentEquals(buttonText)) {//点击了修改
			
			
			int rowIndex = table.getSelectedRow();
			System.out.println("选中的行索引为:"+rowIndex);
			if (rowIndex==-1) {
				JOptionPane.showMessageDialog(null, "请选择要修改的数据");
			}else {
				
				Object number =  table.getValueAt(rowIndex, 0);//获得编号（第rowIndex行 第1列的值）
				System.out.println("编号为:"+number);
				
				Object name =  table.getValueAt(rowIndex, 1);//获得姓名（第rowIndex行 第1列的值）
				System.out.println("姓名为:"+name);
				
				Object phone =  table.getValueAt(rowIndex, 2);//获得手机号（第rowIndex行 第1列的值）
				System.out.println("电话为:"+phone);
				
				
				//弹出一个对话框，把选中行的数据显示到对话框中
				YdEditDialog edit = new YdEditDialog();
				//给YdEditDialog中的文本框赋默认值
				edit.jtfName.setText(name+"");//把Object类型的变量，转换成字符串才可以做为参数传入到setText方法中  简的做法用变量名 +空字符串
				edit.jtfNumber.setText(number+"");
				edit.jtfPhone.setText(phone+"");
				
				//连接数据，删除数据库对应的数据，重新加载表格数据。。
			}
			
			
			
			
			
		}
		//获得表格中选中的行索引
		
		
		
		
	}

	
	JButton jbAdd = new JButton("添加");
	JButton jbUpdate = new JButton("修改");
	JButton jbDelete = new JButton("删除");
	
	//表格的数据
	Object[][] rowData = new Object[][] {
										{"1","张三","18007328601"},
										{"2","李四","18007328601"},
										{"3","王五","18007328601"},
										{"4","赵六","18007328601"}
										
										};
	//列标题					
    Object[] columnNames = new Object[] {"编号","姓名","联系电话"};
	JTable table = new JTable(rowData, columnNames);
	
	
	
	public YdManagerDialog() {
		super.setTitle("预定管理");
		//最大化显示窗体
		super.setSize(600, 600);
		super.setLocationRelativeTo(null);
		
		
		//得到JFrame的中间容器
		Container container =   super.getContentPane();
		//调用container的add就可以添加组件（前提是将组件创建出来,常用组件有JButton,JTextField...）
		//container的默认布局管理是BorderLayout(边界布局)，将界面分为东西南北中五个区域
		
		//创建中间容器:JPanel,将组件(按钮)加到Jpanel中
		JPanel jpNorth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jpNorth.add(jbAdd);
		jpNorth.add(jbUpdate);
		jpNorth.add(jbDelete);
		
		
		//将中中间容器添加到container中
		container.add(jpNorth,BorderLayout.NORTH);
		
		//构造一个带滚动条的面板  JScrollPane
		JScrollPane jsp = new JScrollPane(table);
		
		//把滚动条面板加到container中
		container.add(jsp,BorderLayout.CENTER);
	
		
		super.setVisible(true);
		 
		//给按钮注册监听器
		//多个按钮注册到同一个监听器上，按钮执行的方法是一个，必需在方法中区分用户点的是哪个按钮
		jbDelete.addActionListener(this);
		jbUpdate.addActionListener(this);
	}



	
}
