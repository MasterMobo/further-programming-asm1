package customer;

import card.InsuranceCard;
import id.Identifiable;

public abstract class Customer implements Identifiable {
    protected String id;
    protected String fullName;
    protected InsuranceCard insuranceCard;

    public Customer() {
        this.id = "Default";
        this.fullName = "Default";
        this.insuranceCard = null;
    }

    public Customer(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
        this.insuranceCard = null;
    }

    public InsuranceCard getInsuranceCard() {
        return insuranceCard;
    }

    public void setInsuranceCard(InsuranceCard insuranceCard) {
        this.insuranceCard = insuranceCard;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }

}
