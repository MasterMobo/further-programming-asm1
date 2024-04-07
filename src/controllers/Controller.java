package controllers;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import models.storage.StorageItem;
import models.system.SystemStorageManager;
import views.general.MessageView;
import views.general.operations.ItemDisplayView;
import views.system.SystemViewManager;

import java.util.Map;

public abstract class Controller<T> implements StorageItem {
    // Model
    protected SystemStorageManager systemStorageManager;

    // View
    protected SystemViewManager systemViewManager;

    public Controller() {
    }

    public Controller(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        this.systemStorageManager = systemStorageManager;
        this.systemViewManager = systemViewManager;
    }

    public T executeOperator(ControllerOperator operator, Map<String, String> data, ItemDisplayView<T> view) {
        // Execute some operation over some data, then display results
        MessageView message = systemViewManager.getMessageView();

        T newItem = (T) operator.execute(data);

        if (newItem == null) return null;

        message.displayMessage("Operation Success!");
        view.displayItem(newItem);

        return newItem;
    };

}
