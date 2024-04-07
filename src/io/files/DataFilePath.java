package io.files;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

public interface DataFilePath {
    String SEPARATOR = System.getProperty("file.separator");
    String WORK_DIR = System.getProperty("user.dir");
    String ROOT = WORK_DIR + SEPARATOR + "data";
    String POLICY_HOLDER = ROOT + SEPARATOR + "policy_holders.txt";
    String DEPENDENTS = ROOT + SEPARATOR + "dependents.txt";
    String INSURANCE_CLAIMS = ROOT + SEPARATOR + "insurance_claims.txt";
    String INSURANCE_CARDS = ROOT + SEPARATOR + "insurance_cards.txt";
}
