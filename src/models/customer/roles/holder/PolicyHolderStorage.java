package models.customer.roles.holder;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import models.customer.roles.CustomerRoleStorage;

public interface PolicyHolderStorage extends CustomerRoleStorage<PolicyHolder> {
    PolicyHolder getPolicyHolderOfDependent(String dependentId);
}
