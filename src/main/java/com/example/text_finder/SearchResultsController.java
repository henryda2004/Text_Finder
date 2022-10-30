package com.example.text_finder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class SearchResultsController {

    @FXML
    private Button openfilebtn;

    public void openFile(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("MainTableview.fxml");
    }
}
