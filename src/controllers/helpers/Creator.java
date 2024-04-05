package controllers.helpers;

import java.util.Map;

public interface Creator<T> {
    T create(Map<String, String> data);
}
