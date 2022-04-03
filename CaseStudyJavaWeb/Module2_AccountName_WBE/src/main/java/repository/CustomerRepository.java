package repository;

import model.Customer;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class CustomerRepository {
    BaseRepository baseRepository = new BaseRepository();
    Connection connection = this.baseRepository.getConnection();

    public List<Customer> getCustomerList(){
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from customer");
            Customer customer;
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int customerID = resultSet.getInt("customer_id");
                String name = resultSet.getString("customer_name");
                String dOB = resultSet.getString("customer_birthday");
                boolean gender = resultSet.getBoolean("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phoneNumber = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                int type = resultSet.getInt("customer_type_id");
                customer = new Customer(customerID, name, dOB, gender, idCard, phoneNumber, email, address, type);
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    public void addCustomer(Customer customer){
        try {
            String sql = "Insert into customer values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, customer.getPersonalID());
            preparedStatement.setInt(2, customer.getType());
            preparedStatement.setString(3, customer.getName());
            preparedStatement.setDate(4, Date.valueOf(customer.getdOB()));
            preparedStatement.setBoolean(5, customer.getGender());
            preparedStatement.setString(6, customer.getIdCard());
            preparedStatement.setString(7, customer.getPhoneNumber());
            preparedStatement.setString(8, customer.getEmail());
            preparedStatement.setString(9, customer.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeCustomer(Customer customer){
        String sql = "Delete from customer where customer_id = (?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, customer.getPersonalID());
            int result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateCustomer(Customer customerSearch, Customer newCustomer){
        String sql = "Update customer set customer_id = (?)," +
                " customer_type_id = (?)," +
                " customer_name = (?)," +
                " customer_birthday = (?)," +
                " customer_gender = (?)," +
                " customer_id_card = (?)," +
                " customer_phone = (?)," +
                " customer_email = (?)," +
                " customer_address = (?)" +
                " where customer_id = (?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, newCustomer.getPersonalID());
            preparedStatement.setInt(2, newCustomer.getType());
            preparedStatement.setString(3, newCustomer.getName());
            preparedStatement.setDate(4, Date.valueOf(newCustomer.getdOB()));
            preparedStatement.setBoolean(5, newCustomer.getGender());
            preparedStatement.setString(6, newCustomer.getIdCard());
            preparedStatement.setString(7, newCustomer.getPhoneNumber());
            preparedStatement.setString(8, newCustomer.getEmail());
            preparedStatement.setString(9, newCustomer.getAddress());
            preparedStatement.setInt(10, customerSearch.getPersonalID());
            int result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
