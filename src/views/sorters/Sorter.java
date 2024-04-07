package views.sorters;

import java.util.List;

public abstract class Sorter<T> {
    public Sorter() {
    }

    public abstract List<T> sort(List<T> list);
}
