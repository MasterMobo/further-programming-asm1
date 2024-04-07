package views.general;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import views.system.StorableView;

public interface MessageView extends StorableView {
    void displayMessage(String s);
    void displayError(String s);
    void displayWarning(String s);
}
