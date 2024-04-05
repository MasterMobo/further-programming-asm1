package controllers.customers.creators;

import models.customer.Customer;
import models.customer.CustomerManager;
import models.customer.CustomerRoleCode;
import models.customer.holder.PolicyHolder;
import models.customer.holder.PolicyHolderManager;
import models.system.SystemManager;
import views.general.SystemView;
import views.general.customers.CustomerView;

import java.util.Map;

public class PolicyHolderCreator extends CustomerCreator{

    public PolicyHolderCreator() {
        super();
    }

    public PolicyHolderCreator(SystemManager systemManager, SystemView systemView) {
        super(systemManager, systemView);
    }

    @Override
    public Customer create(Map<String, String> data) {
        CustomerManager customerManager = systemManager.getCustomerManager();

        String id = customerManager.generateAndAddId();
        String fullName = data.get(CustomerView.CUSTOMER_NAME);

        PolicyHolder newHolder = new PolicyHolder(id, fullName);
        PolicyHolderManager policyHolders = (PolicyHolderManager) customerManager.getManager(CustomerRoleCode.POLICYHOLDER);

        return policyHolders.add(newHolder);
    }
}
