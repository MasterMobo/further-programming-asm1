package controllers;

import models.system.SystemStorageManager;
import views.system.SystemViewManager;

import java.util.Map;

public abstract class ControllerOperator<T> {
    protected SystemStorageManager systemStorageManager;
    protected SystemViewManager systemViewManager;

    public ControllerOperator() {
    }

    public ControllerOperator(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        this.systemStorageManager = systemStorageManager;
        this.systemViewManager = systemViewManager;
    }

    public abstract T execute(Map<String, String> data);

}
