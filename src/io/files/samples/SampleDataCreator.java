package io.files.samples;

import models.customer.roles.holder.PolicyHolder;
import models.customer.roles.holder.PolicyHolderMapStorage;
import models.customer.roles.holder.PolicyHolderStorage;
import models.system.SystemStorageManager;

public class SampleDataCreator {
    public static SystemStorageManager create() {


        return null;
    }

    private PolicyHolderStorage createPolicyHolders() {
        PolicyHolderStorage policyHolderStorage = new PolicyHolderMapStorage();


        return policyHolderStorage;
    }
}
