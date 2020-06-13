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
            //JSONObject o = new JSONObject(contents);
            JSONArray Lista = new JSONArray(contents);
            for (int i = 0; i < Lista.length(); i++) {
                //emails.getString("test1")

                //JSONObject test1 = o.getJSONObject("test1");
                //System.out.println(test1.getString("spouse"));
                //System.out.println(emails.get(i));

                System.out.println(Lista.getJSONObject(i).getString("parola"));
                System.out.println(parola);
                //System.out.println(Lista.getJSONObject(i).getString("nume_de_utilizator"));
                if (Lista.getJSONObject(i).getString("nume_de_utilizator").equals(nume)) {
                    System.out.println(Lista.getJSONObject(i).getString("parola"));
                    System.out.println(parola);

                    if (Lista.getJSONObject(i).getString("parola").compareTo(parola) == 0)
                        if (Lista.getJSONObject(i).getString("rol").equals("Doctor"))
                            return 1;
                        else return 2;
                }
                //System.out.println(Lista.getJSONObject(i).getString("parola"));


                //System.out.println(email.getString("spouse"));
                //System.out.println(Lista.getJSONObject(i).getJSONObject("email"));

                //JSONArray programare = Lista.getJSONObject(i).getJSONArray("programari");
                //for(int j=0; j<programare.length();j++)
                {
                    //System.out.println(programare.getJSONObject(j).getInt("zi"));
                }

                //System.out.println(Lista.getJSONObject(i).getJSONArray("programari"));
                //System.out.println(Lista.getJSONObject(i).getJSONArray("programari"));
            }
            //JSONObject family = o.getJSONObject("email");
            //System.out.println(family.getString("spouse"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
