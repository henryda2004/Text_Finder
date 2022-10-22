package com.example.text_finder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private Button btnfile;
    @FXML
    private Button btnfolder;
    @FXML
    private TableView table;

    public TableColumn <Document, String> colFile;
    public TableColumn <Document, String>colType;

    final ObservableList<Document> observableListDocument = FXCollections.observableArrayList(
    );

    static ListaDocuments ListDocuments = new ListaDocuments();
    public void addFile (ActionEvent event) {
        DirectoryChooser dc = new DirectoryChooser();

        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PDF Files", "*.pdf"),
                new FileChooser.ExtensionFilter("TXT Files", "*.txt"),
                new FileChooser.ExtensionFilter("DOCX FILES", "*.docx")
        );
        File selectedFile = fc.showOpenDialog(null);
        if(selectedFile != null) {
            ListDocuments.insertFirst(selectedFile.getName(), selectedFile.getParent());
            observableListDocument.add(new Document(selectedFile.getName(), selectedFile.getParent()));
            table.setItems(observableListDocument);
        } else {
            System.out.println("file is not valid");
        }
    }
    public void addFolder (ActionEvent event) {

        final DirectoryChooser dirchooser = new DirectoryChooser();

        File file = dirchooser.showDialog(null);

        if (file != null){
            File parentDirectory = new File (file.getAbsolutePath());
            listDir(parentDirectory);
        } else {
            System.out.println("file is not valid");
        }
    }

    public void listDir(File dir){
        File elements[] = dir.listFiles();
        for (File element: elements){
            if(!element.getName().equals("*.doc")){
                ListDocuments.insertFirst(element.getName(), element.getParent());
                observableListDocument.add(new Document(element.getName(), element.getParent()));
                table.setItems(observableListDocument);

            }
        }
        ListDocuments.displayList();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colFile.setCellValueFactory(new PropertyValueFactory<>("name"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));

    }


}
