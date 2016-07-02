package com.victoria.Frame;

import com.victoria.Interface.*;
import com.victoria.mysql.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
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
	
	private JLabel backLabel,userLabel,pwdLabel,tipLabel;
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
			System.err.println("can't load the backgroud image");
		}
		backLabel=new JLabel(new ImageIcon(background));
		add(backLabel,BorderLayout.WEST);
		
		
		userLabel=new JLabel("用户名：   ");
		pwdLabel=new JLabel("密码：        ");
		tipLabel=new JLabel("欢迎使用");
		loginButton=new JButton(" 登录 ");
		signButton=new JButton(" 注册 ");
		userText=new JTextField(10);
		pwdText=new JPasswordField(10);
	    
		signButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SignFrame signFrame=new SignFrame();//点击注册按钮进入注册界面进行注册
			}
		});
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DataBase db=new DataBase();
				String alias=checkS(userText.getText());
				String pwd2=checkS(new String(pwdText.getPassword()));
				System.err.println(alias+"|"+pwd2);
				SQL sql=new SQL();
				sql.select("*","passenger","passenger_alias = '" + alias +"' and passenger_password = '" + pwd2 +"'");
				System.err.println(sql.toString());
				ArrayList<ArrayList<String>> res=db.query(sql.toString());
				for(ArrayList<String> tmp:res)
				{
					System.err.println(tmp.toString());
				}
				if(res!=null){
					if(res.size()==1){
						String user=res.get(0).get(0);
						BookingFrame bookingFrame=new BookingFrame(user); 
		                setVisible(false);
		                dispose();
					}else {
						tipLabel.setText("请输入正确的用户名和密码");
					}
				}else{
					tipLabel.setText("请输入正确的用户名和密码");
				}
			}
		});
		
		centerPanel=new JPanel();
		centerPanel.setLayout(new GridLayout(3, 1));
		JPanel p1,p2,p3,p4;
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p1.add(userLabel);
		p1.add(userText);
		p2.add(pwdLabel);
		p2.add(pwdText);
		p3.add(loginButton);
		p3.add(signButton);
		p4.setLayout(new BorderLayout());
		tipLabel.setForeground(Color.red);
		tipLabel.setHorizontalAlignment(JLabel.CENTER);
		p4.add(tipLabel,BorderLayout.CENTER);
		p4.add(new JLabel("                  Powered By RUC"), BorderLayout.SOUTH);
		centerPanel.add(p1);
		centerPanel.add(p2);
		centerPanel.add(p3);
		loginPanel=new JPanel();
		loginPanel.setLayout(new BorderLayout());
		loginPanel.add(centerPanel,BorderLayout.NORTH);
		loginPanel.add(p4);
		
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
