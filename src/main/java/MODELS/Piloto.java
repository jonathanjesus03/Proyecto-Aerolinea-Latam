/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELS;

/**
 *
 * @author cr075
 */
public class Piloto extends Empleado{
    String codigo,jerarquia;
    double sueldo;

    public Piloto() {
    }
    
    public Piloto(String nombre, String apellido, String contacto, String email, int edad,String documentos, String rol, String codigo
    , double sueldo,String jerarquia) {
        super(nombre, apellido, contacto, email, edad,documentos, rol);
        this.sueldo=sueldo;
        this.jerarquia=jerarquia;
        this.codigo=codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getJerarquia() {
        return jerarquia;
    }

    public void setJerarquia(String jerarquia) {
        this.jerarquia = jerarquia;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    public void MostrarInformacionPiloto(){
        super.MostrarInformacionEmpleado();
        System.out.println("Codigo: "+codigo);
        System.out.println("Jerarquia: "+jerarquia);
        System.out.println("Sueldo: "+sueldo);
    }
    
}
