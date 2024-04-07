package io.files.decoders.storages;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import io.files.decoders.items.InsuranceClaimDecoder;
import models.claims.InsuranceClaim;
import models.claims.InsuranceClaimStorage;

public class ClaimStorageDecoder extends StorageDecoder<InsuranceClaimStorage, InsuranceClaim> {
    public ClaimStorageDecoder(InsuranceClaimStorage storage) {
        super(new InsuranceClaimDecoder(), storage);
    }
}
