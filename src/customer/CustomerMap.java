package customer;

import claims.InsuranceClaim;
import insuranceCard.InsuranceCard;
import maps.IdMap;

import java.util.List;

public class CustomerMap extends IdMap<Customer> implements CustomerManager {
    public CustomerMap() {
        super();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        idToItem.forEach((id, item) -> {
            s.append(item.toString());
        });
        return s.toString();
    }

    @Override
    public Customer add(Customer item) {
        System.out.println("This is different now!");
        return super.add(item);
    }

    @Override
    public boolean exists(String id) {
        return idToItem.containsKey(id);
    }

    @Override
    public boolean hasInsuranceCard(String id) {
        if (!exists(id)) return false;

        return idToItem.get(id).getInsuranceCard() != null;
    }

    @Override
    public InsuranceCard getInsuranceCard(String id) {
        if (!exists(id)) return null;

        return idToItem.get(id).getInsuranceCard();
    }

    @Override
    public InsuranceCard addInsuranceCard(String customerId, InsuranceCard card) {
        if (!exists(customerId)) return null;

        get(customerId).setInsuranceCard(card);
        return card;
    }

    @Override
    public List<InsuranceClaim> getAllClaims(String customerId) {
        if (!exists(customerId)) return null;

        return get(customerId).getAllClaims();
    }

    @Override
    public InsuranceClaim addClaim(String customerId, InsuranceClaim claim) {
        if (!exists(customerId)) return null;

        return get(customerId).addClaim(claim);
    }
}
