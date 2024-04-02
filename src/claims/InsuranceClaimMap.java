package claims;

import id.IdMap;
import id.PrefixIdGenerator;

import java.util.List;

public class InsuranceClaimMap extends IdMap<InsuranceClaim> implements ClaimProcessManager{
    public InsuranceClaimMap() {
        super();
        idGenerator = new PrefixIdGenerator("f", 10);
    }

    @Override
    public InsuranceClaim getOne(String claimId) {
        return super.get(claimId);
    }

    @Override
    public List<InsuranceClaim> getAll() {
        return super.getAll();
    }

}
