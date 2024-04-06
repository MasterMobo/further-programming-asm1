package controllers.cards;

import controllers.Controller;
import controllers.AddableController;
import models.card.InsuranceCard;
import models.system.SystemStorageManager;
import views.general.InsuranceCardView;
import views.system.SystemViewManager;

import java.util.Map;

public class InsuranceCardController extends Controller<InsuranceCard> implements AddableController<InsuranceCard> {
    private InsuranceCardCreator creator;
    public InsuranceCardController() {
        super();
        creator = new InsuranceCardCreator();
    }

    public InsuranceCardController(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        super(systemStorageManager, systemViewManager);
        creator = new InsuranceCardCreator(systemStorageManager, systemViewManager);
    }

    @Override
    public InsuranceCard add() {
        InsuranceCardView cardView = systemViewManager.getInsuranceCardView();

        Map<String, String> data = cardView.displayAddForm();
        InsuranceCard newCard = creator.create(data);

        if (newCard == null) return null;

        cardView.displaySuccessAddMsg();
        cardView.displayItem(newCard);

        return newCard;
    }
}
