/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELS;

/**
 *
 * @author Samsung
 */
public class Pasaje {
    private int idPasaje,idPasajero;
    private String codigoPS, codVuelo, codAsiento;

    public Pasaje() {
    }

    public Pasaje(int idPasaje, int idPasajero, String codigoPS, String codVuelo, String codAsiento) {
        this.idPasaje = idPasaje;
        this.idPasajero = idPasajero;
        this.codigoPS = codigoPS;
        this.codVuelo = codVuelo;
        this.codAsiento = codAsiento;
    }

    public int getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }

    public int getIdPasaje() {
        return idPasaje;
    }

    public void setIdPasaje(int idPasaje) {
        this.idPasaje = idPasaje;
    }

    public String getCodigoPS() {
        return codigoPS;
    }

    public void setCodigoPS(String codigoPS) {
        this.codigoPS = codigoPS;
    }

    public String getCodVuelo() {
        return codVuelo;
    }

    public void setCodVuelo(String codVuelo) {
        this.codVuelo = codVuelo;
    }

    public String getCodAsiento() {
        return codAsiento;
    }

    public void setCodAsiento(String codAsiento) {
        this.codAsiento = codAsiento;
    }


   

    

}
