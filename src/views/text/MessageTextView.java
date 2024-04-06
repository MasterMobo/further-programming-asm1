package views.text;

import views.general.MessageView;
import views.system.ViewCode;

public class MessageTextView implements MessageView {
    @Override
    public void displayMessage(String s) {
        System.out.println(s);
    }

    @Override
    public void displayError(String s) {
        System.out.println(s);
    }

    @Override
    public void displayWarning(String s) {
        System.out.println(s);
    }

    @Override
    public String getId() {
        return ViewCode.MESSAGE;
    }
}
