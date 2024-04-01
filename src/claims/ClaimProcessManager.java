package claims;

public interface ClaimProcessManager {
    InsuranceClaim add(String customerId, InsuranceClaim newClaim);
}
