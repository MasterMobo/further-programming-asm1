package views.ui.options.cards;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import controllers.cards.InsuranceCardController;
import controllers.system.SystemControllerManager;
import views.ui.options.Option;

public class AddCardOption extends Option {
    public AddCardOption(SystemControllerManager controllers) {
        super("Add new Insurance Card");
        this.controllers = controllers;
    }

    @Override
    public void execute() {
        InsuranceCardController controller = controllers.getInsuranceCardController();
        controller.add();
    }
}
