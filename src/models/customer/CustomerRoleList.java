package models.customer;

import models.customer.dependent.DependentManager;
import models.customer.holder.PolicyHolderManager;
import models.id.IdGenerator;
import models.id.PrefixIdGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// TODO: find a better name for this
public class CustomerRoleList implements CustomerManager{

    // This set contains the IDs of all customers within the system. This is used to ensure ID uniqueness across different user roles.
    private final Set<String> customerIds;
    private final List<CustomerRoleManager> customerRoles;
    private final IdGenerator idGenerator;

    public CustomerRoleList() {
        customerIds = new HashSet<>();
        customerRoles = new ArrayList<>();
        idGenerator = new PrefixIdGenerator("c", 10);
    }

    public CustomerRoleList(PolicyHolderManager policyHolders, DependentManager dependents) {
        customerIds = new HashSet<>();
        idGenerator = new PrefixIdGenerator("c", 10);

        customerRoles = new ArrayList<>();
        customerRoles.add(policyHolders);
        customerRoles.add(dependents);
    }

    @Override
    public String generateId() {
        // Generates a unique ID across all user roles.
        // This method will NOT add the returned ID to the ID set.
        // Use this method if you are only trying to generate a unique ID, but not use it to set the ID of a Customer
        // If you want to use the return value to set a Customer ID, use addID() after setting it.
        // Alternatively, use generateAndAddId() to accomplish this.

        String id = idGenerator.randomId();
        while (customerIds.contains(id)) {
            id = idGenerator.randomId();
        }

        return id;
    }

    @Override
    public void addId(String id) {
        // Adds an ID to the ID set.
        // This method should ALWAYS be used in tandem with generateId() if you are trying to set Customer ID.

        customerIds.add(id);
    }

    @Override
    public String generateAndAddId() {
        // Generates a unique ID then add it to the ID set.
        // This method should NOT be used to exclusively create Customer IDs. Doing so will not ensure uniqueness on subsequent calls.
        // Use this method ONLY if you are sure that the returned ID will be used to set Customer ID.

        String id = generateId();
        addId(id);
        return id;
    }

    @Override
    public Customer get(String customerId) {
        // Since this class contains customers of all roles. We need to check if the id is contained in any role manager.
        for (CustomerRoleManager manager: customerRoles) {
            Customer customer = (Customer) manager.get(customerId);
            if (customer != null) return customer;
        }
        return null;
    }

    @Override
    public boolean exists(String customerId) {
        return get(customerId) != null;
    }

    @Override
    public boolean hasInsuranceCard(String customerId) {
        return get(customerId).hasInsuranceCard();
    }

    public PolicyHolderManager getPolicyHolders() {
        return (PolicyHolderManager) customerRoles.get(0);
    }

    public DependentManager getDependents() {
        return (DependentManager) customerRoles.get(1);
    }
}
