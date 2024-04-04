package models.customer;

import models.id.Identifiable;

import java.util.HashSet;
import java.util.Set;

public abstract class Customer implements Identifiable {

    protected String id;
    protected String fullName;
    protected String insuranceCardNumber;

    public Customer() {
        this.id = "Default";
        this.fullName = "Default";
        this.insuranceCardNumber = "Default";
    }

    public Customer(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
        this.insuranceCardNumber = null;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getInsuranceCardNumber() {
        return insuranceCardNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "models.id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }


}
