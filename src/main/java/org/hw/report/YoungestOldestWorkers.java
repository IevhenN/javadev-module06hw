package org.hw.report;

import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@NoArgsConstructor
public class YoungestOldestWorkers implements Reportable {
    String type;
    String name;
    LocalDate birthday;

    @Override
    public YoungestOldestWorkers setItems(ResultSet resultSet) {
        try {
            this.type = resultSet.getString("type");
            this.name = resultSet.getString("name");
            this.birthday = resultSet.getDate("birthday").toLocalDate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return this;
    }

    @Override
    public String toString() {
        return "YoungestOldestWorkers{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
