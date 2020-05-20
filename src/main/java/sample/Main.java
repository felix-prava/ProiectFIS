package sample;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
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

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene scene;

        //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample.fxml"));
        primaryStage.setTitle("Dentisti-Tg-Jiu");

        //Prima fereastra(cea de inceput)
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        scene = new Scene(grid, 520, 250);

        Label l1 = new Label("Bine ati venit!");
        GridPane.setConstraints(l1, 1, 0);

        Label l2a = new Label("");
        GridPane.setConstraints(l2a, 0, 0);

        Label l2b = new Label("");
        GridPane.setConstraints(l2b, 0, 1);

        Label l2 = new Label("Programează-te la orice \ndentist din oraș!");
        GridPane.setConstraints(l2, 0, 2);

        Button buttonA = new Button("Înregistrare");
        GridPane.setConstraints(buttonA, 0, 3);

        Label l3a = new Label("");
        GridPane.setConstraints(l3a, 2, 0);

        Label l3 = new Label("        Ai deja cont?");
        GridPane.setConstraints(l3, 2, 1);

        Persoana user = new Persoana();

        TextField text1 = new TextField();
        text1.setPromptText("Username");
        GridPane.setConstraints(text1, 2, 2);

        TextField text2 = new TextField();
        text2.setPromptText("Parolă");
        GridPane.setConstraints(text2, 2, 3);

        Button signIn = new Button("Sign In");
        signIn.setOnAction(e ->
        {
            user.setUser(text1.getText());
            user.setParola(encryptPassword(text2.getText(), user.getUser()));
            System.out.print(user.getUser() + user.getParola());
            loginUser(user);
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
                    if (!usernameParola.getText().equals("")) {
                        AlertBox.display("Resetare parola", "Ti-a fost trimis un mail de resetare parola la acest username!");
                        primaryStage.setScene(scene);
                    } else
                        AlertBox.display("Resetare parola", "Username gresit!");
                }
        );


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loginUser(Persoana user) {
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get("DB2.json"));
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonData);
            JsonNode userNode = rootNode.path("nume_de_utilizator");


            Iterator<JsonNode> elements = userNode.elements();
            while (elements.hasNext()) {
                JsonNode username = elements.next();
                System.out.println(username.asText());
                if (username.asText().equals(user.getUser())) {
                    JsonNode parola = username.findParent("nume_de_utilizator").path("parola");
                    if (parola.asText().equals(user.getParola()))
                        System.out.println("E ok");
                    else
                        System.out.println("Parola gresita");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String encryptPassword(String text, String salt) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(text.getBytes(StandardCharsets.UTF_8));

        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", "");

    }


    private MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 does not exist!");
        }
        return md;
    }
}
