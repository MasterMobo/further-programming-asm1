package controllers.customers;

import models.customer.Customer;
import models.customer.CustomerManager;
import models.customer.dependent.Dependent;
import models.customer.dependent.DependentManager;
import models.customer.holder.PolicyHolder;
import models.customer.holder.PolicyHolderManager;
import models.customer.CustomerRoleCode;

public class CustomerAdder {
    private final PolicyHolderManager policyHolders;
    private final DependentManager dependents;

    public CustomerAdder(CustomerManager customerManager) {
        this.policyHolders = customerManager.getPolicyHolders();
        this.dependents = customerManager.getDependents();
    }

    public Customer add(String role, Customer customer) {
        return switch (role) {
            case CustomerRoleCode.POLICYHOLDER -> addPolicyHolder((PolicyHolder) customer);
            case CustomerRoleCode.DEPENDENT -> addDependent((Dependent) customer);
            default -> null;
        };
    }

    public Customer addPolicyHolder(PolicyHolder holder) {
        return policyHolders.add(holder);
    }

    public Customer addDependent(Dependent dependent) {
        return dependents.add(dependent);
    }
}
