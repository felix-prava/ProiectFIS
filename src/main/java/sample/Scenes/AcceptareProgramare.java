package sample.Scenes;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.json.JSONArray;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AcceptareProgramare {

    public static Scene acceptareProgramare(Stage primaryStage, Scene scene, String numeUtilizator) {

        GridPane grid2 = new GridPane();

        grid2.setPadding(new Insets(10, 10, 10, 10));
        grid2.setVgap(8);
        grid2.setHgap(10);
        Scene editareProfil = new Scene(grid2, 680, 250);

        Label l1 = new Label("Nume client");
        GridPane.setConstraints(l1, 0, 0);
        Label l2 = new Label("Ora propusa de pacient");
        GridPane.setConstraints(l2, 0, 1);
        Label l3 = new Label("Zi propusa de pacient");
        GridPane.setConstraints(l3, 0, 2);
        Label l4 = new Label("Luna");
        GridPane.setConstraints(l4, 0, 3);

        TextField t1 = new TextField();
        GridPane.setConstraints(t1, 1, 0);
        TextField t2 = new TextField();
        GridPane.setConstraints(t2, 1, 1);
        TextField t3 = new TextField();
        GridPane.setConstraints(t3, 1, 2);
        TextField t4 = new TextField();
        GridPane.setConstraints(t4, 1, 3);

        Label l5 = new Label("Ora stabilita");
        GridPane.setConstraints(l5, 2, 1);
        Label l6 = new Label("Ziua stabilita");
        GridPane.setConstraints(l6, 2, 2);
        Label l7 = new Label("Mesajul meu");
        GridPane.setConstraints(l7, 2, 3);
        TextField t5 = new TextField();
        GridPane.setConstraints(t5, 3, 1);
        TextField t6 = new TextField();
        GridPane.setConstraints(t6, 3, 2);
        TextField t7 = new TextField();
        GridPane.setConstraints(t7, 3, 3);

        Button salvare = new Button("Salveaza");
        salvare.setOnAction(e -> {
            int ok = 0;

            String first = "src\\main\\resources\\Programari.json";
            try {
                String contents1 = new String((Files.readAllBytes(Paths.get(first))));
                JSONArray Lista = new JSONArray(contents1);
                for (int i = 0; i < Lista.length(); i++) {

                    if (Lista.getJSONObject(i).getString("numeClient").equals(t1.getText())
                            && Lista.getJSONObject(i).getString("ora").equals(t2.getText())
                            && Lista.getJSONObject(i).getString("ziua").equals(t3.getText())
                            && Lista.getJSONObject(i).getString("luna").equals(t4.getText())
                            && Lista.getJSONObject(i).getString("nume_doctor").equals(numeUtilizator)
                            && Lista.getJSONObject(i).getString("status").equals("In asteptare")
                    ) {
                        ok++;
                        try {
                            String contents = new String((Files.readAllBytes(Paths.get(first))));
                            ObjectMapper mapper = new ObjectMapper();
                            File jsonFile = Paths.get(first).toFile();
                            ArrayNode root = (ArrayNode) mapper.readTree(jsonFile);

                            try {

                                for (JsonNode node : root) {

                                    if (node.path("numeClient").asText().equals(t1.getText())
                                            && node.path("ora").asText().equals(t2.getText())
                                            && node.path("ziua").asText().equals(t3.getText())
                                            && node.path("luna").asText().equals(t4.getText())
                                            && node.path("nume_doctor").asText().equals(numeUtilizator)
                                            && node.path("status").asText().equals("In asteptare")
                                    ) {
                                        ((ObjectNode) node).put("ora", t5.getText());
                                        ((ObjectNode) node).put("ziua", t6.getText());
                                        ((ObjectNode) node).put("mesaj_doctor", t7.getText());
                                        ((ObjectNode) node).put("status", "Acceptata");
                                        mapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, root);
                                    }
                                }

                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }

                        } catch (IOException exc) {
                            exc.printStackTrace();
                        }
                        AlertBox.display("", "Programarea a fost acceptata");
                        Scene newScene = SignInDoctor.inregis(primaryStage, scene, numeUtilizator);
                        primaryStage.setScene(newScene);
                    }


                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if (ok == 0)
                AlertBox.display("", "Datele introduse nu sunt corecte");

        });
        GridPane.setConstraints(salvare, 1, 4);

        Button inapoi = new Button("Inapoi");
        inapoi.setOnAction(e -> {
            Scene newScene = SignInDoctor.inregis(primaryStage, scene, numeUtilizator);
            primaryStage.setScene(newScene);
        });
        GridPane.setConstraints(inapoi, 2, 4);


        grid2.getChildren().addAll(l1, l2, l3, l4, t1, t2, t3, t4, l5, l6, t5, t6, inapoi, salvare, l7, t7);
        grid2.setAlignment(Pos.CENTER);
        return editareProfil;
    }
}
