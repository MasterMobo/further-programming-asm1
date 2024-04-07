package models.system;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import models.card.InsuranceCardStorage;
import models.claims.InsuranceClaimStorage;
import models.customer.CustomerStorageManager;
import models.storage.MapStorage;

public class SystemMapStorage extends MapStorage<SystemStorable> implements SystemStorageManager {
    public SystemMapStorage() {
        super();
    }

    @Override
    public CustomerStorageManager getCustomerStorageManager() {
        return (CustomerStorageManager) get(StorageCode.CUSTOMERS);
    }

    @Override
    public InsuranceClaimStorage getClaimStorage() {
        return (InsuranceClaimStorage) get(StorageCode.INSURANCE_CLAIMS);
    }

    @Override
    public InsuranceCardStorage getCardStorage() {
        return (InsuranceCardStorage) get(StorageCode.INSURANCE_CARDS);
    }
}
