package views.ui.options.customers;

import views.ui.options.Option;

public class CustomerOption extends Option {
    public CustomerOption() {
        super("Customers");
    }

    @Override
    public void execute() {
        System.out.println(title);
    }
}
