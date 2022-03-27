package models;

public class Employee extends Person{
	private String level;
	private String position;
	private int salary;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(int personalID, String name, String dOB, String gender, String cMND,
			String phoneNumber, String email, String level, String position, int salary) {
		super(personalID, name, dOB, gender, cMND, phoneNumber, email);
		this.level = level;
		this.position = position;
		this.salary = salary;
		// TODO Auto-generated constructor stub
	}
	public Employee(String level, String position, int salary) {
		super();
		this.level = level;
		this.position = position;
		this.salary = salary;
	}
	
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [ EmployeeID: " + getPersonalID() 
				+ ",\n Name: " + getName()
				+ ",\n DOB: " + getdOB()
				+ ",\n Gender: " + getGender()
				+ ",\n CMND: " + getcMND()
				+ ",\n Phone number: " + getPhoneNumber()
				+ ",\n Email: " + getEmail()
				+ ",\n Level: " + level 
				+ ",\n Position: " + position 
				+ ",\n Salary: " + salary 
				+ "]";
	}
	
	
	
}
