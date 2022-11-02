package com.example.text_finder;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

/**
 * Contiene documento a subir a la tabla
 */
public class DocumentForTable implements Serializable {
    private SimpleStringProperty name;
    private SimpleStringProperty type;

    /**
     * Constructor
     * @param name
     * @param type
     */
    public DocumentForTable(String name, String type) {
        this.name = new SimpleStringProperty(name);
        this.type = new SimpleStringProperty(type);

    }

    /**
     * Get Name
     * @return
     */
    public String getName() {
        return name.get();
    }

    /**
     * SetName
     * @param name
     */
    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    /**
     * GetType
     * @return
     */
    public String getType() {
        return type.get();
    }

    /**
     * SetType
     * @param type
     */
    public void setType(String type) {
        this.type = new SimpleStringProperty(type);
    }

}
