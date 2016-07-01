import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PersonalFrame extends JFrame implements CheckString{//个人信息界面
	
	private JLabel usernameLabel,balanceLabel,idLabel,chargeLabel,tipLabel;
	private JLabel username,balance,id;
	private JPanel p1,p2,p3,p4,p5;
	private Container container;
	private Box box;
	private JButton chargeButton;
	private JTextField charge;
	private String name;


	public PersonalFrame(String user) {
		// TODO Auto-generated constructor stub
		super("个人信息");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);//界面大小不可改变
		
		this.name=user;

		container =getContentPane();
		box=new Box(BoxLayout.Y_AXIS);
		container.add(box);
		
	    usernameLabel=new JLabel("用户名： ");
	    balanceLabel=new JLabel("余额： ");
	    idLabel=new JLabel("身份证号： ");
	    chargeLabel=new JLabel("充值金额： ");
	    tipLabel=new JLabel("输入正整数金额充值");
	    tipLabel.setForeground(Color.red);
	    tipLabel.setHorizontalAlignment(JLabel.CENTER);
		
	    username=new JLabel("233");
	    balance=new JLabel("233");
	    id=new JLabel("233");
	    charge=new JTextField(15);
	    
	    p1=new JPanel();
	    p2=new JPanel();
	    p3=new JPanel();
	    p4=new JPanel();
	    p5=new JPanel();
	    
	    chargeButton=new JButton("充值");
	    chargeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String t=charge.getText();
				String s=checkS(t);
				System.err.println(s);
				if(!s.equals("")&&s!=null){
					if(Integer.parseInt(s) <= 0) {
						System.err.println("number <= 0");
						return ;
					}
					String sql="update account "+ "set balance = balance + " 
					           + s + " "+ "where account_name = '" 
							   +name+ "'; ";
					DataBase db=new DataBase();
					int flag=db.update(sql);
					if(flag!=0){
						t=Integer.parseInt(s)+Integer.parseInt(s)+"";
						balance.setText(t);
					}else{
						tipLabel.setText("充值失败，请输入正整数");
					}
				}else {
					tipLabel.setText("充值失败，请输入正整数");
				}
			}
		});
	    
	    p1.add(usernameLabel);
	    p1.add(username);
	    p2.add(balanceLabel);
	    p2.add(balance);
	    p3.add(idLabel);
	    p3.add(id);
	    p5.add(chargeLabel);
	    p5.add(charge);
	    p4.add(tipLabel);
	    
	    
	    box.add(p4);
	    box.add(p1);
	    box.add(p2);
	    box.add(p3);
	    box.add(p5);
	    box.add(chargeButton);
	    

	   // pack();
	    setSize(300,300);
	    setLocationRelativeTo(null);//使界面始终位于屏幕中央
	    setVisible(true);
	}
	

	@Override
	public String checkS(String s) {
		// TODO Auto-generated method stub
	    return s.replaceAll(".*([';]+|(--)+).*", " ").trim();
	}

	
}
