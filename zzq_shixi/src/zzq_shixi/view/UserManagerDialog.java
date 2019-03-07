package zzq_shixi.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import zzq_shixi.util.JDBCUtil;

public class  UserManagerDialog extends JDialog  implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String button_text = e.getActionCommand();
		System.out.println(button_text);
		if("添加".equals(button_text)){
			
			UserAddDialog user_add_dialog = new UserAddDialog(this);
			//String id = UUID.randomUUID().toString().replace("-", "");//生成不重复的id
			
		}else if("修改".equals(button_text)){
			
			int row_index = jtable.getSelectedRow();
			System.out.println("选中行为:"+row_index);
			if(row_index == -1) {
				JOptionPane.showMessageDialog(null, "请选中需要修改的行");
			}
			else {
				UserChangeDialog change_dialog = new  UserChangeDialog(this);
				change_dialog.jtf_id.setText(jtable.getValueAt(row_index, 0)+" ");
				change_dialog.jtf_name.setText(jtable.getValueAt(row_index, 2)+" ");
				change_dialog.jtf_sex.setText(jtable.getValueAt(row_index, 3)+" ");
			}
			
		}else if("删除".equals(button_text)){
			int row_index = jtable.getSelectedColumn();
			System.out.println("选中行为:"+row_index);
			if(row_index == -1) {
				JOptionPane.showMessageDialog(null, "请选中需要删除的行");
			}
			else {
				String id = (String) jtable.getValueAt(row_index, 0);//取得删除用户的编号
				String sql = "delete from tbl_user where id='"+id+"'";
				
				try {
					int res = JDBCUtil.Change(sql);
					dtm.removeRow(row_index);
					JOptionPane.showMessageDialog(null, "删除成功");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "删除失败，请稍后再试");
				}
			}
		}else if("刷新".equals(button_text)){
				InitTable();
			
		}
	}
	
	JButton jb_add = new JButton("添加");
	JButton jb_change = new JButton("修改");
	JButton jb_delete = new JButton("删除");
	JButton jb_refresh = new JButton("刷新");
	
	DefaultTableModel dtm = new DefaultTableModel();
	JTable jtable= new JTable(dtm);
	
	public void InitTable()  {
		try {
		String sql = "select * from tbl_user";
		Vector data;
		data = JDBCUtil.QueryReturnVector(sql);
		Vector column_name = new Vector();
		column_name.add("编号");
		column_name.add("登录名");
		column_name.add("姓名");
		column_name.add("性别");
		column_name.add("注册日期");
		dtm.setDataVector(data, column_name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public UserManagerDialog() throws Exception {
		super.setSize(600,600);
		super.setLocationRelativeTo(null);
		this.setVisible(true);
		
		Container container = this.getContentPane();
		JPanel jp_north = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp_north.add(jb_add);
		jp_north.add(jb_change);
		jp_north.add(jb_delete);
		jp_north.add(jb_refresh);
		
		container.add(jp_north, BorderLayout.NORTH);
		JScrollPane jsp = new JScrollPane(jtable);
		container.add(jsp, BorderLayout.CENTER);
		jb_add.addActionListener(this);
		jb_change.addActionListener(this);
		jb_delete.addActionListener(this);
		jb_refresh.addActionListener(this);
		InitTable();
		
	}

}
