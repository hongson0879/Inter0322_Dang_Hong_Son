package service.implement;

import model.Employee;
import repository.EmployeeRepository;
import service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();
    @Override
    public List<Employee> getEmployeeList() {
        return employeeRepository.getEmployeeList();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }

    @Override
    public void removeEmployee(Employee employee) {
        employeeRepository.removeEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employeeSearch, Employee newEmployee) {
        employeeRepository.updateEmployee(employeeSearch, newEmployee);
    }
}
