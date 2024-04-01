package customer;

import java.util.List;

public interface CustomerManager {
    // This interface deals with all the customers in the system

    boolean exists(String customerId);
    Customer get(String customerId);
    List<Customer> getAll();
    void add(Customer customer);
}
