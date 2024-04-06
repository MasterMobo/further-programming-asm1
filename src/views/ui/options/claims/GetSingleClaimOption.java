package views.ui.options.claims;

import controllers.claims.InsuranceClaimController;
import controllers.system.SystemControllerManager;
import views.ui.options.Option;

public class GetSingleClaimOption extends Option {

    public GetSingleClaimOption(SystemControllerManager controllers) {
        super("Find a specific Insurance Claim");
        this.controllers = controllers;
    }

    @Override
    public void execute() {
        InsuranceClaimController controller = controllers.getInsuranceClaimController();
        controller.get();
    }
}
