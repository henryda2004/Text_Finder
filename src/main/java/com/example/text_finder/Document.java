package com.example.text_finder;

import javafx.beans.property.SimpleStringProperty;

public class Document {
    private SimpleStringProperty name;
    private SimpleStringProperty type;
    private Document next;


    public Document(String name, String type) {
        this.name = new SimpleStringProperty(name);
        this.type = new SimpleStringProperty(type);
        this.next = null;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type = new SimpleStringProperty(type);
    }

    public Document getNext() {
        return next;
    }

    public void setNext(Document next) {
        this.next = next;
    }
}
