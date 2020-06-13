package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Scenes.LoginScene;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene;
        scene = LoginScene.test(primaryStage);


        primaryStage.setScene(scene);
        primaryStage.setTitle("Doctori Tg-Jiu");
        primaryStage.show();
    }






}
