package card;

import id.IdMap;
import id.PrefixIdGenerator;

public class InsuranceCardMap extends IdMap<InsuranceCard> implements InsuranceCardManager {
    public InsuranceCardMap() {
        super();
        idGenerator = new PrefixIdGenerator("", 10);
    }
}
