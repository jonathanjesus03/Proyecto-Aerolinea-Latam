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
public class PaxControl {
    private ArrayList<Vuelos> listavuelos;
    private ArrayList<Avion> listaaviones;
    private ArrayList<Alimentos> listaalimentos;
    private Reporte reporte;

    public PaxControl(Reporte reporte) {
        this.listavuelos = new ArrayList<>();
        this.listaaviones = new ArrayList<>();
        this.listaalimentos = new ArrayList<>();
        this.reporte = reporte;
    }

    public ArrayList<Alimentos> getListaalimentos() {
        return listaalimentos;
    }

    public void setListaalimentos(ArrayList<Alimentos> listaalimentos) {
        this.listaalimentos = listaalimentos;
    }

    public ArrayList<Vuelos> getListavuelos() {
        return listavuelos;
    }

    public void setListavuelos(ArrayList<Vuelos> listavuelos) {
        this.listavuelos = listavuelos;
    }

    public ArrayList<Avion> getListaaviones() {
        return listaaviones;
    }

    public void setListaaviones(ArrayList<Avion> listaaviones) {
        this.listaaviones = listaaviones;
    }

    public Reporte getReporte() {
        return reporte;
    }

    public void setReporte(Reporte reporte) {
        this.reporte = reporte;
    }
    
    
    //Metodos
    public void asignarTripulación(ArrayList<Piloto> listap, ArrayList<Azafata> listaa, String codigo){
        for(int i = 0; i<listavuelos.size();i++){
            if(listavuelos.get(i).getCodigo().equalsIgnoreCase(codigo)){
                listavuelos.get(i).getTripulacion().setListaPiloto(listap);
                listavuelos.get(i).getTripulacion().setListaAzafata(listaa);
                reporte.getTripulantesVuelo().setListaAzafata(listaa);
                reporte.getTripulantesVuelo().setListaPiloto(listap);
            }
        }
    }
    
    public void asignarAlimentos(String codigo, Alimentos alimento){
        for(int i = 0; i<listavuelos.size();i++){
            if(listavuelos.get(i).getCodigo().equalsIgnoreCase(codigo)){
                listaalimentos.add(alimento);
                reporte.setCantidadComida(listaalimentos.size());
                break;
            }
        }
    }

    public void asignarFallas(String codigo, String falla){
        for(int i = 0; i<listavuelos.size();i++){
            if(listavuelos.get(i).getCodigo().equalsIgnoreCase(codigo)){
                listavuelos.get(i).getAvion().setFalla(falla);
                break;
            }
        }
    }
    
    public void asignarHorasAbordaje(String codigo, String horallegada, String horasalida){
         for(int i = 0; i<listavuelos.size();i++){
            if(listavuelos.get(i).getCodigo().equalsIgnoreCase(codigo)){
                listavuelos.get(i).setHorallegada(horallegada);
                listavuelos.get(i).setHorasalida(horasalida);
                break; 
            }
        }
    }
    
     public void asignarAvionString(String codigo, int idavion){
         for(int i = 0; i<listavuelos.size();i++){
            if(listavuelos.get(i).getCodigo().equalsIgnoreCase(codigo)){
                for(int e = 0; e<listaaviones.size();e++){    
                    if(listaaviones.get(e).getIdavion() == idavion){
                        Avion avion = listaaviones.get(e);
                        reporte.setAvionVuelo(avion);
                        listavuelos.get(i).setAvion(avion);
                        break; 
                    }
                }
                break;
            }
         }
     }
    
    public void asignarPasajero(String codigo, Pasajeros pasajero){
         for(int i = 0; i<listavuelos.size(); i++){
             if(listavuelos.get(i).getCodigo().equalsIgnoreCase(codigo)){
                 listavuelos.get(i).getListaPasajeros().add(pasajero);
                 reporte.setCantidadpasajeros(listavuelos.get(i).getListaPasajeros().size());
                 listavuelos.get(i).setCantidadpasajeros(listavuelos.get(i).getListaPasajeros().size());
                 break;
             }
         }
     }
    
    public void verificarRetraso(String codigo){
         for(int i = 0; i<listavuelos.size(); i++){
             if(listavuelos.get(i).getCodigo().equalsIgnoreCase(codigo)){
                 reporte.setRetraso(true);
                 break;
             }
         }
    }
    
    public void asignarReporte(){
        
    }
}

