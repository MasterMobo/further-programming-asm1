package models.customer.roles.dependent;

import models.customer.Customer;

public class Dependent extends Customer {
    public Dependent() {
        super();
    }

    public Dependent(String id, String fullName) {
        super(id, fullName);
    }

    @Override
    public String toString() {
        return "Policy Holder (" + id + "): " + fullName + "\t" + "Card Number: " + insuranceCardNumber;
    }
}
