package sample.Regisration;

import org.json.JSONArray;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadingJSON {

    private static final Path USERS_PATH = FileSystemService.getPathToFile("config", "DB.json");

    public static int citireSignIn(String nume, String parola) {
        String first = "src\\main\\resources\\DB.json";
        File jsonFile2 = USERS_PATH.toFile();

        try {
            String contents = new String((Files.readAllBytes(Paths.get(first))));
            String contents2 = new String(Files.readAllBytes(USERS_PATH));
            JSONArray Lista = new JSONArray(contents2);
            for (int i = 0; i < Lista.length(); i++) {

                if (Lista.getJSONObject(i).getString("nume_de_utilizator").equals(nume)) {
                    if (Lista.getJSONObject(i).getString("parola").compareTo(parola) == 0)
                        if (Lista.getJSONObject(i).getString("rol").equals("Doctor"))
                            return 1;
                        else return 2;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
