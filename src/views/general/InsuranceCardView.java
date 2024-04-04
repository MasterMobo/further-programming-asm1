package views.general;

import models.card.InsuranceCard;

import java.util.Map;

public interface InsuranceCardView {
    String CARD_HOLDER = "CARD_HOLDER";
    String POLICY_OWNER = "POLICY_OWNER";
    String EXPIRY_DATE = "EXPIRY_DATE";

    void displayCard(InsuranceCard card);
    Map<String, String> displayCreateCardForm();
    void displayMessage(String s);
    void displayError(String s);
}
