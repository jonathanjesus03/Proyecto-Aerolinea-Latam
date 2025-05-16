/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELS;

/**
 *
 * @author Samsung
 */
public class Alimentos {
    private int id;
    private String refvuelo;
    private String Tipo;
    private String Nombre;

    public Alimentos(String refvuelo, String Tipo, String Nombre){
        this.refvuelo = refvuelo;
        this.Tipo = Tipo;
        this.Nombre = Nombre;
    }

    public String getRefvuelo() {
        return refvuelo;
    }

    public void setRefvuelo(String refvuelo){
        this.refvuelo = refvuelo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNomnbe(String Nomnre) {
        this.Nombre = Nomnre;
    }

    @Override
    public String toString() {
        return "Alimentos{" + "Tipo=" + Tipo + ", Nomnre=" + Nombre + "}" + " Para el vuelo: "+refvuelo;
    }
    
    
}
