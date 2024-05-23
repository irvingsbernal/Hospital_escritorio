/**
 *
 * @author Irving Salvador
 */
package com.isb.hospital.controller;

import com.isb.hospital.model.Node;
import com.isb.hospital.model.Ticket;


public class ControllerHospital {
int tamaño = 0;
Node inicio;
Node fin;


public ControllerHospital(){
    this.tamaño = 0;
    this.inicio = null;
    this.fin = null;
    
}
public int size(){
    return this.tamaño;
}

public Ticket mandarPrimerTicket(){
    if (this.inicio == null){
        return null;
    }else{
    return this.inicio.dato;
    }
}

public Ticket mandarUltimoTicket(){
    if (this.fin == null){
        return null;
       
    }else{
        return fin.dato;
    }
}

public void limpiar(){
    this.tamaño = 0;
    this.inicio = null;
    this.fin = null;
}
public void añadir(Ticket t){
    Node nuevo = new Node();
    nuevo.dato = t;
    nuevo.siguiente = null;
    
    if(tamaño == 0){
        inicio = nuevo;
        fin = nuevo;
        tamaño++;
    }else{
        fin.siguiente = nuevo;
        fin = nuevo;
        tamaño++;
    }
}
public Ticket eliminarTicket(){
    Node anterior = new Node();
    Node actual = new Node();
    Ticket t = new Ticket();
    actual = inicio;
    boolean encontrado = true;
    
    if(tamaño == 0){
        encontrado = false;
    }else if(tamaño == 1){
        t = fin.dato;
        limpiar();
    }else {
        if(inicio.dato.prio == 3){
            t = inicio.dato;
            inicio = inicio.siguiente;
            tamaño --;
        }else {
            for (int i = 0; i < tamaño -1 ; i++) {
                anterior = actual;
                actual = actual.siguiente;
                if(inicio.dato.prio == 3){
                    t = fin.dato;
                    anterior.siguiente = actual.siguiente;
                    tamaño --;
                    break;
                }   
                }
            actual = inicio;
            if (inicio.dato.prio == 2){
                t = inicio.dato;
                inicio = inicio.siguiente;
                tamaño--;
            }else{
                for (int i = 0; i < tamaño -1 ; i++) {
                    anterior = actual;
                    actual = actual.siguiente;
                    if(inicio.dato.prio == 2){
                        t = fin.dato;
                        anterior.siguiente = actual.siguiente;
                        tamaño--;
                        break;
                    }
                }
            }
            actual = inicio;
            if(inicio.dato.prio == 1){
                
                t = inicio.dato;
                inicio = inicio.siguiente;
                tamaño--;
            }else{
                for (int i = 0; i < tamaño -1 ; i++) {
                    anterior = actual;
                    actual = actual.siguiente;
                    if(inicio.dato.prio == 1){
                        t = fin.dato;
                        anterior.siguiente = actual.siguiente;
                        tamaño--;
                        break;
                    }
                }
            }
        }
    }
    return t;
}
}
