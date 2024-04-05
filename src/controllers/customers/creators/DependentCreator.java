package controllers.customers.creators;

import models.customer.Customer;
import models.customer.CustomerManager;
import models.customer.CustomerRoleCode;
import models.customer.dependent.Dependent;
import models.customer.dependent.DependentManager;
import models.customer.holder.PolicyHolder;
import models.customer.holder.PolicyHolderManager;
import models.system.SystemManager;
import views.general.MessageView;
import views.general.SystemView;
import views.general.customers.CustomerView;
import views.general.customers.DependentView;

import java.util.Map;

public class DependentCreator extends CustomerCreator{

    public DependentCreator() {
        super();
    }

    public DependentCreator(SystemManager systemManager, SystemView systemView) {
        super(systemManager, systemView);
    }

    @Override
    public Customer create(Map<String, String> data) {
        MessageView messageView = systemView.getMessageView();

        // Get the managers
        CustomerManager customerManager = systemManager.getCustomerManager();
        PolicyHolderManager policyHolders = (PolicyHolderManager) customerManager.getManager(CustomerRoleCode.POLICYHOLDER);
        DependentManager dependents = (DependentManager) customerManager.getManager(CustomerRoleCode.DEPENDENT);

        String dependsOn = data.get(DependentView.DEPENDS_ON);

        // Check if policy-holder ID is valid
        if (!policyHolders.exists(dependsOn)){
            messageView.displayError("Policy Holder does not exist. Customer creation failed.");
            return null;
        }

        String id = customerManager.generateAndAddId();
        String fullName = data.get(CustomerView.CUSTOMER_NAME);

        // Add dependent to policy holder
        PolicyHolder holder =  policyHolders.get(dependsOn);
        holder.addDependent(id);

        Dependent newDependent = new Dependent(id, fullName);

        return dependents.add(newDependent);
    }
}
