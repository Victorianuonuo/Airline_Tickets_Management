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

public class SignFrame extends JFrame implements CheckString{//ע�����
	
	private Container container;
	private Box box;
	private JTextField userField,idField;
	private JPasswordField pwdField,pwdField2;
	private JLabel userLabel,pwdLabel,pwdLabel2,idLabel,tipLabel;
	private JPanel p1,p2,p3,p4,p5;
	private JButton submitButton;
	
	static final String driver="com.mysql.jdbc.Driver";
    static final String url="jdbc:mysql://localhost:3306/foo";
    
    private String username="root";
	private String pwd="victoria";

	public SignFrame() {
		// TODO Auto-generated constructor stub
		super("ע��");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		container =getContentPane();
		box=new Box(BoxLayout.Y_AXIS);
		container.add(box);
		
		userField=new JTextField(20);
		pwdField=new JPasswordField(20);
		pwdField2=new JPasswordField(20);
		idField=new JTextField(20);
		userLabel=new JLabel("�û�����      ");
		pwdLabel=new  JLabel("���룺           ");
		pwdLabel2=new JLabel("ȷ�����룺 ");
		idLabel=new   JLabel("���֤�ţ� ");
		tipLabel=new JLabel("");
		tipLabel.setHorizontalAlignment(JLabel.CENTER);
		tipLabel.setForeground(Color.RED);
		submitButton=new JButton("    �ύ   ");
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String t1=userField.getText().trim();
				String t2=pwdField.getPassword().toString().trim();
				String t3=pwdField2.getPassword().toString().trim();
				String t4=idField.getText().trim();
				String s1=checkS(t1);
				String s2=checkS(t2);
				String s3=checkS(t3);
				String s4=checkS(t4);
				if(!t2.equals(t3)||!s2.equals(s3)||s4.length()!=18){
					if(s4.length()==18)
					tipLabel.setText("�������벻һ�£�");
					else {
						tipLabel.setText("���֤�ű���18λ��");
					}
				}else{	
					DataBase db=new DataBase(driver, url,username,pwd);
					String sql="insert into account"+
					"(account_name, account_password, account_id, balance) "
							+ "values ( '" + s1 +"', '" + s2 + "', '" +s4 +"', 0); ";
					int col=db.update(sql);
					if(col!=0){
						tipLabel.setText("ע��ɹ���");
					}else{
						tipLabel.setText("�˺��Ѵ��ڣ���ֱ�ӵ�¼");
					}
				}
			}
		});
		
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
		setResizable(false);//�����С���ɸı�
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
