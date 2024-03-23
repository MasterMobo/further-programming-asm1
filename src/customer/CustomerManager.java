package customer;

import claims.InsuranceClaim;
import insuranceCard.InsuranceCard;

import java.util.List;

public interface CustomerManager {
    // This interface deals with all the customers in the system

    boolean exists(String customerId);
    boolean hasInsuranceCard(String customerId);
    Customer get(String customerId);
    Customer add(Customer customer);
    InsuranceCard getInsuranceCard(String customerId);
    InsuranceCard addInsuranceCard(String customerId, InsuranceCard card);
    List<InsuranceClaim> getAllClaims(String customerId);
    InsuranceClaim addClaim(String customerId, InsuranceClaim claim);
}
