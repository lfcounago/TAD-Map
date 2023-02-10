/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer_2d;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import grafo.*;

/**
 *
 * @author LuisFerCou
 */
public class EscaleraPalabras {
 public static Map<String, List<String>> crearDiccionario(List<String> palabras) {

        Map<String, List<String>> diccionario = new HashMap<>(palabras.size());
        for (int i = 0; i < palabras.size(); i++) {
            String palabraDada = palabras.get(i);

            for (int j = 0; j < palabraDada.length(); j++) {
                String palabraClave;
                palabraClave = palabraDada.substring(0, j) + "-" + palabraDada.substring(j+1);
                List<String> ListaAsociada = new LinkedList<>();
                if (!diccionario.esta(palabraClave)) {

                    ListaAsociada.add(palabraDada);
                    diccionario.put(palabraClave, ListaAsociada);
                } else {
                    ListaAsociada = diccionario.get(palabraClave);
                    ListaAsociada.add(palabraDada);
                    diccionario.put(palabraClave, ListaAsociada);
                }

            }
        }
        
        

        return diccionario;

    }

    public static Grafo<String, Integer> construirGrafo( List<String> lista) {
        Map<String, List<String>> diccionario = crearDiccionario(lista);
                
        Grafo<String, Integer> toret = new ListaAdyacencia<>();

        for (String l : lista) { 
            toret.insertarVertice(new Vertice<>(l));
        }
        Iterator<List<String>> it = diccionario.values();
        while (it.hasNext()) {
            List<String> valores = it.next();
            if (valores.size() > 1) {
                for (String origen : lista) {
                    for (String destino : lista) {
                        if (!origen.equals(destino)) {
                            
                            toret.insertarArco(new Arco<>(new Vertice<>(origen), new Vertice<>(destino), 0));
                        }

                    }
                }

            }
        }
        return toret;
    }
}
