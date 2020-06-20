package sample.Regisration;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import org.apache.commons.io.FileUtils;
import sample.Users.Persoana;
import sample.Users.Programare;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class UserService {

    private static final Path USERS_PATH = FileSystemService.getPathToFile("config", "DB.json");
    private static final Path USERS_PATH2 = FileSystemService.getPathToFile2("config", "Programari.json");
    private static List<Persoana> clienti;
    private static List<Programare> programari;

    public static void loadUsersFromFile() throws IOException {

        if (!Files.exists(USERS_PATH)) {
            FileUtils.copyURLToFile(UserService.class.getClassLoader().getResource("DB.json"), USERS_PATH.toFile());
        }


        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.setVisibilityChecker(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));

        clienti = objectMapper.readValue(USERS_PATH.toFile(), new TypeReference<List<Persoana>>() {
        });


        if (!Files.exists(USERS_PATH2)) {
            FileUtils.copyURLToFile(UserService.class.getClassLoader().getResource("Programari.json"), USERS_PATH2.toFile());
        }

        ObjectMapper objectMapper2 = new ObjectMapper();
        objectMapper2.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper2.setVisibilityChecker(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));

        programari = objectMapper2.readValue(USERS_PATH2.toFile(), new TypeReference<List<Programare>>() {
        });


    }

    public static void persistUsers() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(USERS_PATH.toFile(), clienti);
        } catch (IOException e) {
            throw new CouldNotWriteUsersException();
        }
    }

    public static void persistUsers2() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(USERS_PATH2.toFile(), programari);
        } catch (IOException e) {
            throw new CouldNotWriteUsersException();
        }
    }
}
