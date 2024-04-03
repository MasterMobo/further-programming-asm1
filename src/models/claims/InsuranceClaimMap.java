package models.claims;

import models.id.IdGenerator;
import models.id.IdMap;
import models.id.PrefixIdGenerator;

import java.util.List;

public class InsuranceClaimMap extends IdMap<InsuranceClaim> implements ClaimProcessManager{
    public InsuranceClaimMap() {
        super(new PrefixIdGenerator("f", 10));
    }

    @Override
    public InsuranceClaim getOne(String claimId) {
        return super.get(claimId);
    }
}
