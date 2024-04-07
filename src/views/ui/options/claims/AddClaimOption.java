package views.ui.options.claims;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import controllers.claims.InsuranceClaimController;
import controllers.system.SystemControllerManager;
import views.ui.options.Option;

public class AddClaimOption extends Option {
    public AddClaimOption(SystemControllerManager controllers) {
        super("Add a new Insurance Claim");
        this.controllers = controllers;
    }

    @Override
    public void execute() {
        InsuranceClaimController controller = controllers.getInsuranceClaimController();
        controller.add();
    }
}
