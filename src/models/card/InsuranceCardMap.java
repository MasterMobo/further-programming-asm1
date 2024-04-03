package models.card;

import models.id.IdGenerator;
import models.id.IdMap;
import models.id.PrefixIdGenerator;

public class InsuranceCardMap extends IdMap<InsuranceCard> implements InsuranceCardManager {
    public InsuranceCardMap() {
        super(new PrefixIdGenerator("", 10));
    }

}
