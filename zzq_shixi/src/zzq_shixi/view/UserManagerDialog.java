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
		if("���".equals(button_text)){
			
			UserAddDialog user_add_dialog = new UserAddDialog(this);
			//String id = UUID.randomUUID().toString().replace("-", "");//���ɲ��ظ���id
			
		}else if("�޸�".equals(button_text)){
			
			int row_index = jtable.getSelectedRow();
			System.out.println("ѡ����Ϊ:"+row_index);
			if(row_index == -1) {
				JOptionPane.showMessageDialog(null, "��ѡ����Ҫ�޸ĵ���");
			}
			else {
				UserChangeDialog change_dialog = new  UserChangeDialog(this);
				change_dialog.jtf_id.setText(jtable.getValueAt(row_index, 0)+" ");
				change_dialog.jtf_name.setText(jtable.getValueAt(row_index, 2)+" ");
				change_dialog.jtf_sex.setText(jtable.getValueAt(row_index, 3)+" ");
			}
			
		}else if("ɾ��".equals(button_text)){
			int row_index = jtable.getSelectedColumn();
			System.out.println("ѡ����Ϊ:"+row_index);
			if(row_index == -1) {
				JOptionPane.showMessageDialog(null, "��ѡ����Ҫɾ������");
			}
			else {
				String id = (String) jtable.getValueAt(row_index, 0);//ȡ��ɾ���û��ı��
				String sql = "delete from tbl_user where id='"+id+"'";
				
				try {
					int res = JDBCUtil.Change(sql);
					dtm.removeRow(row_index);
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ����Ժ�����");
				}
			}
		}else if("ˢ��".equals(button_text)){
				InitTable();
			
		}
	}
	
	JButton jb_add = new JButton("���");
	JButton jb_change = new JButton("�޸�");
	JButton jb_delete = new JButton("ɾ��");
	JButton jb_refresh = new JButton("ˢ��");
	
	DefaultTableModel dtm = new DefaultTableModel();
	JTable jtable= new JTable(dtm);
	
	public void InitTable()  {
		try {
		String sql = "select * from tbl_user";
		Vector data;
		data = JDBCUtil.QueryReturnVector(sql);
		Vector column_name = new Vector();
		column_name.add("���");
		column_name.add("��¼��");
		column_name.add("����");
		column_name.add("�Ա�");
		column_name.add("ע������");
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
