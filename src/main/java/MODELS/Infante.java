/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELS;

/**
 *
 * @author cr075
 */
public class Infante extends Pasajeros{
        private String idinfante; 

    public Infante(String idinfante, boolean checkeado, Vuelos vuelos, Pasaje pasaje, Maleta maleta, String discapacidad, String nombre, String apellido, String contacto, String email, int edad, String documentos) {
        super(checkeado, vuelos, pasaje, maleta, discapacidad, nombre, apellido, contacto, email, edad, documentos);
        this.idinfante = idinfante;
    }
    
    public String getIdinfante() {
        return idinfante;
    }

    public void setIdinfante(String idinfante) {
        this.idinfante = idinfante;
    }
    
    
   
}
