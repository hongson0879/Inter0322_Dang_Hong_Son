package models;

public class Booking {
	private int bookingCode;
	private String startDate;
	private String finishDate;
	private int customerID;
	private String serviceName;
	private String serviceType;
	
	public Booking() {
	}

	public Booking(int bookingCode, String startDate, String finishDate, int customerID,
			String serviceName, String serviceType) {
		this.bookingCode = bookingCode;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.customerID = customerID;
		this.serviceName = serviceName;
		this.serviceType = serviceType;
	}

	public int getBookingCode() {
		return bookingCode;
	}

	public void setBookingCode(int bookingCode) {
		this.bookingCode = bookingCode;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
}
