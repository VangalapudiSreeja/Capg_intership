package FlightApp;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import FlightApp.Hault;

public class Flight {
	
	private String flightNumber;
	private String airliner;

	private String source;
	private LocalDateTime flyDateTime;


	private String destination;
	private LocalDateTime arrivalDateTime;

	private Hault[] hault; 

	private boolean flyType; 
	private int internationFlyTax; 

	private int baseFare; // always include 5% as airport surcharge and 30% as fuel cost
	private int finalCost;// based on Airliner calendar and other criteria's 	

	

	public Flight(String flightNumber, String airliner, String source, LocalDateTime flyDateTime, String destination,
			LocalDateTime arrivalDateTime, boolean flyType, int baseFare ) {
		super();
		this.flightNumber = flightNumber;
		this.airliner = airliner;
		this.source = source;
		this.flyDateTime = flyDateTime;
		this.destination = destination;
		this.arrivalDateTime = arrivalDateTime;
		this.flyType = flyType;
		this.baseFare = baseFare;
	}

	double NonFriendlyTax;
	double timeTax ;
	double holidayTax ;
	double airportSurcharge;
	double fuelCost;
	
	//check arrival date
	/*1. arrival date. :-
		 * 		1.a)  If 10 to 2 days prior to the AirlinerCalendar Date	 :- 20% extra
		 * 		1.b)  If 1 to 0 day prior to the AirlinerCalendar Date 	:-  50% extra*/
	public double checkCalender(){
		AirlinerCalendar ac=new AirlinerCalendar ();
		LocalDate arrivaldate=arrivalDateTime.toLocalDate();
		double taxPercentage=0;
		for(LocalDate l:ac.listOfHolidays){
			int DaysDiff = (int)ChronoUnit.DAYS.between(l, arrivaldate);
			if(DaysDiff>=2 && DaysDiff<=10){
				taxPercentage=0.2;
			}else if(DaysDiff==1 || DaysDiff==0){
				taxPercentage=0.5;
			}
		}		
		return taxPercentage;
	}	  

	//check arrival time
	/* 2. arrival time.
		 * 		2.a) If flight land time is 2 hr +/- to 12:00 Noon (Any Date)	:- 10% extra
		 */
	public double arrivalTime(){
		LocalTime arrivalTime=arrivalDateTime.toLocalTime();
		LocalTime Time=LocalTime.parse("12:00");
		double taxPercentage=0;
		int TimeDiff=(int)ChronoUnit.MINUTES.between(arrivalTime,Time );

		if(TimeDiff<=120){
			taxPercentage=0.3;
		}		
		return taxPercentage;
	}

	//check friendly country
	/*3. Non free travel countries (List of FriendlyCountry.java)
	 * 		3.a) If destination belongs to non free travel, friendly country :- 30% extra
	 * */
	public double checkFriendlyCountry(){	
		FriendlyCountry fc=new FriendlyCountry();

		double taxPercentage=0;
		for(String country:fc.countries){
			if(destination.equals(country)){ 
				taxPercentage=0.3;
				break;
			}
		}
		return taxPercentage;
	} 

	public int calculateCost(){
		/*
		 * Cost of the flight will be decided by 
		 * 1. arrival date. :-
		 * 		1.a)  If 10 to 2 days prior to the AirlinerCalendar Date	 :- 20% extra
		 * 		1.b)  If 1 to 0 day prior to the AirlinerCalendar Date 	:-  50% extra
		 * 2. arrival time.
		 * 		2.a) If flight land time is 2 hr +/- to 12:00 Noon (Any Date)	:- 10% extra
		 *	
		 3. Non free travel countries (List of FriendlyCountry.java)
		 * 		3.a) If destination belongs to non free travel, friendly country :- 30% extra
		 * */
		if(flyType){
			internationFlyTax=2000;
		}else{
			internationFlyTax=0;
		}
		NonFriendlyTax = baseFare *  checkFriendlyCountry();
		timeTax = baseFare * arrivalTime();
		holidayTax = baseFare * checkCalender();
		airportSurcharge = baseFare * 0.05;
		fuelCost = baseFare * 0.3;

		int finalCost = (int)(baseFare + internationFlyTax + NonFriendlyTax + timeTax + holidayTax + airportSurcharge + fuelCost);

		return finalCost;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getAirliner() {
		return airliner;
	}

	public void setAirliner(String airliner) {
		this.airliner = airliner;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public LocalDateTime getFlyDateTime() {
		return flyDateTime;
	}

	public void setFlyDateTime(LocalDateTime flyDateTime) {
		this.flyDateTime = flyDateTime;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDateTime getArrivalDateTime() {
		return arrivalDateTime;
	}

	public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}

	public Hault[] getHault() {
		return hault;
	}

	public void setHault(Hault[] hault) {
		this.hault = hault;
	}
	
	public boolean isFlyType() {
		return flyType;
	}
	
	public double getNonFriendlyTax() {
		return NonFriendlyTax;
	}
	
	public void setNonFriendlyTax(double nonFriendlyTax) {
		NonFriendlyTax = nonFriendlyTax;
	}

	public double getTimeTax() {
		return timeTax;
	}

	public void setTimeTax(double timeTax) {
		this.timeTax = timeTax;
	}

	public double getHolidayTax() {
		return holidayTax;
	}

	public void setHolidayTax(double holidayTax) {
		this.holidayTax = holidayTax;
	}

	public double getAirportSurcharge() {
		return airportSurcharge;
	}

	public void setAirportSurcharge(double airportSurcharge) {
		this.airportSurcharge = airportSurcharge;
	}

	public double getFuelCost() {
		return fuelCost;
	}

	public void setFuelCost(double fuelCost) {
		this.fuelCost = fuelCost;
	}

	public void setFlyType(boolean flyType) {
		this.flyType = flyType;
	}

	public int getInternationFlyTax() {
		return internationFlyTax;
	}

	public void setInternationFlyTax(int internationFlyTax) {
		this.internationFlyTax = internationFlyTax;
	}

	public int getBaseFare() {
		return baseFare;
	}

	public void setBaseFare(int baseFare) {
		this.baseFare = baseFare;
	}

	public int getFinalCost() {
		return finalCost;
	}

	public void setFinalCost(int finalCost) {
		this.finalCost = finalCost;
	}
	

}
