/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELS;

import java.util.ArrayList;

/**
 *
 * @author cr075
 */
public class Reporte {
    private int id;
    private String referenciaVuelo,origen,destino,horasalida,horallegada;
    private boolean retraso;
    private boolean estadoVuelo;
    private int cantidadpasajeros;
    private Avion avionVuelo;
    private Tripulacion tripulantesVuelo;
    private int cantidadComida;
    private ArrayList<Pasajeros> pasajerosVuelo;
    
    public Reporte(){}

    public Reporte(String referenciaVuelo, String origen, String destino, String horasalida, String horallegada, boolean retraso, int cantidadpasajeros, Avion avionVuelo, Tripulacion tripulantesVuelo) {
        this.referenciaVuelo = referenciaVuelo;
        this.origen = origen;
        this.destino = destino;
        this.horasalida = horasalida;
        this.horallegada = horallegada;
        this.retraso = retraso;
        this.cantidadpasajeros = cantidadpasajeros;
        this.avionVuelo = avionVuelo;
        this.tripulantesVuelo = tripulantesVuelo;
    }
    
    
    public Reporte(String referenciaVuelo, String origen, String destino, String horasalida, String horallegada, 
                    boolean retraso, boolean estadoVuelo, int cantidadpasajeros, Avion avionVuelo, Tripulacion tripulantesVuelo,
                    int cantidadComida, ArrayList<Pasajeros> pasajerosVuelo) {
        this.referenciaVuelo = referenciaVuelo;
        this.origen = origen;
        this.destino = destino;
        this.horasalida = horasalida;
        this.horallegada = horallegada;
        this.retraso = retraso;
        this.estadoVuelo = estadoVuelo;
        this.cantidadpasajeros = cantidadpasajeros;
        this.avionVuelo = avionVuelo;
        this.tripulantesVuelo = tripulantesVuelo;
        this.cantidadComida = cantidadComida;
        this.pasajerosVuelo = new ArrayList<>();
    }

 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getHorasalida() {
        return horasalida;
    }

    public void setHorasalida(String horasalida) {
        this.horasalida = horasalida;
    }

    public String getHorallegada() {
        return horallegada;
    }

    public void setHorallegada(String horallegada) {
        this.horallegada = horallegada;
    }
    
    public Tripulacion getTripulantesVuelo() {
        return tripulantesVuelo;
    }

    public void setTripulantesVuelo(Tripulacion tripulantesVuelo) {
        this.tripulantesVuelo = tripulantesVuelo;
    }

    public String getReferenciaVuelo() {
        return referenciaVuelo;
    }

    public void setReferenciaVuelo(String referenciaVuelo) {
        this.referenciaVuelo = referenciaVuelo;
    }

    public int getCantidadpasajeros() {
        return cantidadpasajeros;
    }

    public void setCantidadpasajeros(int cantidadpasajeros) {
        this.cantidadpasajeros = cantidadpasajeros;
    }

    public Avion getAvionVuelo() {
        return avionVuelo;
    }

    public void setAvionVuelo(Avion avionVuelo) {
        this.avionVuelo = avionVuelo;
    }

    public boolean isEstadoVuelo() {
        return estadoVuelo;
    }

    public void setEstadoVuelo(boolean estadoVuelo) {
        this.estadoVuelo = estadoVuelo;
    }

    public int getCantidadComida() {
        return cantidadComida;
    }

    public void setCantidadComida(int cantidadComida) {
        this.cantidadComida = cantidadComida;
    }

    public ArrayList<Pasajeros> getPasajerosVuelo() {
        return pasajerosVuelo;
    }

    public void setPasajerosVuelo(ArrayList<Pasajeros> pasajerosVuelo) {
        this.pasajerosVuelo = pasajerosVuelo;
    }

    public boolean isRetraso() {
        return retraso;
    }

    public void setRetraso(boolean retraso) {
        this.retraso = retraso;
    }
    
    //Metodos para la Lista de Asientos
     public void agregarPasajero(Pasajeros pasajero){
        pasajerosVuelo.add(pasajero);
    }

    public Pasajeros obtenerPasajero(int index){
        if(index>=0 && index < pasajerosVuelo.size()){
           return pasajerosVuelo.get(index);
        }
        else{
            return null;
        }
    } 
    
    public void MostrarPasajeroporvuelo(){
        for(int pos=0; pos<pasajerosVuelo.size();pos++) {
            System.out.println("Lista de pasajeros");
            pasajerosVuelo.get(pos).MostrarInformacionPasajero();
        }
    }
    
    
}
