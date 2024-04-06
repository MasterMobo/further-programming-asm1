package models.system;

import models.card.InsuranceCardStorage;
import models.claims.InsuranceClaimStorage;
import models.customer.CustomerStorageManager;
import models.storage.Storage;

public interface SystemStorageManager extends Storage<SystemStorable> {
    public CustomerStorageManager getCustomerStorageManager();
    public InsuranceClaimStorage getClaimStorage();
    public InsuranceCardStorage getCardStorage();
}
