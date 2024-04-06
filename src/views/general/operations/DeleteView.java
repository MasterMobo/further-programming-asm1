package views.general.operations;

import java.util.Map;

public interface DeleteView {
    Map<String, String> displayDeleteForm();
    boolean displayDeleteConfirm();
}
