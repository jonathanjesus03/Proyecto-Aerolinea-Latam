/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELS;

/**
 *
 * @author cr075
 */
public class Avion {
    private int idavion;
    private String nombre,falla,placa;
    private int cantpasajerosmax;
    private boolean estadoVuelo = false;

    public Avion() {
    }
    
    public Avion(String nombre,String falla,String placa, int cantpasajerosmax) {
        this.nombre = nombre;
        this.falla=falla;
        this.placa=placa;
        this.cantpasajerosmax = cantpasajerosmax;
    }

    public int getIdavion() {
        return idavion;
    }

    public void setIdavion(int idavion) {
        this.idavion = idavion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantpasajerosmax() {
        return cantpasajerosmax;
    }

    public void setCantpasajerosmax(int cantpasajerosmax) {
        this.cantpasajerosmax = cantpasajerosmax;
    }

    public boolean isEstadoVuelo() {
        return estadoVuelo;
    }

    public void setEstadoVuelo(boolean estadoVuelo) {
        this.estadoVuelo = estadoVuelo;
    }

    public String getFalla() {
        return falla;
    }

    public void setFalla(String falla) {
        this.falla = falla;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    public void MostrarInformacionAvion(){
        System.out.println("Modelo: "+nombre);
        System.out.println("Placa: "+placa);
        System.out.println("Falla alguna: "+falla);
        System.out.println("Placa: "+placa);
        System.out.println("Total de pasajeros: "+cantpasajerosmax);
        System.out.println("Estado de vuelo: "+estadoVuelo);
    }
}
