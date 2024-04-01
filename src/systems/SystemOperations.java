package systems;

import claims.InsuranceClaim;
import customer.Customer;

public interface SystemOperations {
    Customer addCustomer(Customer customer);
    InsuranceClaim addClaim(String customerId, InsuranceClaim claim);
    void displayCustomers();
}
