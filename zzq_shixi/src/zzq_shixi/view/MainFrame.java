package zzq_shixi.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String button_text=e.getActionCommand();
		System.out.println(button_text);
		if("Ԥ������".equals(button_text))
		{
			YdManagerDialog yd_manager_dialog=new YdManagerDialog();
		}
	}
	
	JButton jb_gkkd = new JButton("�˿Ϳ���");
	JButton jb_ydgl = new JButton("Ԥ������");
	JButton jb_bkjz = new JButton("���ͽ���");
	JButton jb_center = new JButton("��ʱ�����м䲿�ֵİ�ť");
	
	public MainFrame ()
	{
		super.setTitle("XXXX����ϵͳ");
		super.setSize(800, 300);
		super.setLocationRelativeTo(null);
		super.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		Container container =  this.getContentPane();
		
		JPanel jp_north=new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		jp_north.add(jb_gkkd);
		jp_north.add(jb_ydgl);
		jp_north.add(jb_bkjz);
		//jp_north.add(jb_center);
		
		container.add(jp_north,BorderLayout.NORTH);
		container.add(jb_center, BorderLayout.CENTER);
		
		jb_gkkd.addActionListener(this);
		jb_ydgl.addActionListener(this);
		jb_bkjz.addActionListener(this);
		
		this.setVisible(true);
	}

}
