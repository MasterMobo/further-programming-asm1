package controllers.customers;

import controllers.customers.creators.PolicyHolderCreator;
import controllers.system.ControllerCode;
import models.customer.Customer;
import models.system.SystemStorageManager;
import views.system.SystemViewManager;
import views.general.customers.PolicyHolderView;

import java.util.Map;

public class PolicyHolderController extends CustomerController{
    public PolicyHolderController() {
        super();
    }

    public PolicyHolderController(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        super(systemStorageManager, systemViewManager);
    }

    @Override
    public Customer add() {
        PolicyHolderView policyHolderView = systemViewManager.getPolicyHolderView();
        Map<String, String> data = policyHolderView.displayAddForm();
        PolicyHolderCreator creator = new PolicyHolderCreator(systemStorageManager, systemViewManager);

        return executeOperator(creator, data, policyHolderView);
    }

    @Override
    public String getId() {
        return ControllerCode.POLICY_HOLDER;
    }
}
