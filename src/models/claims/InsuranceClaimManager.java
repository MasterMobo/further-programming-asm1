package models.claims;

import models.id.IdManager;

public interface InsuranceClaimManager extends IdManager<InsuranceClaim> {
    InsuranceClaim getOne(String claimId);
}
