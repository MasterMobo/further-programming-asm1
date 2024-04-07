package views.ui.options.customers.policy_holders;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import controllers.customers.policy_holder.PolicyHolderController;
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
