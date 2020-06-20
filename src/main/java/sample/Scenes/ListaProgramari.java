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
import sample.Regisration.FileSystemService;
import sample.Users.Programare;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListaProgramari {
    public static Scene listaProgramari(Stage primaryStage, Scene scene, String numeUtilizator) {


        TableColumn<Programare, String> nameColumn = new TableColumn<>("Nume doctor");
        nameColumn.setMinWidth(160);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("numeDoctor"));

        TableColumn<Programare, String> oraColumn = new TableColumn<>("Ora");
        oraColumn.setMinWidth(160);
        oraColumn.setCellValueFactory(new PropertyValueFactory<>("ora"));

        TableColumn<Programare, String> ziColumn = new TableColumn<>("Zi");
        ziColumn.setMinWidth(220);
        ziColumn.setCellValueFactory(new PropertyValueFactory<>("zi"));

        TableColumn<Programare, String> lunaColumn = new TableColumn<>("Luna");
        lunaColumn.setMinWidth(260);
        lunaColumn.setCellValueFactory(new PropertyValueFactory<>("luna"));

        TableColumn<Programare, String> detaliuColumn = new TableColumn<>("Alte Detalii");
        detaliuColumn.setMinWidth(260);
        detaliuColumn.setCellValueFactory(new PropertyValueFactory<>("detalii"));

        TableColumn<Programare, String> mesajColumn = new TableColumn<>("Mesajul Doctorului");
        mesajColumn.setMinWidth(360);
        mesajColumn.setCellValueFactory(new PropertyValueFactory<>("mesaj"));

        TableColumn<Programare, String> statusColumn = new TableColumn<>("Statusul Programării");
        statusColumn.setMinWidth(260);
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        TableView<Programare> table = new TableView<>();
        table.setItems(getProgramari(numeUtilizator));
        //table.setItems(getDoctor());
        table.getColumns().addAll(nameColumn, oraColumn, ziColumn, lunaColumn, detaliuColumn, mesajColumn, statusColumn);

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

    private static final Path USERS_PATH2 = FileSystemService.getPathToFile2("config", "Programari.json");

    public static ObservableList<Programare> getProgramari(String numeUtilizator) {
        ObservableList<Programare> programari = FXCollections.observableArrayList();
        String first = "src\\main\\resources\\Programari.json";
        String contents = null;
        String contents2 = null;
        try {
            contents = new String((Files.readAllBytes(Paths.get(first))));
            contents2 = new String((Files.readAllBytes(USERS_PATH2)));

            JSONArray Lista = new JSONArray(contents2);
            for (int i = 0; i < Lista.length(); i++) {
                if (Lista.getJSONObject(i).getString("numeClient").equals(numeUtilizator)) {
                    String a = Lista.getJSONObject(i).getString("nume_doctor");
                    String b = Lista.getJSONObject(i).getString("ora");
                    String c = Lista.getJSONObject(i).getString("ziua");
                    String d = Lista.getJSONObject(i).getString("luna");
                    String e = Lista.getJSONObject(i).getString("alte_detalii");
                    String f = Lista.getJSONObject(i).getString("mesaj_doctor");
                    String g = Lista.getJSONObject(i).getString("status");
                    programari.add(new Programare(a, b, c, d, e, f, g, ""));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return programari;
    }


    public static Scene listaProgramari2(Stage primaryStage, Scene scene, String numeUtilizator) {


        TableColumn<Programare, String> nameColumn = new TableColumn<>("Nume doctor");
        nameColumn.setMinWidth(160);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("numeDoctor"));

        TableColumn<Programare, String> oraColumn = new TableColumn<>("Ora");
        oraColumn.setMinWidth(160);
        oraColumn.setCellValueFactory(new PropertyValueFactory<>("ora"));

        TableColumn<Programare, String> ziColumn = new TableColumn<>("Zi");
        ziColumn.setMinWidth(220);
        ziColumn.setCellValueFactory(new PropertyValueFactory<>("zi"));

        TableColumn<Programare, String> lunaColumn = new TableColumn<>("Luna");
        lunaColumn.setMinWidth(260);
        lunaColumn.setCellValueFactory(new PropertyValueFactory<>("luna"));

        TableColumn<Programare, String> detaliuColumn = new TableColumn<>("Alte Detalii");
        detaliuColumn.setMinWidth(260);
        detaliuColumn.setCellValueFactory(new PropertyValueFactory<>("detalii"));

        TableColumn<Programare, String> mesajColumn = new TableColumn<>("Mesajul Doctorului");
        mesajColumn.setMinWidth(360);
        mesajColumn.setCellValueFactory(new PropertyValueFactory<>("mesaj"));

        TableColumn<Programare, String> statusColumn = new TableColumn<>("Statusul Programării");
        statusColumn.setMinWidth(260);
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        TableView<Programare> table = new TableView<>();
        table.setItems(getProgramari2(numeUtilizator));
        table.getColumns().addAll(nameColumn, oraColumn, ziColumn, lunaColumn, detaliuColumn, mesajColumn, statusColumn);

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

        Scene scene2 = new Scene(vBox, 750, 120);

        return scene2;
    }


    public static ObservableList<Programare> getProgramari2(String numeUtilizator) {
        ObservableList<Programare> programari = FXCollections.observableArrayList();
        String first = "src\\main\\resources\\Programari.json";
        String contents = null;
        String contents2 = null;
        try {
            contents = new String((Files.readAllBytes(Paths.get(first))));
            contents2 = new String((Files.readAllBytes(USERS_PATH2)));

            JSONArray Lista = new JSONArray(contents2);
            for (int i = Lista.length() - 1; i >= 0; i--) {
                if (Lista.getJSONObject(i).getString("numeClient").equals(numeUtilizator)) {
                    String a = Lista.getJSONObject(i).getString("nume_doctor");
                    String b = Lista.getJSONObject(i).getString("ora");
                    String c = Lista.getJSONObject(i).getString("ziua");
                    String d = Lista.getJSONObject(i).getString("luna");
                    String e = Lista.getJSONObject(i).getString("alte_detalii");
                    String f = Lista.getJSONObject(i).getString("mesaj_doctor");
                    String g = Lista.getJSONObject(i).getString("status");
                    programari.add(new Programare(a, b, c, d, e, f, g, ""));
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return programari;
    }


    public static Scene listaProgramariDoctor(Stage primaryStage, Scene scene, String numeUtilizator) {


        TableColumn<Programare, String> nameColumn = new TableColumn<>("Nume client");
        nameColumn.setMinWidth(160);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("numeClient"));

        TableColumn<Programare, String> oraColumn = new TableColumn<>("Ora");
        oraColumn.setMinWidth(160);
        oraColumn.setCellValueFactory(new PropertyValueFactory<>("ora"));

        TableColumn<Programare, String> ziColumn = new TableColumn<>("Zi");
        ziColumn.setMinWidth(220);
        ziColumn.setCellValueFactory(new PropertyValueFactory<>("zi"));

        TableColumn<Programare, String> lunaColumn = new TableColumn<>("Luna");
        lunaColumn.setMinWidth(260);
        lunaColumn.setCellValueFactory(new PropertyValueFactory<>("luna"));

        TableColumn<Programare, String> detaliuColumn = new TableColumn<>("Mesajul clientului");
        detaliuColumn.setMinWidth(260);
        detaliuColumn.setCellValueFactory(new PropertyValueFactory<>("detalii"));

        TableColumn<Programare, String> mesajColumn = new TableColumn<>("Mesajul meu");
        mesajColumn.setMinWidth(360);
        mesajColumn.setCellValueFactory(new PropertyValueFactory<>("mesaj"));

        TableColumn<Programare, String> statusColumn = new TableColumn<>("Statusul Programării");
        statusColumn.setMinWidth(260);
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        TableView<Programare> table = new TableView<>();
        table.setItems(getProgramariDoctori(numeUtilizator));
        //table.setItems(getDoctor());
        table.getColumns().addAll(nameColumn, oraColumn, ziColumn, lunaColumn, detaliuColumn, mesajColumn, statusColumn);

        Button inapoi = new Button("Înapoi");
        inapoi.setOnAction(e -> {
            Scene scene2 = SignInDoctor.inregis(primaryStage, scene, numeUtilizator);
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

    public static ObservableList<Programare> getProgramariDoctori(String numeUtilizator) {
        ObservableList<Programare> programari = FXCollections.observableArrayList();
        String first = "src\\main\\resources\\Programari.json";
        String contents = null;
        String contents2 = null;
        try {
            contents = new String((Files.readAllBytes(Paths.get(first))));
            contents2 = new String((Files.readAllBytes(USERS_PATH2)));

            JSONArray Lista = new JSONArray(contents2);
            for (int i = 0; i < Lista.length(); i++) {
                if (Lista.getJSONObject(i).getString("nume_doctor").equals(numeUtilizator)) {
                    String a = Lista.getJSONObject(i).getString("numeClient");
                    String b = Lista.getJSONObject(i).getString("ora");
                    String c = Lista.getJSONObject(i).getString("ziua");
                    String d = Lista.getJSONObject(i).getString("luna");
                    String e = Lista.getJSONObject(i).getString("alte_detalii");
                    String f = Lista.getJSONObject(i).getString("mesaj_doctor");
                    String g = Lista.getJSONObject(i).getString("status");
                    programari.add(new Programare("Nu conteaza", b, c, d, e, f, g, a));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return programari;
    }


}
