package views.ui.options.claims;

import views.ui.options.Option;

public class GetManyClaimOption extends Option {
    public GetManyClaimOption() {
        super("Get all Insurance Claims from a Customer/the System");
    }

    @Override
    public void execute() {
        System.out.println(title);
    }
}
