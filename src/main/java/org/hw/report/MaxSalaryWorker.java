package org.hw.report;

import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@NoArgsConstructor
public class MaxSalaryWorker implements Reportable {
    String name;
    int salary;

    @Override
    public MaxSalaryWorker setItems(ResultSet resultSet) {
        try {
            this.name = resultSet.getString("name");
            this.salary = resultSet.getInt("salary");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return this;
    }

    @Override
    public String toString() {
        return "MaxSalaryWorker{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
