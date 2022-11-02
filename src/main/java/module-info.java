
module com.example.text_finder {
    requires javafx.controls;
    requires javafx.fxml;
    requires pdfbox.app;
    requires org.apache.poi.ooxml;
    requires java.logging;


    opens com.example.text_finder to javafx.fxml;
    exports com.example.text_finder;
}