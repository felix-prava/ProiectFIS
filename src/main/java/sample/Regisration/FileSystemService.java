package sample.Regisration;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystemService {
    public static final Path APPLICATION_HOME_PATH;
    private static final String APPLICATION_FOLDER = ".registration-example";
    private static final String USER_FOLDER = System.getProperty("user.home");

    static {
        APPLICATION_HOME_PATH = Paths.get(USER_FOLDER, ".registration-example");
    }

    public FileSystemService() {
    }

    public static Path getPathToFile(String... path) {
        return APPLICATION_HOME_PATH.resolve(Paths.get(".", path));
    }
}