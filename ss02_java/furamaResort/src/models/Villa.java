package models;

import java.io.Serializable;

public class Villa extends Facility implements Serializable{
	private String roomStandard;
	private int poolArea;
	private int floorsNumber;
	private static final long serialVersionUID = -6500665823330706018L;
	
	public Villa() {
	}

	public Villa(String facilityID, 
			String facilityName,
			int acreage, 
			int rentalCost, 
			int maxPeopleNumber, 
			String rentalType,
			String roomStandard, 
			int poolArea, 
			int floorsNumber) {
		super(facilityID, facilityName, acreage, rentalCost, maxPeopleNumber, rentalType);
		this.roomStandard = roomStandard;
		this.poolArea = poolArea;
		this.floorsNumber = floorsNumber;
		// TODO Auto-generated constructor stub
	}
	public Villa(String roomStandard, int poolArea, int floorsNumber) {
		this.roomStandard = roomStandard;
		this.poolArea = poolArea;
		this.floorsNumber = floorsNumber;
	}

	public String getRoomStandard() {
		return roomStandard;
	}

	public void setRoomStandard(String roomStandard) {
		this.roomStandard = roomStandard;
	}

	public int getPoolArea() {
		return poolArea;
	}

	public void setPoolArea(int poolArea) {
		this.poolArea = poolArea;
	}

	public int getFloorsNumber() {
		return floorsNumber;
	}

	public void setFloorsNumber(int floorsNumber) {
		this.floorsNumber = floorsNumber;
	}

	@Override
	public String toString() {
		return "Villa ["
				+ "FacilityID: " + getFacilityID()
				+ ", Name: " + getFacilityName()
				+ ", Acreage: " + getAcreage()
				+ ", Rental cost: " + getRentalCost()
				+ ", Max of people number: " + getMaxPeopleNumber()
				+ ", Rental type: " + getRentalType()
				+", Room standard: " + roomStandard
				+ ", Pool area=" + poolArea 
				+ ", Floors number: " + floorsNumber
				+ "]";
	}
	
	
}
