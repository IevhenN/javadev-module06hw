package org.hw.report;

import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@NoArgsConstructor
public class LongestProject implements Reportable {
    private String name;
    private int monthCount;

    @Override
    public LongestProject setItems(ResultSet resultSet) {
        try {
            this.name = resultSet.getString("name");
            this.monthCount = resultSet.getInt("month_count");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return this;
    }

    @Override
    public String toString() {
        return "LongestProject{" +
                "name='" + name + '\'' +
                ", monthCount=" + monthCount +
                '}';
    }
}
