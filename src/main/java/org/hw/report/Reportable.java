package org.hw.report;

import java.sql.ResultSet;

@FunctionalInterface
public interface Reportable<T> {
    T setItems(ResultSet resultSet);
}
