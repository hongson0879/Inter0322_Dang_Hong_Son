package repository;

import model.Customer;
import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    BaseRepository baseRepository = new BaseRepository();
    Connection connection = this.baseRepository.getConnection();

    public List<Employee> getEmployeeList(){
        List<Employee> employeeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from employee");
            Employee employee;
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int employeeID = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                String dOB = resultSet.getString("employee_birthday");
                boolean gender = resultSet.getBoolean("employee_gender");
                String idCard = resultSet.getString("employee_id_card");
                double salary = resultSet.getDouble("employee_salary");
                String phoneNumber = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                int position = resultSet.getInt("position_id");
                int educationDegree = resultSet.getInt("education_degree_id");
                int division = resultSet.getInt("division_id");
                String username = resultSet.getString("username");
                employee = new Employee(employeeID, name, dOB, gender,
                        idCard, phoneNumber, email, address,
                        salary, position, educationDegree, division, username);
                employeeList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    public void addEmployee(Employee employee){
        try {
            String sql = "Insert into employee values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employee.getPersonalID());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setDate(3, Date.valueOf(employee.getdOB()));
            preparedStatement.setBoolean(4, employee.getGender());
            preparedStatement.setString(5, employee.getIdCard());
            preparedStatement.setDouble(6, employee.getSalary());
            preparedStatement.setString(7, employee.getPhoneNumber());
            preparedStatement.setString(8, employee.getEmail());
            preparedStatement.setString(9, employee.getAddress());
            preparedStatement.setInt(10, employee.getPosition());
            preparedStatement.setInt(11, employee.getEducationDegree());
            preparedStatement.setInt(12, employee.getDivision());
            preparedStatement.setString(13, employee.getUsername());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeEmployee(Employee employee){
        String sql = "Delete from employee where employee_id = (?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employee.getPersonalID());
            int result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateEmployee(Employee employeeSearch, Employee newEmployee){
        String sql = "Update employee set employee_id = (?)," +
                " employee_name = (?)," +
                " employee_birthday = (?)," +
                " employee_gender = (?)," +
                " employee_id_card = (?)," +
                " employee_salary = (?)," +
                " employee_phone = (?)," +
                " employee_email = (?)," +
                " employee_address = (?)," +
                " position_id = (?)," +
                " education_degree_id = (?)," +
                " division_id = (?)," +
                " username = (?)" +
                " where employee_id = (?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, newEmployee.getPersonalID());
            preparedStatement.setString(2, newEmployee.getName());
            preparedStatement.setDate(3, Date.valueOf(newEmployee.getdOB()));
            preparedStatement.setBoolean(4, newEmployee.getGender());
            preparedStatement.setString(5, newEmployee.getIdCard());
            preparedStatement.setDouble(6, newEmployee.getSalary());
            preparedStatement.setString(7, newEmployee.getPhoneNumber());
            preparedStatement.setString(8, newEmployee.getEmail());
            preparedStatement.setString(9, newEmployee.getAddress());
            preparedStatement.setInt(10, newEmployee.getPosition());
            preparedStatement.setInt(11, newEmployee.getEducationDegree());
            preparedStatement.setInt(12, newEmployee.getDivision());
            preparedStatement.setString(13, newEmployee.getUsername());
            preparedStatement.setInt(14, employeeSearch.getPersonalID());
            int result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
