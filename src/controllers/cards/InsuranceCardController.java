package controllers.cards;

import controllers.Controller;
import controllers.AddableController;
import models.card.InsuranceCard;
import models.system.SystemStorageManager;
import views.general.InsuranceCardView;
import views.general.SystemView;

import java.util.Map;

public class InsuranceCardController extends Controller<InsuranceCard> implements AddableController<InsuranceCard> {
    private InsuranceCardCreator creator;
    public InsuranceCardController() {
        super();
        creator = new InsuranceCardCreator();
    }

    public InsuranceCardController(SystemStorageManager systemStorageManager, SystemView systemView) {
        super(systemStorageManager, systemView);
        creator = new InsuranceCardCreator(systemStorageManager, systemView);
    }

    @Override
    public InsuranceCard add() {
        InsuranceCardView cardView = systemView.getInsuranceCardView();

        Map<String, String> data = cardView.displayAddForm();
        InsuranceCard newCard = creator.create(data);

        if (newCard == null) return null;

        cardView.displaySuccessAddMsg();
        cardView.displayItem(newCard);

        return newCard;
    }
}
