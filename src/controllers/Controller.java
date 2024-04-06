package controllers;

import models.claims.InsuranceClaim;
import models.system.SystemStorageManager;
import views.general.MessageView;
import views.general.operations.ItemDisplayView;
import views.system.SystemViewManager;

import java.util.Map;

public abstract class Controller<T>{
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

    public T executeOperator(ControllerOperator<T> operator, Map<String, String> data, ItemDisplayView<T> view) {
        // Execute some operation over some data, then display results
        MessageView message = systemViewManager.getMessageView();

        T newItem = operator.execute(data);

        if (newItem == null) return null;

        message.displayMessage("Operation Success!");
        view.displayItem(newItem);

        return newItem;
    };

}
