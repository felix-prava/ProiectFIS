package sample.Scenes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.json.JSONArray;
import sample.Users.Doctor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListaDoctori {
    public static Scene inregis(Stage primaryStage, Scene scene, String numeUtilizator) {


        TableColumn<Doctor, String> nameColumn = new TableColumn<>("Nume");
        nameColumn.setMinWidth(160);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nume"));

        TableColumn<Doctor, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setMinWidth(160);
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Doctor, String> adressColumn = new TableColumn<>("Adresa");
        adressColumn.setMinWidth(220);
        adressColumn.setCellValueFactory(new PropertyValueFactory<>("adresa"));

        TableColumn<Doctor, String> profilColumn = new TableColumn<>("Profil");
        profilColumn.setMinWidth(260);
        profilColumn.setCellValueFactory(new PropertyValueFactory<>("profil"));

        TableView<Doctor> table = new TableView<>();
        table.setItems(getDoctor());
        table.getColumns().addAll(nameColumn, emailColumn, adressColumn, profilColumn);

        Button inapoi = new Button("Înapoi");
        inapoi.setOnAction(e -> {
            Scene scene2 = SignInClient.inregis(primaryStage, scene, numeUtilizator);
            primaryStage.setScene(scene2);
        });

        Label l1 = new Label("                                                                               ");
        Label l2 = new Label(" ");

        HBox hBox = new HBox();
        hBox.getChildren().addAll(l1, inapoi, l2);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);

        Scene scene2 = new Scene(vBox, 750, 400);

        return scene2;
    }

    public static ObservableList<Doctor> getDoctor() {
        ObservableList<Doctor> doctori = FXCollections.observableArrayList();
        String first = "src\\main\\resources\\DB.json";
        String contents = null;
        try {
            contents = new String((Files.readAllBytes(Paths.get(first))));

            JSONArray Lista = new JSONArray(contents);
            for (int i = 0; i < Lista.length(); i++) {
                if (Lista.getJSONObject(i).getString("rol").equals("Doctor")) {
                    String a = Lista.getJSONObject(i).getString("nume_de_utilizator");
                    String b = Lista.getJSONObject(i).getString("email");
                    String c = Lista.getJSONObject(i).getString("adresa");
                    String d = Lista.getJSONObject(i).getString("profil");
                    doctori.add(new Doctor(a, b, c, d));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doctori;
    }


}
