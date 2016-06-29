import java.awt.Container;
import java.awt.Frame;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TeamWokersFrame extends JFrame{//团队信息界面
	
	private Container container;
	private Box box;
	private JLabel teamworkersLabel,aimLabel,nameLabel;
	private JPanel p1,p2,p3,p4;
	
	public TeamWokersFrame() {
		// TODO Auto-generated constructor stub
		super("关于");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		container =getContentPane();
		box=new Box(BoxLayout.Y_AXIS);
		container.add(box);
		
		teamworkersLabel=new JLabel("Team: 欧阳思琪，郑伟昊，周立博，万欣宇");
		aimLabel=new JLabel("For: 数据库大作业");
		nameLabel=new JLabel("Name: Airline_Tickets_Management");
		
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		
		p1.add(nameLabel);
		p2.add(teamworkersLabel);
		p3.add(aimLabel);
		p4.add(new JLabel());
		
		box.add(p4);
		box.add(p1);
		box.add(p2);
		box.add(p3);
		
	
		setSize(300, 300);
		setVisible(true);
		setLocationRelativeTo(null);//使界面始终位于屏幕中央
		setResizable(false);//界面大小不可改变
		setAlwaysOnTop(true);
	}

}
