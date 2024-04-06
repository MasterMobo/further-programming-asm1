package models.claims;

import models.storage.MapStorage;
import models.storage.PrefixIdGenerator;
import models.storage.StorageCode;

import java.util.ArrayList;
import java.util.List;

public class InsuranceClaimMapStorage extends MapStorage<InsuranceClaim> implements InsuranceClaimStorage {
    public InsuranceClaimMapStorage() {
        super(new PrefixIdGenerator("f", 10));
    }

    @Override
    public InsuranceClaim getOne(String claimId) {
        return super.get(claimId);
    }

    @Override
    public List<InsuranceClaim> getClaimsOfCustomer(String customerId) {
        List<InsuranceClaim> res = new ArrayList<>();

        for (InsuranceClaim claim: getAll()) {
            if (claim.getInsuredPersonId().equals(customerId)) {
                res.add(claim);
            }
        }

        return res;
    }

    @Override
    public String getId() {
        return StorageCode.INSURANCE_CLAIMS;
    }
}
