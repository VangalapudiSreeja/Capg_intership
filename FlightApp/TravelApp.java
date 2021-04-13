package FlightApp;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TravelApp {
	public static void main(String[] args) {
		/* Write code to call Flight constructor and Flight class setter methods*/
		Scanner sc=new Scanner(System.in);
		FlightDetails fd=new FlightDetails();		
		
		DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		
		Flight f=new Flight("R35007","Indigo Airlines","India",LocalDateTime.parse("06-04-2021 07:00", format),"Nepal",LocalDateTime.parse("06-04-2021 08:30" , format),false,5000);
		
		
		
		
		f.calculateCost();
		fd.printFlightDetails(f);	
	}

}
