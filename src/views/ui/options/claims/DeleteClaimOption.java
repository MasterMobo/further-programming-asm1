package views.ui.options.claims;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import controllers.claims.InsuranceClaimController;
import controllers.system.SystemControllerManager;
import views.ui.options.Option;

public class DeleteClaimOption extends Option {
    public DeleteClaimOption(SystemControllerManager controllers) {
        super("Delete an Insurance Claim");
        this.controllers = controllers;
    }

    @Override
    public void execute() {
        InsuranceClaimController controller = controllers.getInsuranceClaimController();
        controller.delete();
    }
}
