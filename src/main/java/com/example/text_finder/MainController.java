package com.example.text_finder;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

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
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainController implements Initializable {
    @FXML
    public Label warningLabel;
    @FXML
    private TextField textField;
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
    public String getType (File file){

        // convert the file name into string
        String fileName = file.toString();

        int index = fileName.lastIndexOf('.');
        if(index > 0) {
            String extension = fileName.substring(index + 1);
            return extension;
        }
        return null;
    }

    public String[] getContent (File file, String type) throws IOException {
        String content = "";
        String words[] = new String[0];
        if (type.equals("txt")){
            Scanner sc = new Scanner(file);
            while (sc.hasNext()){
                content = content + " " + sc.next();
            }
            words = content.split("[ \t\n,?.!\"]+");
            return words;
        }else if(type.equals("pdf")){

            FileInputStream fis = new FileInputStream(file);
            PDDocument pdfdocument = PDDocument.load(fis);

            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            String docText = pdfTextStripper.getText(pdfdocument);
            words = docText.split("[ \t\n,?.!\"]+");

            pdfdocument.close();
            fis.close();

            return words;
        }else{

            try{
                XWPFDocument fis = new XWPFDocument(new FileInputStream(file));
                XWPFWordExtractor we = new XWPFWordExtractor(fis);
                content = we.getText();
            } catch (Exception e){
                System.out.println(e);
            }
            words = content.split("[ \t\n,?.!\"]+");
            return words;
        }
    }


    public void addFile (ActionEvent event) throws IOException {
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
            ListDocuments.add(new Document(selectedFile.getName(), getType(selectedFile), getContent(selectedFile, getType(selectedFile)), selectedFile.lastModified(), Integer.valueOf((int) selectedFile.lastModified()), getContent(selectedFile, getType(selectedFile)).length));
            for(int i = 0; i < getContent(selectedFile, getType(selectedFile)).length; i++){
                System.out.println("word["+i+"] = " +getContent(selectedFile, getType(selectedFile))[i]);
            }
            observableListDocumentForTable.add(new DocumentForTable(selectedFile.getName(), getType(selectedFile)));
            this.list.add(new DocumentForTable(selectedFile.getName(), selectedFile.getParent()));
            table.setItems(observableListDocumentForTable);
        } else {
            warningLabel.setText("File not found");
            System.out.println("file is not valid");
        }
    }
    public void addFolder (ActionEvent event) throws IOException {
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

    public void listDir(File dir) throws IOException {
        File elements[] = dir.listFiles();
        for (File element: elements){
            if(Objects.equals(getType(element), "pdf") || Objects.equals(getType(element), "docx") || Objects.equals(getType(element), "txt")){
                ListDocuments.add(new Document(element.getName(), getType(element), getContent(element, getType(element)), element.lastModified(), Integer.valueOf((int) element.lastModified()), getContent(element, getType(element)).length));
                observableListDocumentForTable.add(new DocumentForTable(element.getName(), getType(element)));
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

    public String[] getToSearch(String toSearch){
        String[] words = toSearch.split("[ \t\n,?.!\"]+");
        return words;
    }

    public String getSort(){
        String sortMethod = dropDownMenu.getValue();
        return sortMethod;
    }
    public void search(ActionEvent event) throws IOException {
        //HelloApplication m = new HelloApplication();
        if (hayFiles == true) {
            //m.changeScene("Results.fxml");
            ClientInformation ci = new ClientInformation(getSort(), ListDocuments, getToSearch(textField.getText()));
            final String HOST = "127.0.0.1";
            final int PORT = 5000;
            //ObjectInputStream in;
            ObjectOutputStream out;


            try {
                Socket clientSocket = new Socket(HOST, PORT);

                //in = new ObjectInputStream(clientSocket.getInputStream());
                out = new ObjectOutputStream(clientSocket.getOutputStream());

                out.writeObject(ci); //Envio informacion para el servidor

                //Object message = in.readObject(); //Leo la lista proviniente del servidor
                //ClientInformation si = (ClientInformation) message;

                clientSocket.close(); //Este cierra recibir informacion del cliente

            } catch (IOException e) {

                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE,null,e);
            }

        }
        else {
            warningLabel.setText("File not found");
        }
    }

    public static void main(String[] args) {

    }
}
