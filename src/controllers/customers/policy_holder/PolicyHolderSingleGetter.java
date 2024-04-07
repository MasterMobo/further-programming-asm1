package controllers.customers.policy_holder;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import controllers.ControllerOperator;
import models.customer.roles.dependent.Dependent;
import models.customer.roles.dependent.DependentStorage;
import models.customer.roles.holder.PolicyHolder;
import models.customer.roles.holder.PolicyHolderStorage;
import models.system.SystemStorageManager;
import views.general.MessageView;
import views.general.customers.PolicyHolderView;
import views.system.SystemViewManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PolicyHolderSingleGetter extends ControllerOperator {
    public PolicyHolderSingleGetter() {
        super();
    }

    public PolicyHolderSingleGetter(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        super(systemStorageManager, systemViewManager);
    }

    @Override
    public List<Object> execute(Map<String, String> data) {
        // First element is the policy holder
        // Second element is the dependents
        List<Object> res = new ArrayList<>(2);
        res.add(null);
        res.add(new ArrayList<>());

        MessageView message = systemViewManager.getMessageView();
        String id = data.get(PolicyHolderView.CUSTOMER_ID);

        // Check if exists
        PolicyHolderStorage policyHolders = systemStorageManager.getCustomerStorageManager().getPolicyHolderStorage();
        if (!policyHolders.exists(id)) {
            message.displayError("Policy Holder does not exist");
        }

        // Get the policyholder
        PolicyHolder policyHolder = policyHolders.get(id);
        res.set(0, policyHolder);
        if (policyHolder.getDependentIds().size() == 0) {
            return res;
        }

        // Get dependents
        DependentStorage dependents = systemStorageManager.getCustomerStorageManager().getDependentStorage();
        List<Dependent> dependentRes = new ArrayList<>();
        for (String dependentId: policyHolder.getDependentIds()) {
            dependentRes.add(dependents.get(dependentId));
        }
        res.set(1, dependentRes);

        return res;
    }
}
