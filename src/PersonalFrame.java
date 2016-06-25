import java.awt.BorderLayout;
import java.awt.Container;
import java.io.BufferedWriter;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PersonalFrame extends JFrame{
	
	private JLabel usernameLabel,balanceLabel,idLabel;
	private JLabel username,balance,id;
	private JPanel p1,p2,p3,p4;
	private Container container;
	private Box box;

	public PersonalFrame() {
		// TODO Auto-generated constructor stub
		super("个人信息");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		container =getContentPane();
		box=new Box(BoxLayout.Y_AXIS);
		container.add(box);
		
	    usernameLabel=new JLabel("用户名： ");
	    balanceLabel=new JLabel("余额： ");
	    idLabel=new JLabel("身份证号： ");
		
	    username=new JLabel("233");
	    balance=new JLabel("233");
	    id=new JLabel("233");
	    
	    p1=new JPanel();
	    p2=new JPanel();
	    p3=new JPanel();
	    p4=new JPanel();
	    
	    p1.add(usernameLabel);
	    p1.add(username);
	    p2.add(balanceLabel);
	    p2.add(balance);
	    p3.add(idLabel);
	    p3.add(id);
	    p4.add(new JLabel());
	    
	    box.add(p4);
	    box.add(p1);
	    box.add(p2);
	    box.add(p3);
	    

	   // pack();
	    setSize(300,300);
	    setVisible(true);
	}
	
}
