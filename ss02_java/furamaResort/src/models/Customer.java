package models;

import java.io.Serializable;

public class Customer extends Person implements Serializable{
	private String type;
	private String address;
	private static final long serialVersionUID = -6500665823330706018L;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int personalID, String name, String dOB, String gender, String cMND, 
			String phoneNumber, String email, String type, String address) {
		super(personalID, name, dOB, gender, cMND, phoneNumber, email);
		this.type = type;
		this.address = address;
		// TODO Auto-generated constructor stub
	}
	public Customer(String type, String address) {
		this.type = type;
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Customer [ CustomerID: " + getPersonalID() 
				+ ",\n Name: " + getName()
				+ ",\n DOB: " + getdOB()
				+ ",\n Gender: " + getGender()
				+ ",\n CMND: " + getcMND()
				+ ",\n Phone number: " + getPhoneNumber()
				+ ",\n Email: " + getEmail()
				+ ",\n Type: " + type 
				+ ",\n Address: " + address 
				+ "]";
	}
}
