/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isb.hospital.model;

/**
 *
 * @author Irving Salvador
 */
public class Node {
    public Ticket dato;
    public Node siguiente;

    public Ticket getDato() {
        return dato;
    }

    public void setDato(Ticket dato) {
        this.dato = dato;
    }

    public Node getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Node siguiente) {
        this.siguiente = siguiente;
    }
    
}

