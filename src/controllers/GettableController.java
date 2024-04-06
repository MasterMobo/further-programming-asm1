package controllers;

import java.util.List;

public interface GettableController<T> {
    T get();
    List<T> getMany();
}
