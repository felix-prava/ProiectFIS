package sample.Scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ListaDoctori {

    public static Scene inregis(Stage primaryStage, Scene scene) {

        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(10, 10, 10, 10));
        grid2.setVgap(8);
        grid2.setHgap(10);
        Scene sceneInregistrare = new Scene(grid2, 400, 250);
        javafx.scene.control.Label l24 = new javafx.scene.control.Label("Test:");
        GridPane.setConstraints(l24, 0, 0);
        javafx.scene.control.Label l24a = new javafx.scene.control.Label("Test2:");
        GridPane.setConstraints(l24a, 0, 1);
        javafx.scene.control.Label l24b = new javafx.scene.control.Label("Test3:");
        GridPane.setConstraints(l24b, 0, 2);
        javafx.scene.control.Label l24c = new javafx.scene.control.Label("Test4:");
        GridPane.setConstraints(l24c, 0, 3);
        javafx.scene.control.TextField text1 = new javafx.scene.control.TextField();
        GridPane.setConstraints(text1, 1, 0);
        javafx.scene.control.TextField text2 = new javafx.scene.control.TextField();
        GridPane.setConstraints(text2, 1, 1);
        javafx.scene.control.TextField text3 = new javafx.scene.control.TextField();
        GridPane.setConstraints(text3, 1, 2);
        javafx.scene.control.TextField text4 = new javafx.scene.control.TextField();
        GridPane.setConstraints(text4, 1, 3);
        javafx.scene.control.Button ok = new Button("Gata!");
        ok.setOnAction(e ->
        {
            AlertBox.display("Cont nou24", "Înregistrarea a fost realizată cu succes!!!");
            primaryStage.setScene(scene);
        });
        GridPane.setConstraints(ok, 1, 4);
        grid2.getChildren().addAll(l24, l24a, l24b, l24c, text1, text2, text3, text4, ok);
        grid2.setAlignment(Pos.CENTER);
        return sceneInregistrare;
    }
}
