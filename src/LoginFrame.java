import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class LoginFrame extends JFrame implements CheckString{//登陆界面
   
	
	private Image background;
	
	static final String driver="com.mysql.jdbc.Driver";
    static final String url="jdbc:mysql://localhost:3306/foo";
    
    private String username="root";
	private String pwd="victoria";
	
	private JLabel backLabel,userLabel,pwdLabel;
	private JPanel centerPanel,loginPanel;
	private JButton loginButton,signButton;
	private JTextField userText;
	private JPasswordField pwdText;
	
	public LoginFrame() {
		// TODO Auto-generated constructor stub
		super("Welcome!");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);//界面大小不可改变
		
		try {
			background=ImageIO.read(new File("background.png"));
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("nani  ");
		}
		backLabel=new JLabel(new ImageIcon(background));
		add(backLabel,BorderLayout.WEST);
		
		
		userLabel=new JLabel("用户名：   ");
		pwdLabel=new JLabel("密码：        ");
		loginButton=new JButton(" 登录 ");
		signButton=new JButton(" 注册 ");
		userText=new JTextField(10);
		pwdText=new JPasswordField(10);
	    
		signButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SignFrame signFrame=new SignFrame();//点击注册按钮进入注册界面进行注册
				setVisible(false);
				dispose();
			}
		});
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DataBase db=new DataBase(driver, url, username, pwd);
				String user=checkS(userText.getText());
				String pwd2=checkS(pwdText.getPassword().toString());
				String sql="select * "+ "from account "
						   + "where account_name = '" + user 
						   +"' and account_password = '" + pwd2 +"'; ";
				db.query(sql);
			}
		});
		
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
		setLocationRelativeTo(null);
		setVisible(true);
		
		
	}
	
	@Override
		public String checkS(String s) {
			// TODO Auto-generated method stub
		    return s.replaceAll(".*([';]+|(--)+).*", " ").trim();
		}
	
	
}
