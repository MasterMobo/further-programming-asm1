package controllers.customers.policy_holder;

import controllers.customers.CustomerController;
import controllers.customers.policy_holder.PolicyHolderCreator;
import controllers.customers.policy_holder.PolicyHolderManyGetter;
import controllers.customers.policy_holder.PolicyHolderSingleGetter;
import controllers.system.ControllerCode;
import models.customer.roles.holder.PolicyHolder;
import models.system.SystemStorageManager;
import views.system.SystemViewManager;
import views.general.customers.PolicyHolderView;

import java.util.List;
import java.util.Map;

public class PolicyHolderController extends CustomerController<PolicyHolder> {
    public PolicyHolderController() {
        super();
    }

    public PolicyHolderController(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        super(systemStorageManager, systemViewManager);
    }

    @Override
    public PolicyHolder add() {
        PolicyHolderView policyHolderView = systemViewManager.getPolicyHolderView();
        Map<String, String> data = policyHolderView.displayAddForm();
        PolicyHolderCreator creator = new PolicyHolderCreator(systemStorageManager, systemViewManager);

        return executeOperator(creator, data, policyHolderView);
    }

    @Override
    public String getId() {
        return ControllerCode.POLICY_HOLDER;
    }

    @Override
    public PolicyHolder get() {
        PolicyHolderView policyHolderView = systemViewManager.getPolicyHolderView();
        Map<String, String> data = policyHolderView.displayGetForm();
        PolicyHolderSingleGetter singleGetter = new PolicyHolderSingleGetter(systemStorageManager, systemViewManager);

        List<Object> res = singleGetter.execute(data);

        if (res.get(0) == null) return null;

        policyHolderView.displayWithDependents(res);

        return null;
    }

    @Override
    public List<PolicyHolder> getMany() {
        PolicyHolderView policyHolderView = systemViewManager.getPolicyHolderView();
        PolicyHolderManyGetter manyGetter = new PolicyHolderManyGetter(systemStorageManager, systemViewManager);

        List<PolicyHolder> res = manyGetter.execute(null);
        policyHolderView.displayMany(res);

        return res;
    }

    @Override
    public PolicyHolder delete() {
        PolicyHolderView policyHolderView = systemViewManager.getPolicyHolderView();
        Map<String, String> data = policyHolderView.displayDeleteForm();
        PolicyHolderDeleter deleter = new PolicyHolderDeleter(systemStorageManager, systemViewManager);

        return executeOperator(deleter, data, policyHolderView);
    }
}
