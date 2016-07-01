import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.util.ArrayList;

import javax.print.DocFlavor.STRING;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.fabric.xmlrpc.base.Data;
import com.mysql.jdbc.DatabaseMetaData;

public class PersonalFrame extends JFrame implements CheckString{//������Ϣ����
	
	private JLabel usernameLabel,balanceLabel,idLabel,chargeLabel,tipLabel,alialLabel;
	private JLabel aliasname,username,balance,id;
	private JPanel p1,p2,p3,p4,p5,p6;
	private Container container;
	private Box box;
	private JButton chargeButton;
	private JTextField charge;
	private String name;


	public PersonalFrame(String user) {
		// TODO Auto-generated constructor stub
		super("������Ϣ");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);//�����С���ɸı�
		
		this.name=user;

		container =getContentPane();
		box=new Box(BoxLayout.Y_AXIS);
		container.add(box);
		
	    usernameLabel=new JLabel("�û����� ");
	    balanceLabel=new JLabel("�� ");
	    idLabel=new JLabel("���֤�ţ� ");
	    chargeLabel=new JLabel("��ֵ�� ");
	    tipLabel=new JLabel("��������������ֵ");
	    tipLabel.setForeground(Color.red);
	    tipLabel.setHorizontalAlignment(JLabel.CENTER);
	    alialLabel=new JLabel("��½���� ");
	    
	    SQL sql=new SQL();
	    sql.select(" passenger_id, passenger_alias, passenger_name, balance " ,
				"  passenger " ,
				"  passenger_id = '" + user + "'");
	    DataBase db=new DataBase();
	    System.err.println(sql.toString());
	    ArrayList<ArrayList<String>> res=db.query(sql.toString());
	    for(ArrayList<String> tmp:res){
	    	System.err.println(tmp.toString());
	    }
	    Passenger passenger=new Passenger(res.get(0));
		
	    username=new JLabel(passenger.getName());
	    balance=new JLabel(passenger.getBalance());
	    id=new JLabel(passenger.getId());
	    aliasname=new JLabel(passenger.getAlias());
	    charge=new JTextField(15);
	    
	    p1=new JPanel();
	    p2=new JPanel();
	    p3=new JPanel();
	    p4=new JPanel();
	    p5=new JPanel();
	    p6=new JPanel();
	    
	    chargeButton=new JButton("��ֵ");
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
					SQL sql=new SQL();
					sql.update("passenger",
							"balance = balance + " + Integer.parseInt(s),
							"passenger_id = '" + user + "'");
					System.err.println(sql.toString());
					DataBase db=new DataBase();
					int flag=db.update(sql.toString());
					if(flag!=-1){
						PersonalFrame newFrame=new PersonalFrame(user);
						setVisible(false);
						dispose();
					}else{
						tipLabel.setText("��ֵʧ�ܣ�������������");
					}
				}else {
					tipLabel.setText("��ֵʧ�ܣ�������������");
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
	    p6.add(alialLabel);
	    p6.add(aliasname);
	    
	    
	    box.add(p4);
	    box.add(p6);
	    box.add(p1);
	    box.add(p2);
	    box.add(p3);
	    box.add(p5);
	    box.add(chargeButton);
	    

	   // pack();
	    setSize(300,300);
	    setLocationRelativeTo(null);//ʹ����ʼ��λ����Ļ����
	    setVisible(true);
	}
	

	@Override
	public String checkS(String s) {
		// TODO Auto-generated method stub
	    return s.replaceAll(".*([';]+|(--)+).*", " ").trim();
	}

	
}
