package views.ui.options.customers.dependents;

import views.ui.options.Option;

public class DependentOption extends Option {
    public DependentOption() {
        super("Dependent");
    }

    @Override
    public void execute() {
        System.out.println(title);
    }
}