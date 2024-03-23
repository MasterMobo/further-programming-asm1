package customer;

import claims.CustomerClaimManager;
import claims.CustomerClaimMap;
import claims.InsuranceClaim;
import insuranceCard.InsuranceCard;
import maps.Identifiable;

import java.util.List;

public abstract class Customer implements Identifiable {
    protected String id;
    protected String fullName;
    protected InsuranceCard insuranceCard;
    protected CustomerClaimManager insuranceClaims;

    public Customer() {
        this.id = "Default";
        this.fullName = "Default";
        this.insuranceCard = null;
        this.insuranceClaims = new CustomerClaimMap();
    }

    public Customer(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
        this.insuranceCard = null;
        this.insuranceClaims = new CustomerClaimMap();
    }

    public InsuranceCard getInsuranceCard() {
        return insuranceCard;
    }

    public void setInsuranceCard(InsuranceCard insuranceCard) {
        this.insuranceCard = insuranceCard;
    }

    public InsuranceClaim addClaim(InsuranceClaim claim) {
        return insuranceClaims.add(claim);
    }

    public List<InsuranceClaim> getAllClaims() {
        return insuranceClaims.getAll();
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
