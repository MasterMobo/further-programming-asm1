package models.customer.roles.holder;

import models.customer.roles.CustomerRoleStorage;

public interface PolicyHolderStorage extends CustomerRoleStorage<PolicyHolder> {
    public PolicyHolder getPolicyHolderOfDependent(String dependentId);
}
