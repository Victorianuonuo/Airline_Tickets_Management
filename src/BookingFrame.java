import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.xml.crypto.Data;
import javax.xml.transform.Templates;

import org.omg.CORBA.INITIALIZE;

public class BookingFrame extends JFrame implements CheckString{//查询订票界面
     
	private JMenu personalMenu,helpMenu;
	private DefaultListModel<Flight> model;
    final JList<Flight> list;//用于显示查询所得到的机票结果 
	private JMenuBar menuBar;
	private JPanel numberPanel,desPanel,idPanel;
	private JMenuItem infoItem,ticketItem,tipItem,exitItem;
	private JRadioButton numberButton,desButton;
	private JTextField numberText,startText,endText,idText;
	private ButtonGroup choiceGroup;
	private JLabel startLabel,endLabel,numberLabel,datesLabel;
	private JComboBox datesBox,classBox;
	private JButton queryButton,bookingButton;
	private String[] dates={"2016-7-1","2016-7-2","2016-7-3","2016-7-4","2016-7-5",
			               "2016-7-6","2016-7-7","2016-7-8","2016-7-9","2016-7-10",
			               "2016-7-11","2016-7-12","2016-7-13","2016-7-14","2016-7-15",
			               "2016-7-16","2016-7-17","2016-7-18","2016-7-19","2016-7-20",
			               "2016-7-21","2016-7-22","2016-7-23","2016-7-24","2016-7-25",
			               "2016-7-26","2016-7-27","2016-7-28","2016-7-29","2016-7-30",
	};//只能查询和预定30天之内的飞机票
	private String[] flight_classes={"first","economy","business"};//飞机三个不同舱位：头等舱，经济舱，商务舱
	private boolean selected=false;
	private String date="2016-7-1",flight_class="first";
	
	
	
	private String user_id;
	
	
	public BookingFrame(String user) {
		// TODO Auto-generated constructor stub
		super("订票");
		this.user_id=user;
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridBagLayout());
		
		GridBagConstraints c=new GridBagConstraints();
		c.fill=GridBagConstraints.BOTH;
		
		personalMenu=new JMenu("个人");
		helpMenu=new JMenu("帮助");
		
		infoItem=new JMenuItem("个人信息");
		ticketItem=new JMenuItem("订票信息");
		tipItem=new JMenuItem("关于");
		exitItem=new JMenuItem("退出");
		
        infoItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {//点击菜单中的个人信息栏时将新建一个PersonalFrame来显示该用户所有信息
				// TODO Auto-generated method stub
				PersonalFrame personalFrame=new PersonalFrame(user);
			}
		});
        
        ticketItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UnprintedTicketFrame unprintedTicketFrame=new UnprintedTicketFrame(user);//点击菜单中的订票信息栏时将新建一个AllTicketFrame来显示该用户所订机票的所有信息
			}
		});
        
        tipItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TeamWokersFrame teamWokersDialog=new TeamWokersFrame();//点击菜单中的关于栏时将新建一个TeamWokersFrame来显示团队信息
			}
		});
        exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {//点击菜单中的退出栏时将回到登陆界面
				// TODO Auto-generated method stub
				LoginFrame loginFrame=new LoginFrame();
				setVisible(false);
			}
		});
		
		
		personalMenu.add(infoItem);
		personalMenu.add(ticketItem);
		helpMenu.add(tipItem);
		helpMenu.add(exitItem);
		
		numberButton=new JRadioButton("车次查询");
		desButton=new JRadioButton("站点查询");
		
		choiceGroup=new ButtonGroup();
		choiceGroup.add(numberButton);
		choiceGroup.add(desButton);
		numberButton.setSelected(true);
		
		numberButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {//选中按航班号查找按钮
				// TODO Auto-generated method stub
				numberButton.setSelected(true);
				desButton.setSelected(false);
				selected=false;
			}
		});
		desButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {//选中按地点查找按钮
				// TODO Auto-generated method stub
				desButton.setSelected(true);
				numberButton.setSelected(false);
				selected=true;
			}
		});
		
		
		numberText=new JTextField(10);
		startText=new JTextField(10);
		endText=new JTextField(10);
		idText=new JTextField(10);
		
		startLabel= new   JLabel("  从       ");
		endLabel  = new   JLabel("  到       ");
		numberLabel=new   JLabel("  航班号  ");
		datesLabel=new JLabel("     日期");
		
		numberPanel=new JPanel();
		desPanel=new JPanel();
		idPanel=new JPanel();
		
		queryButton=new JButton("查询");
		bookingButton=new JButton("订票");
		
		queryButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SQL sql=new SQL();
				if(selected==false){//查询，输入flight-id, date，返回ResultSet
					String t1=numberText.getText();
					String safe=checkS(t1);
					System.err.println(safe);
					if(safe!=null){
	     						sql.select("flight_id, flight_date, start_port, end_port, start_time, end_time",
								"flight_book_query",
								"flight_id = '" + t1 + "' and flight_date = cast('" + date + "' as date)");
					}
				}else {//查询，输入起点，重点，date
					String t1=startText.getText(),t2=endText.getText();
					String s1=checkS(t1);
					String s2=checkS(t2);
					System.err.println(s1+" | "+s2);
					if(s1!=null&&s2!=null){
						sql.select("flight_id, flight_date, start_port, end_port, start_time, end_time",
								"flight_book_query",
								"start_port = '" + s1 + "' and end_port = '" + s2 + "' and flight_date = cast '" + date + "' as date");
					}
				}
				DataBase db=new DataBase();
				System.err.println(sql.toString());
				ArrayList<ArrayList<String>> res=db.query(sql.toString());
				model.removeAllElements();
				if(res!=null){
					for(ArrayList<String> tmp:res){
						System.err.println(tmp);
						sql.select("price, remain",
								"class_book_query",
								"flight_id = '" + tmp.get(0) + "' and flight_date = cast('" + date + "' as date)","  class_name ");
						ArrayList<ArrayList<String>> res2=db.query(sql.toString());
						System.err.println(res2);
						ArrayList<String> tmp2=new ArrayList<>();
						for(String tmp4:tmp)
							tmp2.add(tmp4);
						for(ArrayList<String> tmp3:res2){
							System.err.println(tmp3);
							for(String tmp5:tmp3)
								tmp2.add(tmp5);
						}
						Flight flight=new Flight(tmp2);
						model.addElement(flight);
					}
				}
			}
		});
		
		bookingButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String t1=idText.getText();
				String s1=checkS(t1);
				System.err.println(s1);
				if(t1!=null&&s1!=null){
					SQL sql=new SQL();
					sql.select("price "
							, "class_book_query "
							, "flight_id = '" + s1 + "' and flight_date = cast('" + date +"' as date ) and class_name = '" + flight_class + "' and remain > 0 ");
					DataBase db=new DataBase();
					ArrayList<ArrayList<String>> tmp=db.query(sql.toString());
					System.err.println(tmp);
					if(tmp!=null){
	
						sql.update("passenger "
								,"set balance = balance - " + tmp.get(0).get(0) + " "
								,"where passenger_name = '" + s1 + "' ");
						int r1=db.update(sql.toString());
						if(r1!=-1){
							sql.update("flight_class "
									, "set remain = remain - 1 "
									, "where flight_id = '" + s1 + "' and flight_date = cast('" + date +"' as date) and class_name = '" + flight_class + "' ");
							int r2=db.update(sql.toString());
							if(r2!=-1){
								sql.insert("ticket(passanger_id, flight_id, flight_date, class_name, worth) "
									       ,"values ('" + BookingFrame.this.user_id + "', '" + s1 + "', '" + date + "', '" + flight_class + "', '" +tmp.get(0).get(0) + "') ");
								int r3=db.update(sql.toString());
								if(r3!=-1){
									showDialog("预定成功！请在起飞前打印机票！");
								}else{
									showDialog("预定失败");
								}
							}else{
								showDialog("预定失败");
							}
						}else{
							showDialog("预定失败");
						}
					}
				}else {
					showDialog("请输入正确的航班号");
				}
			}
		});
		
		numberPanel.add(numberLabel);
		numberPanel.add(numberText);
		desPanel.add(startLabel);
		desPanel.add(startText);
		desPanel.add(endLabel);
		desPanel.add(endText);
		idPanel.add(numberLabel);
		idPanel.add(idText);
		
		datesBox=new JComboBox<>(dates);
		classBox=new JComboBox<>(flight_classes);
		datesBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {//在下拉栏中选择不同的时间将改变所选中的时间
				// TODO Auto-generated method stub
				date= (String)datesBox.getSelectedItem();
				
			}
		});
		classBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {//在下拉栏中选择不同的舱位将改变所选中的舱位
				// TODO Auto-generated method stub
				flight_class=(String)classBox.getSelectedItem();
			}
		});
		
		menuBar=new JMenuBar();
		menuBar.add(personalMenu);
		menuBar.add(helpMenu);
		
		setJMenuBar(menuBar);

		c.gridx=2;
		c.gridy=5;
        c.gridwidth=3;
        c.gridheight=1;
        c.weightx=1;
        c.weighty=1;
		add(numberButton,c);
		
		c.gridx=8;
		c.gridy=5;
        c.gridwidth=5;
        c.gridheight=1;
        c.weightx=0;
        c.weighty=0;
		add(numberPanel,c);
		
		c.gridx=2;
		c.gridy=10;
        c.gridwidth=3;
        c.gridheight=1;
        c.weightx=1;
        c.weighty=1;
		add(desButton,c);
		
		c.gridx=8;
		c.gridy=10;
        c.gridwidth=5;
        c.gridheight=1;
        c.weightx=1;
        c.weighty=1;
		add(desPanel,c);
		
		c.gridx=25;
		c.gridy=5;
        c.gridwidth=1;
        c.gridheight=1;
        c.weightx=1;
        c.weighty=1;
		add(datesLabel,c);
		
		c.gridx=26;
		c.gridy=5;
        c.gridwidth=1;
        c.gridheight=1;
        c.weightx=1;
        c.weighty=1;
		add(datesBox,c);

		c.gridx=26;
		c.gridy=10;
        c.gridwidth=1;
        c.gridheight=1;
        c.weightx=1;
        c.weighty=1;
		add(queryButton,c);
		
		c.gridx=2;
		c.gridy=15;
        c.gridwidth=20;
        c.gridheight=15;
        c.weightx=1;
        c.weighty=1;
		model=new DefaultListModel<Flight>();
    	list=new JList<Flight>(model);
    	add(new JScrollPane(list),c);
    	
    	c.gridx=25;
		c.gridy=15;
        c.gridwidth=0;
        c.gridheight=1;
        c.weightx=1;
        c.weighty=1;
		add(idPanel,c);
		
		c.gridx=25;
		c.gridy=16;
        c.gridwidth=0;
        c.gridheight=1;
        c.weightx=1;
        c.weighty=1;
		add(new JLabel("      舱位："),c);
        
		c.gridx=25;
		c.gridy=17;
        c.gridwidth=0;
        c.gridheight=1;
        c.weightx=1;
        c.weighty=1;
		add(classBox,c);
		
		c.gridx=25;
		c.gridy=18;
        c.gridwidth=0;
        c.gridheight=0;
        c.weightx=1;
        c.weighty=1;
		add(bookingButton,c);
		
		
		pack();
		setLocationRelativeTo(null);//使界面始终位于屏幕中央
		setResizable(false);//界面大小不可改变
		setVisible(true);
		
	}
	
	@Override
	public String checkS(String s) {
		// TODO Auto-generated method stub
	    return s.replaceAll(".*([';]+|(--)+).*", " ").trim();
	}

	private void showDialog(String text){
		InfoDialog infoDialog=new InfoDialog(BookingFrame.this);
		infoDialog.setText(text);
	}
	
}
