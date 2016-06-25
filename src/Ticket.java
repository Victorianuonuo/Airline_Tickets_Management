import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ticket {//用于显示查询时的订单状态
	
	private String ticket_id,username,flight,start,end,date,flight_class,seat,price;
	
	

	public Ticket(ResultSet temp) {//由从数据库中取出的信息进行构造
		// TODO Auto-generated constructor stub
		
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ticket:  "+ticket_id+"  "+username+" 于  "+date+"  乘坐"+flight
				+"  "+flight_class+"  舱位  "+" 中 "+seat+"   位置    "
				+" 从 "+start+"  前往    "+end+"   票价为    "+price;
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
