package controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import yeowoo.Yeowoo;

/**
 * A GUI for Yeowoo using FXML.
 */
public class Main extends Application {

    private Yeowoo yeowoo = new Yeowoo();

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setDuke(yeowoo);
            stage.setTitle("Yeowoo");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
