package card;

import java.util.List;

public interface InsuranceCardManager {
    InsuranceCard get(String cardNum);
    List<InsuranceCard> getAll();
    void add(InsuranceCard newCard);
}
