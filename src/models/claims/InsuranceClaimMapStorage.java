package models.claims;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import models.storage.MapStorage;
import models.storage.PrefixIdGenerator;
import models.system.StorageCode;

import java.util.ArrayList;
import java.util.List;

public class InsuranceClaimMapStorage extends MapStorage<InsuranceClaim> implements InsuranceClaimStorage {
    public InsuranceClaimMapStorage() {
        super(new PrefixIdGenerator("f", 10));
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
