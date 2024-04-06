package views.ui.options.claims;

import controllers.claims.InsuranceClaimController;
import controllers.system.SystemControllerManager;
import views.ui.options.Option;

public class UpdateClaimOption extends Option {
    public UpdateClaimOption(SystemControllerManager controllers) {
        super("Update an Insurance Claim");
        this.controllers = controllers;
    }

    @Override
    public void execute() {
        InsuranceClaimController controller = controllers.getInsuranceClaimController();
        controller.update();
    }
}
