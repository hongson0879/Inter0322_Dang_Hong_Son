package service;

import model.Customer;
import repository.CustomerRepository;

import java.util.List;

public interface CustomerService extends PersonService {
    public List<Customer> getCustomerList();
    public void addCustomer(Customer customer);
    public void removeCustomer(Customer customer);
    public void updateCustomer(Customer customerSearch, Customer newCustomer);
}
