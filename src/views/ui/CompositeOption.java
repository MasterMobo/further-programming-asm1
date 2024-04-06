package views.ui;

import java.util.ArrayList;
import java.util.List;

public class CompositeOption extends Option{
    private List<Option> children;

    public CompositeOption(String title) {
        super(title);
        children = new ArrayList<>();
    }

    public void addOption(Option option) {
        children.add(option);
    }


    @Override
    public void displayOption() {
        for (int i = 0; i < children.size(); i++) {
            Option option = children.get(i);
            System.out.println((i + 1) + " - " + option.getTitle());
        }
    }
}
