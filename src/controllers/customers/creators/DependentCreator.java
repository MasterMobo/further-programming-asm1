package controllers.customers.creators;

import models.customer.Customer;
import models.customer.CustomerManager;
import models.customer.dependent.Dependent;
import models.customer.dependent.DependentManager;
import models.customer.holder.PolicyHolder;
import models.customer.holder.PolicyHolderManager;
import views.general.CustomerView;
import views.general.DependentView;

import java.util.Map;

public class DependentCreator extends CustomerCreator{
    public DependentCreator(CustomerManager customerManager, CustomerView customerView) {
        super(customerManager, customerView);
    }

    @Override
    public Customer create(Map<String, String> data) {
        PolicyHolderManager policyHolders = customerManager.getPolicyHolders();
        DependentManager dependents = customerManager.getDependents();

        String dependsOn = data.get(DependentView.DEPENDS_ON);

        // Check if policy-holder ID is valid
        if (!policyHolders.exists(dependsOn)){
            customerView.displayError("Policy Holder does not. Customer creation failed.");
            return null;
        }

        String id = customerManager.generateAndAddId();
        String fullName = data.get(CustomerView.CUSTOMER_NAME);

        Dependent newDependent = new Dependent(id, fullName);
        PolicyHolder holder =  policyHolders.get(dependsOn);

        holder.addDependent(newDependent.getId());

        return newDependent;
    }
}
