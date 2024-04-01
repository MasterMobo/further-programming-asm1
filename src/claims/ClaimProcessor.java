package claims;

import customer.CustomerManager;

public class ClaimProcessor implements ClaimProcessManager{
    // This class processes all claims in the system

    private CustomerManager customerManager;

    public ClaimProcessor(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }

    @Override
    public InsuranceClaim add(String customerId, InsuranceClaim newClaim) {
        if (!customerManager.exists(customerId)) return null;
        if (!customerManager.hasInsuranceCard(customerId))  return null;

        return customerManager.addClaim(customerId, newClaim);
    }
}
