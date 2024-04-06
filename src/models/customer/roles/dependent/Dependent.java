package models.customer.roles.dependent;

import models.customer.Customer;

public class Dependent extends Customer {
    public Dependent() {
        super();
    }

    public Dependent(String id, String fullName) {
        super(id, fullName);
    }

    public Dependent(String id, String fullName, String insuranceCardNumber) {
        super(id, fullName);
        this.insuranceCardNumber = insuranceCardNumber;
    }

    @Override
    public String toString() {
        return "Policy Holder (" + id + "): " + fullName + "\t" + "Card Number: " + insuranceCardNumber;
    }
}
