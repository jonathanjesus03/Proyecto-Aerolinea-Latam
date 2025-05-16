/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import Connectionbd.Connectiondb;
import Interfaces.DAOPilotos;
import MODELS.Piloto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Samsung
 */
public class DAOPilotosIMPL extends Connectiondb implements DAOPilotos{
     @Override
    public void registrarPaT(int idP, int idT) throws Exception {
        try {
            this.getConnetion();
            PreparedStatement ps = this.conexion.prepareStatement("INSERT INTO Piloto_Tripulacion(Id_Piloto,Id_Tripulacion) VALUES(?,?)");
            ps.setInt(1, idP);
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
    public void registrarPI(Piloto piloto) throws Exception {
        try {
            this.getConnetion();
            PreparedStatement ps = this.conexion.prepareStatement("INSERT INTO Piloto(Nombre, Apellido, Edad, Contacto, Correo, Documento, Codigo, Sueldo, Rol, Jerarquia) VALUES(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, piloto.getNombre());
            ps.setString(2, piloto.getApellido());
            ps.setInt(3, piloto.getEdad());
            ps.setString(4, piloto.getContacto());
            ps.setString(5, piloto.getEmail());
            ps.setString(6, piloto.getDocumentos());
            ps.setString(7, piloto.getCodigo());
            ps.setDouble(8, piloto.getSueldo());
            ps.setString(9, piloto.getRol());
            ps.setString(10, piloto.getJerarquia());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.err.println(e);
        }finally{
            this.closeConnection();
            }
    }

    @Override
    public void modificarPI(Piloto piloto) throws Exception {
        try {
            this.getConnetion();
            PreparedStatement ps = this.conexion.prepareStatement("UPDATE Piloto SET Nombre = ?, Apellido = ? ,Edad = ?, Contacto = ?, Correo = ?, Documento = ?, Codigo = ?, Sueldo = ?, Rol = ?, Jerarquia = ? WHERE Id_Piloto = ?");
            ps.setString(1, piloto.getNombre() != null ? piloto.getNombre() : null);
            ps.setString(2, piloto.getApellido() != null ? piloto.getApellido() : null);
            ps.setInt(3, piloto.getEdad());
            ps.setString(4, piloto.getContacto() != null ? piloto.getContacto() : null);
            ps.setString(5, piloto.getEmail() != null ? piloto.getEmail() : null);
            ps.setString(6, piloto.getDocumentos() != null ? piloto.getDocumentos() : null);
            ps.setString(7, piloto.getCodigo()!= null ? piloto.getDiscapacidad() : null);
            ps.setDouble(8, piloto.getSueldo() != 0 ? piloto.getSueldo() : 0);
            ps.setObject(9, piloto.getRol() != null ? piloto.getRol() : null);
            ps.setObject(10, piloto.getJerarquia()!= null ? piloto.getJerarquia(): null);
            ps.setInt(11, piloto.getId());
            
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.err.println(e);
        }finally{
            this.closeConnection();
            }
    }

    @Override
    public void elminarPI(String codePI) throws Exception {
        try {
            this.getConnetion();
            PreparedStatement ps = this.conexion.prepareStatement("DELETE FROM Piloto WHERE Codigo = ?");
            ps.setString(1, codePI);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.closeConnection();
        }
    }

    @Override
    public List<Piloto> listarPI(String name) throws Exception {
        List<Piloto> lista = null;
        try {
            this.getConnetion();
            String query = name.isEmpty() ? "SELECT * FROM Piloto" : "SELECT * FROM Piloto WHERE Nombre like '%"+name+"%'";
            PreparedStatement ps = this.conexion.prepareStatement(query);
            
            lista = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Piloto p = new Piloto();
                p.setId(rs.getInt("Id_Piloto"));
                p.setNombre(rs.getString("Nombre"));
                p.setApellido(rs.getString("Apellido"));
                p.setEdad(rs.getInt("Edad"));
                p.setContacto(rs.getString("Contacto"));
                p.setEmail( rs.getString("Correo"));
                p.setDocumentos(rs.getString("Documento"));
                p.setRol(rs.getString("Rol"));
                p.setCodigo(rs.getString("Codigo"));
                p.setSueldo(rs.getDouble("Sueldo"));
                p.setJerarquia(rs.getString("Jerarquia"));
                lista.add(p);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.closeConnection();
        }
        return lista;    }

    
    @Override
    public Piloto getPilotobyId(int idP) throws Exception {
        Piloto p = new Piloto();
        try {
            this.getConnetion();
            PreparedStatement ps = this.conexion.prepareStatement("SELECT TOP 1 * FROM Piloto WHERE Id_Piloto = ?");
            ps.setInt(1, idP);            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                p.setId(rs.getInt("Id_Piloto"));
                p.setNombre(rs.getString("Nombre"));
                p.setApellido(rs.getString("Apellido"));
                p.setEdad(rs.getInt("Edad"));
                p.setContacto(rs.getString("Contacto"));
                p.setEmail( rs.getString("Correo"));
                p.setDocumentos(rs.getString("Documento"));
                p.setRol(rs.getString("Rol"));
                p.setCodigo(rs.getString("Codigo"));
                p.setSueldo(rs.getDouble("Sueldo"));
                p.setJerarquia(rs.getString("Jerarquia"));

            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.closeConnection();
        }
        return p;    }
    
    @Override
    public Piloto getPilotobyCode(String codigo) throws Exception {
        Piloto p = new Piloto();
        try {
            this.getConnetion();
            PreparedStatement ps = this.conexion.prepareStatement("SELECT TOP 1 * FROM Piloto WHERE Codigo = ?");
            ps.setString(1, codigo);            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                p.setId(rs.getInt("Id_Piloto"));
                p.setNombre(rs.getString("Nombre"));
                p.setApellido(rs.getString("Apellido"));
                p.setEdad(rs.getInt("Edad"));
                p.setContacto(rs.getString("Contacto"));
                p.setEmail( rs.getString("Correo"));
                p.setDocumentos(rs.getString("Documento"));
                p.setRol(rs.getString("Rol"));
                p.setCodigo(rs.getString("Codigo"));
                p.setSueldo(rs.getDouble("Sueldo"));
                p.setJerarquia(rs.getString("Jerarquia"));

            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.closeConnection();
        }
        return p;    }
    
}
