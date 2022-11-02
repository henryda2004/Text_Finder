package com.example.text_finder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

/**
 * segunda pantalla con resultados
 */
public class SearchResultsController {

    @FXML
    private Button openfilebtn;

    /**
     * retorna a menu principal
     * @param event
     * @throws IOException
     */
    public void openFile(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("MainTableview.fxml");
    }
}
