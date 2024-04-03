package models.claims;

import models.id.IdManager;

public interface ClaimProcessManager extends IdManager<InsuranceClaim> {
    InsuranceClaim getOne(String claimId);
}
