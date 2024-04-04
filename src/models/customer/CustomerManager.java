package models.customer;

import models.customer.dependent.DependentManager;
import models.customer.holder.PolicyHolderManager;

public interface CustomerManager {
    // This interfaces manages customers of ALL roles within the system
    // By default, the system will always have 2 roles (PolicyHolders and Dependents)
    // If you wish to add more roles, use addRoleManager()
    // Remember to add appropriate methods to access new roles

    // Add a new CustomerRoleManager, allowing the system to deal with more customer roles.
    void addRoleManager(String roleCode, CustomerRoleManager roleManager);
    CustomerRoleManager getManager(String roleCode);

    // Generates a unique ID across all user roles.
    // This method will NOT add the returned ID to the ID set.
    // Use this method if you are only trying to generate a unique ID, but not use it to set the ID of a Customer
    // If you want to use the return value to set a Customer ID, use addID() after setting it.
    // Alternatively, use generateAndAddId() to accomplish this.
    String generateId();

    // Adds an ID to the ID set.
    // This method should ALWAYS be used in tandem with generateId() if you are trying to set Customer ID.
    void addId(String id);

    // Generates a unique ID then add it to the ID set.
    // This method should NOT be used to exclusively create Customer IDs. Doing so will not ensure uniqueness on subsequent calls.
    // Use this method ONLY if you are sure that the returned ID will be used to set Customer ID.
    String generateAndAddId();

    // Get a customer with the provided ID from any role
    Customer get(String customerId);

    // Checks if a customer with the provided ID of any role exists
    boolean exists(String customerId);

    // Check if the customer with the provided ID has an insurance card
    boolean hasInsuranceCard(String customerId);

    String getCardNumber(String customerId);
}
