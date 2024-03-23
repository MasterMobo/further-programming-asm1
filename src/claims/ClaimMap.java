package claims;

import maps.IdMap;

import java.util.ArrayList;
import java.util.List;

public class ClaimMap extends IdMap<InsuranceClaim> implements ClaimMapOperations {
    // This class maps unique ID (String) to InsuranceClaim
    // IMPORTANT: Each instance of this class only records insurance claims of ONE customer
    // This class is NOT used to manage all the claims in the entire system

    public ClaimMap() {
        super();
    }

    @Override
    public List<InsuranceClaim> getAll() {
        return new ArrayList<>(idToItem.values());
    }

    @Override
    public InsuranceClaim update(String id, InsuranceClaim newClaim) {
        if (!idToItem.containsKey(id)) {
            return null;
        }

        return idToItem.put(id, newClaim);
    }
}
