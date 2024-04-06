package models.claims;

import models.storage.MapStorage;
import models.storage.PrefixIdGenerator;
import models.storage.StorageCode;

public class InsuranceClaimMapStorage extends MapStorage<InsuranceClaim> implements InsuranceClaimStorage {
    public InsuranceClaimMapStorage() {
        super(new PrefixIdGenerator("f", 10));
    }

    @Override
    public InsuranceClaim getOne(String claimId) {
        return super.get(claimId);
    }

    @Override
    public String getId() {
        return StorageCode.INSURANCE_CLAIMS;
    }
}
