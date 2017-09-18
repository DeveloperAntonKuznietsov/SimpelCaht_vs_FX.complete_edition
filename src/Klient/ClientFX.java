package Klient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClientFX extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage window) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Client.fxml"));
        window.setScene(new Scene(root,310,420));
        window.setTitle("Klient");
        window.setOnCloseRequest(event -> {System.exit(1);});
        window.show();
    }
}
