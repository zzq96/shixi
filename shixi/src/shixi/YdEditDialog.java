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

/**
 * Ԥ������Ի���
 * @author Administrator
 *
 */
public class YdEditDialog extends JDialog  implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//�¼��������д�ڴ˴�����
		System.out.println("����˰�ť");
		//�õ��ı��е��û���:����JtextFiled��getText()����
		String userName =  jtfNumber.getText();
		System.out.println("�û���Ϊ:"+userName);
		String pwd = jtfName.getText();
		System.out.println("����Ϊ:"+pwd);
		//��������û�Ϊadmin,����Ϊ123456������Ϊ��¼�ɹ�
		if ("admin".equals(userName) && "123456".contentEquals(pwd)) {
			System.out.println("�û���������ȷ");
			//�رյ�ǰ��¼����(����dispolse()����)������һ�µĴ���
			super.dispose();
			//�����´���
			MainFrame mf = new MainFrame();//�����½���
		}else {
			JOptionPane.showMessageDialog(null, "�û������������");//����ȷ�϶Ի���
		}
	}
	
	JButton jbOK = new JButton("ȷ��");//��ʾ����һ����ť����
	JLabel jlbNumber = new JLabel("���:");
	JTextField jtfNumber = new JTextField();	
	
	JLabel jlbName = new JLabel("����:");
	JTextField jtfName = new JTextField();
	
	JLabel jlbPhone = new JLabel("�ֻ���");
	JTextField jtfPhone = new JTextField();
	
	
	public YdEditDialog() {//���췽��
		//����JFrame���ṩ�ķ������ô�������
		//����ʹ��super.��ʽ����
		super.setSize(400, 300);//����400*300�Ĵ���
		super.setTitle("�޸�Ԥ����Ϣ");
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
		
		jlbPhone.setBounds(20, 130, 80, 40);
		jtfPhone.setBounds(100, 130, 220, 40);
		
		//��������뵽������
		container.add(jbOK);
		container.add(jlbNumber);
		container.add(jtfNumber);
		container.add(jlbName);
		container.add(jtfName);	
		container.add(jlbPhone);
		container.add(jtfPhone);
		super.setVisible(true);//���ô���ɼ�
		
		//�����ע�������
		jbOK.addActionListener(this);
	}


	
}
