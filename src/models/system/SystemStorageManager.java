package models.system;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import models.card.InsuranceCardStorage;
import models.claims.InsuranceClaimStorage;
import models.customer.CustomerStorageManager;
import models.storage.Storage;

public interface SystemStorageManager extends Storage<SystemStorable> {
    CustomerStorageManager getCustomerStorageManager();
    InsuranceClaimStorage getClaimStorage();
    InsuranceCardStorage getCardStorage();
}
