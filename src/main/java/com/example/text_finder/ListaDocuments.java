package com.example.text_finder;

public class ListaDocuments {
    private Document head;
    public ListaDocuments() {
        this.head = null;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    /***
     *  inserta un nodo de tipo usuario a la primera posicion de la lista
     * @param name nombre completo del usuario
     * @param type correo del usuario
     */
    public void insertFirst(String name, String type) {

        Document newDocument = new Document(name, type);
        newDocument.setNext(this.head);
        this.head = newDocument;

    }

    /***
     * borra el primer nodo de tipo usuario a la lista.
     * @return no devuelve nada porque no es necesario hacer ningun reurn.
     */
    public Document deleteFirst() {
        if (this.head != null){
            Document temp = this.head;
            this.head = this.head.getNext();
            return temp;
        } else {
            return null;
        }
    }

    public void displayList() {

        Document current = this.head;
        while (current != null) {
            System.out.println(current.getName() + current.getType());
            current = current.getNext();

        }

    }
    
}
