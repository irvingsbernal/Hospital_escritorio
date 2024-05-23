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
public class Ticket {
    public String nombre;
    public String padecimiento;
    public String NSS;
    public int prio;
    

    public Ticket() {
        this.nombre = null;
        this.padecimiento = null;
        this.NSS = null;
        this.prio = 0;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPadecimiento() {
        return padecimiento;
    }

    public void setPadecimiento(String padecimiento) {
        this.padecimiento = padecimiento;
    }

    public String getNSS() {
        return NSS;
    }

    public void setNSS(String NSS) {
        this.NSS = NSS;
    }

    public int getPrio() {
        return prio;
    }

    public void setPrio(int prio) {
        this.prio = prio;
    }
}
