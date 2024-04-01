package claims;

import id.IdMap;

import java.util.List;

public class ClaimMap extends IdMap<InsuranceClaim> implements ClaimProcessManager{
    public ClaimMap() {
        super();
    }

    @Override
    public InsuranceClaim getOne(String claimId) {
        return super.get(claimId);
    }

    @Override
    public List<InsuranceClaim> getAll() {
        return super.getAll();
    }

    @Override
    public boolean exists(String id) {
        return super.exists(id);
    }
}
