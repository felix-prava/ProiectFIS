package sample.Regisration;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystemService {
    //public static final Path APPLICATION_HOME_PATH;
    //public static final Path APPLICATION_HOME_PATH2;
    private static final String APPLICATION_FOLDER = ".registration";
    public static final Path APPLICATION_HOME_PATH = Paths.get(USER_FOLDER, APPLICATION_FOLDER);
    private static final String USER_FOLDER = System.getProperty("user.home");
    private static final String APPLICATION_FOLDER2 = ".appointment";
    public static final Path APPLICATION_HOME_PATH2 = Paths.get(USER_FOLDER, APPLICATION_FOLDER2);


    public FileSystemService() {
    }

    public static Path getPathToFile(String... path) {
        return APPLICATION_HOME_PATH.resolve(Paths.get(".", path));
    }

    public static Path getPathToFile2(String... path) {
        return APPLICATION_HOME_PATH2.resolve(Paths.get(".", path));
    }
}