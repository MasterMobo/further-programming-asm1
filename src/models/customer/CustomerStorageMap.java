package models.customer;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import models.customer.roles.dependent.DependentStorage;
import models.customer.roles.holder.PolicyHolderStorage;
import models.customer.roles.CustomerRoleStorage;
import models.storage.MapStorage;
import models.storage.PrefixIdGenerator;
import models.storage.StorageCode;

import java.util.*;

public class CustomerStorageMap extends MapStorage<CustomerRoleStorage> implements CustomerStorageManager {
    // This class manages customer of ALL roles within the system.
    // This class uses a map to keep track of different CustomerRoleManager. Each role manager has a unique role code defined in CustomerRoleCode.
    // To access a role, use getManager() with correct role code.

    // By default, the system will always have 2 roles (PolicyHolders and Dependents)
    // If you wish to add more roles, first define the role code in CustomerRoleCode, then use addRoleManager()

    // The reason this class has such different implementation from other IdManagers is because Customer ID need to be unique across different CustomerRoleManager
    // Since we don't know how many CustomerRoleManager could be added to the system in the future, we need a scalable way of checking ID.
    // This is the purpose of the customerIds set.

    private final Set<String> customerIds;     // This set contains the IDs of all customers within the system. This is used to ensure ID uniqueness across different user roles.

    public CustomerStorageMap() {
        super(new PrefixIdGenerator("c", 7));
        customerIds = new HashSet<>();
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
    public Customer getCustomer(String customerId) {
        // Since this class contains customers of all roles. We need to check if the id is contained in any role manager.
        for (CustomerRoleStorage manager: map.values()) {
            Customer customer = (Customer) manager.get(customerId);
            if (customer != null) return customer;
        }
        return null;
    }

    @Override
    public boolean customerExists(String customerId) {
        return getCustomer(customerId) != null;
    }

    @Override
    public boolean hasInsuranceCard(String customerId) {
        return getCustomer(customerId).hasInsuranceCard();
    }

    @Override
    public String getCardNumber(String customerId) {
        return getCustomer(customerId).getInsuranceCardNumber();
    }

    @Override
    public PolicyHolderStorage getPolicyHolderStorage() {
        return (PolicyHolderStorage) get(StorageCode.POLICY_HOLDERS);
    }

    @Override
    public DependentStorage getDependentStorage() {
        return (DependentStorage) get(StorageCode.DEPENDENTS);
    }

    @Override
    public String getId() {
        return StorageCode.CUSTOMERS;
    }
}
