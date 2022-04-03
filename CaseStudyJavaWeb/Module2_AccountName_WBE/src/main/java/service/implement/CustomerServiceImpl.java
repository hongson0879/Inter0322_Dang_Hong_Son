package service.implement;

import model.Customer;
import repository.CustomerRepository;
import service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> getCustomerList() {
        return customerRepository.getCustomerList();
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
    }

    @Override
    public void removeCustomer(Customer customer) {
        customerRepository.removeCustomer(customer);
    }

    @Override
    public void updateCustomer(Customer customerSearch, Customer newCustomer) {
        customerRepository.updateCustomer(customerSearch, newCustomer);
    }


}
