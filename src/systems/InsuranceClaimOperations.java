package systems;

import claims.InsuranceClaim;

import java.util.List;

public interface InsuranceClaimOperations {
    void add(InsuranceClaim claim);
    InsuranceClaim getInsuranceClaim(String id);
    List<InsuranceClaim> getInsuranceClaim();
    void deleteInsuranceClaim(String id);
    void updateInsuranceClaim(String id, InsuranceClaim newClaim);
}
