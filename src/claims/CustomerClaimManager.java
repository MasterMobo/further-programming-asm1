package claims;

import java.util.List;

public interface CustomerClaimManager {
    // This interface deals with all the claims belonging to a single customer

    // Get the claim with specified ID
    // Returns null if id does not exist
    InsuranceClaim get(String claimId);

    // Get all the claims in the map
    // Returns empty list if map is empty
    List<InsuranceClaim> getAll();

    // Find and update a claim with specified ID
    // Returns the newly updated claim
    // If ID does not exist, return null
    InsuranceClaim update(String claimId, InsuranceClaim newClaim);

    // Add a new claim to the map
    // Return the new claim
    InsuranceClaim add(InsuranceClaim claim);
}
