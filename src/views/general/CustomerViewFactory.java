package views.general;

public abstract class CustomerViewFactory {
    public abstract CustomerView createView();
    public abstract CustomerView createView(String role);
}
