
import java.util.ArrayList;



public class UnprintedTicket {//������ʾ��ѯʱ�Ķ���״̬
	
	private String ticket_id,flight_id,date,flight_class,price;
	
	

	public UnprintedTicket(ArrayList<String> temp) {//�ɴ����ݿ���ȡ������Ϣ���й���
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
		return "ticket:  "+ticket_id+" ��  "+date+"  ����"+flight_id
				+" ����  "+flight_class+"  ��λ     Ʊ��Ϊ    "+price;
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
