package sample.Regisration;

import org.json.JSONArray;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadingJSON {

    public static int citireSignIn(String nume, String parola) {
        String first = "src\\main\\resources\\DB.json";

        try {
            String contents = new String((Files.readAllBytes(Paths.get(first))));
            JSONArray Lista = new JSONArray(contents);
            for (int i = 0; i < Lista.length(); i++) {

                if (Lista.getJSONObject(i).getString("nume_de_utilizator").equals(nume)) {
                    //System.out.println(Lista.getJSONObject(i).getString("parola"));
                    //System.out.println(parola);

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
