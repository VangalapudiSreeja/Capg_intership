package FlightApp;

public class FlightDetails {
	public void printFlightDetails(Flight flight)
	{
		/* Write code to print the flight information and fare break up*/
		System.out.println("Flight details are as follows\n");
		System.out.println("Flight Number:"+flight.getFlightNumber());
		System.out.println("Airliner: "+flight.getAirliner());
		System.out.println("Source: "+flight.getSource());
		System.out.println("Departure Date and Time: "+flight.getFlyDateTime());
		System.out.println("Destination: "+flight.getDestination());
		System.out.println("Arrival Date and Time: "+flight.getArrivalDateTime());
		System.out.println("Flight type-international(True) or domestic(false): "+flight.isFlyType());
		System.out.println("\nFinal Cost: " + flight.calculateCost());
	}

}
