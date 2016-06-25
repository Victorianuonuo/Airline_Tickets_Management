import java.sql.ResultSet;

public class Flight {//用于显示查询时的航班状态
	
	private String flight,start,end,date,price,left;

	public Flight(ResultSet temp) {//由从数据库中取出的信息进行构造
		// TODO Auto-generated constructor stub
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "  航班     "+flight+"  从    "+start+"  到    "+end+" 于   "+date+" 余票：   "+left+"  价格： "+price ;
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
