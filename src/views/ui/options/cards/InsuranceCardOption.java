package views.ui.options.cards;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import views.ui.options.Option;

public class InsuranceCardOption extends Option {
    public InsuranceCardOption() {
        super("Insurance Cards");
    }

    @Override
    public void execute() {
        System.out.println(title);
    }
}
