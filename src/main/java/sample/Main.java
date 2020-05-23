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
        //if("]yޒ\u0013!��8�!\u000BE��X�=l��jO��vg\u0006�\u000E��".equals(EncryptPassword.encryptPassword("Felix","test")))
        //System.out.println("AA");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Doctori Tg-Jiu");
        primaryStage.show();
    }






}
