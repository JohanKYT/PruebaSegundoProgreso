package Logica;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ListaSimple {

    private Nodo inicio;
    private int tamanio;

    public ListaSimple() {

        this.inicio = null;
        this.tamanio = 0;
    }

    public int getTamanio(){

        return this.tamanio;
    }

    public boolean isEmpty() {

        boolean flag = false;

        if(this.inicio == null) {

            flag = true;
        }

        return flag;
    }

    public void addElement(GuerreroStarWars guerrero) {

        Nodo nuevo = new Nodo(guerrero);
        if(isEmpty()){

            this.inicio = nuevo;
        }else{

            nuevo.setNext(this.inicio);
            this.inicio = nuevo;
            tamanio++;
        }
    }

    public int buscarLineal(int codigoGuerrero) {

        Nodo actual = this.inicio;
        int posicion = 0;

        while (actual != null) {

            if (actual.getGuerrero().getCodigo() == codigoGuerrero) {

                return posicion;
            }

            actual = actual.getNext();
            posicion++;
        }

        return -1; // Retorna -1 si no se encuentra
    }

    public void ordenar(){

        if (this.inicio == null || this.inicio.getNext() == null) return;

        boolean swapped;
        do {
            swapped = false;
            Nodo actual = this.inicio;
            Nodo siguiente = this.inicio.getNext();
            while (siguiente != null) {

                if (actual.getGuerrero().getNivelFuerza() > siguiente.getGuerrero().getNivelFuerza()) {

                    GuerreroStarWars temp = actual.getGuerrero();
                    actual.setGuerrero(siguiente.getGuerrero());
                    siguiente.setGuerrero(temp);
                    swapped = true;
                }
                actual = siguiente;
                siguiente = siguiente.getNext();
            }
        } while (swapped);
    }

    public void mostrarElementos(JTable table){

        Nodo aux = this.inicio;

        while(aux != null){


            DefaultTableModel model = new DefaultTableModel(new Object[]{"Codigo", "Nombre", "Afiliacion", "PlanetaOrigen", "NivelFuerza"}, 0);
            model.addRow(new Object[]{"Codigo", "Nombre", "Afiliacion", "PlanetaOrigen", "NivelFuerza"});

            while(aux != null){

                model.addRow(new Object[]{aux.getGuerrero().getCodigo(), aux.getGuerrero().getNombre(), aux.getGuerrero().getAfiliacion(), aux.getGuerrero().getPlanetaOrigen(), aux.getGuerrero().getNivelFuerza()});
                aux = aux.getNext();
            }

            table.setModel(model);
        }
    }

    public ListaSimple filtrarLista(String afiliacion){

        Nodo aux = this.inicio;
        ListaSimple lista = new ListaSimple();

        while(aux != null){

            if(!afiliacion.equals(aux.getGuerrero().getAfiliacion())){

                lista.addElement(aux.getGuerrero());
            }
            aux = aux.getNext();
        }

        return lista;
    }
}
