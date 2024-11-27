package Logica;

public class Nodo {

    private GuerreroStarWars guerrero;
    private Nodo next;

    public Nodo(GuerreroStarWars guerrero) {

        this.guerrero = guerrero;
        this.next = null;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public GuerreroStarWars getGuerrero() {
        return guerrero;
    }

    public void setGuerrero(GuerreroStarWars guerrero) {
        this.guerrero = guerrero;
    }
}
