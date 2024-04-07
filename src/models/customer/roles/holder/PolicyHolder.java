package models.customer.roles.holder;

import models.customer.Customer;

import java.util.ArrayList;
import java.util.List;

public class PolicyHolder extends Customer {
    private List<String> dependentIds;

    public PolicyHolder() {
        super();
        dependentIds = new ArrayList<>();
    }

    public PolicyHolder(String id, String fullName) {
        super(id, fullName);
        dependentIds = new ArrayList<>();
    }

    public PolicyHolder(String id, String fullName, String insuranceCardNumber, List<String> dependentIds) {
        super(id, fullName);
        this.insuranceCardNumber = insuranceCardNumber;
        this.dependentIds = dependentIds;
    }

    public List<String> getDependentIds() {
        return dependentIds;
    }

    public void addDependent(String dependentId) {
        dependentIds.add(dependentId);
    }

    public void removeDependent(String dependentId) {
        dependentIds.remove(dependentId);
    }

    @Override
    public String toString() {
        return "Policy Holder (" + id + "): " + fullName + "\t" + "Card Number: " + insuranceCardNumber;
    }

}
