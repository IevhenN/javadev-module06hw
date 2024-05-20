package org.hw.db;

import lombok.Data;
import org.hw.reader.ReaderSQLFiles;
import org.hw.report.*;
import org.hw.settings.Settings;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Data
public class DatabaseQueryService {
    public static void main(String[] args) {
        DatabaseQueryService databaseQueryService = new DatabaseQueryService();
        DataBase dataBase = DataBase.getInstance();
        Connection connection = dataBase.getConnection();

        List<LongestProject> longestProjects = databaseQueryService.findLongestProject(connection);
        System.out.println(longestProjects.toString());
        System.out.println("");

        List<MaxProjectsClient> maxProjectsClients = databaseQueryService.findMaxProjectsClient(connection);
        System.out.println(maxProjectsClients.toString());
        System.out.println("");

        List<MaxSalaryWorker> maxSalaryWorkers = databaseQueryService.findMaxSalaryWorker(connection);
        System.out.println(maxSalaryWorkers.toString());
        System.out.println("");

        List<YoungestOldestWorkers> youngestOldestWorkers = databaseQueryService.findYoungestOldestWorkers(connection);
        System.out.println(youngestOldestWorkers.toString());
        System.out.println("");

        List<PrintProjectPrices> printProjectPrices = databaseQueryService.findPrintProjectPrices(connection);
        System.out.println(printProjectPrices.toString());

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<LongestProject> findLongestProject(Connection connection) {
        String script = new ReaderSQLFiles().getScript(Settings.FILE_NAME_FIND_LONGEST_PROJECT);
        List<LongestProject> longestProjects = fillClassData(LongestProject.class, connection, script);
        return longestProjects;
    }

    public List<MaxProjectsClient> findMaxProjectsClient(Connection connection) {
        String script = new ReaderSQLFiles().getScript(Settings.FILE_NAME_FIND_MAX_PROJECTS_CLIENT);
        List<MaxProjectsClient> maxProjectsClients = fillClassData(MaxProjectsClient.class, connection, script);
        return maxProjectsClients;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker(Connection connection) {
        String script = new ReaderSQLFiles().getScript(Settings.FILE_NAME_FIND_MAX_SALARY_WORKER);
        List<MaxSalaryWorker> maxSalaryWorkers = fillClassData(MaxSalaryWorker.class, connection, script);
        return maxSalaryWorkers;
    }

    public List<YoungestOldestWorkers> findYoungestOldestWorkers(Connection connection) {
        String script = new ReaderSQLFiles().getScript(Settings.FILE_NAME_FIND_YOUNGEST_OLDEST_WORKERS);
        List<YoungestOldestWorkers> youngestOldestWorkers = fillClassData(YoungestOldestWorkers.class, connection, script);
        return youngestOldestWorkers;
    }

    public List<PrintProjectPrices> findPrintProjectPrices(Connection connection) {
        String script = new ReaderSQLFiles().getScript(Settings.FILE_NAME_PRINT_PROJECT_PRICES);
        List<PrintProjectPrices> printProjectPrices = fillClassData(PrintProjectPrices.class, connection, script);
        return printProjectPrices;
    }

    public <T extends Reportable<T>> List<T> fillClassData(Class<T> tClass, Connection connection, String script) {
        List<T> classes = new ArrayList<>();
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(script);
            while (resultSet.next()) {
                classes.add(tClass.getDeclaredConstructor().newInstance().setItems(resultSet));
            }
        } catch (SQLException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            e.fillInStackTrace();
        }
        return classes;
    }
}
