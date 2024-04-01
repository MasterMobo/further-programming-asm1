package claims;

import java.util.List;

public interface ClaimProcessManager {
    InsuranceClaim getOne(String claimId);
    List<InsuranceClaim> getAll();
    void add(InsuranceClaim newClaim);
}
