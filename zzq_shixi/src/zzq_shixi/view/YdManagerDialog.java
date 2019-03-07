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
		if("���".equals(button_text)){
			
		}else if("�޸�".equals(button_text)){
			int row_index = jtable.getSelectedRow();
			System.out.println("ѡ����Ϊ:"+row_index);
			if(row_index == -1) {
				JOptionPane.showMessageDialog(null, "��ѡ����Ҫ�޸ĵ���");
			}
			else {
				YdChangeDialog change_dialog = new  YdChangeDialog();
				change_dialog.jtf_number.setText(jtable.getValueAt(row_index, 0)+" ");
				change_dialog.jtf_name.setText(jtable.getValueAt(row_index, 1)+" ");
				change_dialog.jtf_phone.setText(jtable.getValueAt(row_index, 2)+" ");
			}
			
		}else if("ɾ��".equals(button_text)){
			
		}
	}
	
	JButton jb_add = new JButton("���");
	JButton jb_change = new JButton("�޸�");
	JButton jb_delete = new JButton("ɾ��");
	
	Object[][] row_data = new Object[][] {
		{"1","����","11111"},
		{"2","����","1111111"},
		{"3","����","21321"},
	};
	
	Object[] column_name = new Object[] {"���","����","��ϵ��ʽ"};
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
