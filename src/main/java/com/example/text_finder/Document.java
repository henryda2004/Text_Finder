package com.example.text_finder;
import java.io.Serializable;

/**
 * Contiene la clase documento y todas sus caracteristicas
 */
public class Document implements Serializable {
    private String name;
    private String type;
    private long date;
    private int dateInt;
    private int words;
    private String[] content;

    /**
     * Constructor
     * @param name
     * @param type
     * @param content
     * @param date
     * @param dateInt
     * @param words
     */
    public Document(String name, String type, String[] content, long date, int dateInt, int words) {
        this.name = name;
        this.type = type;
        this.content = content;
        this.date = date;
        this.dateInt = dateInt;
        this.words = words;
    }

    /**
     * Retorna informacion en Documento
     * @return
     */
    @Override
    public String toString() {
        return "Document{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                ", Int='" + dateInt + '\'' +
                ", words='" + words + '\'' +
                '}';
    }

    /**
     * GetName
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * SetName
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * GetType
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * SetType
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * GetContent
     * @return
     */
    public String[] getContent() {
        return content;
    }

    /**
     * SetContent
     * @param content
     */
    public void setContent(String[] content) {
        this.content = content;
    }

    /**
     * GetDate
     * @return
     */
    public long getDate() {
        return date;
    }

    /**
     * SetDate
     * @param date
     */
    public void setDate(long date) {
        this.date = date;
    }

    /**
     * GetDate
     * @return
     */
    public int getDateInt() {
        return dateInt;
    }

    /**
     * SetDate
     * @param dateInt
     */
    public void setDateInt(int dateInt) {
        this.dateInt = dateInt;
    }

    /**
     * GetWords
     * @return
     */
    public int getWords() {
        return words;
    }

    /**
     * SetWords
     * @param words
     */
    public void setWords(int words) {
        this.words = words;
    }

}

