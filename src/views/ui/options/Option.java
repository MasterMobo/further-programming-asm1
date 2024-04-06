package views.ui.options;

import java.util.ArrayList;
import java.util.List;

public abstract class Option {
    protected String title;
    protected List<Option> children;

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
