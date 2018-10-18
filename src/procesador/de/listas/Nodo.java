/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesador.de.listas;

/**
 *
 * @author cdcasalins
 */
public class Nodo {

    Nodo rLink;//siguiente Nodo de la lista
    Nodo lLink;//Nodo predecesor de la lista
    String contenido;//contenido de cada Nodo

    public Nodo(String contenido) {//contructor y asignacion de contenido al Nodo
        this.contenido = contenido;
    }

    public void insertar(Nodo p) {//Metodo para añadir un Nodo en ultima posicion de la lista
        Nodo e = this;
        if (this.rLink == null) {
            this.rLink = p;
        } else {
            while (e.rLink != null) {
                e = e.rLink;
            }
            e.rLink = p;
        }
    }

    public void eliminar(String nombre, Nodo ptr) {//metodo para eliminar un Nodo con el contenido de entrada
        //if (!nombre.equals("")) {
        Nodo p = ptr;
        
        if (nombre.equals(ptr.contenido)) {

            ptr = ptr.rLink;
            p = null;
        } else {

            while (p != null && p.contenido.equals(nombre)) {
                p = p.rLink;
            }
            if (p.rLink.rLink == null) {
                ptr.rLink = null;
            } else {
                Nodo k = p.rLink.rLink;
                p.rLink = k;
                k.lLink = p;
            }
        }
    
    }

    public void ordenar() { //metodo para ordenar Ascendentemente la lista
        Nodo p = this.rLink;
        Nodo q = this.rLink;
        Nodo mayor = this.rLink;
        String aux = "";
        while (p != null) {
            mayor = p;
            while (q != null) {
                if (mayor.contenido.substring(0, 1).compareTo(q.contenido.substring(0, 1)) < 0) {
                    mayor = q;
                    aux = p.contenido;
                    p.contenido = mayor.contenido;
                    mayor.contenido = aux;
                }
                q = q.rLink;
            }
            p = p.rLink;
            q = this.rLink;
        }
    }

    public int buscar(String cont) {//busca el primer Nodo con el contenido de entrada
        int indice = 0;
        Nodo p = this;
        while (p != null && !p.contenido.equals(cont)) {
            p = p.rLink;
            indice++;
        }
        return indice - 1;
    }

}
