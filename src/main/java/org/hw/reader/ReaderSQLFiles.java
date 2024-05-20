package org.hw.reader;

import lombok.Data;
import org.apache.commons.io.FileUtils;
import org.hw.settings.Settings;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Data
public class ReaderSQLFiles {
    public String getScript(String fileName) {
        String pathFile = String.format("%s/%s"
                , Settings.getInstance().getString(Settings.PATH_SQL_SCRIPT_FOLDER)
                , Settings.getInstance().getString(fileName));
        File file = new File(pathFile);

        try {
            return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
