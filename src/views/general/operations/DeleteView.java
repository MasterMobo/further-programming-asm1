package views.general.operations;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import java.util.Map;

public interface DeleteView {
    Map<String, String> displayDeleteForm();
    boolean displayDeleteConfirm();
}
