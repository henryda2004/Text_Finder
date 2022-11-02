package com.example.text_finder;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Representa la informacion que va a ser enviada al servidor
 */
public class ClientInformation implements Serializable {
    private String sort;



    private String[] toSearch;
    private ArrayList<Document> lisDocuments;

    /**
     * Constructor
     * @param sort
     * @param lisDocuments
     * @param toSearch
     */
    public ClientInformation(String sort, ArrayList<Document> lisDocuments, String[] toSearch) {
        this.sort = sort;
        this.lisDocuments = lisDocuments;
        this.toSearch = toSearch;
    }

    /**
     * Retorna informacion de clienteInfo
     * @return
     */
    @Override
    public String toString() {
        return "ClientInformation{" +
                "sort='" + sort + '\'' +
                ", toSearch=" + toSearch + '\'' +
                ", lisDocuments=" + lisDocuments + '\'' +
                '}';
    }

    /**
     * getSort
     * @return
     */
    public String getSort() {
        return sort;
    }

    /**
     * SetSort
     * @param sort
     */
    public void setSort(String sort) {
        this.sort = sort;
    }

    /**
     * GetList
     * @return
     */
    public ArrayList<Document> getLisDocuments() {
        return lisDocuments;
    }

    /**
     * SetListDocuments
     * @param lisDocuments
     */
    public void setLisDocuments(ArrayList<Document> lisDocuments) {
        this.lisDocuments = lisDocuments;
    }

    /**
     * GetTosearch
     * @return
     */
    public String[] getToSearch() {
        return toSearch;
    }

    /**
     * SetTosearch
     * @param toSearch
     */
    public void setToSearch(String[] toSearch) {
        this.toSearch = toSearch;
    }
}
