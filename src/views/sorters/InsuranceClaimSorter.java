package views.sorters;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import models.claims.InsuranceClaim;
import models.claims.InsuranceClaimStatus;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InsuranceClaimSorter extends Sorter<InsuranceClaim> {
    @Override
    public List<InsuranceClaim> sort(List<InsuranceClaim> list) {
        List<InsuranceClaim> temp = new ArrayList<>(list);
        temp.sort(Comparator.comparing((InsuranceClaim c) -> c.getStatus().toString())
        );
        return temp;
    }
}
