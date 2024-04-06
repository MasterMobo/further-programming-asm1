package views.ui.options.customers;

import views.ui.options.Option;

public class AddDependentOption extends Option {
    public AddDependentOption() {
        super("Add a new Dependent to a Policy Holder");
    }

    @Override
    public void execute() {
        System.out.println(title);
    }
}
