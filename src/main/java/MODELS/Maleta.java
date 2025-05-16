/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELS;

/**
 *
 * @author cr075
 */
public class Maleta {
    private int id, idPasajero;
    private int[] dimension;
    private float peso;

    public Maleta() {
    }

    public Maleta(int idPasajero, int[] dimension, float peso) {
        this.idPasajero= idPasajero;
        this.dimension = dimension;
        this.peso = peso;
    }

    public int getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }

    

    public int[] getDimension() {
        return dimension;
    }

    public void setDimension(int[] dimension) {
        this.dimension = dimension;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getId() {
        return id;
    }

    public void setId(int cod_maleta) {
        this.id = cod_maleta;
    }
    
    
    public void MostrarInformacionDimension(){
      for(int i: dimension) {
         System.out.println(i);
         }  
    }
    public void MostrarInformacionPeso(){
        System.out.println("Codigo de Maleta: "+this.id+"\nPeso: "+peso+"kg");
    }
}
