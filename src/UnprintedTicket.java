
import java.util.ArrayList;



public class UnprintedTicket {//用于显示查询时的订单状态
	
	private String ticket_id,flight_id,date,flight_class,price;
	
	

	public UnprintedTicket(ArrayList<String> temp) {//由从数据库中取出的信息进行构造
		// TODO Auto-generated constructor stub
		ticket_id=temp.get(0);
		flight_id=temp.get(1);
		date=temp.get(2);
		flight_class=temp.get(3);
		price=temp.get(4);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ticket:  "+ticket_id+" 于  "+date+"  乘坐"+flight_id
				+" 航班  "+flight_class+"  舱位     票价为    "+price;
	}
	

	public String getDate() {
		return date;
	}

	public String getFlight_class() {
		return flight_class;
	}
	public String getPrice() {
		return price;
	}
	public String getFlight_id() {
		return flight_id;
	}

	public String getTicket_id() {
		return ticket_id;
	}
	
	
}
