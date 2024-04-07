package views.ui.options.customers;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

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
