package views.ui.options.cards;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import controllers.cards.InsuranceCardController;
import controllers.system.SystemControllerManager;
import views.ui.options.Option;

public class GetManyCardOption extends Option {
    public GetManyCardOption(SystemControllerManager controllers) {
        super("Get all Insurance Cards from the system. Or from a Customer and their Dependents");
        this.controllers = controllers;
    }

    @Override
    public void execute() {
        InsuranceCardController controller = controllers.getInsuranceCardController();
        controller.getMany();
    }
}
