import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame{
   
	
	private Image background;
	
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost:3306/JDBC_SC";
    
    private String username;
	private String pwd;
	static Connection connection=null;
	
	private JLabel backLabel,userLabel,pwdLabel;
	private JPanel centerPanel,loginPanel;
	private JButton loginButton,signButton;
	private JTextField userText;
	private JPasswordField pwdText;
	
	public LoginFrame() {
		// TODO Auto-generated constructor stub
		super("Welcome!");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		try {
			background=ImageIO.read(new File("background.png"));
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("nani  ");
		}
		backLabel=new JLabel(new ImageIcon(background));
		add(backLabel,BorderLayout.WEST);
		
		
		userLabel=new JLabel("ÓÃ»§Ãû£º   ");
		pwdLabel=new JLabel("ÃÜÂë£º        ");
		loginButton=new JButton(" µÇÂ¼ ");
		signButton=new JButton(" ×¢²á ");
		userText=new JTextField(10);
		pwdText=new JPasswordField(10);
	    
		
		centerPanel=new JPanel();
		centerPanel.setLayout(new GridLayout(3, 1));
		JPanel p1,p2,p3;
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p1.add(userLabel);
		p1.add(userText);
		p2.add(pwdLabel);
		p2.add(pwdText);
		p3.add(loginButton);
		p3.add(signButton);
		centerPanel.add(p1);
		centerPanel.add(p2);
		centerPanel.add(p3);
		loginPanel=new JPanel();
		loginPanel.setLayout(new BorderLayout());
		loginPanel.add(centerPanel,BorderLayout.NORTH);
		loginPanel.add(new JLabel("                  Powered By RUC"), BorderLayout.SOUTH);
		
		add(loginPanel,BorderLayout.EAST);
		pack();
		setVisible(true);
		
		
	}
	
	
	
	
}
