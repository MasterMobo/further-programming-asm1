package views.general;

import models.card.InsuranceCard;
import views.general.operations.AddView;
import views.general.operations.DeleteView;
import views.general.operations.GetView;
import views.general.operations.ItemDisplayView;
import views.system.StorableView;

import java.util.List;

public interface InsuranceCardView extends AddView, GetView, ItemDisplayView<InsuranceCard>, DeleteView, StorableView {
    String CARD_NUM = "CARD_NUM";
    String CARD_HOLDER = "CARD_HOLDER";
    String POLICY_OWNER = "POLICY_OWNER";
    String EXPIRY_DATE = "EXPIRY_DATE";

    void displayMany(List<List<InsuranceCard>> res);
}
