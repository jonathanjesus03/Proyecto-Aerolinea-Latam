/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import Connectionbd.Connectiondb;
import Interfaces.DAOAzafata;
import MODELS.Azafata;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Samsung
 */
public class DAOAzafataIMPL extends Connectiondb implements DAOAzafata {

    @Override
    public void registrarAZaT(int idAZ, int idT) throws Exception {
        try {
            this.getConnetion();
            PreparedStatement ps = this.conexion.prepareStatement("INSERT INTO Azafata_Tripulacion(Id_Azafata,Id_Tripulacion) VALUES(?,?)");
            ps.setInt(1, idAZ);
            ps.setInt(2, idT);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.err.println(e);
        }finally{
            this.closeConnection();
            }
    }
    
    @Override
        public void registrarAZ(Azafata azafata) throws Exception {
            try {
                this.getConnetion();
                PreparedStatement ps = this.conexion.prepareStatement("INSERT INTO Azafata(Nombre, Apellido, Edad, Contacto, Correo, Documento, Codigo, Sueldo, Rol, Jerarquia) VALUES(?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1, azafata.getNombre());
                ps.setString(2, azafata.getApellido());
                ps.setInt(3, azafata.getEdad());
                ps.setString(4, azafata.getContacto());
                ps.setString(5, azafata.getEmail());
                ps.setString(6, azafata.getDocumentos());
                ps.setString(7, azafata.getCodigo());
                ps.setDouble(8, azafata.getSueldo());
                ps.setString(9, azafata.getRol());
                ps.setString(10, azafata.getJerarquia());
                ps.executeUpdate();
                ps.close();
            } catch (Exception e) {
                System.err.println(e);
            }finally{
                this.closeConnection();
                }    
        }

    @Override
    public void modificarAZ(Azafata azafata) throws Exception {
try {
            this.getConnetion();
            PreparedStatement ps = this.conexion.prepareStatement("UPDATE Azafata SET Nombre = ?, Apellido = ? ,Edad = ?, Contacto = ?, Correo = ?, Documento = ?, Codigo = ?, Sueldo = ?, Rol = ?, Jerarquia = ? WHERE Id_Azafata = ?");
            ps.setString(1, azafata.getNombre() != null ? azafata.getNombre() : null);
            ps.setString(2, azafata.getApellido() != null ? azafata.getApellido() : null);
            ps.setInt(3, azafata.getEdad());
            ps.setString(4, azafata.getContacto() != null ? azafata.getContacto() : null);
            ps.setString(5, azafata.getEmail() != null ? azafata.getEmail() : null);
            ps.setString(6, azafata.getDocumentos() != null ? azafata.getDocumentos() : null);
            ps.setString(7, azafata.getCodigo()!= null ? azafata.getDiscapacidad() : null);
            ps.setDouble(8, azafata.getSueldo() != 0 ? azafata.getSueldo() : 0);
            ps.setObject(9, azafata.getRol() != null ? azafata.getRol() : null);
            ps.setObject(10, azafata.getJerarquia()!= null ? azafata.getJerarquia(): null);
            ps.setInt(11, azafata.getId());
            
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.err.println(e);
        }finally{
            this.closeConnection();
            }
    }

    @Override
    public void elminarAZ(String azID) throws Exception {
        try {
            this.getConnetion();
            PreparedStatement ps = this.conexion.prepareStatement("DELETE FROM Azafata WHERE Codigo = ?");
            ps.setString(1, azID);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.closeConnection();
        }    }

    @Override
    public List<Azafata> listarAZ(String name) throws Exception {
        List<Azafata> lista = null;
        try {
            this.getConnetion();
            String query = name.isEmpty() ? "SELECT * FROM Azafata" : "SELECT * FROM Azafata WHERE Nombre like '%"+name+"%'";
            PreparedStatement ps = this.conexion.prepareStatement(query);
            
            lista = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Azafata az = new Azafata();
                az.setId(rs.getInt("Id_Azafata"));
                az.setNombre(rs.getString("Nombre"));
                az.setApellido(rs.getString("Apellido"));
                az.setEdad(rs.getInt("Edad"));
                az.setContacto(rs.getString("Contacto"));
                az.setEmail( rs.getString("Correo"));
                az.setDocumentos(rs.getString("Documento"));
                az.setRol(rs.getString("Rol"));
                az.setCodigo(rs.getString("Codigo"));
                az.setSueldo(rs.getDouble("Sueldo"));
                az.setJerarquia(rs.getString("Jerarquia"));
                lista.add(az);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.closeConnection();
        }
        return lista;    
    }

    @Override
    public Azafata getAzafatabyId(int userid) throws Exception {
       Azafata az = new Azafata();
        try {
            this.getConnetion();
            PreparedStatement ps = this.conexion.prepareStatement("SELECT TOP 1 * FROM Azafata WHERE Id_Azafata = ?");
            ps.setInt(1, userid);            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                az.setId(rs.getInt("Id_Azafata"));
                az.setNombre(rs.getString("Nombre"));
                az.setApellido(rs.getString("Apellido"));
                az.setEdad(rs.getInt("Edad"));
                az.setContacto(rs.getString("Contacto"));
                az.setEmail( rs.getString("Correo"));
                az.setDocumentos(rs.getString("Documento"));
                az.setRol(rs.getString("Rol"));
                az.setCodigo(rs.getString("Codigo"));
                az.setSueldo(rs.getDouble("Sueldo"));
                az.setJerarquia(rs.getString("Jerarquia"));

            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.closeConnection();
        }
        return az;    }
    
    @Override
    public Azafata getAzafatabyCode(String code) throws Exception {
       Azafata az = new Azafata();
        try {
            this.getConnetion();
            PreparedStatement ps = this.conexion.prepareStatement("SELECT TOP 1 * FROM Azafata WHERE Codigo = ?");
            ps.setString(1, code);            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                az.setId(rs.getInt("Id_Azafata"));
                az.setNombre(rs.getString("Nombre"));
                az.setApellido(rs.getString("Apellido"));
                az.setEdad(rs.getInt("Edad"));
                az.setContacto(rs.getString("Contacto"));
                az.setEmail( rs.getString("Correo"));
                az.setDocumentos(rs.getString("Documento"));
                az.setRol(rs.getString("Rol"));
                az.setCodigo(rs.getString("Codigo"));
                az.setSueldo(rs.getDouble("Sueldo"));
                az.setJerarquia(rs.getString("Jerarquia"));

            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.closeConnection();
        }
        return az;    }
    
}
