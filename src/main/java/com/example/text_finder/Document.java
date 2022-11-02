package com.example.text_finder;
import java.io.Serializable;

public class Document implements Serializable {
    private String name;
    private String type;
    private long date;
    private int dateInt;
    private int words;
    private String[] content;
    public Document(String name, String type, String[] content, long date, int dateInt, int words) {
        this.name = name;
        this.type = type;
        this.content = content;
        this.date = date;
        this.dateInt = dateInt;
        this.words = words;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getContent() {
        return content;
    }

    public void setContent(String[] content) {
        this.content = content;
    }
    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getDateInt() {
        return dateInt;
    }

    public void setDateInt(int dateInt) {
        this.dateInt = dateInt;
    }

    public int getWords() {
        return words;
    }

    public void setWords(int words) {
        this.words = words;
    }

}

