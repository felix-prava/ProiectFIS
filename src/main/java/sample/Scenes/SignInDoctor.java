package sample.Scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SignInDoctor {

    public static Scene inregis(Stage primaryStage, Scene scene, String numeUtilizator) {

        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(10, 10, 10, 10));
        grid2.setVgap(8);
        grid2.setHgap(10);
        Scene sceneInregistrare = new Scene(grid2, 500, 250);

        Button programare = new Button("Cereri de programare");
        programare.setOnAction(e ->
        {
            Scene newScene = ListaProgramari.listaProgramariDoctor(primaryStage, scene, numeUtilizator);
            primaryStage.setScene(newScene);
        });
        GridPane.setConstraints(programare, 0, 0);

        javafx.scene.control.Label l24a = new javafx.scene.control.Label("Test2:");
        GridPane.setConstraints(l24a, 0, 1);

        Button listaProg = new Button("Acceptare Programare");
        GridPane.setConstraints(listaProg, 0, 2);

        javafx.scene.control.Label l24c = new javafx.scene.control.Label("Test4:");
        GridPane.setConstraints(l24c, 0, 3);

        Button profil = new Button("Editare profil");
        profil.setOnAction(e ->
        {
            Scene newScene = EditareProfil.editareProfil(primaryStage, scene, numeUtilizator);
            primaryStage.setScene(newScene);
        });
        GridPane.setConstraints(profil, 2, 0);

        javafx.scene.control.TextField text2 = new javafx.scene.control.TextField();
        GridPane.setConstraints(text2, 1, 1);

        Button ultimaProg = new Button("Refuzare Programare");
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
        grid2.getChildren().addAll(programare, listaProg, profil, ultimaProg, ok);
        grid2.setAlignment(Pos.CENTER);
        return sceneInregistrare;
    }
}
