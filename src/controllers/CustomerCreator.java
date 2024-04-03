package controllers;

import models.customer.Customer;
import models.customer.CustomerManager;
import models.customer.dependent.Dependent;
import models.customer.dependent.DependentManager;
import models.customer.holder.PolicyHolder;
import models.customer.holder.PolicyHolderManager;
import models.customer.CustomerRoleCode;
import views.general.CustomerView;
import views.general.DependentView;

import java.util.Map;

public class CustomerCreator {
    private PolicyHolderManager policyHolders;
    private DependentManager dependents;
    private CustomerView customerView;

    public CustomerCreator(PolicyHolderManager policyHolders, DependentManager dependents, CustomerView customerView) {
        this.policyHolders = policyHolders;
        this.dependents = dependents;
        this.customerView = customerView;
    }

    public Customer create(String role, Map<String, String> data) {
        return switch (role) {
            case CustomerRoleCode.POLICYHOLDER -> createPolicyHolder(data);
            case CustomerRoleCode.DEPENDENT -> createDependent(data);
            default -> null;
        };
    };

    private Customer createPolicyHolder(Map<String, String> data) {
        String id = generateCustomerId(policyHolders);
        String fullName = data.get(CustomerView.CUSTOMER_NAME);

        return new PolicyHolder(id, fullName);
    }

    private Customer createDependent(Map<String, String> data) {
        String dependsOn = data.get(DependentView.DEPENDS_ON);

        // Check if policy-holder ID is valid
        if (!policyHolders.exists(dependsOn)){
            customerView.displayError("Policy Holder does not. Customer creation failed.");
            return null;
        }

        String id = generateCustomerId(dependents);
        String fullName = data.get(CustomerView.CUSTOMER_NAME);

        Dependent newDependent = new Dependent(id, fullName);
        PolicyHolder holder =  policyHolders.get(dependsOn);

        holder.addDependent(newDependent.getId());

        return newDependent;
    }

    private <K extends Customer, T extends CustomerManager<K>> String generateCustomerId(T manager) {
        String id = manager.generateId();
        Customer.addId(id); // Add to ID set to ensure uniqueness
        return id;
    }

}
