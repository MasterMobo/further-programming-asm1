package views.ui.options.customers.policy_holders;

import controllers.customers.policy_holder.PolicyHolderController;
import controllers.system.SystemControllerManager;
import views.ui.options.Option;

public class GetSinglePolicyHolderOption extends Option {
    public GetSinglePolicyHolderOption(SystemControllerManager controllers) {
        super("Get a specific Policy Holder (along with dependents)");
        this.controllers = controllers;
    }

    @Override
    public void execute() {
        PolicyHolderController controller = controllers.getPolicyHolderController();
        controller.get();
    }
}
