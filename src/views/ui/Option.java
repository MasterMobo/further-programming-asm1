package views.ui;

public abstract class Option {
    protected String title;

    public Option(String title) {
        this.title = title;
    }

    public abstract void displayOption();

    public String getTitle() {
        return title;
    }
}
