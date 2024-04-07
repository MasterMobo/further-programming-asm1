package controllers.cards;

import controllers.*;
import controllers.system.ControllerCode;
import models.card.InsuranceCard;
import models.system.SystemStorageManager;
import views.general.InsuranceCardView;
import views.system.SystemViewManager;

import java.util.List;
import java.util.Map;

public class InsuranceCardController extends Controller<InsuranceCard> implements AddableController<InsuranceCard>, GettableController<InsuranceCard>, DeletableController<InsuranceCard>, UpdatableController<InsuranceCard> {
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

    @Override
    public InsuranceCard get() {
        InsuranceCardSingleGetter singleGetter = new InsuranceCardSingleGetter(systemStorageManager, systemViewManager);
        InsuranceCardView cardView = systemViewManager.getInsuranceCardView();
        Map<String, String> data = cardView.displayGetForm();

        return executeOperator(singleGetter, data, cardView);
    }

    @Override
    public List<InsuranceCard> getMany() {
        InsuranceCardManyGetter manyGetter = new InsuranceCardManyGetter(systemStorageManager, systemViewManager);
        InsuranceCardView cardView = systemViewManager.getInsuranceCardView();
        Map<String, String> data = cardView.displayGetManyForm();

        List<List<InsuranceCard>> res = manyGetter.execute(data);

        if (res == null) return null;

        cardView.displayMany(res);

        return res.get(0);
    }

    @Override
    public InsuranceCard delete() {
        InsuranceCardDeleter deleter = new InsuranceCardDeleter(systemStorageManager, systemViewManager);
        InsuranceCardView cardView = systemViewManager.getInsuranceCardView();
        Map<String, String> data = cardView.displayGetForm();

        return executeOperator(deleter, data, cardView);
    }

    @Override
    public InsuranceCard update() {
        InsuranceCardUpdater updater = new InsuranceCardUpdater(systemStorageManager, systemViewManager);
        InsuranceCardView cardView = systemViewManager.getInsuranceCardView();
        Map<String, String> data = cardView.displayUpdateForm();

        return executeOperator(updater, data, cardView);
    }
}
