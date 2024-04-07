package controllers.claims;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import controllers.ControllerOperator;
import models.claims.InsuranceClaim;
import models.claims.InsuranceClaimStorage;
import models.system.SystemStorageManager;
import views.general.InsuranceClaimView;
import views.general.MessageView;
import views.system.SystemViewManager;

import java.util.Map;

public class InsuranceClaimSingleGetter extends ControllerOperator {
    public InsuranceClaimSingleGetter() {
        super();
    }

    public InsuranceClaimSingleGetter(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        super(systemStorageManager, systemViewManager);
    }

    @Override
    public InsuranceClaim execute(Map<String, String> data) {
        InsuranceClaimStorage claims = systemStorageManager.getClaimStorage();
        MessageView message = systemViewManager.getMessageView();

        String claimId = data.get(InsuranceClaimView.CLAIM_ID);

        if (!claims.exists(claimId)) {
            message.displayError("Insurance Claim does not exist");
            return null;
        }

        return claims.get(claimId);
    }
}
