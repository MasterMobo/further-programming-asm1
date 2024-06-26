package views.ui.options;

import controllers.system.SystemControllerManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

public abstract class Option {
    protected String title;
    protected List<Option> children;
    protected SystemControllerManager controllers;

    public Option(String title) {
        this.title = title;
        children = new ArrayList<>();
    }

    public abstract void execute();

    public String getTitle() {
        return title;
    }

    public List<Option> getChildren() {
        return children;
    }

    public void addOption(Option option) {
        children.add(option);
    }

    public boolean isLeaf() {
        return children.size() == 0;
    }
}
