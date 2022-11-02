package com.example.text_finder;

import java.io.Serializable;

public class DocumentToSend implements Serializable {
    private String word;
    private String line;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    private int position;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getWordsAm() {
        return wordsAm;
    }

    public void setWordsAm(int wordsAm) {
        this.wordsAm = wordsAm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBin() {
        return bin;
    }

    public void setBin(int bin) {
        this.bin = bin;
    }

    public int getAvl() {
        return avl;
    }

    public void setAvl(int avl) {
        this.avl = avl;
    }
    public int getDateValue() {
        return dateValue;
    }

    public void setDateValue(int dateValue) {
        this.dateValue = dateValue;
    }
    private String date;
    private int dateValue;
    private int wordsAm;
    private String name;
    private int bin;
    private int avl;
    public DocumentToSend(String word, String line, int position, String date, int dateValue, int wordsAm, String name, int bin, int avl) {
        this.word = word;
        this.line = line;
        this.position = position;
        this.date = date;
        this.dateValue = dateValue;
        this.wordsAm = wordsAm;
        this.name = name;
        this.bin = bin;
        this.avl = avl;
    }

    @Override
    public String toString() {
        return "DocumentToSend{" +
                "word='" + word + '\'' +
                ", line='" + line + '\'' +
                ", position=" + position +
                ", date='" + date + '\'' +
                ", dateValue=" + dateValue +
                ", wordsAm=" + wordsAm +
                ", name='" + name + '\'' +
                ", bin=" + bin +
                ", avl=" + avl +
                '}';
    }
}
