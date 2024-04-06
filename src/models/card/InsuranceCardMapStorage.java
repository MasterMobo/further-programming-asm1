package models.card;

import models.storage.MapStorage;
import models.storage.PrefixIdGenerator;
import models.storage.StorageCode;

public class InsuranceCardMapStorage extends MapStorage<InsuranceCard> implements InsuranceCardStorage {
    public InsuranceCardMapStorage() {
        super(new PrefixIdGenerator("", 10));
    }

    @Override
    public String getId() {
        return StorageCode.INSURANCE_CARDS;
    }
}
