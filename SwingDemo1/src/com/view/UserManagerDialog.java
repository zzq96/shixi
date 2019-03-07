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
 * �û��������
 * @author Administrator
 *
 */
public class UserManagerDialog extends JDialog implements ActionListener {
	
	@Override
	//����ActionEvent e �����¼����󣬿���ͨ���ö������¼�Դ����Ϣ
	//	 ͨ������e.getActionCommand()�������Ի�ð�ť�ϵ��ı���Ϣ(ɾ�����޸�)
	public void actionPerformed(ActionEvent e) {
		
		String buttonText = e.getActionCommand();
		System.out.println("����İ�ťΪ:"+buttonText);
		
		if ("ɾ��".contentEquals(buttonText)) {//��ʾ�����ɾ����ť��ִ��ɾ����Ӧ��ҵ���߼�
			int rowIndex = table.getSelectedRow();
			System.out.println("ѡ�е�������Ϊ:"+rowIndex);
			if (rowIndex==-1) {
				JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ��������");
			}else {
				
				
				
				Object number =  table.getValueAt(rowIndex, 0);//��ñ�ţ���rowIndex�� ��1�е�ֵ��
				System.out.println("���Ϊ:"+number);
				String sql = "delete from tbl_user where id='"+number+"'";
				
				try {
					int res = JDBCUtil.inserOrUpdateOrDelete(sql);
					
					if(res>0) {//���ݿ�������ɾ���󣬰ѱ���еĶ�Ӧ�����ݴӽ������Ƴ�
						dtm.removeRow(rowIndex);//�Ƴ�����е�ĳһ��
						//initTableData();
					}
					JOptionPane.showMessageDialog(null,"ɾ���ɹ�");
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�ϵͳ����");
				}
				
				
				
				/*
				 * Object name = table.getValueAt(rowIndex, 1);//�����������rowIndex�� ��1�е�ֵ��
				 * System.out.println("����Ϊ:"+name);
				 * 
				 * Object phone = table.getValueAt(rowIndex, 2);//����ֻ��ţ���rowIndex�� ��1�е�ֵ��
				 * System.out.println("�绰Ϊ:"+phone);
				 */
				
				//�������ݣ�ɾ�����ݿ��Ӧ�����ݣ����¼��ر�����ݡ���
			}
			
			
		}else if ("�޸�".contentEquals(buttonText)) {//������޸�
			
			
			int rowIndex = table.getSelectedRow();
			System.out.println("ѡ�е�������Ϊ:"+rowIndex);
			if (rowIndex==-1) {
				JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵ�����");
			}else {
				
				Object number =  table.getValueAt(rowIndex, 0);//��ñ�ţ���rowIndex�� ��1�е�ֵ��
				System.out.println("���Ϊ:"+number);
				
				Object name =  table.getValueAt(rowIndex, 2);//�����������rowIndex�� ��1�е�ֵ��
				System.out.println("����Ϊ:"+name);
				
				Object sex =  table.getValueAt(rowIndex, 3);//����ֻ��ţ���rowIndex�� ��1�е�ֵ��
				System.out.println("�Ա�:"+sex);
				
				
				//����һ���Ի��򣬰�ѡ���е�������ʾ���Ի�����
				UserEditDialog edit = new UserEditDialog(this);
				//��YdEditDialog�е��ı���Ĭ��ֵ
				edit.jtfName.setText(name+"");//��Object���͵ı�����ת�����ַ����ſ�����Ϊ�������뵽setText������  ��������ñ����� +���ַ���
				//�����ı����setEditable���������ı����Ƿ�ɱ༭
				edit.jtfNumber.setEditable(false);
				edit.jtfNumber.setText(number+"");
				edit.jtfSex.setText(sex+"");
				
				//�������ݣ�ɾ�����ݿ��Ӧ�����ݣ����¼��ر�����ݡ���
			}
			
		}else if ("ˢ��".equals(buttonText)) {
			initTableData();
		}
		//��ñ����ѡ�е�������
		
		
		
		
	}

	
	JButton jbAdd = new JButton("���");
	JButton jbUpdate = new JButton("�޸�");
	JButton jbDelete = new JButton("ɾ��");
	JButton jbReLoad = new JButton("ˢ��");
	//��������
	/*
	 * Object[][] rowData = new Object[][] { {"1","����11","18007328601"},
	 * {"2","����22","18007328601"}, {"3","����33","18007328601"},
	 * {"4","����44","18007328601"}
	 * 
	 * };
	 */
	DefaultTableModel dtm = new DefaultTableModel();//���ģ�Ͷ���
	JTable table   = new JTable(dtm);//�����ģ�Ͷ�����ΪJTable�Ĺ��췽������
	
	
	/**
	 * ��ѯ���ݣ�����û������������
	 */
	public void initTableData() {
		String sql = "select * from tbl_user";
		try {
			ResultSet rs =  JDBCUtil.query(sql);
			
			Vector rowData = new Vector();//��Vector�������ڴ洢whileѭ���в�����Vector����
			
			while(rs.next()) {
				String  id = rs.getString("id");
				String  loginName = rs.getString("loginName");
				String  name = rs.getString("name");
				String  sex = rs.getString("sex");
				String  regDate = rs.getString("regDate");
				
				Vector v = new Vector();//ÿѭ��һ�Σ���һ�����ݴ浽Vector������
				v.add(id);
				v.add(loginName);
				v.add(name);
				v.add(sex);
				v.add(regDate);
				
				rowData.add(v);//��Vector����ʾ��һ�����ݣ��ִ洢��Vector�У��γɶ�ά����
			}
			Vector columnNames = new Vector();
			columnNames.add("���");
			columnNames.add("��¼��");
			columnNames.add("����");
			columnNames.add("�Ա�");
			columnNames.add("ע������");
			
			dtm.setDataVector(rowData, columnNames);//��Ҫ:��DefaultTableModel��ֵ���Ϳ��Խ�����������ʾ�ڱ����
			
			
			
			//��������� 
			//����DefaultTable��setDataVector()�����޸ı������
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}
	
	
	
	
	//�б���					
   // Object[] columnNames = new Object[] {"���","����","��ϵ�绰"};
	
	
	
	
	public UserManagerDialog() {
		super.setTitle("�û�����");
		//�����ʾ����
		super.setSize(600, 600);
		super.setLocationRelativeTo(null);
		
		
		//�õ�JFrame���м�����
		Container container =   super.getContentPane();
		//����container��add�Ϳ�����������ǰ���ǽ������������,���������JButton,JTextField...��
		//container��Ĭ�ϲ��ֹ�����BorderLayout(�߽粼��)���������Ϊ�����ϱ����������
		
		//�����м�����:JPanel,�����(��ť)�ӵ�Jpanel��
		JPanel jpNorth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jpNorth.add(jbAdd);
		jpNorth.add(jbUpdate);
		jpNorth.add(jbDelete);
		jpNorth.add(jbReLoad);
		
		
		//�����м�������ӵ�container��
		container.add(jpNorth,BorderLayout.NORTH);
		
		//����һ���������������  JScrollPane
		JScrollPane jsp = new JScrollPane(table);
		
		//�ѹ��������ӵ�container��
		container.add(jsp,BorderLayout.CENTER);
	
		
		super.setVisible(true);
		 
		//����ťע�������
		//�����ťע�ᵽͬһ���������ϣ���ťִ�еķ�����һ���������ڷ����������û�������ĸ���ť
		jbDelete.addActionListener(this);
		jbUpdate.addActionListener(this);
		jbReLoad.addActionListener(this);
		//ʵʼ��������ݣ������ݿ��м�������
		initTableData();
	}



	
}
