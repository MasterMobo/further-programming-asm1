package models.customer.roles.holder;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import models.customer.roles.CustomerRoleMapStorage;
import models.system.StorageCode;

public class PolicyHolderMapStorage extends CustomerRoleMapStorage<PolicyHolder> implements PolicyHolderStorage {
    public PolicyHolderMapStorage() {
        super();
    }

    @Override
    public String getId() {
        return StorageCode.POLICY_HOLDERS;
    }

    @Override
    public PolicyHolder getPolicyHolderOfDependent(String dependentId) {
        for (PolicyHolder policyHolder: getAll()) {
            if (policyHolder.getDependentIds().contains(dependentId)) {
                return policyHolder;
            }
        }
        return null;
    }
}
