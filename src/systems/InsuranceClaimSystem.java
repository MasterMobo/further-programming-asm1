package systems;

import card.InsuranceCard;
import card.InsuranceCardManager;
import card.InsuranceCardMap;
import claims.ClaimMap;
import claims.ClaimProcessManager;
import claims.InsuranceClaim;
import customer.Customer;
import customer.CustomerManager;
import customer.CustomerMap;

import java.util.List;


public class InsuranceClaimSystem implements SystemOperations{
    // Highest class, entry point of the system

    private CustomerManager customerManager;
    private InsuranceCardManager insuranceCardManager;
    private ClaimProcessManager claimProcessManager;    // delegation

    public InsuranceClaimSystem() {
        // Default implementations
        customerManager = new CustomerMap();
        insuranceCardManager = new InsuranceCardMap();
        claimProcessManager = new ClaimMap();
    }

    public InsuranceClaimSystem(CustomerManager customerManager, InsuranceCardManager insuranceCardManager, ClaimProcessManager claimProcessManager) {
        // If you are using different implementations, put it here
        // Makes sure to adhere to the interfaces

        this.customerManager = customerManager;
        this.insuranceCardManager = insuranceCardManager;
        this.claimProcessManager = claimProcessManager;
    }

    @Override
    public void add(Customer customer) {
        customerManager.add(customer);
    }

    @Override
    public void add(InsuranceCard card) {
        insuranceCardManager.add(card);
    }

    @Override
    public InsuranceCard getInsuranceCard(String cardNum) {
        return insuranceCardManager.get(cardNum);
    }

    @Override
    public List<InsuranceCard> getAllInsuranceCards() {
        return insuranceCardManager.getAll();
    }

    @Override
    public void add(InsuranceClaim claim) {

    }

    @Override
    public Customer getCustomer(String customerId) {
        return customerManager.get(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerManager.getAll();
    }

}