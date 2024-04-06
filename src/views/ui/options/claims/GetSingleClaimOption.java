package views.ui.options.claims;

import views.ui.options.Option;

public class GetSingleClaimOption extends Option {

    public GetSingleClaimOption() {
        super("Find a specific Insurance Claim");
    }

    @Override
    public void execute() {
        System.out.println(title);
    }
}
