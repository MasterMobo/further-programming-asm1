package systems;

import card.InsuranceCard;

import java.util.List;

public interface InsuranceCardOperations {
    void add(InsuranceCard card);
    InsuranceCard getInsuranceCard(String cardNum);
    List<InsuranceCard> getAllInsuranceCards();
}
