package controllers;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import models.system.SystemStorageManager;
import views.system.SystemViewManager;

import java.util.Map;

public abstract class ControllerOperator {
    protected SystemStorageManager systemStorageManager;
    protected SystemViewManager systemViewManager;

    public ControllerOperator() {
    }

    public ControllerOperator(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        this.systemStorageManager = systemStorageManager;
        this.systemViewManager = systemViewManager;
    }

    public abstract Object execute(Map<String, String> data);

}
