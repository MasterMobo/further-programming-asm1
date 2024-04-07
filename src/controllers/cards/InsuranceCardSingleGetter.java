package controllers.cards;

import controllers.ControllerOperator;
import models.card.InsuranceCard;
import models.card.InsuranceCardStorage;
import models.system.SystemStorageManager;
import views.general.InsuranceCardView;
import views.general.MessageView;
import views.system.SystemViewManager;

import java.util.Map;

public class InsuranceCardSingleGetter extends ControllerOperator {
    public InsuranceCardSingleGetter() {
        super();
    }

    public InsuranceCardSingleGetter(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        super(systemStorageManager, systemViewManager);
    }

    @Override
    public InsuranceCard execute(Map<String, String> data) {
        MessageView message = systemViewManager.getMessageView();

        String cardNum = data.get(InsuranceCardView.CARD_NUM);
        InsuranceCardStorage cards = systemStorageManager.getCardStorage();

        if (!cards.exists(cardNum)) {
            message.displayError("Insurance Card does not exist");
        }

        return cards.get(cardNum);
    }
}
