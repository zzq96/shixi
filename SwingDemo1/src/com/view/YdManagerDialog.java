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
 * Ԥ���������
 * @author Administrator
 *
 */
public class YdManagerDialog extends JDialog implements ActionListener {
	
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
				
				Object name =  table.getValueAt(rowIndex, 1);//�����������rowIndex�� ��1�е�ֵ��
				System.out.println("����Ϊ:"+name);
				
				Object phone =  table.getValueAt(rowIndex, 2);//����ֻ��ţ���rowIndex�� ��1�е�ֵ��
				System.out.println("�绰Ϊ:"+phone);
				
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
				
				Object name =  table.getValueAt(rowIndex, 1);//�����������rowIndex�� ��1�е�ֵ��
				System.out.println("����Ϊ:"+name);
				
				Object phone =  table.getValueAt(rowIndex, 2);//����ֻ��ţ���rowIndex�� ��1�е�ֵ��
				System.out.println("�绰Ϊ:"+phone);
				
				
				//����һ���Ի��򣬰�ѡ���е�������ʾ���Ի�����
				YdEditDialog edit = new YdEditDialog();
				//��YdEditDialog�е��ı���Ĭ��ֵ
				edit.jtfName.setText(name+"");//��Object���͵ı�����ת�����ַ����ſ�����Ϊ�������뵽setText������  ��������ñ����� +���ַ���
				edit.jtfNumber.setText(number+"");
				edit.jtfPhone.setText(phone+"");
				
				//�������ݣ�ɾ�����ݿ��Ӧ�����ݣ����¼��ر�����ݡ���
			}
			
			
			
			
			
		}
		//��ñ����ѡ�е�������
		
		
		
		
	}

	
	JButton jbAdd = new JButton("���");
	JButton jbUpdate = new JButton("�޸�");
	JButton jbDelete = new JButton("ɾ��");
	
	//��������
	Object[][] rowData = new Object[][] {
										{"1","����","18007328601"},
										{"2","����","18007328601"},
										{"3","����","18007328601"},
										{"4","����","18007328601"}
										
										};
	//�б���					
    Object[] columnNames = new Object[] {"���","����","��ϵ�绰"};
	JTable table = new JTable(rowData, columnNames);
	
	
	
	public YdManagerDialog() {
		super.setTitle("Ԥ������");
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
	}



	
}
