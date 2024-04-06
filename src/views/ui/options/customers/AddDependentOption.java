package views.ui.options.customers;

import controllers.customers.DependentController;
import controllers.system.SystemControllerManager;
import views.ui.options.Option;

public class AddDependentOption extends Option {
    public AddDependentOption(SystemControllerManager controllers) {
        super("Add a new Dependent to a Policy Holder");
        this.controllers = controllers;
    }

    @Override
    public void execute() {
        DependentController controller = controllers.getDependentController();
        controller.add();
    }
}
