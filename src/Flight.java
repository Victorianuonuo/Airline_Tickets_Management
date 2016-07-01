import java.sql.ResultSet;
import java.util.ArrayList;

public class Flight {//������ʾ��ѯʱ�ĺ���״̬
	
	private String flight_id, flight_date, start_point, end_point, start_time, end_time, first_price, first_left, business_price, business_left, economy_price, economy_left;

	public Flight(ArrayList<String> temp) {//�ɴ����ݿ���ȡ������Ϣ���й���
		// TODO Auto-generated constructor stub
		flight_id=temp.get(0);
		flight_date=temp.get(1);
		start_point=temp.get(2);
		end_point=temp.get(3);
		start_time=temp.get(4);
		end_time=temp.get(5);
		first_price=temp.get(6);
		first_left=temp.get(7);
		business_price=temp.get(8);
		business_left=temp.get(9);
		economy_price=temp.get(10);
		economy_left=temp.get(11);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "  ����     "+flight_id+"  ��    "+start_point+"  ��    "+end_point+" ��   "+flight_date+"  ͷ�Ȳգ�   "+first_left+"  �۸� "+first_price+"  ����գ�   "+first_left+"  �۸� "+first_price+"  ���òգ�   "+first_left+"  �۸� "+first_price ;
	}

	public String getBusiness_left() {
		return business_left;
	}
	public String getBusiness_price() {
		return business_price;
	}
	public String getEconomy_left() {
		return economy_left;
	}
	public String getEconomy_price() {
		return economy_price;
	}
	public String getEnd_point() {
		return end_point;
	}
	public String getEnd_time() {
		return end_time;
	}
	public String getFirst_left() {
		return first_left;
	}
	public String getPrice(String s) {
		String temp = null;
		switch (s) {
		case "first":
			temp=first_price;
			break;
		case "business":
			temp=business_price;
			break;	
		case "economy":
			temp=economy_price;
			break;
		}
		return temp;
	}
	public String getFlight_date() {
		return flight_date;
	}
	public String getFlight_id() {
		return flight_id;
	}
	public String getStart_point() {
		return start_point;
	}
	public String getStart_time() {
		return start_time;
	}
	
}
