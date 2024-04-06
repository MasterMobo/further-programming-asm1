package io.files.decoders.storages;

import io.files.decoders.items.InsuranceCardDecoder;
import models.card.InsuranceCard;
import models.card.InsuranceCardStorage;

public class CardStorageDecoder extends StorageDecoder<InsuranceCardStorage, InsuranceCard> {
    public CardStorageDecoder(InsuranceCardStorage storage) {
        super(new InsuranceCardDecoder(), storage);
    }
}
