package controllers;

import models.system.SystemStorageManager;
import views.system.SystemViewManager;

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
}
