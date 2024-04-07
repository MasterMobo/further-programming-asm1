package models.card;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import models.storage.MapStorage;
import models.storage.PrefixIdGenerator;
import models.system.StorageCode;

public class InsuranceCardMapStorage extends MapStorage<InsuranceCard> implements InsuranceCardStorage {
    public InsuranceCardMapStorage() {
        super(new PrefixIdGenerator("", 10));
    }

    @Override
    public String getId() {
        return StorageCode.INSURANCE_CARDS;
    }
}
