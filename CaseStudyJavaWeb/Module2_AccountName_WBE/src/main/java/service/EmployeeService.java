package service;

import model.Employee;

import java.util.List;

public interface EmployeeService extends PersonService {
    public List<Employee> getEmployeeList();
    public void addEmployee(Employee employee);
    public void removeEmployee(Employee employee);
    public void updateEmployee(Employee employeeSearch, Employee newEmployee);
}
