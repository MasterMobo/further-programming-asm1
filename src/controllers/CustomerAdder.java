package controllers;

import models.customer.Customer;
import models.customer.dependent.Dependent;
import models.customer.dependent.DependentManager;
import models.customer.holder.PolicyHolder;
import models.customer.holder.PolicyHolderManager;
import models.customer.CustomerRoleCode;

public class CustomerAdder {
    private PolicyHolderManager policyHolders;
    private DependentManager dependents;

    public CustomerAdder(PolicyHolderManager policyHolders, DependentManager dependents) {
        this.policyHolders = policyHolders;
        this.dependents = dependents;
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
