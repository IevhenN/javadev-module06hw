package org.hw.settings;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Settings {
    public static final String INIT_FILE_PATH_DEFAULT = "settings.json";
    public static final String PATH_SQL_SCRIPT_FOLDER = "path_sql_script_folder";

    public static final String DB_CONNECTION_URL = "db_connection_url";
    public static final String FILE_NAME_INIT_DB = "file_name_init_db";
    public static final String FILE_NAME_POPULATE_DB = "file_name_populate_db";
    public static final String FILE_NAME_FIND_LONGEST_PROJECT = "file_name_find_longest_project";
    public static final String FILE_NAME_FIND_MAX_PROJECTS_CLIENT = "file_name_find_max_projects_client";

    public static final String FILE_NAME_FIND_MAX_SALARY_WORKER = "file_name_find_max_salary_worker";
    public static final String FILE_NAME_FIND_YOUNGEST_OLDEST_WORKERS = "file_name_find_youngest_oldest_workers";
    public static final String FILE_NAME_PRINT_PROJECT_PRICES = "file_name_print_project_prices";

    private static final Settings INSTANCE = new Settings(INIT_FILE_PATH_DEFAULT);

    private Map<String, Object> settings = new HashMap<>();

    public static Settings getInstance() {
        return INSTANCE;
    }

    public String getString(String key) {
        return settings.get(key).toString();
    }

    public Object getObject(String key) {
        return settings.get(key);
    }

    private Settings(String filePath) {
        initSettings(filePath);
    }

    private void initSettings(String filePath) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        JsonObject jsonObject = JsonParser.parseReader(fileReader).getAsJsonObject();
        Gson gson = new Gson();

        TypeToken<?> typeToken = TypeToken.getParameterized(
                Map.class,
                String.class,
                Object.class
        );
        settings = gson.fromJson(jsonObject, typeToken.getType());
    }
}
