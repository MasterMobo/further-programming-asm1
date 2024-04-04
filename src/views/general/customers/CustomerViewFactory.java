package views.general.customers;

public abstract class CustomerViewFactory {
    public abstract CustomerView createView();
    public abstract CustomerView createView(String role);
}
