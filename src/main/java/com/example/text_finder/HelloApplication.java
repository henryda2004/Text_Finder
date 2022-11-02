package com.example.text_finder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

/**
 * ejecucion principal del programa
 */
public class HelloApplication extends Application {

    private static Stage stg;

    /**
     * inicializacion del programa
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainTableview.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 562, 364);
        stage.setTitle("TextFinder");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * cambio de pantalla
     * @param fxml
     * @throws IOException
     */
    public void changeScene(String fxml) throws IOException{
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }

    /**
     * ejecuta el programa
     * @param args
     */
    public static void main(String[] args) {

        launch();
    }

}