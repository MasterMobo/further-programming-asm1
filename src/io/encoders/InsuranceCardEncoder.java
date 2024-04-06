package io.encoders;

import io.Separator;
import models.card.InsuranceCard;

public class InsuranceCardEncoder extends StringEncoder<InsuranceCard> {
    @Override
    public String encode(InsuranceCard item) {
        return item.getCardNumber() + Separator.OBJECT
                + item.getCardHolderId() + Separator.OBJECT
                + item.getPolicyOwner() + Separator.OBJECT
                + item.getExpirationDate();
    }
}
