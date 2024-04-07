package views.ui.options.cards;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import controllers.cards.InsuranceCardController;
import controllers.system.SystemControllerManager;
import views.ui.options.Option;

public class DeleteCardOption extends Option {
    public DeleteCardOption(SystemControllerManager controllers) {
        super("Delete an Insurance Card");
        this.controllers = controllers;
    }

    @Override
    public void execute() {
        InsuranceCardController controller = controllers.getInsuranceCardController();
        controller.delete();
    }
}
