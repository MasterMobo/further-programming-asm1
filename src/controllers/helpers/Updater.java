package controllers.helpers;

import models.claims.InsuranceClaim;

import java.util.Map;

public interface Updater<T> {
    T update(Map<String, String> data);
}
