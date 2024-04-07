package views.ui.options.claims;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import controllers.claims.InsuranceClaimController;
import controllers.system.SystemControllerManager;
import views.ui.options.Option;

public class GetManyClaimOption extends Option {
    public GetManyClaimOption(SystemControllerManager controllers) {
        super("Get all Insurance Claims from a Customer/the System");
        this.controllers = controllers;
    }

    @Override
    public void execute() {
        InsuranceClaimController controller = controllers.getInsuranceClaimController();
        controller.getMany();
    }
}
