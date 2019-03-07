package zzq_shixi.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class  YdManagerDialog extends JDialog  implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String button_text = e.getActionCommand();
		System.out.println(button_text);
		// TODO Auto-generated method stub
		if("添加".equals(button_text)){
			
		}else if("修改".equals(button_text)){
			int row_index = jtable.getSelectedRow();
			System.out.println("选中行为:"+row_index);
			if(row_index == -1) {
				JOptionPane.showMessageDialog(null, "请选中需要修改的行");
			}
			else {
				YdChangeDialog change_dialog = new  YdChangeDialog();
				change_dialog.jtf_number.setText(jtable.getValueAt(row_index, 0)+" ");
				change_dialog.jtf_name.setText(jtable.getValueAt(row_index, 1)+" ");
				change_dialog.jtf_phone.setText(jtable.getValueAt(row_index, 2)+" ");
			}
			
		}else if("删除".equals(button_text)){
			
		}
	}
	
	JButton jb_add = new JButton("添加");
	JButton jb_change = new JButton("修改");
	JButton jb_delete = new JButton("删除");
	
	Object[][] row_data = new Object[][] {
		{"1","张三","11111"},
		{"2","李四","1111111"},
		{"3","王五","21321"},
	};
	
	Object[] column_name = new Object[] {"编号","姓名","联系方式"};
	JTable jtable= new JTable(row_data, column_name);
	
	public YdManagerDialog() {
		super.setSize(600,600);
		super.setLocationRelativeTo(null);
		this.setVisible(true);
		
		Container container = this.getContentPane();
		JPanel jp_north = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp_north.add(jb_add);
		jp_north.add(jb_change);
		jp_north.add(jb_delete);
		
		container.add(jp_north, BorderLayout.NORTH);
		
		JScrollPane jsp = new JScrollPane(jtable);
		container.add(jsp, BorderLayout.CENTER);
		jb_add.addActionListener(this);
		jb_change.addActionListener(this);
		jb_delete.addActionListener(this);
		
	}

}
