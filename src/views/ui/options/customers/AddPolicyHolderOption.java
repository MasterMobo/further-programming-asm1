package views.ui.options.customers;

import views.ui.options.Option;

public class AddPolicyHolderOption extends Option {
    public AddPolicyHolderOption() {
        super("Add a new Policy Holder");
    }

    @Override
    public void execute() {
        System.out.println(title);
    }
}
