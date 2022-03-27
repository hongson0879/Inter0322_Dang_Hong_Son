package models;

import java.io.Serializable;

public abstract class Person implements Serializable{
	private int personalID;
	private String name;
	private String dOB;
	private String gender;
	private String cMND;
	private String phoneNumber;
	private String email;
	private static final long serialVersionUID = -6500665823330706018L;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(int personalID, String name, String dOB, String gender, String cMND, String phoneNumber,
			String email) {
		this.personalID = personalID;
		this.name = name;
		this.dOB = dOB;
		this.gender = gender;
		this.cMND = cMND;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public int getPersonalID() {
		return personalID;
	}

	public void setPersonalID(int personalID) {
		this.personalID = personalID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getdOB() {
		return dOB;
	}

	public void setdOB(String dOB) {
		this.dOB = dOB;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getcMND() {
		return cMND;
	}

	public void setcMND(String cMND) {
		this.cMND = cMND;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
