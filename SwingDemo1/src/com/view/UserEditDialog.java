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
 * �û�������
 * @author Administrator
 *
 */
public class UserEditDialog extends JDialog  implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//�¼��������д�ڴ˴�����
		System.out.println("����˰�ť");
		//�õ��ı��е��û���:����JtextFiled��getText()����
		String id =  jtfNumber.getText();//��ñ��
		String name = jtfName.getText();//����
		String sex = jtfSex.getText();//�Ա�
		String sql = "update tbl_user set name='"+name+"' ,sex='"+sex+"' where id='"+id+"' ";
		try {
			int res = JDBCUtil.inserOrUpdateOrDelete(sql);
			userManagerDialog.initTableData();
			JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
			this.dispose();//�رյ�ǰ�Ľ���
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�ϵͳ����");
		}
		
		
	}
	
	JButton jbOK = new JButton("ȷ��");//��ʾ����һ����ť����
	JLabel jlbNumber = new JLabel("���:");
	JTextField jtfNumber = new JTextField();	
	
	JLabel jlbName = new JLabel("����:");
	JTextField jtfName = new JTextField();
	
	JLabel jlbSex = new JLabel("�Ա�");
	JTextField jtfSex = new JTextField();
	
	
	UserManagerDialog userManagerDialog ;
	
	public UserEditDialog(UserManagerDialog umd ) {//���췽��.��ʾ����UserEditDialog�����ʱ�����贫��һ��UserManagerDialog����
		this.userManagerDialog = umd;//�Ѳ���������Ա������Ŀ���������������п������øò���
		//����JFrame���ṩ�ķ������ô�������
		//����ʹ��super.��ʽ����
		super.setSize(400, 300);//����400*300�Ĵ���
		super.setTitle("�޸��û���Ϣ");
		//super.setLocation(600, 300);//���ô����������Ļ���Ͻǵ�ƫ����
		super.setLocationRelativeTo(null);//���������ʾ
		
		//super.setResizable(false);//������ı䴰��
		//JFrame�Ƕ�������,��ö����������õ��м������������м�����������
		Container container =   super.getContentPane();
		//����container��add�Ϳ�����������ǰ���ǽ������������,���������JButton,JTextField...��
		//container��Ĭ�ϲ��ֹ�����BorderLayout(�߽粼��)���������Ϊ�����ϱ����������
		//���Խ�container�Ĳ��ֹ���������Ϊ�ղ���(����setLayOut(null)),������������setBounds(int x ,int y,int widht,int height)������������ڷ��ڽ�����ĸ�λ��
		container.setLayout(null);
		jbOK.setBounds(250,200,120,40);//�����λ�ü���С
		
		jlbNumber.setBounds(20, 30, 80, 40);
		jtfNumber.setBounds(100, 30, 220, 40);
		
		jlbName.setBounds(20, 80, 80, 40);
		jtfName.setBounds(100, 80, 220, 40);
		
		jlbSex.setBounds(20, 130, 80, 40);
		jtfSex.setBounds(100, 130, 220, 40);
		
		//��������뵽������
		container.add(jbOK);
		container.add(jlbNumber);
		container.add(jtfNumber);
		container.add(jlbName);
		container.add(jtfName);	
		container.add(jlbSex);
		container.add(jtfSex);
		super.setVisible(true);//���ô���ɼ�
		
		//�����ע�������
		jbOK.addActionListener(this);
	}


	
}
