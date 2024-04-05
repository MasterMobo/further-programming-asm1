package models.system;

import models.card.InsuranceCardManager;
import models.claims.InsuranceClaimManager;
import models.customer.CustomerManager;

public interface SystemManager {
    public CustomerManager getCustomerManager();
    public InsuranceClaimManager getClaimManager();
    public InsuranceCardManager getCardManager();
}
