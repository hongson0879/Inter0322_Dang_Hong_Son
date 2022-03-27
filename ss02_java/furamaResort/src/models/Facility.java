package models;

import java.io.Serializable;

public abstract class Facility implements Serializable{
	private String facilityID;
	private String facilityName;
	private int acreage;
	private int rentalCost;
	private int maxPeopleNumber;
	private String rentalType;
	private static final long serialVersionUID = -6500665823330706018L;
	
	public Facility() {

	}

	public Facility(String facilityID, String facilityName, int acreage, int rentalCost, int maxPeopleNumber, String rentalType) {
		this.facilityID = facilityID;
		this.facilityName = facilityName;
		this.acreage = acreage;
		this.rentalCost = rentalCost;
		this.maxPeopleNumber = maxPeopleNumber;
		this.rentalType = rentalType;
	}

	public String getFacilityID() {
		return facilityID;
	}

	public void setFacilityID(String facilityID) {
		this.facilityID = facilityID;
	}

	public int getAcreage() {
		return acreage;
	}

	public void setAcreage(int acreage) {
		this.acreage = acreage;
	}

	public int getRentalCost() {
		return rentalCost;
	}

	public void setRentalCost(int rentalCost) {
		this.rentalCost = rentalCost;
	}

	public int getMaxPeopleNumber() {
		return maxPeopleNumber;
	}

	public void setMaxPeopleNumber(int maxPeopleNumber) {
		this.maxPeopleNumber = maxPeopleNumber;
	}

	public String getRentalType() {
		return rentalType;
	}

	public void setRentalType(String rentalType) {
		this.rentalType = rentalType;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
}
