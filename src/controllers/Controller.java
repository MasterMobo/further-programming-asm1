package controllers;

import models.system.SystemStorageManager;
import views.general.SystemView;

public abstract class Controller<T>{
    // Model
    protected SystemStorageManager systemStorageManager;

    // View
    protected SystemView systemView;

    public Controller() {
    }

    public Controller(SystemStorageManager systemStorageManager, SystemView systemView) {
        this.systemStorageManager = systemStorageManager;
        this.systemView = systemView;
    }
}
