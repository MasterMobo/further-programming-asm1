package models.claims;

import models.storage.Storage;
import models.storage.StorageItem;
import models.system.SystemStorable;

import java.util.List;

public interface InsuranceClaimStorage extends Storage<InsuranceClaim>, SystemStorable {
    InsuranceClaim getOne(String claimId);
    List<InsuranceClaim> getClaimsOfCustomer(String customerId);
}
