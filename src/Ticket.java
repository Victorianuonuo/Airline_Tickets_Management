import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ticket {//������ʾ��ѯʱ�Ķ���״̬
	
	private String ticket_id,username,flight,start,end,date,flight_class,seat,price;
	
	

	public Ticket(ResultSet temp) {//�ɴ����ݿ���ȡ������Ϣ���й���
		// TODO Auto-generated constructor stub
		
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ticket:  "+ticket_id+"  "+username+" ��  "+date+"  ����"+flight
				+"  "+flight_class+"  ��λ  "+" �� "+seat+"   λ��    "
				+" �� "+start+"  ǰ��    "+end+"   Ʊ��Ϊ    "+price;
	}
	
	public String getUsername() {
		return username;
	}
	public String getDate() {
		return date;
	}
	public String getEnd() {
		return end;
	}
	public String getFlight() {
		return flight;
	}
	public String getFlight_class() {
		return flight_class;
	}
	public String getPrice() {
		return price;
	}
	public String getSeat() {
		return seat;
	}
	public String getStart() {
		return start;
	}
	public String getTicket_id() {
		return ticket_id;
	}
	
	
}
