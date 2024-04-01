package claims;

public class Document {
    private String title;
    private String content;

    public Document() {
        title = "Default";
        content = "Default";
    }

    public Document(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
