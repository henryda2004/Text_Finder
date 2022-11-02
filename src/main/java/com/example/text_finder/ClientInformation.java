package com.example.text_finder;
import java.io.Serializable;
import java.util.ArrayList;

public class ClientInformation implements Serializable {
    private String sort;



    private String[] toSearch;
    private ArrayList<Document> lisDocuments;

    public ClientInformation(String sort, ArrayList<Document> lisDocuments, String[] toSearch) {
        this.sort = sort;
        this.lisDocuments = lisDocuments;
        this.toSearch = toSearch;
    }

    @Override
    public String toString() {
        return "ClientInformation{" +
                "sort='" + sort + '\'' +
                ", toSearch=" + toSearch + '\'' +
                ", lisDocuments=" + lisDocuments + '\'' +
                '}';
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public ArrayList<Document> getLisDocuments() {
        return lisDocuments;
    }

    public void setLisDocuments(ArrayList<Document> lisDocuments) {
        this.lisDocuments = lisDocuments;
    }

    public String[] getToSearch() {
        return toSearch;
    }

    public void setToSearch(String[] toSearch) {
        this.toSearch = toSearch;
    }
}
