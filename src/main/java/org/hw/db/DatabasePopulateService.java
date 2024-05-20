package org.hw.db;

import org.hw.reader.ReaderSQLFiles;
import org.hw.settings.Settings;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabasePopulateService {
    public static void main(String[] args) {
        DataBase dataBase = DataBase.getInstance();
        Connection conn = dataBase.getConnection();
        String script = new ReaderSQLFiles().getScript(Settings.FILE_NAME_POPULATE_DB);
        try {
            conn.createStatement().execute(script);
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
