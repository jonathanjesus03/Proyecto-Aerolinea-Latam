/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELS;

import java.util.ArrayList;

/**
 *
 * @author Samsung
 */
public class CheckIn {
    private ArrayList<Integer> dimMaleta;
    private int pesoMaximo;

    public CheckIn() {
    }

    public CheckIn(ArrayList<Integer> dimMaleta, int pesoMaximo) {
        this.dimMaleta = dimMaleta;
        this.pesoMaximo = pesoMaximo;
    }

    public ArrayList<Integer> getDimMaleta() {
        return dimMaleta;
    }

    public void setDimMaleta(ArrayList<Integer> dimMaleta) {
        this.dimMaleta = dimMaleta;
    }

    public int getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(int pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }
    
    public boolean verificarIdentificación(Pasajeros pasajero, String documento){
        boolean value=false;
        if(pasajero.getDocumentos().equalsIgnoreCase(documento)){
            value = true;
        }
        return value;
    }
    
    public boolean verificarNombre(Pasajeros pasajero, String nombre){
        boolean value=false;
        if(pasajero.getNombre().equalsIgnoreCase(nombre)){
            value = true;
        }
        return value;
    }
    public boolean verificarMenor(Pasajeros pasajero){
        boolean value=false;
        if(pasajero.getEdad()<18){
            value = true;
        }
        return value;
    }
    
    public void asociarServicio(Pasajeros pasajero, ServiciosEspeciales servicioespecial, int value){
        pasajero.setServicioEspecial(servicioespecial);
    }
    
    public void asociarMaleta(Maleta maleta, Pasajeros pasajero){
        pasajero.setMaleta(maleta);
    }
    
    
}
