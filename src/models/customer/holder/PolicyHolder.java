package models.customer.holder;

import models.customer.Customer;
import models.customer.CustomerManager;
import models.customer.CustomerMap;
import models.customer.dependent.Dependent;

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

    public List<String> getDependentIds() {
        return dependentIds;
    }

    public void addDependent(String dependentId) {
        dependentIds.add(dependentId);
    }

    @Override
    public String toString() {
        return "Policy Holder (" + id + "): " + fullName + "\t" + "Card Number: " + insuranceCardNumber;
    }

}
