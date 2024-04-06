package views.ui.options.customers;

import views.ui.options.Option;

public class PolicyHolderOption extends Option {

    public PolicyHolderOption() {
        super("Policy Holder");
    }

    @Override
    public void execute() {
        System.out.println(title);
    }
}
