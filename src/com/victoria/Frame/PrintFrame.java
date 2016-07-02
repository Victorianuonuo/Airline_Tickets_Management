package com.victoria.Frame;
import com.victoria.Entity.*;
import com.victoria.mysql.*;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PrintFrame extends JFrame{//打印机票信息界面
	
	private JPanel companyPanel,idPanel,userPanel,fligtPanel,startposPanel,endposPanel,starttimePanel,endtimePanel,classPanel,seatPanel,datePanel;
	private JLabel companyLabel,idLabel,userLabel,fligtLabel,startposLabel,endposLabel,starttimeLabel,endtimeLabel,classLabel,seatLabel,dateLabel;
	private String company,ticket_id,username,flight,startpos,endpos,starttime,endtime,date,flight_class,seat;
	private Container container;
	private Box box;
	private JButton printButton;
                  
	public PrintFrame(String ticket_id,String user) {
		// TODO Auto-generated constructor stub
		super("打印");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);//界面大小不可改变
		
		this.ticket_id=ticket_id;
		DataBase db=new DataBase();
		db.update("call getSeat('" + Integer.parseUnsignedInt(ticket_id) +"', '" + user + "') ");
		SQL sql=new SQL();
		sql.select(" company, booking_reference, passenger_name, start_port, end_port, flight_id, class_name, flight_date, start_time, end_time, seat "
				, " print_query "
				, " booking_reference = " + Integer.parseUnsignedInt(ticket_id)+ " ");
		ArrayList<ArrayList<String>> res=db.query(sql.toString());
		System.err.println(sql.toString());
		System.err.println(res);
		PrintTicket ticket=new PrintTicket(res.get(0));
		
		company=ticket.getCompany();
		//ticket_id=ticket.getBooking_reference();
		username=ticket.getPassenger_name();
		flight=ticket.getFlight_id();
		startpos=ticket.getStart_port();
		endpos=ticket.getEnd_port();
		starttime=ticket.getStart_time();
		endtime=ticket.getEnd_time();
		date=ticket.getFlight_date();
		seat=ticket.getSeat();
		flight_class=ticket.getClass_name();
		
		companyPanel=new JPanel();
		idPanel=new JPanel();
		userPanel=new JPanel();
		fligtPanel=new JPanel();
		startposPanel=new JPanel();
		endposPanel=new JPanel();
		starttimePanel=new JPanel();
		endtimePanel=new JPanel();
		classPanel=new JPanel();
		seatPanel=new JPanel();
		datePanel=new JPanel();
		
		companyLabel=new JLabel(company);
		idLabel=new JLabel(this.ticket_id);
		userLabel=new JLabel(username);
		fligtLabel=new JLabel(flight);
		startposLabel=new JLabel(startpos);
		endposLabel=new JLabel(endpos);
		starttimeLabel=new JLabel(starttime);
		endtimeLabel=new JLabel(endtime);
		classLabel=new JLabel(flight_class);
		seatLabel=new JLabel(seat);
		dateLabel=new JLabel(date);
		
		companyPanel.add(new JLabel("航班公司： "));
		companyPanel.add(companyLabel);
		idPanel.add(new JLabel("编号：  "));
		idPanel.add(idLabel);
		userPanel.add(new JLabel("用户名： "));
		userPanel.add(userLabel);
		fligtPanel.add(new JLabel("航班号： "));
		fligtPanel.add(fligtLabel);
		startposPanel.add(new JLabel("起始点： "));
		startposPanel.add(startposLabel);
		endposPanel.add(new JLabel("终点： "));
		endposPanel.add(endposLabel);
		starttimePanel.add(new JLabel("起始时间： "));
		starttimePanel.add(starttimeLabel);
		endtimePanel.add(new JLabel("终止时间： "));
		endtimePanel.add(endtimeLabel);
		seatPanel.add(new JLabel("座位： "));
		seatPanel.add(seatLabel);
		classPanel.add(new JLabel("舱位： "));
		classPanel.add(classLabel);
		datePanel.add(new JLabel("时间： "));
		datePanel.add(dateLabel);
		
		container =getContentPane();
		box=new Box(BoxLayout.Y_AXIS);
		container.add(box);
		
		printButton=new JButton("关闭");
		printButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				dispose();
			}
		});
		
		box.add(companyPanel);
		box.add(idPanel);
		box.add(userPanel);
		box.add(datePanel);
		box.add(idPanel);
		box.add(startposPanel);
		box.add(endposPanel);
		box.add(starttimePanel);
		box.add(endtimePanel);
		box.add(classPanel);
		box.add(seatPanel);
		
		
		setSize(500,600);
	    setLocationRelativeTo(null);//使界面始终位于屏幕中央
	    setVisible(true);
		
	}
	
	
	
}
