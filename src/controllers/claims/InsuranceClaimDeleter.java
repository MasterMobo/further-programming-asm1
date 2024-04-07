package controllers.claims;

import controllers.ControllerOperator;
import models.claims.InsuranceClaim;
import models.claims.InsuranceClaimStorage;
import models.system.SystemStorageManager;
import views.general.InsuranceClaimView;
import views.general.MessageView;
import views.system.SystemViewManager;

import java.util.Map;

public class InsuranceClaimDeleter extends ControllerOperator {
    public InsuranceClaimDeleter() {
        super();
    }

    public InsuranceClaimDeleter(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        super(systemStorageManager, systemViewManager);
    }

    @Override
    public InsuranceClaim execute(Map<String, String> data) {
        InsuranceClaimStorage claims = systemStorageManager.getClaimStorage();
        InsuranceClaimView claimView = systemViewManager.getInsuranceClaimView();
        MessageView message = systemViewManager.getMessageView();

        String claimId = data.get(InsuranceClaimView.CLAIM_ID);

        if (!claims.exists(claimId)) {
            message.displayError("Insurance Claim does not exist");
            return null;
        }

        if (!claimView.displayDeleteConfirm()) {
            message.displayMessage("Delete canceled");
            return null;
        }

        return claims.delete(claimId);
    }
}
