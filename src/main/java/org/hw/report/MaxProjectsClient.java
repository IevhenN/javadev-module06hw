package org.hw.report;

import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@NoArgsConstructor

public class MaxProjectsClient implements Reportable {
    private String name;
    int projectCount = 0;

    @Override
    public MaxProjectsClient setItems(ResultSet resultSet) {
        try {
            this.name = resultSet.getString("name");
            this.projectCount = resultSet.getInt("project_count");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return this;
    }

    @Override
    public String toString() {
        return "MaxProjectsClient{" +
                "name='" + name + '\'' +
                ", projectCount=" + projectCount +
                '}';
    }
}
