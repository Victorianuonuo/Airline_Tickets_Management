import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignFrame extends JFrame implements CheckString{//注册界面
	
	private Container container;
	private Box box;
	private JTextField userField,idField,aliasField;
	private JPasswordField pwdField,pwdField2;
	private JLabel userLabel,pwdLabel,pwdLabel2,idLabel,tipLabel,aliasLable;
	private JPanel p1,p2,p3,p4,p5,p6;
	private JButton submitButton;
	
	static final String driver="com.mysql.jdbc.Driver";
    static final String url="jdbc:mysql://localhost:3306/foo";
    
    private String username="root";
	private String pwd="victoria";

	public SignFrame() {
		// TODO Auto-generated constructor stub
		super("注册");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		container =getContentPane();
		box=new Box(BoxLayout.Y_AXIS);
		container.add(box);
		
		userField=new JTextField(20);
		pwdField=new JPasswordField(20);
		pwdField2=new JPasswordField(20);
		idField=new JTextField(20);
		aliasField=new JTextField(20);
		aliasLable=new JLabel("登陆账号： ");
		userLabel=new  JLabel("用户名：      ");
		pwdLabel=new   JLabel("密码：           ");
		pwdLabel2=new  JLabel("确认密码： ");
		idLabel=new    JLabel("身份证号： ");
		tipLabel=new JLabel("");
		tipLabel.setHorizontalAlignment(JLabel.CENTER);
		tipLabel.setForeground(Color.RED);
		submitButton=new JButton("    提交   ");
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String t1=userField.getText().trim();
				String t2=pwdField.getPassword().toString().trim();
				String t3=pwdField2.getPassword().toString().trim();
				String t4=idField.getText().trim();
				String t5=aliasField.getText().trim();
				String user_check=checkS(t1);
				String pwd_check=checkS(t2);
				String pwd2_check=checkS(t3);
				String id_check=checkS(t4);
				String alias_check=checkS(t5);
				if(!pwd_check.equals(pwd2_check)||!t2.equals(t3)||id_check.length()!=18){
					if(id_check.length()==18)
					tipLabel.setText("两次密码不一致！");
					else {
						tipLabel.setText("身份证号必须18位！");
					}
				}else{	
					SQL sql=new SQL();
					sql.insert("passenger(passenger_id, passenger_alias, passenger_password, passenger_name)",
						"values ( '" + id_check +"', '" + alias_check + "', '" + pwd_check +"', '" + user_check + "')");
					DataBase db=new DataBase();
					int col=db.update(sql.toString());
					if(col!=0){
						tipLabel.setText("注册成功！");
					}else{
						tipLabel.setText("登陆账号已存在，请重新输入登陆账号或直接登录");
					}
				}
			}
		});
		p6=new JPanel();
	    p6.add(aliasLable);
	    p6.add(aliasField);
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
		box.add(p6);
		box.add(p1);
		box.add(p2);
		box.add(p3);
		box.add(p4);
		box.add(p5);
		
		setSize(500, 300);
		setResizable(false);//界面大小不可改变
		//pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	@Override
	public String checkS(String s) {
		// TODO Auto-generated method stub
	    return s.replaceAll(".*([';]+|(--)+).*", " ").trim();
	}

	
}
