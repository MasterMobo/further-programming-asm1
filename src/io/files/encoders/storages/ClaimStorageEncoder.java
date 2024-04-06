package io.files.encoders.storages;

import io.files.encoders.items.InsuranceClaimEncoder;
import models.claims.InsuranceClaim;
import models.claims.InsuranceClaimStorage;

public class ClaimStorageEncoder extends StorageEncoder<InsuranceClaimStorage, InsuranceClaim> {
    public ClaimStorageEncoder() {
        super(new InsuranceClaimEncoder());
    }
}
