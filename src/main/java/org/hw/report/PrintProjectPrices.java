package org.hw.report;

import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@NoArgsConstructor
public class PrintProjectPrices implements Reportable {
    String name;
    int price;

    @Override
    public PrintProjectPrices setItems(ResultSet resultSet) {
        try {
            this.name = resultSet.getString("name");
            this.price = resultSet.getInt("price");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public String toString() {
        return "PrintProjectPrices{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
