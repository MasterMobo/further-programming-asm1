package views.general;

import models.card.InsuranceCard;
import views.general.operations.AddView;
import views.general.operations.ItemDisplayView;
import views.system.StorableView;

public interface InsuranceCardView extends AddView, ItemDisplayView<InsuranceCard>, StorableView {
    String CARD_HOLDER = "CARD_HOLDER";
    String POLICY_OWNER = "POLICY_OWNER";
    String EXPIRY_DATE = "EXPIRY_DATE";

}
