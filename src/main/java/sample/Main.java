package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample.fxml"));
        primaryStage.setTitle("Dentisti-Tg-Jiu");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

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

        TextField text1 = new TextField("Username");
        GridPane.setConstraints(text1, 2, 2);

        TextField text2 = new TextField("Parolă");
        GridPane.setConstraints(text2, 2, 3);

        Button signIn = new Button("Sign In");
        GridPane.setConstraints(signIn, 2, 4);

        Button forgot = new Button("Ai uitat parola?");
        GridPane.setConstraints(forgot, 2, 5);


        grid.getChildren().addAll(l1, l2, l2a, l2b, buttonA, l3a, l3, text1, text2, signIn, forgot);


        Scene scene = new Scene(grid, 520, 375);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
