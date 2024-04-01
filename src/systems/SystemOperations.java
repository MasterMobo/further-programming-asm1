package systems;

import card.InsuranceCard;
import claims.InsuranceClaim;
import customer.Customer;

import java.util.List;

public interface SystemOperations extends CustomerOperations, InsuranceCardOperations, InsuranceClaimOperations{

}
