package views.text;

import views.general.MessageView;

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
}
