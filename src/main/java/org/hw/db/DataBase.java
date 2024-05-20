package org.hw.db;

import org.hw.settings.Settings;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
    private static final DataBase INSTANCE = new DataBase();
    private Connection connection;

    private DataBase() {
        try {
            String connectionUrl = Settings.getInstance().getString(Settings.DB_CONNECTION_URL);
            connection = DriverManager.getConnection(connectionUrl);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static DataBase getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }
}
