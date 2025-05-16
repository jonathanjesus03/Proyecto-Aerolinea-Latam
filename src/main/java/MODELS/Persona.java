/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELS;

/**
 * 
 * @author cr075
 */
public class Persona {
   private String nombre,apellido,contacto,email,documentos;
   private int edad;
   private String discapacidad = "N/A";

    public Persona() {
    }

    public Persona(String nombre, String apellido, String contacto, String email, int edad, String documentos){
        this.nombre = nombre;
        this.apellido = apellido;
        this.contacto = contacto;
        this.email = email;
        this.documentos = documentos;
        this.edad = edad;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocumentos() {
        return documentos;
    }

    public void setDocumentos(String documentos) {
        this.documentos = documentos;
    }
    
   
    public void MostrarInformacion(){
        System.out.println("Nombre: "+nombre);
        System.out.println("Apellido: "+apellido);
        System.out.println("Contacto: "+contacto);
        System.out.println("Email: "+email);
        System.out.println("Edad: "+edad);
        System.out.println("Documento: "+documentos);
    }
}
