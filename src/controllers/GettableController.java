package controllers;

import java.util.List;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

public interface GettableController<T> {
    T get();
    List<T> getMany();
}
