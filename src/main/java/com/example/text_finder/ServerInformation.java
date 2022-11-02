package com.example.text_finder;

import java.io.Serializable;
import java.util.ArrayList;

public class ServerInformation implements Serializable {
    public ArrayList<DocumentToSend> getListadocuments() {
        return listadocuments;
    }

    public void setListadocuments(ArrayList<DocumentToSend> listadocuments) {
        this.listadocuments = listadocuments;
    }

    private ArrayList<DocumentToSend> listadocuments;

    public ServerInformation(ArrayList<DocumentToSend> listadocuments) {
        this.listadocuments = listadocuments;
    }
}
