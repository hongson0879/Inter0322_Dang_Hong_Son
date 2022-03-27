package controllers;

import java.util.Scanner;

import services.impl.CustomerServiceImpl;
import services.impl.EmployeeServiceImpl;
import services.impl.FacilityServiceImpl;

public class FuramaController {
	public static void main(String args[]) {
		displayMainMenu();
	}
	public static void displayMainMenu() {
		boolean check = true;
		Scanner scan = new Scanner(System.in);
		while (check){
			System.out.println("1. Employee Management");
			System.out.println("2. Customer Management");
			System.out.println("3. Facility Management");
			System.out.println("4. Booking Managerment");
			System.out.println("5. Promotion Management");
			System.out.println("6. Exit");
			System.out.print("Please choose a menu: ");
			int menuNumber = 0;
			try {
				menuNumber = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("You entered the wrong format, please enter it again: ");
			}
			switch (menuNumber) {
				case 1: {
					displayEmployeeMenu();
					break;
				}
				case 2: {
					displayCustomerMenu();
					break;
				}
				case 3: {
					displayFacilityMenu();
					break;
				}
				case 4: {
					//displayBookingMenu();
					break;
				}
				case 5: {
					//displayPromotionMenu();
					break;
				}
				case 6: {
					check = false;
					break;
				}
			}
		}
	}
	
	//menu 1: display Employee Management menu
	public static void displayEmployeeMenu() {
		EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
		Scanner scan = new Scanner(System.in);
		boolean subCheck = true;
		while (subCheck){
			System.out.println("1. Display list employees");
			System.out.println("2. Add new employee");
			System.out.println("3. Edit employee");
			System.out.println("4. Return main menu");
			System.out.print("Please choose a function: ");
			int functionNumber = 0;
			try {
				functionNumber = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("You entered the wrong format, please enter it again: ");
			}
			switch (functionNumber) {
			case 1: {
				employeeService.display();
				break;
			}
			case 2: {
				employeeService.addNew();
				break;
			}
			case 3: {
				employeeService.edit();
				break;
			}
			case 4: {
				return;
			}
			default:
				System.out.println("The selected function is not valid!");
			}
		}
	}
	
	//menu 2: display Customer Management menu
	public static void displayCustomerMenu() {
		Scanner scan = new Scanner(System.in);
		CustomerServiceImpl customerService = new CustomerServiceImpl();
		boolean subCheck = true;
		while (subCheck){
			System.out.println("1. Display list customers");
			System.out.println("2. Add new customers");
			System.out.println("3. Edit customers");
			System.out.println("4. Return main menu");
			System.out.print("Please choose a function: ");
			int functionNumber = 0;
			try {
				functionNumber = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("You entered the wrong format, please enter it again: ");
			}
			switch (functionNumber) {
			case 1: {
				customerService.display();
				break;
			}
			case 2: {
				customerService.addNew();
				break;
			}
			case 3: {
				customerService.edit();
				break;
			}
			case 4: {
				return;
			}
			default:
				System.out.println("The selected function is not valid!");
			}
		}
	}
	
	//menu 3: display Facility Management menu
	public static void displayFacilityMenu() {
		FacilityServiceImpl facilityService = new FacilityServiceImpl();
		Scanner scan = new Scanner(System.in);
		boolean subCheck = true;
		while (subCheck){
			System.out.println("1. Display list facility");
			System.out.println("2. Add new facility");
			System.out.println("3. Display list facility maintenance");
			System.out.println("4. Return main menu");
			System.out.print("Please choose a function: ");
			int functionNumber = 0;
			try {
				functionNumber = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("You entered the wrong format, please enter it again: ");
			}
			switch (functionNumber) {
				case 1: {
					facilityService.display();
					break;
				}
				case 2: {
					addNewFacilityMenu();
					break;
				}
				case 3:{
					facilityService.displayMaintain();
				}
				case 4:{
					return;
				}
				default:
					System.out.println("The selected function is not valid!");
			}
			
		}
	}
	
//	//menu 4: display Booking Management menu
//	public static void displayBookingMenu() {
//		Scanner scan = new Scanner(System.in);
//		boolean subCheck = true;
//		while (subCheck){
//			System.out.println("1. Add new booking");
//			System.out.println("2. Display list booking");
//			System.out.println("3. Create new constracts");
//			System.out.println("4. Display list contracts");
//			System.out.println("5. Edit contracts");
//			System.out.println("6. Return main menu");
//			System.out.print("Please choose a function: ");
//			int functionNumber = scan.nextInt();
//			scan.nextLine();
//			
//		}
//	}
//	
//	//menu 5: display Promotion Management menu
//	public static void displayPromotionMenu() {
//		Scanner scan = new Scanner(System.in);
//		boolean subCheck = true;
//		while (subCheck){
//			System.out.println("1. Display list customers use service");
//			System.out.println("2. Display list customers get voucher");
//			System.out.println("3. Return main menu");
//			System.out.print("Please choose a function: ");
//			int functionNumber = scan.nextInt();
//			scan.nextLine();
//			
//		}
//	}
	
	// submenu 3: display addNewFacilityMenu
	public static void addNewFacilityMenu() {
		FacilityServiceImpl facilityService = new FacilityServiceImpl();
		Scanner scan = new Scanner(System.in);
		boolean subCheck = true;
		while (subCheck){
			System.out.println("1. Add new villa");
			System.out.println("2. Add new house");
			System.out.println("3. Add new room");
			System.out.println("4. Return Facility Management menu");
			System.out.print("Please choose a function: ");
			int functionNumber = 0;
			try {
				functionNumber = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("You entered the wrong format, please enter it again: ");
			}
			switch (functionNumber) {
				case 1:{
					facilityService.addNewVilla();
					break;
				}
				case 2:{
					facilityService.addNewHouse();
					break;
				}
				case 3:{
					facilityService.addNewRoom();
					break;
				}
				case 4:{
					return;
				}
				default:
					System.out.println("The selected function is not valid!");
			}
		}
	}
}
