package com.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.util.JDBCUtil;

/**
 * 用户管理界面
 * @author Administrator
 *
 */
public class UserManagerDialog extends JDialog implements ActionListener {
	
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
				String sql = "delete from tbl_user where id='"+number+"'";
				
				try {
					int res = JDBCUtil.inserOrUpdateOrDelete(sql);
					
					if(res>0) {//数据库中数据删除后，把表格中的对应行数据从界面中移除
						dtm.removeRow(rowIndex);//移除表格中的某一行
						//initTableData();
					}
					JOptionPane.showMessageDialog(null,"删除成功");
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "删除失败，系统错误");
				}
				
				
				
				/*
				 * Object name = table.getValueAt(rowIndex, 1);//获得姓名（第rowIndex行 第1列的值）
				 * System.out.println("姓名为:"+name);
				 * 
				 * Object phone = table.getValueAt(rowIndex, 2);//获得手机号（第rowIndex行 第1列的值）
				 * System.out.println("电话为:"+phone);
				 */
				
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
				
				Object name =  table.getValueAt(rowIndex, 2);//获得姓名（第rowIndex行 第1列的值）
				System.out.println("姓名为:"+name);
				
				Object sex =  table.getValueAt(rowIndex, 3);//获得手机号（第rowIndex行 第1列的值）
				System.out.println("性别:"+sex);
				
				
				//弹出一个对话框，把选中行的数据显示到对话框中
				UserEditDialog edit = new UserEditDialog(this);
				//给YdEditDialog中的文本框赋默认值
				edit.jtfName.setText(name+"");//把Object类型的变量，转换成字符串才可以做为参数传入到setText方法中  简的做法用变量名 +空字符串
				//调用文本框的setEditable方法设置文本框是否可编辑
				edit.jtfNumber.setEditable(false);
				edit.jtfNumber.setText(number+"");
				edit.jtfSex.setText(sex+"");
				
				//连接数据，删除数据库对应的数据，重新加载表格数据。。
			}
			
		}else if ("刷新".equals(buttonText)) {
			initTableData();
		}
		//获得表格中选中的行索引
		
		
		
		
	}

	
	JButton jbAdd = new JButton("添加");
	JButton jbUpdate = new JButton("修改");
	JButton jbDelete = new JButton("删除");
	JButton jbReLoad = new JButton("刷新");
	//表格的数据
	/*
	 * Object[][] rowData = new Object[][] { {"1","张三11","18007328601"},
	 * {"2","李四22","18007328601"}, {"3","王五33","18007328601"},
	 * {"4","赵六44","18007328601"}
	 * 
	 * };
	 */
	DefaultTableModel dtm = new DefaultTableModel();//表格模型对象
	JTable table   = new JTable(dtm);//将表格模型对象做为JTable的构造方法参数
	
	
	/**
	 * 查询数据，获得用户表的所有数据
	 */
	public void initTableData() {
		String sql = "select * from tbl_user";
		try {
			ResultSet rs =  JDBCUtil.query(sql);
			
			Vector rowData = new Vector();//此Vector对象用于存储while循环中产生的Vector对象
			
			while(rs.next()) {
				String  id = rs.getString("id");
				String  loginName = rs.getString("loginName");
				String  name = rs.getString("name");
				String  sex = rs.getString("sex");
				String  regDate = rs.getString("regDate");
				
				Vector v = new Vector();//每循环一次，将一行数据存到Vector对象中
				v.add(id);
				v.add(loginName);
				v.add(name);
				v.add(sex);
				v.add(regDate);
				
				rowData.add(v);//把Vector所表示的一行数据，又存储到Vector中，形成二维数组
			}
			Vector columnNames = new Vector();
			columnNames.add("编号");
			columnNames.add("登录名");
			columnNames.add("姓名");
			columnNames.add("性别");
			columnNames.add("注册日期");
			
			dtm.setDataVector(rowData, columnNames);//重要:给DefaultTableModel赋值，就可以将参数数据显示在表格中
			
			
			
			//构造表格对象 
			//调用DefaultTable的setDataVector()方法修改表格数据
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}
	
	
	
	
	//列标题					
   // Object[] columnNames = new Object[] {"编号","姓名","联系电话"};
	
	
	
	
	public UserManagerDialog() {
		super.setTitle("用户管理");
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
		jpNorth.add(jbReLoad);
		
		
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
		jbReLoad.addActionListener(this);
		//实始化表格数据，从数据库中加载数据
		initTableData();
	}



	
}
