package models.customer;

import models.storage.StorageItem;

public abstract class Customer implements StorageItem {

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
        this.insuranceCardNumber = "Default";
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

    public boolean hasInsuranceCard() {
        return insuranceCardNumber != null && !(insuranceCardNumber.equals("Default"));
    }

    public void setInsuranceCardNumber(String insuranceCardNumber) {
        this.insuranceCardNumber = insuranceCardNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "models.id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }


}
