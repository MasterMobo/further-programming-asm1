package models.claims;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import models.storage.Storage;
import models.storage.StorageItem;
import models.system.SystemStorable;

import java.util.List;

public interface InsuranceClaimStorage extends Storage<InsuranceClaim>, SystemStorable {
    List<InsuranceClaim> getClaimsOfCustomer(String customerId);
}
