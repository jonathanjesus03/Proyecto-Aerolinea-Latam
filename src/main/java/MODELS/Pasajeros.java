/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELS;

/**
 *
 * @author cr075
 */
public class Pasajeros extends Persona{
    private int idcliente;
    private boolean checkeado = false;
    private Vuelos vuelos;
    private Pasaje pasaje;
    private Maleta maleta;
    private ServiciosEspeciales servicioEspecial;

    public Pasajeros(String nombre, String apellido, String contacto, String email, String documentos, int edad) {
        super(nombre, apellido, contacto, email, edad, documentos);
    }

    public Pasajeros() {
    }
  
    
     public Pasajeros(boolean checkeado, Vuelos vuelos, Pasaje pasaje, Maleta maleta, String discapacidad, String nombre, String apellido, String contacto, String email, int edad, String documentos) {
        super(nombre, apellido, contacto, email, edad, documentos);
        this.checkeado = checkeado;
        this.vuelos = vuelos;
        this.pasaje = pasaje;
        this.maleta = maleta;
    }

    public Pasaje getPasaje() {
        return pasaje;
    }
    
    public void setPasaje(Pasaje pasaje) {
        this.pasaje = pasaje;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }


    public boolean isCheckeado() {
        return checkeado;
    }

    public void setCheckeado(boolean checkeado) {
        this.checkeado = checkeado;
    }

    public Vuelos getVuelos() {
        return vuelos;
    }

    public void setVuelos(Vuelos vuelos) {
        this.vuelos = vuelos;
    }

    public Maleta getMaleta() {
        return maleta;
    }

    public void setMaleta(Maleta maleta) {
        this.maleta = maleta;
    }
    
    
    public ServiciosEspeciales getServicioEspeciales() {
        return servicioEspecial ;
    }

    public void setServicioEspecial(ServiciosEspeciales servicio) {
        this.servicioEspecial = servicio;
    }
    
     public void MostrarInformacionPasajero(){
        super.MostrarInformacion();
         System.out.println("ID del cliente: "+idcliente);
         System.out.println("Check in: "+checkeado);
         System.out.println(vuelos != null ? String.valueOf(vuelos.getIdvuelo()): "N/A");
         System.out.println("Discapacidad: "+this.getDiscapacidad());
         System.out.println(servicioEspecial == null ? "N/A" :servicioEspecial.getDescripcion());
         if(maleta != null){
            maleta.MostrarInformacionDimension();
            maleta.MostrarInformacionPeso();
         }else{System.out.println("Maleta: N/A");}
    }
}
