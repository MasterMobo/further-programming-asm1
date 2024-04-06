package controllers.claims;

import controllers.AddableController;
import controllers.Controller;
import controllers.UpdatableController;
import models.claims.InsuranceClaim;
import models.system.SystemStorageManager;
import views.general.InsuranceClaimView;
import views.system.SystemViewManager;

import java.util.Map;

public class InsuranceClaimController extends Controller<InsuranceClaim> implements AddableController<InsuranceClaim>, UpdatableController<InsuranceClaim> {
    private InsuranceClaimCreator creator;
    private InsuranceClaimUpdater updater;

    public InsuranceClaimController() {
        creator = new InsuranceClaimCreator();
    }

    public InsuranceClaimController(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        this.systemStorageManager = systemStorageManager;
        this.systemViewManager = systemViewManager;

        creator = new InsuranceClaimCreator(systemStorageManager, systemViewManager);
        updater = new InsuranceClaimUpdater(systemStorageManager, systemViewManager);
    }

    // TODO: All theses add() methods are the same, should just abstract
    @Override
    public InsuranceClaim add() {
        InsuranceClaimView claimView = systemViewManager.getInsuranceClaimView();

        Map<String, String> data = claimView.displayAddForm();
        InsuranceClaim newClaim = creator.create(data);

        if (newClaim == null) return null;

        claimView.displaySuccessAddMsg();
        claimView.displayItem(newClaim);

        return newClaim;
    }

    @Override
    public InsuranceClaim update() {
        InsuranceClaimView claimView = systemViewManager.getInsuranceClaimView();

        Map<String, String> data = claimView.displayUpdateForm();
        InsuranceClaim updatedClaim = updater.update(data);

        if (updatedClaim == null) return null;

        claimView.displaySuccessUpdateMsg();
        claimView.displayItem(updatedClaim);

        return null;
    }
}
