package controllers.claims;

import controllers.AddableController;
import controllers.Controller;
import models.claims.InsuranceClaim;
import models.system.SystemStorageManager;
import views.general.InsuranceClaimView;
import views.general.SystemView;

import java.util.Map;

public class InsuranceClaimController extends Controller<InsuranceClaim> implements AddableController<InsuranceClaim> {
    private InsuranceClaimCreator creator;

    public InsuranceClaimController() {
        creator = new InsuranceClaimCreator();
    }

    public InsuranceClaimController(SystemStorageManager systemStorageManager, SystemView systemView) {
        this.systemStorageManager = systemStorageManager;
        this.systemView = systemView;
        creator = new InsuranceClaimCreator(systemStorageManager, systemView);
    }

    // TODO: All theses add() methods are the same, should just abstract
    @Override
    public InsuranceClaim add() {
        InsuranceClaimView claimView = systemView.getInsuranceClaimView();

        Map<String, String> data = claimView.displayAddForm();
        InsuranceClaim newClaim = creator.create(data);

        if (newClaim == null) return null;

        claimView.displaySuccessAddMsg();
        claimView.displayItem(newClaim);

        return newClaim;
    }
}
