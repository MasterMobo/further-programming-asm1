package claims;

import maps.Identifiable;

public class InsuranceClaim implements Identifiable {
    private String id;

    @Override
    public String getId() {
        return id;
    }
}
