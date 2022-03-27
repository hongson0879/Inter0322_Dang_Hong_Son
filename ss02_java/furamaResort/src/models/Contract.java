package models;

public class Contract {
	private int contractCode;
	private int bookingCode;
	private int deposit;
	private int totalCost;
	private int customerID;
	
	public Contract() {
	}

	public Contract(int contractCode, int bookingCode, int deposit, int totalCost,
					int customerID) {
		this.contractCode = contractCode;
		this.bookingCode = bookingCode;
		this.deposit = deposit;
		this.totalCost = totalCost;
		this.customerID = customerID;
	}

	public int getContractCode() {
		return contractCode;
	}

	public void setContractCode(int contractCode) {
		this.contractCode = contractCode;
	}

	public int getBookingCode() {
		return bookingCode;
	}

	public void setBookingCode(int bookingCode) {
		this.bookingCode = bookingCode;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
}
