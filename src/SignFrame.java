import java.awt.Container;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignFrame extends JFrame{
	
	private Container container;
	private Box box;
	private JTextField userField,idField;
	private JPasswordField pwdField,pwdField2;
	private JLabel userLabel,pwdLabel,pwdLabel2,idLabel,tipLabel;
	private JPanel p1,p2,p3,p4,p5;
	private JButton submitButton;

	public SignFrame() {
		// TODO Auto-generated constructor stub
		super("注册");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		container =getContentPane();
		box=new Box(BoxLayout.Y_AXIS);
		container.add(box);
		
		userField=new JTextField(20);
		pwdField=new JPasswordField(20);
		pwdField2=new JPasswordField(20);
		idField=new JTextField(20);
		userLabel=new JLabel("用户名：      ");
		pwdLabel=new  JLabel("密码：           ");
		pwdLabel2=new JLabel("确认密码： ");
		idLabel=new   JLabel("身份证号： ");
		tipLabel=new JLabel("          ");
		submitButton=new JButton("    提交   ");
		
		p1=new JPanel();
		p1.add(userLabel);
		p1.add(userField);
		p2=new JPanel();
		p2.add(pwdLabel);
		p2.add(pwdField);
		p3=new JPanel();
		p3.add(pwdLabel2);
		p3.add(pwdField2);
		p4=new JPanel();
		p4.add(idLabel);
		p4.add(idField);
		p5=new JPanel();
		p5.add(tipLabel);
		p5.add(submitButton);
		box.add(p1);
		box.add(p2);
		box.add(p3);
		box.add(p4);
		box.add(p5);
		
		setSize(500, 300);
		//pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	
}
