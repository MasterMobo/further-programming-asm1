package id;

public class PrefixIdGenerator implements IdGenerator{
    private String prefix;  // Prefix of the id
    private int numLength;  // Length of the number after the prefix

    public PrefixIdGenerator() {
        prefix = "";
        numLength = 0;
    }

    public PrefixIdGenerator(String prefix, int numLength) {
        this.prefix = prefix;
        this.numLength = numLength;
    }

    @Override
    public String randomId() {
        StringBuilder s = new StringBuilder(prefix);
        for (int i = 0; i < numLength; i++) {
            s.append((int) Math.floor(Math.random() * 10));
        }
        return s.toString();
    }
}
