package sample.Scenes;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.json.JSONArray;
import sample.Regisration.FileSystemService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SignInClient {

    private static final Path USERS_PATH = FileSystemService.getPathToFile("config", "DB.json");
    private static final Path USERS_PATH2 = FileSystemService.getPathToFile2("config", "Programari.json");

    public static Scene inregis(Stage primaryStage, Scene scene, String numeUtilizator) {

        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(10, 10, 10, 10));
        grid2.setVgap(8);
        grid2.setHgap(10);
        Scene sceneInregistrare = new Scene(grid2, 500, 250);

        Button programare = new Button("Programare noua ");
        programare.setOnAction(e ->
        {
            Scene programareNoua = SignInClient.programare(primaryStage, scene, numeUtilizator);
            primaryStage.setScene(programareNoua);
        });
        GridPane.setConstraints(programare, 0, 0);

        javafx.scene.control.Label l24a = new javafx.scene.control.Label("Test2:");
        GridPane.setConstraints(l24a, 0, 1);

        Button listaProg = new Button("Lista Programari");
        listaProg.setOnAction(e ->
        {
            Scene newScene = ListaProgramari.listaProgramari(primaryStage, scene, numeUtilizator);
            primaryStage.setScene(newScene);
        });
        GridPane.setConstraints(listaProg, 0, 2);

        javafx.scene.control.Label l24c = new javafx.scene.control.Label("Test4:");
        GridPane.setConstraints(l24c, 0, 3);

        Button listaDoctori = new Button("Lista de doctori");
        listaDoctori.setOnAction(e ->
        {
            Scene newScene = ListaDoctori.inregis(primaryStage, scene, numeUtilizator);
            primaryStage.setScene(newScene);
        });
        GridPane.setConstraints(listaDoctori, 2, 0);

        javafx.scene.control.TextField text2 = new javafx.scene.control.TextField();
        GridPane.setConstraints(text2, 1, 1);

        Button ultimaProg = new Button("Ultima programare");
        ultimaProg.setOnAction(e -> {
            Scene newScene = ListaProgramari.listaProgramari2(primaryStage, scene, numeUtilizator);
            primaryStage.setScene(newScene);
        });
        GridPane.setConstraints(ultimaProg, 2, 2);

        javafx.scene.control.TextField text4 = new javafx.scene.control.TextField();
        GridPane.setConstraints(text4, 1, 3);

        javafx.scene.control.Button ok = new Button("Iesire");
        ok.setOnAction(e ->
        {
            AlertBox.display("", "La revedere, sperăm că v-am fost de ajutor!");
            primaryStage.setScene(scene);
        });
        GridPane.setConstraints(ok, 1, 4);
        grid2.getChildren().addAll(programare, listaProg, listaDoctori, ultimaProg, ok);
        grid2.setAlignment(Pos.CENTER);
        return sceneInregistrare;
    }


    public static Scene programare(Stage primaryStage, Scene scene, String numeUtilizator) {

        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(10, 10, 10, 10));
        grid2.setVgap(8);
        grid2.setHgap(10);

        Scene sceneInregistrare = new Scene(grid2, 500, 250);

        Button programare = new Button("Inapoi ");
        programare.setOnAction(e ->
        {
            Scene sceneBack = SignInClient.inregis(primaryStage, scene, numeUtilizator);
            primaryStage.setScene(sceneBack);
        });
        GridPane.setConstraints(programare, 1, 5);


        javafx.scene.control.Label l1 = new javafx.scene.control.Label("Nume doctor:");
        GridPane.setConstraints(l1, 0, 0);

        TextField t1 = new TextField();
        GridPane.setConstraints(t1, 1, 0);

        javafx.scene.control.Label l2 = new javafx.scene.control.Label("Ora:");
        GridPane.setConstraints(l2, 0, 1);

        TextField t2 = new TextField();
        GridPane.setConstraints(t2, 1, 1);

        javafx.scene.control.Label l3 = new javafx.scene.control.Label("Ziua:");
        GridPane.setConstraints(l3, 0, 2);

        TextField t3 = new TextField();
        GridPane.setConstraints(t3, 1, 2);

        javafx.scene.control.Label l4 = new javafx.scene.control.Label("Luna:");
        GridPane.setConstraints(l4, 0, 3);

        TextField t4 = new TextField();
        GridPane.setConstraints(t4, 1, 3);

        javafx.scene.control.Label l5 = new javafx.scene.control.Label("Alte informații:");
        GridPane.setConstraints(l5, 0, 4);

        TextField t5 = new TextField();
        GridPane.setConstraints(t5, 1, 4);

        TextField t6 = new TextField();


        Button gata = new Button("Gata");
        gata.setOnAction(e ->
        {
            String first = "src\\main\\resources\\DB.json";
            int ok = 0;
            try {
                String contents = new String((Files.readAllBytes(Paths.get(first))));
                String contents2 = new String(Files.readAllBytes(USERS_PATH));
                JSONArray Lista = new JSONArray(contents2);
                for (int i = 0; i < Lista.length(); i++) {
                    if (Lista.getJSONObject(i).getString("nume_de_utilizator").equals(t1.getText()) && Lista.getJSONObject(i).getString("rol").equals("Doctor"))
                        ok++;
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if (t1.getText().equals("") || t2.getText().equals("") ||
                    t3.getText().equals("") || t4.getText().equals("")) {
                AlertBox.display("Eroarare", "Trebuie completate toate casutele");
            } else {
                if (ok == 0) {
                    AlertBox.display("Eroare", "Numele acestui doctor este greșit");
                } else {
                    ObjectMapper mapper = new ObjectMapper();
                    File jsonFile = Paths.get("src\\main\\resources\\Programari.json").toFile();
                    File jsonFile2 = USERS_PATH2.toFile();
                    JsonNode node = mapper.createObjectNode();

                    ((ObjectNode) node).put("numeClient", numeUtilizator);
                    ((ObjectNode) node).put("nume_doctor", t1.getText());
                    ((ObjectNode) node).put("ora", t2.getText());
                    ((ObjectNode) node).put("ziua", t3.getText());
                    ((ObjectNode) node).put("luna", t4.getText());
                    ((ObjectNode) node).put("alte_detalii", t5.getText());
                    ((ObjectNode) node).put("mesaj_doctor", "Necompletat");
                    ((ObjectNode) node).put("status", "In asteptare");
                    try {
                        ArrayNode root = (ArrayNode) mapper.readTree(jsonFile2);
                        root.add(node);
                        mapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile2, root);

                        ArrayNode root2 = (ArrayNode) mapper.readTree(jsonFile);
                        root2.add(node);
                        mapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, root2);
                        //UserService.persistUsers2();

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    AlertBox.display("Programare efectuata", "Programarea a fost realizată cu succes!");


                    Scene newScene = SignInClient.inregis(primaryStage, scene, numeUtilizator);
                    primaryStage.setScene(newScene);
                }
            }
        });
        GridPane.setConstraints(gata, 0, 5);


        grid2.getChildren().addAll(programare, l1, t1, l2, t2, l3, t3, l4, t4, l5, t5, gata);

        grid2.setAlignment(Pos.CENTER);

        return sceneInregistrare;
    }

}
