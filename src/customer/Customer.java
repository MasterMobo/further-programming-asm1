package customer;

import claims.ClaimMap;
import insuranceCard.InsuranceCard;
import maps.Identifiable;

public abstract class Customer implements Identifiable {
    protected String id;
    protected String fullName;
    protected InsuranceCard insuranceCard;
    protected ClaimMap insuranceClaimMap;

    public Customer() {
        this.id = "Default";
        this.fullName = "Default";
    }

    public Customer(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

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
