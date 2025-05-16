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
public class Vuelos {
    
    private String codigo,destino,origen,estado,fecha,horallegada,horasalida;
    private int idvuelo,cantidadpasajeros;
    private ArrayList<Pasajeros> ListaPasajeros;
    private Tripulacion tripulacion;
    //tripulacion es con la clase azafatas y pilotos 
    private Avion avion;


    public Vuelos() {
                ListaPasajeros=new ArrayList();
    }

        public Vuelos(String codigo,String destino, String origen, String estado,String fecha, int idvuelo, String horallegada, String horasalida, int cantidadpasajeros, Tripulacion tripulacion,Avion avion) {
        this.codigo=codigo;
        this.destino = destino;
        this.origen = origen;
        this.estado = estado;
        this.fecha = fecha;
        this.idvuelo = idvuelo;
        this.horallegada = horallegada;
        this.horasalida = horasalida;
        this.cantidadpasajeros = cantidadpasajeros;
        ListaPasajeros=new ArrayList();
        this.tripulacion=tripulacion;
        this.avion=avion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdvuelo() {
        return idvuelo;
    }

    public void setIdvuelo(int idvuelo) {
        this.idvuelo = idvuelo;
    }

    public String getHorallegada() {
        return horallegada;
    }

    public void setHorallegada(String horallegada) {
        this.horallegada = horallegada;
    }

    public String getHorasalida() {
        return horasalida;
    }

    public void setHorasalida(String horasalida) {
        this.horasalida = horasalida;
    }

    public int getCantidadpasajeros() {
        return cantidadpasajeros;
    }

    public void setCantidadpasajeros(int cantidadpasajeros) {
        this.cantidadpasajeros = cantidadpasajeros;
    }
 
    public ArrayList<Pasajeros> getListaPasajeros() {
        return ListaPasajeros;
    }

    public void setListaPasajeros(ArrayList<Pasajeros> ListaPasajeros) {
        this.ListaPasajeros = ListaPasajeros;
    }
    
    public Tripulacion getTripulacion() {
        return tripulacion;
    }

    public void setTripulacion(Tripulacion tripulacion) {
        this.tripulacion = tripulacion;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }
    
    public void MostrarAsientoporvuelo(){
     /*   for(int pos=0; pos<ListaAsientos.size();pos++) {
            System.out.println("Asientos disponibles por el vuelo: "+(idvuelo));
            System.out.println(ListaAsientos.get(pos).getAsientosdisponibles());  
        }*/
    }
    
    public void ControldeAsientos(){
        /*for(int pos=0; pos<ListaAsientos.size();pos++) {
        if (ListaAsientos.get(pos).getAsientosdisponibles() >= cantidadpasajeros) {
            System.out.println("La cantidad de pasajeros por vuelo fue realizada con éxito.");
        } else {
        System.out.println("Disculpe, no se puedo completar su operación dado que no hay asientos disponibles");
            }*/
    }
    
    //Metodos para la Lista de Asientos
     public void agregarPasajero(Pasajeros pasajero){
        ListaPasajeros.add(pasajero);
    }

    public Pasajeros obtenerPasajero(int index){
        if(index>=0 && index < ListaPasajeros.size()){
           return ListaPasajeros.get(index);
        }
        else{
            return null;
        }
    } 
    
    public void MostrarPasajeroporvuelo(){
        for(int pos=0; pos<ListaPasajeros.size();pos++) {
            System.out.println("Lista de pasajeros por el vuelo: "+(idvuelo));
            ListaPasajeros.get(pos).MostrarInformacionPasajero();
        }
    }

    
    public void MostrarInformacionVuelo(){
        System.out.println("Id Vuelo: "+idvuelo);
        System.out.println("Estado: "+estado);
        System.out.println("Origen: "+origen);
        System.out.println("Destino: "+destino);
        System.out.println("Hora de llegada: "+horallegada);
        System.out.println("Hora de salida: "+horasalida);
        System.out.println("Cantidad de pasajeros: "+cantidadpasajeros);
        System.out.println("Id Tripulación: "+ tripulacion  != null ? tripulacion.getIdtripulacion() : "N/A");
        tripulacion.MostrarInformacionTripulacion();
        System.out.println("Total de Tripulantes: "+tripulacion.TotalTripulantes());
        System.out.println("Id Avion: "+avion.getIdavion()); 
    }
}
