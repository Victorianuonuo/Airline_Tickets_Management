import java.sql.ResultSet;

public class Flight {//������ʾ��ѯʱ�ĺ���״̬
	
	private String flight,start,end,date,price,left;

	public Flight(ResultSet temp) {//�ɴ����ݿ���ȡ������Ϣ���й���
		// TODO Auto-generated constructor stub
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "  ����     "+flight+"  ��    "+start+"  ��    "+end+" ��   "+date+" ��Ʊ��   "+left+"  �۸� "+price ;
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
	public String getPrice() {
		return price;
	}
	public String getStart() {
		return start;
	}
	public String getLeft() {
		return left;
	}
	
	
}
