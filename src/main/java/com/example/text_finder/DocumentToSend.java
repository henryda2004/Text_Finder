package com.example.text_finder;

import java.io.Serializable;

/**
 * Contiene Documento recibido de servidor
 */
public class DocumentToSend implements Serializable {
    private String word;
    private String line;

    /**
     * getposicion
     * @return
     */
    public int getPosition() {
        return position;
    }

    /**
     * setposicion
     * @param position
     */
    public void setPosition(int position) {
        this.position = position;
    }

    private int position;

    /**
     * getword
     * @return
     */
    public String getWord() {
        return word;
    }

    /**
     * setword
     * @param word
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * getline
     * @return
     */
    public String getLine() {
        return line;
    }

    /**
     * setline
     * @param line
     */
    public void setLine(String line) {
        this.line = line;
    }

    /**
     * getdate
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     * setdate
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * getWordsAm
     * @return
     */
    public int getWordsAm() {
        return wordsAm;
    }

    /**
     * setWordsAm
     * @param wordsAm
     */
    public void setWordsAm(int wordsAm) {
        this.wordsAm = wordsAm;
    }

    /**
     * getName
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * setName
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getBin
     * @return
     */
    public int getBin() {
        return bin;
    }

    /**
     * setBin
     * @param bin
     */
    public void setBin(int bin) {
        this.bin = bin;
    }

    /**
     * getAvl
     * @return
     */
    public int getAvl() {
        return avl;
    }

    /**
     * SetAvl
     * @param avl
     */
    public void setAvl(int avl) {
        this.avl = avl;
    }

    /**
     * getdatevalue
     * @return
     */
    public int getDateValue() {
        return dateValue;
    }

    /**
     * setdatevalue
     * @param dateValue
     */
    public void setDateValue(int dateValue) {
        this.dateValue = dateValue;
    }
    private String date;
    private int dateValue;
    private int wordsAm;
    private String name;
    private int bin;
    private int avl;

    /**
     * constructor
     * @param word
     * @param line
     * @param position
     * @param date
     * @param dateValue
     * @param wordsAm
     * @param name
     * @param bin
     * @param avl
     */
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

    /**
     * retorna valor de documento recibido por cliente
     * @return
     */
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
