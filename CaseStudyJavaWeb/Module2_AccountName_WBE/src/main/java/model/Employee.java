package model;

public class Employee extends Person{
    private double salary;
    private int position;
    private int educationDegree;
    private int division;
    private String username;

    public Employee() {
    }

    public Employee(int personalID) {
        super(personalID);
    }

    public Employee(int personalID,
                    String name,
                    String dOB,
                    boolean gender,
                    String idCard,
                    String phoneNumber,
                    String email,
                    String address,
                    double salary,
                    int position,
                    int educationDegree,
                    int division,
                    String username) {
        super(personalID, name, dOB, gender, idCard, phoneNumber, email, address);
        this.salary = salary;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.username = username;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(int educationDegree) {
        this.educationDegree = educationDegree;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
