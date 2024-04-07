package controllers.customers.policy_holder;

import controllers.ControllerOperator;
import models.customer.roles.holder.PolicyHolder;
import models.customer.roles.holder.PolicyHolderStorage;
import models.system.SystemStorageManager;
import views.system.SystemViewManager;

import java.util.List;
import java.util.Map;

public class PolicyHolderManyGetter extends ControllerOperator {
    public PolicyHolderManyGetter() {
        super();
    }

    public PolicyHolderManyGetter(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        super(systemStorageManager, systemViewManager);
    }

    @Override
    public List<PolicyHolder> execute(Map<String, String> data) {
        // Get all the PolicyHolders
        // No data is needed here
        PolicyHolderStorage policyHolders = systemStorageManager.getCustomerStorageManager().getPolicyHolderStorage();
        return policyHolders.getAll();
    }
}
