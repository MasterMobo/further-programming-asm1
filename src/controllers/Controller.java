package controllers;

import models.system.SystemManager;
import views.general.SystemView;

public abstract class Controller<T>{
    // Model
    protected SystemManager systemManager;

    // View
    protected SystemView systemView;

    public Controller() {
    }

    public Controller(SystemManager systemManager, SystemView systemView) {
        this.systemManager = systemManager;
        this.systemView = systemView;
    }
}
