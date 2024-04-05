package views.general;

import models.card.InsuranceCard;

public interface InsuranceCardView extends AddView, ItemDisplayView<InsuranceCard> {
    String CARD_HOLDER = "CARD_HOLDER";
    String POLICY_OWNER = "POLICY_OWNER";
    String EXPIRY_DATE = "EXPIRY_DATE";

}
