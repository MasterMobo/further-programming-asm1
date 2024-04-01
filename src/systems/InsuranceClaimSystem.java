package systems;

import claims.ClaimProcessManager;
import claims.ClaimProcessor;
import claims.InsuranceClaim;
import customer.Customer;
import customer.CustomerManager;
import customer.CustomerMap;


public class InsuranceClaimSystem implements SystemOperations{
    // Highest class, entry point of the system

    private CustomerManager customerManager;
    private ClaimProcessManager claimProcessManager;    // delegation

    public InsuranceClaimSystem() {
        // Default implementation
        customerManager = new CustomerMap();
        claimProcessManager = new ClaimProcessor(customerManager);
    }

    public InsuranceClaimSystem(CustomerManager customerManager, ClaimProcessManager claimProcessManager) {
        // If you are using different implementations, put it here
        // Makes sure to adhere to the interfaces
        this.customerManager = customerManager;
        this.claimProcessManager = claimProcessManager;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerManager.add(customer);
    }

    @Override
    public InsuranceClaim addClaim(String customerId, InsuranceClaim claim) {
        return claimProcessManager.add(customerId, claim);
    }

    @Override
    public void displayCustomers() {
        System.out.println(customerManager.toString());
    }
}
