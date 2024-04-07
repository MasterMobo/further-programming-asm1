package views.sorters;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import java.util.List;

public abstract class Sorter<T> {
    public Sorter() {
    }

    public abstract List<T> sort(List<T> list);
}
