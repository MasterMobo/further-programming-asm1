package card;

public class PolicyOwner {
    private String name;

    public PolicyOwner() {
        name = "Default";
    }

    public PolicyOwner(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PolicyOwner{" +
                "name='" + name + '\'' +
                '}';
    }
}
