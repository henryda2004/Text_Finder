package com.example.text_finder;

import com.example.text_finder.DocumentToSend;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.text_finder.MainController.tableList;

/**
 * contiene la table view que muestra los resultados de la busqueda de acuerdo a la forma de ordenamiento seleccionada, y las comparaciones de BST y AVL.
 */
public class SearchResultsController implements Initializable {

    @FXML
    private TableColumn<DocumentToSend, String> date;

    @FXML
    private Button openfilebtn;

    @FXML
    private TableColumn<DocumentToSend, String> line;

    @FXML
    private TableColumn<DocumentToSend, Integer> avl;

    @FXML
    private TableColumn<DocumentToSend, String> document;

    @FXML
    private TableColumn<DocumentToSend, Integer> binary;

    @FXML
    private TableColumn<DocumentToSend, Integer> words;

    @FXML
    private TableColumn<DocumentToSend, String> word;

    @FXML
    private TableView<DocumentToSend> table;

    ObservableList<DocumentToSend> list = FXCollections.observableArrayList(
    );

    /**
     * abre el documento.
     * @param event
     */
    @FXML
    void openFile(ActionEvent event) {

    }

    /**
     * inicializa las variables de la tabla y las columnas de la tabla para que puedan ser llenadas con la inofmracion de los resultados de busqueda.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        word.setCellValueFactory(new PropertyValueFactory<DocumentToSend, String>("word"));
        line.setCellValueFactory(new PropertyValueFactory<DocumentToSend, String>("line"));
        document.setCellValueFactory(new PropertyValueFactory<DocumentToSend, String>("name"));
        date.setCellValueFactory(new PropertyValueFactory<DocumentToSend, String>("date"));
        words.setCellValueFactory(new PropertyValueFactory<DocumentToSend, Integer>("wordsAm"));
        binary.setCellValueFactory(new PropertyValueFactory<DocumentToSend, Integer>("bin"));
        avl.setCellValueFactory(new PropertyValueFactory<DocumentToSend, Integer>("avl"));

        for (int i = 0; i < tableList.size(); i++){
            list.add(new DocumentToSend(tableList.get(i).getWord(), tableList.get(i).getLine(), tableList.get(i).getPosition(), tableList.get(i).getDate(), tableList.get(i).getDateValue(), tableList.get(i).getWordsAm(), tableList.get(i).getName(), tableList.get(i).getBin(), tableList.get(i).getAvl()));
        }

        table.setItems(list);
    }
}
