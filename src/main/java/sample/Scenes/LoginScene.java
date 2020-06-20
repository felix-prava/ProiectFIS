package sample.Scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.json.JSONArray;
import sample.Regisration.EncryptPassword;
import sample.Regisration.ReadingJSON;
import sample.Users.Persoana;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoginScene {
    public static Scene test(Stage primaryStage) {

        //Prima fereastra(cea de inceput)
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Scene scene = new Scene(grid, 520, 250);

        Label l1 = new Label("Bine ati venit!");
        GridPane.setConstraints(l1, 1, 0);
        Label l2a = new Label("");

        GridPane.setConstraints(l2a, 0, 0);

        Label l2b = new Label("");
        GridPane.setConstraints(l2b, 0, 1);

        Label l2 = new Label("Programează-te la orice \ndentist din oraș!");
        GridPane.setConstraints(l2, 0, 2);

        Button buttonA = new Button("Înregistrare");
        buttonA.setOnAction(event -> {
            Scene newScene = Inregistrare.inregis(primaryStage, scene);
            primaryStage.setScene(newScene);
        });
        GridPane.setConstraints(buttonA, 0, 3);

        Label l3a = new Label("");
        GridPane.setConstraints(l3a, 2, 0);

        Label l3 = new Label("        Ai deja cont?");
        GridPane.setConstraints(l3, 2, 1);

        TextField text1 = new TextField();
        text1.setPromptText("Username");
        GridPane.setConstraints(text1, 2, 2);

        TextField text2 = new TextField();
        text2.setPromptText("Parolă");
        GridPane.setConstraints(text2, 2, 3);

        Persoana user = new Persoana();
        Button signIn = new Button("Sign In");
        signIn.setOnAction(e ->
        {
            String numeTextField = text1.getText();
            String parolaTextField = text2.getText();
            String encryptPass = EncryptPassword.encryptPassword(parolaTextField, numeTextField);

            user.setUser(numeTextField);
            user.setParola(encryptPass);


            if (ReadingJSON.citireSignIn(numeTextField, encryptPass) == 1) {

                Scene newScene = SignInDoctor.inregis(primaryStage, scene, numeTextField);
                primaryStage.setScene(newScene);

                text1.clear();
                text1.setPromptText("Username");
                text2.clear();
                text2.setPromptText("Parolă");

            } else if (ReadingJSON.citireSignIn(numeTextField, encryptPass) == 2) {

                Scene newScene = SignInClient.inregis(primaryStage, scene, numeTextField);
                primaryStage.setScene(newScene);

                text1.clear();
                text1.setPromptText("Username");
                text2.clear();
                text2.setPromptText("Parolă");

            } else AlertBox.display("Eroare", "Datele introduse sunt gresite");

        });
        GridPane.setConstraints(signIn, 2, 4);
        Button forgot = new Button("Ai uitat parola?");
        GridPane.setConstraints(forgot, 2, 5);
        grid.getChildren().addAll(l1, l2, l2a, l2b, buttonA, l3a, l3, text1, text2, signIn, forgot);
        grid.setAlignment(Pos.CENTER);

        //Buton 'Ai uitat parola?'(forgot) + fereastra noua
        Label textParolaUitata = new Label("                 Introdu username-ul");
        Button parola_Uitata = new Button("Gata! ");
        TextField usernameParola = new TextField();
        HBox h1 = new HBox(20);
        h1.getChildren().addAll(usernameParola, parola_Uitata);
        VBox parolaUitata = new VBox(20);
        parolaUitata.getChildren().addAll(textParolaUitata, h1);
        Scene amUitatParola = new Scene(parolaUitata, 300, 200);
        forgot.setOnAction(e -> primaryStage.setScene(amUitatParola));

        //Buton Gata! + mesaj corespunzator
        parola_Uitata.setOnAction(e ->
                {
                    String first = "src\\main\\resources\\DB.json";
                    int ok = 0;
                    try {
                        String contents = new String((Files.readAllBytes(Paths.get(first))));
                        JSONArray Lista = new JSONArray(contents);
                        for (int i = 0; i < Lista.length(); i++) {
                            if (Lista.getJSONObject(i).getString("nume_de_utilizator").equals(usernameParola.getText()))
                                ok++;

                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }


                    if (!usernameParola.getText().equals("") && ok > 0) {
                        AlertBox.display("Resetare parola", "Ti-a fost trimis un mail de resetare parola la acest username!");
                        primaryStage.setScene(scene);
                    } else
                        AlertBox.display("Resetare parola", "Username gresit!");
                }
        );
        return scene;

    }

}