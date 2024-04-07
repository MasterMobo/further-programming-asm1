package views.general;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import models.card.InsuranceCard;
import views.general.operations.*;
import views.system.StorableView;

import java.util.List;

public interface InsuranceCardView extends AddView, GetView, ItemDisplayView<InsuranceCard>, DeleteView, UpdateView, StorableView {
    String CARD_NUM = "CARD_NUM";
    String CARD_HOLDER = "CARD_HOLDER";
    String POLICY_OWNER = "POLICY_OWNER";
    String EXPIRY_DATE = "EXPIRY_DATE";

    void displayMany(List<List<InsuranceCard>> res);
}
