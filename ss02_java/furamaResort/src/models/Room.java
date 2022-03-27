package models;

public class Room extends Facility {
	private String freeService;
	
	public Room() {
		// TODO Auto-generated constructor stub
	}
	public Room(String facilityID, 
			String facilityName, 
			int acreage, 
			int rentalCost, 
			int maxPeopleNumber, 
			String rentalType,
			String freeService) {
		super(facilityID, facilityName, acreage, rentalCost, maxPeopleNumber, rentalType);
		this.freeService = freeService;
		// TODO Auto-generated constructor stub
	}
	public Room(String freeService) {
		this.freeService = freeService;
	}
	
	public String getFreeService() {
		return freeService;
	}
	public void setFreeService(String freeService) {
		this.freeService = freeService;
	}
	
	@Override
	public String toString() {
		return "Room ["
				+ "FacilityID: " + getFacilityID()
				+ ", Name: " + getFacilityName()
				+ ", Acreage: " + getAcreage()
				+ ", Rental cost: " + getRentalCost()
				+ ", Max of people number: " + getMaxPeopleNumber()
				+ ", Rental type: " + getRentalType()
				+", Free service: " + freeService
				+ "]";
	}
}
