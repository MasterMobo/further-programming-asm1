package models.claims;

import models.id.IdMap;
import models.id.PrefixIdGenerator;

public class InsuranceClaimMap extends IdMap<InsuranceClaim> implements InsuranceClaimManager {
    public InsuranceClaimMap() {
        super(new PrefixIdGenerator("f", 10));
    }

    @Override
    public InsuranceClaim getOne(String claimId) {
        return super.get(claimId);
    }
}
