package controllers.customers.creators;

import models.customer.Customer;
import models.customer.CustomerStorageManager;
import models.customer.roles.dependent.Dependent;
import models.customer.roles.dependent.DependentStorage;
import models.customer.roles.holder.PolicyHolder;
import models.customer.roles.holder.PolicyHolderStorage;
import models.system.SystemStorageManager;
import views.general.MessageView;
import views.general.SystemView;
import views.general.customers.CustomerView;
import views.general.customers.DependentView;

import java.util.Map;

public class DependentCreator extends CustomerCreator{

    public DependentCreator() {
        super();
    }

    public DependentCreator(SystemStorageManager systemStorageManager, SystemView systemView) {
        super(systemStorageManager, systemView);
    }

    @Override
    public Customer create(Map<String, String> data) {
        MessageView messageView = systemView.getMessageView();

        // Get the storages
        CustomerStorageManager customerStorageManager = systemStorageManager.getCustomerManager();
        PolicyHolderStorage policyHolders = customerStorageManager.getPolicyHolderStorage();
        DependentStorage dependents = customerStorageManager.getDependentStorage();

        String dependsOn = data.get(DependentView.DEPENDS_ON);

        // Check if policy-holder ID is valid
        if (!policyHolders.exists(dependsOn)){
            messageView.displayError("Policy Holder does not exist. Customer creation failed.");
            return null;
        }

        String id = customerStorageManager.generateAndAddId();
        String fullName = data.get(CustomerView.CUSTOMER_NAME);

        // Add dependent to policy holder
        PolicyHolder holder =  policyHolders.get(dependsOn);
        holder.addDependent(id);

        Dependent newDependent = new Dependent(id, fullName);

        return dependents.add(newDependent);
    }
}
