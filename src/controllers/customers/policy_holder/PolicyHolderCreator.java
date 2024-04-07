package controllers.customers.policy_holder;

import controllers.ControllerOperator;
import models.customer.CustomerStorageManager;
import models.customer.roles.holder.PolicyHolder;
import models.customer.roles.holder.PolicyHolderStorage;
import models.system.SystemStorageManager;
import views.system.SystemViewManager;
import views.general.customers.CustomerView;

import java.util.Map;

public class PolicyHolderCreator extends ControllerOperator {

    public PolicyHolderCreator() {
        super();
    }

    public PolicyHolderCreator(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        super(systemStorageManager, systemViewManager);
    }

    @Override
    public PolicyHolder execute(Map<String, String> data) {
        CustomerStorageManager customerStorageManager = systemStorageManager.getCustomerStorageManager();

        String id = customerStorageManager.generateAndAddId();
        String fullName = data.get(CustomerView.CUSTOMER_NAME);

        PolicyHolder newHolder = new PolicyHolder(id, fullName);
        PolicyHolderStorage policyHolders = customerStorageManager.getPolicyHolderStorage();

        return policyHolders.add(newHolder);
    }
}
