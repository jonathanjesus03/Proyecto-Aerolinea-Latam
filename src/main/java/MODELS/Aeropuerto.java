/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELS;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Samsung
 */
public class Aeropuerto {
        private ArrayList<Reporte> listaReporte;
        private ArrayList<Avion> Avion;
        private ArrayList<Vuelos> vuelos;
        private List<Pasajeros> Pasajeros;
        private SalaAbordaje salaAbordaje;
        private CheckIn checkin;

    public Aeropuerto(ArrayList<Reporte> listaReporte, ArrayList<Avion> Avion, ArrayList<Vuelos> vuelos, List<Pasajeros> Pasajeros, SalaAbordaje salaAbordaje, CheckIn checkin) {
        this.listaReporte = listaReporte;
        this.Avion = Avion;
        this.vuelos = vuelos;
        this.Pasajeros = Pasajeros;
        this.salaAbordaje = salaAbordaje;
        this.checkin = checkin;
    }
        
        public Aeropuerto(){}

    public ArrayList<Reporte> getListaReporte() {
        return listaReporte;
    }

    public void setListaReporte(ArrayList<Reporte> listaReporte) {
        this.listaReporte = listaReporte;
    }

    public ArrayList<Avion> getAvion() {
        return Avion;
    }

    public void setAvion(ArrayList<Avion> Avion) {
        this.Avion = Avion;
    }

    public ArrayList<Vuelos> getVuelos() {
        return vuelos;
    }

    public void setVuelos(ArrayList<Vuelos> vuelos) {
        this.vuelos = vuelos;
    }

    public List<Pasajeros> getPasajeros() {
        return Pasajeros;
    }

    public void setPasajeros(List<Pasajeros> Pasajeros) {
        this.Pasajeros = Pasajeros;
    }

    public SalaAbordaje getSalaAbordaje() {
        return salaAbordaje;
    }

    public void setSalaAbordaje(SalaAbordaje salaAbordaje) {
        this.salaAbordaje = salaAbordaje;
    }

    public CheckIn getCheckin() {
        return checkin;
    }

    public void setCheckin(CheckIn checkin) {
        this.checkin = checkin;
    }
 
        
    public void aplicarCheckIn(Pasajeros pasajero){
        
    }
}
