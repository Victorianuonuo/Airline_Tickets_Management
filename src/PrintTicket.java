import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

public class PrintTicket {

	private String company, booking_reference, passenger_name, start_port, end_port, flight_id, class_name, flight_date, start_time, end_time, seat ;
	
	public PrintTicket(ArrayList<String> tmp) {
		// TODO Auto-generated constructor stub
		
		company=tmp.get(0);
		booking_reference=tmp.get(1);
		passenger_name=tmp.get(2);
		start_port=tmp.get(3);
		end_port=tmp.get(4);
		flight_id=tmp.get(5); 
		class_name=tmp.get(6); 
		flight_date=tmp.get(7);
		start_time=tmp.get(8);
		end_time=tmp.get(9);
		seat=tmp.get(10);
	}
	
	public String getBooking_reference() {
		return booking_reference;
	}
	public String getClass_name() {
		return class_name;
	}
	public String getCompany() {
		return company;
	}
	public String getEnd_port() {
		return end_port;
	}
	public String getEnd_time() {
		return end_time;
	}
	public String getFlight_date() {
		return flight_date;
	}
	public String getFlight_id() {
		return flight_id;
	}
	public String getPassenger_name() {
		return passenger_name;
	}
	public String getSeat() {
		return seat;
	}
	public String getStart_port() {
		return start_port;
	}
	public String getStart_time() {
		return start_time;
	}
	
	
}
