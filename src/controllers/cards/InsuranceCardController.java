package controllers.cards;

import controllers.Controller;
import controllers.AddableController;
import controllers.system.ControllerCode;
import models.card.InsuranceCard;
import models.system.SystemStorageManager;
import views.general.InsuranceCardView;
import views.system.SystemViewManager;

import java.util.Map;

public class InsuranceCardController extends Controller<InsuranceCard> implements AddableController<InsuranceCard> {
    public InsuranceCardController() {
        super();
    }

    public InsuranceCardController(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        super(systemStorageManager, systemViewManager);
    }

    @Override
    public InsuranceCard add() {
        InsuranceCardCreator creator = new InsuranceCardCreator(systemStorageManager, systemViewManager);
        InsuranceCardView cardView = systemViewManager.getInsuranceCardView();
        Map<String, String> data = cardView.displayAddForm();

        return executeOperator(creator, data, cardView);
    }

    @Override
    public String getId() {
        return ControllerCode.INSURANCE_CARDS;
    }
}
