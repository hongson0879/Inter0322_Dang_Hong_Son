package services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import services.EmployeeService;
import utils.ReadWriteFile;
import utils.RegexData;
import models.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	private static List<Employee> employeeList = new ArrayList<>();
	private static Scanner scan = new Scanner(System.in);
	private static final String REGEX_BIRTHDAY = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";
	
	@Override
	public void display() {
		employeeList = (List<Employee>) ReadWriteFile.read("C:\\Users\\dangh\\Desktop\\Intern CodeGym\\Submit"
				+ "\\Inter0322_Dang_Hong_Son\\ss02_java\\furamaResort\\src\\data\\employee.csv");
		for(Employee employee : employeeList) {
			System.out.println(employee.toString());
		}
	}

	@Override
	public void addNew() {
		System.out.println("Enter employee ID: ");
		int employeeID = Integer.parseInt(scan.nextLine());
		System.out.println("Enter name: ");
		String name = scan.nextLine();
		System.out.println("Enter date of birth: ");
		String dOB = RegexData.regexAge(scan.nextLine(), REGEX_BIRTHDAY);
		System.out.println("Enter gender: ");
		String gender = scan.nextLine();
		System.out.println("Enter CMND: ");
		String cMND = scan.nextLine();
		System.out.println("Enter phone number: ");
		String phoneNumber = scan.nextLine();
		System.out.println("Enter email: ");
		String email = scan.nextLine();
		System.out.println("Enter level: ");
		String level = scan.nextLine();
		System.out.println("Enter position: ");
		String position = scan.nextLine();
		System.out.println("Enter salary: ");
		int salary = Integer.parseInt(scan.nextLine());
		Employee employee = new Employee(employeeID, name, dOB, gender, cMND, phoneNumber, 
										email, level, position, salary);
		employeeList.add(employee);
		System.out.println("Add employee successfully!");
		ReadWriteFile.write(employeeList, "C:\\Users\\dangh\\Desktop\\Intern CodeGym\\Submit"
				+ "\\Inter0322_Dang_Hong_Son\\ss02_java\\furamaResort\\src\\data\\employee.csv");
	}

	@Override
	public void edit() {
		System.out.println("Enter EmployeeID you want to update: ");
		int searchID = Integer.parseInt(scan.nextLine());
		boolean isExist = false;
		for (Employee employee : employeeList) {
			if(employee.getPersonalID() == searchID) {
				isExist = true;
				System.out.println("Enter new information: ");	
				System.out.println("Enter employee ID: ");
				boolean check;
				do {
					check = true;
					int employeeID = Integer.parseInt(scan.nextLine());
					if(employeeID != searchID) {	
						for(Employee employee2 : employeeList) {
							if(employee2.getPersonalID() == employeeID) {
								check = false;
								System.out.println("This ID is exist, enter EmployeeID again: ");
								break;
							}
						}
					}
					if(check == true || employeeID == searchID) {
						employee.setPersonalID(employeeID);
						break;
					}
				} while (check == false);
				System.out.println("Enter name: ");
				String name = scan.nextLine();
				employee.setName(name);
				System.out.println("Enter date of birth: ");
				String dOB = scan.nextLine();
				employee.setdOB(dOB);
				System.out.println("Enter gender: ");
				String gender = scan.nextLine();
				employee.setGender(gender);
				System.out.println("Enter CMND: ");
				String cMND = scan.nextLine();
				employee.setcMND(cMND);
				System.out.println("Enter phone number: ");
				String phoneNumber = scan.nextLine();
				employee.setPhoneNumber(phoneNumber);
				System.out.println("Enter email: ");
				String email = scan.nextLine();
				employee.setEmail(email);
				System.out.println("Enter level: ");
				String level = scan.nextLine();
				employee.setLevel(level);
				System.out.println("Enter position: ");
				String position = scan.nextLine();
				employee.setPosition(position);
				System.out.println("Enter salary: ");
				int salary = Integer.parseInt(scan.nextLine());
				employee.setSalary(salary);
				System.out.println("Update successfully!");
				break;
			}
		}
		if(isExist == false)
			System.out.println("EmployeeID is not exist!");
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}
