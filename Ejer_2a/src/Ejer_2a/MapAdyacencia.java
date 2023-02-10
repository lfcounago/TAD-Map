/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejer_2a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author LuisFerCou
 * @param <E>
 * @param <T>
 */
public class MapAdyacencia<E, T> implements Grafo<E, T> {

    private List<VerticeConMap<E, T>> listVertices;

    public MapAdyacencia() {
        listVertices = new ArrayList<>();
    }

    @Override
    public boolean estaArco(Arco<E, T> a) {
        boolean toret = false;
        int i = 0;
        while (i < listVertices.size() && toret == false) { //Mientras no recorro todos los arcos

            if (listVertices.get(i).getVertice().equals(a.getOrigen()) //Si el vértice es igual al arco a
                    && listVertices.get(i).getAdy().esta(a.getDestino())//y es adyacente
                    && listVertices.get(i).getAdy().get(a.getDestino()).equals(a.getEtiqueta())) { //y su adyacente es igual a la etiqueta del arco a
                toret = true; //está el arco
            }

            i++;
        }
        return toret;
    }

    @Override
    public Iterator<Vertice<E>> adyacentes(Vertice<E> v) {

        int i = 0;
        //Busco el vértice que me pasan como parámetro
        while (i < listVertices.size() && !listVertices.get(i).getVertice().equals(v)) {
            i++;
        }

        //Guardo en una lista las claves de los adyacentes
        if (listVertices.get(i).getVertice().equals(v)) {
            return listVertices.get(i).getAdy().keySet();
        } else {
            return new ArrayList<Vertice<E>>().iterator();
        }
    }

    @Override
    public boolean esVacio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean estaVertice(Vertice<E> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<Vertice<E>> vertices() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<Arco<E, T>> arcos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertarVertice(Vertice<E> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertarArco(Arco<E, T> a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarVertice(Vertice<E> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarArco(Arco<E, T> a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
