import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PrintFrame extends JFrame{//打印机票信息界面
	
	private JPanel idPanel,userPanel,fligtPanel,startPanel,endPanel,classPanel,seatPanel,datePanel;
	private JLabel idLabel,userLabel,fligtLabel,startLabel,endLabel,classLabel,seatLabel,dateLabel;
	private String ticket_id,username,flight,start,end,date,flight_class,seat;
	private Container container;
	private Box box;
	private JButton printButton;
                  
	public PrintFrame(Ticket ticket) {
		// TODO Auto-generated constructor stub
		super("打印");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);//界面大小不可改变
		
		ticket_id=ticket.getTicket_id();
		username=ticket.getUsername();
		flight=ticket.getFlight();
		start=ticket.getStart();
		end=ticket.getEnd();
		date=ticket.getDate();
		flight_class=ticket.getFlight_class();
		seat=ticket.getSeat();
		
		idPanel=new JPanel();
		userPanel=new JPanel();
		fligtPanel=new JPanel();
		startPanel=new JPanel();
		endPanel=new JPanel();
		classPanel=new JPanel();
		seatPanel=new JPanel();
		datePanel=new JPanel();
		
		idLabel=new JLabel(ticket_id);
		userLabel=new JLabel(username);
		fligtLabel=new JLabel(flight);
		startLabel=new JLabel(start);
		endLabel=new JLabel(end);
		classLabel=new JLabel(flight_class);
		seatLabel=new JLabel(seat);
		dateLabel=new JLabel(date);
		
		idPanel.add(new JLabel("编号：  "));
		idPanel.add(idLabel);
		userPanel.add(new JLabel("用户名： "));
		userPanel.add(userLabel);
		fligtPanel.add(new JLabel("航班号： "));
		fligtPanel.add(fligtLabel);
		startPanel.add(new JLabel("起始点： "));
		startPanel.add(startLabel);
		endPanel.add(new JLabel("终点： "));
		endPanel.add(endLabel);
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
		
		box.add(idPanel);
		box.add(userPanel);
		box.add(datePanel);
		box.add(startPanel);
		box.add(endPanel);
		box.add(classPanel);
		box.add(seatLabel);
		
		setSize(300,300);
	    setLocationRelativeTo(null);//使界面始终位于屏幕中央
	    setVisible(true);
		
	}
	
	
	
}
