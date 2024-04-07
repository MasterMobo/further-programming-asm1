package views.ui.options.claims;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import views.ui.options.Option;

public class InsuranceClaimOption extends Option {
    public InsuranceClaimOption() {
        super("Insurance Claims");
    }

    @Override
    public void execute() {
        System.out.println(title);
    }
}
