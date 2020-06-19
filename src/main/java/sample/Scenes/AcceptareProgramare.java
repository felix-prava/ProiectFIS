package sample.Scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

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
        TextField t5 = new TextField();
        GridPane.setConstraints(t5, 3, 1);
        TextField t6 = new TextField();
        GridPane.setConstraints(t6, 3, 2);

        Button salvare = new Button("Salveaza");

        GridPane.setConstraints(salvare, 1, 4);

        Button inapoi = new Button("Inapoi");
        inapoi.setOnAction(e -> {
            Scene newScene = SignInDoctor.inregis(primaryStage, scene, numeUtilizator);
            primaryStage.setScene(newScene);
        });
        GridPane.setConstraints(inapoi, 2, 4);


        grid2.getChildren().addAll(l1, l2, l3, l4, t1, t2, t3, t4, l5, l6, t5, t6, inapoi, salvare);
        grid2.setAlignment(Pos.CENTER);
        return editareProfil;
    }
}
