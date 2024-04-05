package models.system;

import models.card.InsuranceCardManager;
import models.claims.InsuranceClaimManager;
import models.customer.CustomerManager;

// TODO: FIND A BETTER NAME!!!
public class ManagerSet implements SystemManager{
    private CustomerManager customerManager;
    private InsuranceClaimManager claimManager;
    private InsuranceCardManager cardManager;

    public ManagerSet() {
        customerManager = null;
        claimManager = null;
        cardManager = null;
    }

    public ManagerSet(CustomerManager customerManager, InsuranceClaimManager claimManager, InsuranceCardManager cardManager) {
        this.customerManager = customerManager;
        this.claimManager = claimManager;
        this.cardManager = cardManager;
    }

    @Override
    public CustomerManager getCustomerManager() {
        return customerManager;
    }

    @Override
    public InsuranceClaimManager getClaimManager() {
        return claimManager;
    }

    @Override
    public InsuranceCardManager getCardManager() {
        return cardManager;
    }
}
