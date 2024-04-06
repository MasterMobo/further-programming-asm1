package controllers.claims;

import controllers.*;
import models.claims.InsuranceClaim;
import models.system.SystemStorageManager;
import views.general.InsuranceClaimView;
import views.general.MessageView;
import views.general.operations.ItemDisplayView;
import views.system.SystemViewManager;

import java.util.Map;

public class InsuranceClaimController extends Controller<InsuranceClaim> implements AddableController<InsuranceClaim>, UpdatableController<InsuranceClaim>, DeletableController<InsuranceClaim> {


    public InsuranceClaimController() {
        super();
    }

    public InsuranceClaimController(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        this.systemStorageManager = systemStorageManager;
        this.systemViewManager = systemViewManager;
    }


    @Override
    public InsuranceClaim add() {
        InsuranceClaimCreator creator = new InsuranceClaimCreator(systemStorageManager, systemViewManager);
        InsuranceClaimView claimView = systemViewManager.getInsuranceClaimView();
        Map<String, String> data = claimView.displayAddForm();

        return executeOperator(creator, data, claimView);
    }

    @Override
    public InsuranceClaim update() {
        InsuranceClaimUpdater updater = new InsuranceClaimUpdater(systemStorageManager, systemViewManager);
        InsuranceClaimView claimView = systemViewManager.getInsuranceClaimView();
        Map<String, String> data = claimView.displayUpdateForm();

        return executeOperator(updater, data, claimView);
    }

    @Override
    public InsuranceClaim delete() {
        InsuranceClaimDeleter deleter = new InsuranceClaimDeleter(systemStorageManager, systemViewManager);
        InsuranceClaimView claimView = systemViewManager.getInsuranceClaimView();
        Map<String, String> data = claimView.displayDeleteForm();

        return executeOperator(deleter, data, claimView);
    }
}
