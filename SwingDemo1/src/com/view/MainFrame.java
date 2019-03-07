package com.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String btnText = e.getActionCommand();
		
		if ("�û�����".equals(btnText)) {
			///�����û��������
			UserManagerDialog ud = new UserManagerDialog();
		}else if ("Ԥ������".equals(btnText)) {
			//���Ԥ������ť������YdManagerDialog����
			YdManagerDialog yd = new YdManagerDialog();
		}
	
	}
	
	
	JButton jbGKKD = new JButton("�˿Ϳ���");
	JButton jbYDGL = new JButton("Ԥ������");
	JButton jbBKJZ = new JButton("���ͽ���");

	JButton jbYHGL = new JButton("�û�����");
	
	JButton jbCenter = new JButton("��ʱ�����м䲿�ֵİ�ť");
	
	public MainFrame() {
		super.setTitle("XXXX����ϵͳ");
		//�����ʾ����
		super.setSize(800, 300);
		super.setExtendedState(JFrame.MAXIMIZED_BOTH);//�����ʾ����
		
		//�õ�JFrame���м�����
		Container container =   super.getContentPane();
		//����container��add�Ϳ�����������ǰ���ǽ������������,���������JButton,JTextField...��
		//container��Ĭ�ϲ��ֹ�����BorderLayout(�߽粼��)���������Ϊ�����ϱ����������
		
		//�����м�����:JPanel,�����(��ť)�ӵ�Jpanel��
		JPanel jpNorth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jpNorth.add(jbGKKD);
		jpNorth.add(jbYDGL);
		jpNorth.add(jbBKJZ);
		jpNorth.add(jbYHGL);
		
		
		//�����м�������ӵ�container��
		container.add(jpNorth,BorderLayout.NORTH);
		container.add(jbCenter,BorderLayout.CENTER);
	
		
		super.setVisible(true);
		
		//ע�������
		jbYDGL.addActionListener(this);
		jbYHGL.addActionListener(this);
	}


}
