package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Regisration.EncryptPassword;
import sample.Regisration.ReadingJSON;
import sample.Scenes.LoginScene;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene;
        scene = LoginScene.test(primaryStage);
        ReadingJSON.citireSignIn("a", "b");
        //if("]yޒ\u0013!��8�!\u000BE��X�=l��jO��vg\u0006�\u000E��".equals(EncryptPassword.encryptPassword("Felix","test")))
        //System.out.println(EncryptPassword.encryptPassword("Andrei","test")+"!");
        System.out.println(EncryptPassword.encryptPassword("Test24", "test24") + "!");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Doctori Tg-Jiu");
        primaryStage.show();
    }






}
