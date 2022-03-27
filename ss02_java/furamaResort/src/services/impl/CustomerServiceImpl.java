package services.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import models.Customer;
import services.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	private static List<Customer> customerList = new LinkedList<>();
	private static Scanner scan = new Scanner(System.in);
	
	@Override
	public void display() {
		for(Customer customer : customerList) {
			System.out.println(customer.toString());
		}
	}

	@Override
	public void addNew() {
		System.out.println("Enter customer ID: ");
		int employeeID = Integer.parseInt(scan.nextLine());
		System.out.println("Enter name: ");
		String name = scan.nextLine();
		System.out.println("Enter date of birth: ");
		String dOB = scan.nextLine();
		System.out.println("Enter gender: ");
		String gender = scan.nextLine();
		System.out.println("Enter CMND: ");
		String cMND = scan.nextLine();
		System.out.println("Enter phone number: ");
		String phoneNumber = scan.nextLine();
		System.out.println("Enter email: ");
		String email = scan.nextLine();
		System.out.println("Enter type: ");
		String type = scan.nextLine();
		System.out.println("Enter address: ");
		String address = scan.nextLine();
		Customer customer = new Customer(employeeID, name, dOB, gender, cMND, phoneNumber, 
										email, type, address);
		customerList.add(customer);
		System.out.println("Add customer successfully!");
	}

	@Override
	public void edit() {
		System.out.println("Enter CustomerID you want to update: ");
		int searchID = Integer.parseInt(scan.nextLine());
		boolean isExist = false;
		for (Customer customer : customerList) {
			if(customer.getPersonalID() == searchID) {
				isExist = true;
				System.out.println("Enter new information: ");	
				System.out.println("Enter customer ID: ");
				boolean check;
				do {
					check = true;
					int customerID = Integer.parseInt(scan.nextLine());
					if(customerID != searchID) {	
						for(Customer customer2 : customerList) {
							if(customer2.getPersonalID() == customerID) {
								check = false;
								System.out.println("This ID is exist, enter EmployeeID again: ");
								break;
							}
						}
					}
					if(check == true || customerID == searchID) {
						customer.setPersonalID(customerID);
						break;
					}
				} while (check == false);
				System.out.println("Enter name: ");
				String name = scan.nextLine();
				customer.setName(name);
				System.out.println("Enter date of birth: ");
				String dOB = scan.nextLine();
				customer.setdOB(dOB);
				System.out.println("Enter gender: ");
				String gender = scan.nextLine();
				customer.setGender(gender);
				System.out.println("Enter CMND: ");
				String cMND = scan.nextLine();
				customer.setcMND(cMND);
				System.out.println("Enter phone number: ");
				String phoneNumber = scan.nextLine();
				customer.setPhoneNumber(phoneNumber);
				System.out.println("Enter email: ");
				String email = scan.nextLine();
				customer.setEmail(email);
				System.out.println("Enter customer type: ");
				String type = scan.nextLine();
				customer.setType(type);
				System.out.println("Enter address: ");
				String address = scan.nextLine();
				customer.setAddress(address);
				System.out.println("Update successfully!");
				break;
			}
		}
		if(isExist == false)
			System.out.println("CustomerID is not exist!");
	}

	@Override
	public void delete() {
		
		
	}

}
