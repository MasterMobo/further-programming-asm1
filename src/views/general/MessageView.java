package views.general;

import views.system.StorableView;

public interface MessageView extends StorableView {
    void displayMessage(String s);
    void displayError(String s);
    void displayWarning(String s);
}
