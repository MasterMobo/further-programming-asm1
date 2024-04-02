package systems;

import customer.Customer;

import java.util.List;

public interface CustomerOperations {
    void add(Customer customer);
    Customer getCustomer(String customerId);
    List<Customer> getCustomer(); // get all customers
}
