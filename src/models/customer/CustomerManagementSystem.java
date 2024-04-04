package models.customer;

import models.customer.dependent.DependentManager;
import models.customer.holder.PolicyHolderManager;
import models.id.IdGenerator;
import models.id.PrefixIdGenerator;

import java.util.*;

public class CustomerManagementSystem implements CustomerManager{
    // This class manages customer of ALL roles within the system.
    // This class uses a map to keep track of different user roles. Each role has a unique role code defined in CustomerRoleCode.
    // By default, the system will always have 2 roles (PolicyHolders and Dependents)
    // If you wish to add more roles, use addRoleManager()
    // Remember to add methods to access new roles

    private final Set<String> customerIds;     // This set contains the IDs of all customers within the system. This is used to ensure ID uniqueness across different user roles.
    private final Map<String, CustomerRoleManager> customerRoles;  // This maps a unique role code to a role manager. All customer roles in the system should be present here.
    private final IdGenerator idGenerator;  // User ID format is shared between all CustomerManagers, therefore this IdGenerator is also shared.

    public CustomerManagementSystem() {
        customerIds = new HashSet<>();
        customerRoles = new HashMap<>();
        idGenerator = new PrefixIdGenerator("c", 10);
    }

    public CustomerManagementSystem(PolicyHolderManager policyHolders, DependentManager dependents) {
        customerIds = new HashSet<>();
        idGenerator = new PrefixIdGenerator("c", 10);

        customerRoles = new HashMap<>();
        // Default roles
        customerRoles.put(CustomerRoleCode.POLICYHOLDER, policyHolders);
        customerRoles.put(CustomerRoleCode.DEPENDENT, dependents);
    }


    @Override
    public void addRoleManager(String roleCode, CustomerRoleManager roleManager) {
        // Add a new CustomerRoleManager, allowing the system to deal with more customer roles.
        customerRoles.put(roleCode, roleManager);
    }

    @Override
    public CustomerRoleManager getManager(String roleCode) {
        // Get the manager corresponding to the role code
        return customerRoles.get(roleCode);
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
        for (CustomerRoleManager manager: customerRoles.values()) {
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

}
