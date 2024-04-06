package views.general.operations;

import java.util.Map;

public interface FormView<T> extends ItemDisplayView<T>{
    Map<String, String> displayForm();
    void displaySuccessMsg();
}
