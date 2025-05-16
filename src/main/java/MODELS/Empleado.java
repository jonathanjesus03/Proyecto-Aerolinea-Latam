/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELS;

/**
 *
 * @author cr075
 */
public class Empleado extends Persona{
    private int id;
    private String rol;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, String contacto, String email, int edad,String documentos,String rol) {
        super(nombre, apellido, contacto, email, edad,documentos);
        this.rol=rol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
   
    
    public void MostrarInformacionEmpleado(){
        System.out.println("id: "+id);
        super.MostrarInformacion();
    }
}
