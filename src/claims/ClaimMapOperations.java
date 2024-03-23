package claims;

import java.util.List;

public interface ClaimMapOperations {
    // Get the claim with specified ID
    // Returns null if id does not exist
    InsuranceClaim get(String id);

    // Get all the claims in the map
    // Returns empty list if map is empty
    List<InsuranceClaim> getAll();

    // Find and update a claim with specified ID
    // Returns the newly updated claim
    // If ID does not exist, return null
    InsuranceClaim update(String id, InsuranceClaim newClaim);

    // Add a new claim to the map
    // Return the new claim
    InsuranceClaim add(InsuranceClaim claim);
}
