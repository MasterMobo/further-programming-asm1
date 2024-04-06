package models.system;

import models.card.InsuranceCardStorage;
import models.claims.InsuranceClaimStorage;
import models.customer.CustomerStorageManager;
import models.storage.MapStorage;
import models.storage.StorageCode;

public class SystemStorageMap extends MapStorage<SystemStorable> implements SystemStorageManager {
    public SystemStorageMap() {
        super();
    }


    @Override
    public CustomerStorageManager getCustomerManager() {
        return (CustomerStorageManager) get(StorageCode.CUSTOMERS);
    }

    @Override
    public InsuranceClaimStorage getClaimManager() {
        return (InsuranceClaimStorage) get(StorageCode.INSURANCE_CLAIMS);
    }

    @Override
    public InsuranceCardStorage getCardManager() {
        return (InsuranceCardStorage) get(StorageCode.INSURANCE_CARDS);
    }
}
