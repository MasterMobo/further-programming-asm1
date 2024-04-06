package io.files;

import io.files.decoders.items.PolicyHolderDecoder;
import io.files.decoders.storages.CardStorageDecoder;
import io.files.decoders.storages.ClaimStorageDecoder;
import io.files.decoders.storages.DependentStorageDecoder;
import io.files.decoders.storages.PolicyHolderStorageDecoder;
import io.files.encoders.items.PolicyHolderEncoder;
import io.files.encoders.storages.CardStorageEncoder;
import io.files.encoders.storages.ClaimStorageEncoder;
import io.files.encoders.storages.DependentStorageEncoder;
import io.files.encoders.storages.PolicyHolderStorageEncoder;
import models.card.InsuranceCardMapStorage;
import models.card.InsuranceCardStorage;
import models.claims.InsuranceClaimMapStorage;
import models.claims.InsuranceClaimStorage;
import models.customer.CustomerStorageManager;
import models.customer.CustomerStorageMap;
import models.customer.roles.dependent.Dependent;
import models.customer.roles.dependent.DependentMapStorage;
import models.customer.roles.dependent.DependentStorage;
import models.customer.roles.holder.PolicyHolderMapStorage;
import models.customer.roles.holder.PolicyHolderStorage;
import models.system.SystemStorageManager;
import models.system.SystemStorageMap;

import java.beans.Encoder;

public class FileManager {
    private static FileManager instance;
    private SystemStorageManager systemStorageManager;
    private FileIOHandler ioHandler;
    private FileManager() {
        ioHandler = new FileIOHandler();
    }

    public SystemStorageManager initializeDataFiles() {
        if (!ioHandler.dirExists(DataFilePath.ROOT)) {
            ioHandler.createDir(DataFilePath.ROOT);

            // TODO: add sample data here
            ioHandler.writeTo(DataFilePath.POLICY_HOLDER, "");
            ioHandler.writeTo(DataFilePath.DEPENDENTS, "");
            ioHandler.writeTo(DataFilePath.INSURANCE_CARDS, "");
            ioHandler.writeTo(DataFilePath.INSURANCE_CLAIMS, "");
        }

        return read();
    }

    public void save() {
        // Create the encoders
        PolicyHolderStorageEncoder policyHolderEncoder = new PolicyHolderStorageEncoder();
        DependentStorageEncoder dependentEncoder = new DependentStorageEncoder();
        CardStorageEncoder cardEncoder = new CardStorageEncoder();
        ClaimStorageEncoder claimEncoder = new ClaimStorageEncoder();

        // Get the storages
        PolicyHolderStorage policyHolders = systemStorageManager.getCustomerStorageManager().getPolicyHolderStorage();
        DependentStorage dependents = systemStorageManager.getCustomerStorageManager().getDependentStorage();
        InsuranceCardStorage cards = systemStorageManager.getCardStorage();
        InsuranceClaimStorage claims = systemStorageManager.getClaimStorage();

        // Encode contents from storages to file
        ioHandler.writeTo(DataFilePath.POLICY_HOLDER, policyHolderEncoder.encode(policyHolders));
        ioHandler.writeTo(DataFilePath.DEPENDENTS, dependentEncoder.encode(dependents));
        ioHandler.writeTo(DataFilePath.INSURANCE_CARDS, cardEncoder.encode(cards));
        ioHandler.writeTo(DataFilePath.INSURANCE_CLAIMS, claimEncoder.encode(claims));
    }

    public SystemStorageManager read() {
        // Create new storages
        SystemStorageManager storageManager = new SystemStorageMap();
        CustomerStorageManager customers = new CustomerStorageMap();
        PolicyHolderStorage policyHolders = new PolicyHolderMapStorage();
        DependentStorage dependents = new DependentMapStorage();
        InsuranceCardStorage cards = new InsuranceCardMapStorage();
        InsuranceClaimStorage claims = new InsuranceClaimMapStorage();

        // Create decoders
        PolicyHolderStorageDecoder policyHolderDecoder = new PolicyHolderStorageDecoder(policyHolders);
        DependentStorageDecoder dependentDecoder = new DependentStorageDecoder(dependents);
        CardStorageDecoder cardDecoder = new CardStorageDecoder(cards);
        ClaimStorageDecoder claimDecoder = new ClaimStorageDecoder(claims);

        // Read contents from file and add it to storages
        policyHolderDecoder.decode(ioHandler.readFrom(DataFilePath.POLICY_HOLDER));
        dependentDecoder.decode(ioHandler.readFrom(DataFilePath.DEPENDENTS));
        cardDecoder.decode(ioHandler.readFrom(DataFilePath.INSURANCE_CARDS));
        claimDecoder.decode(ioHandler.readFrom(DataFilePath.INSURANCE_CLAIMS));

        // Reconstruct system storage manager
        customers.add(policyHolders);
        customers.add(dependents);
        storageManager.add(customers);
        storageManager.add(cards);
        storageManager.add(claims);

        return storageManager;
    }

    public static FileManager setSystemStorageManager(SystemStorageManager systemStorageManager) {
        instance = getInstance();
        instance.systemStorageManager = systemStorageManager;
        return instance;
    }

    public static FileManager getInstance() {
        if (instance == null) {
            instance = new FileManager();
        }
        return instance;
    }
}
