package controllers.cards;

import controllers.Controller;
import controllers.AddableController;
import models.card.InsuranceCard;
import models.system.SystemManager;
import views.general.InsuranceCardView;
import views.general.MessageView;
import views.general.SystemView;

import java.util.Map;

public class InsuranceCardController extends Controller<InsuranceCard> implements AddableController<InsuranceCard> {
    private InsuranceCardCreator creator;
    public InsuranceCardController() {
        super();
        creator = new InsuranceCardCreator();
    }

    public InsuranceCardController(SystemManager systemManager, SystemView systemView) {
        super(systemManager, systemView);
        creator = new InsuranceCardCreator(systemManager, systemView);
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
