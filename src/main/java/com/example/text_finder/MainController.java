package com.example.text_finder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    public Label warningLabel;
    @FXML
    private ChoiceBox<String> dropDownMenu;
    @FXML
    private Button btnfile;
    @FXML
    private Button btnfolder;
    @FXML
    private TableView table;

    public TableColumn <DocumentForTable, String> colFile;
    public TableColumn <DocumentForTable, String>colType;

    final ObservableList<DocumentForTable> observableListDocumentForTable = FXCollections.observableArrayList(
    );
    final File[] filetoSend = new File[1];
    static ArrayList<Document> ListDocuments = new ArrayList<>();
    private ArrayList<DocumentForTable> list;

    static boolean ArraySocketsIniciado = false;

    static boolean hayFiles = false;

    private void InitList(){

    }


    //Conexion con server

    public void addFile (ActionEvent event) {
        hayFiles = true;
        this.list = new ArrayList<>();
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PDF Files", "*.pdf"),
                new FileChooser.ExtensionFilter("TXT Files", "*.txt"),
                new FileChooser.ExtensionFilter("DOCX FILES", "*.docx")
        );
        File selectedFile = fc.showOpenDialog(null);
        if(selectedFile != null) {
            ListDocuments.add(new Document(selectedFile.getName(), selectedFile.getParent()));
            observableListDocumentForTable.add(new DocumentForTable(selectedFile.getName(), selectedFile.getParent()));
            this.list.add(new DocumentForTable(selectedFile.getName(), selectedFile.getParent()));
            table.setItems(observableListDocumentForTable);
        } else {
            warningLabel.setText("File not found");
            System.out.println("file is not valid");
        }
    }
    public void addFolder (ActionEvent event) {
        hayFiles = true;
        if (ArraySocketsIniciado = false){
            InitList();
            ArraySocketsIniciado = true;
        }
        final DirectoryChooser dirchooser = new DirectoryChooser();

        File file = dirchooser.showDialog(null);

        if (file != null){
            File parentDirectory = new File (file.getAbsolutePath());
            listDir(parentDirectory);
        } else {
            warningLabel.setText("File not found");
            System.out.println("file is not valid");
        }
    }

    public void listDir(File dir){
        File elements[] = dir.listFiles();
        for (File element: elements){
            if(!element.getName().equals("*.doc")){
                ListDocuments.add(new Document(element.getName(), element.getParent()));
                observableListDocumentForTable.add(new DocumentForTable(element.getName(), element.getParent()));
                table.setItems(observableListDocumentForTable);

            }
        }
        for (DocumentForTable documentForTable : observableListDocumentForTable) {
            System.out.println(documentForTable.getName());
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colFile.setCellValueFactory(new PropertyValueFactory<>("name"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));

        dropDownMenu.setValue("Name");
        dropDownMenu.getItems().addAll("Name", "Date", "Words");


    }

    public String getSort(){
        String sortMethod = dropDownMenu.getValue();
        return sortMethod;
    }
    public void search(ActionEvent event) throws IOException {
        //HelloApplication m = new HelloApplication();
        if (hayFiles == true) {
            //m.changeScene("Results.fxml");

            final String HOST = "127.0.0.1";
            final int PORT = 5000;
            //ObjectInputStream in;
            ObjectOutputStream out;


            try {
                Socket clientSocket = new Socket(HOST, PORT);

                //in = new ObjectInputStream(clientSocket.getInputStream());
                out = new ObjectOutputStream(clientSocket.getOutputStream());

                out.writeObject(ListDocuments);

                /*
                out.writeInt(listDocument.size());
                Iterator<Document> aux = listDocument.iterator();
                while (aux.hasNext()) {
                    objectOutputStream.writeObject(aux.next());
                }
                */
                //String message = in.readUTF();
                //System.out.println(message);

                clientSocket.close(); //Este cierra recibir informacion del cliente

            } catch (IOException e) {

                System.out.println(e);
                //Manejo de biblioteca gson
            }

        }
        else {
            warningLabel.setText("File not found");
        }
    }

    public static void main(String[] args) {

    }
}
