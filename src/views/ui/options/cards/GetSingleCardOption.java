package views.ui.options.cards;

import controllers.cards.InsuranceCardController;
import controllers.system.SystemControllerManager;
import views.ui.options.Option;

public class GetSingleCardOption extends Option {
    public GetSingleCardOption(SystemControllerManager controllers) {
        super("Find a specific Insurance Card");
        this.controllers = controllers;
    }

    @Override
    public void execute() {
        InsuranceCardController controller = controllers.getInsuranceCardController();
        controller.get();
    }
}
