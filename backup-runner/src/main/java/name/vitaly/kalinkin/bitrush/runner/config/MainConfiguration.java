package name.vitaly.kalinkin.bitrush.runner.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.io.File;
import java.util.List;

public class MainConfiguration {

    private static final String SOURCE_FOLDERS_KEY = "source_folders";
    private static final String TEMPORARY_RESULT_FOLDER = "temp_folder";
    private List<String> sourceFolders;
    private String temporaryReactorFolder;

    public List<String> getSourceFolders() {
        return sourceFolders;
    }

    public static MainConfiguration readFromFile(String configurationFileName) {
        Config config = ConfigFactory.parseFile(new File(configurationFileName));
        
        return parseFromConfig(config);
    }

    public String getTemporaryReactorFolder() {
        return temporaryReactorFolder;
    }

    private static MainConfiguration parseFromConfig(Config config) {
        MainConfiguration result = new MainConfiguration();
        
        result.sourceFolders = config.getStringList(SOURCE_FOLDERS_KEY);
        result.temporaryReactorFolder = config.getString(TEMPORARY_RESULT_FOLDER);
        
        return result;
    }

    @Override
    public String toString() {
        return "MainConfiguration{" +
                "sourceFolders=" + sourceFolders +
                '}';
    }
}