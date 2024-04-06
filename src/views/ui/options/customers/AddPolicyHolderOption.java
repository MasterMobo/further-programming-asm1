package views.ui.options.customers;

import controllers.customers.PolicyHolderController;
import controllers.system.SystemControllerManager;
import views.ui.options.Option;

public class AddPolicyHolderOption extends Option {
    public AddPolicyHolderOption(SystemControllerManager controllers) {
        super("Add a new Policy Holder");
        this.controllers = controllers;
    }

    @Override
    public void execute() {
        PolicyHolderController controller = controllers.getPolicyHolderController();
        controller.add();
    }
}
