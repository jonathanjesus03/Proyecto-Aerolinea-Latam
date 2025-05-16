/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import Connectionbd.Connectiondb;
import Interfaces.DAOMaleta;
import Interfaces.DAOPasaje;
import Interfaces.DAOPasajero;
import Interfaces.DAOVuelos;
import MODELS.Maleta;
import MODELS.Pasaje;
import MODELS.Pasajeros;
import MODELS.Vuelos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Samsung
 */
public class DAOPasajeroIMPL extends Connectiondb implements DAOPasajero{

    @Override
    public void registrarPA(Pasajeros pasajero) throws Exception {
        try {
            this.getConnetion();
            PreparedStatement ps = this.conexion.prepareStatement("INSERT INTO Pasajero(Nombre, Apellido, Edad, Contacto, Correo, Documento, Discapacidad) VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, pasajero.getNombre());
            ps.setString(2, pasajero.getApellido());
            ps.setInt(3, pasajero.getEdad());
            ps.setString(4, pasajero.getContacto());
            ps.setString(5, pasajero.getEmail());
            ps.setString(6, pasajero.getDocumentos());
            ps.setString(7, pasajero.getDiscapacidad());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.err.println(e);
        }finally{
            this.closeConnection();
            }
    }

    @Override
    public void modificarPA(Pasajeros pasajero) throws Exception {
            try {
            this.getConnetion();
            PreparedStatement ps = this.conexion.prepareStatement("UPDATE Pasajero SET Nombre = ?, Apellido = ? ,Edad = ?, Contacto = ?, Correo = ?, Documento = ?, Discapacidad = ?, Chekeado = ?, Id_Maleta = ?, Id_Vuelo = ?, Cod_Pasaje = ?, Id_Avion = ? WHERE Id_Cliente = ?");
            ps.setString(1, pasajero.getNombre() != null ? pasajero.getNombre() : null);
            ps.setString(2, pasajero.getApellido() != null ? pasajero.getApellido() : null);
            ps.setInt(3, pasajero.getEdad());
            ps.setString(4, pasajero.getContacto() != null ? pasajero.getContacto() : null);
            ps.setString(5, pasajero.getEmail() != null ? pasajero.getEmail() : null);
            ps.setString(6, pasajero.getDocumentos() != null ? pasajero.getDocumentos() : null);
            ps.setString(7, pasajero.getDiscapacidad() != null ? pasajero.getDiscapacidad() : "N/A");
            ps.setInt( 8, pasajero.isCheckeado() ? 1 : 0);
            ps.setObject(9, pasajero.getMaleta()!=  null ? pasajero.getMaleta().getId() : null);
            ps.setObject(10, pasajero.getVuelos() != null? pasajero.getVuelos().getIdvuelo() : null);

            if (pasajero.getPasaje() != null && pasajero.getPasaje().getIdPasaje() != 0) {
                ps.setString(11, pasajero.getPasaje().getCodigoPS());
            } else {
            ps.setNull(11, java.sql.Types.INTEGER);
            }
            ps.setObject(12, pasajero.getVuelos() != null ? pasajero.getVuelos().getAvion().getIdavion() : null);
            ps.setInt(13, pasajero.getIdcliente());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.err.println(e);
        }finally{
            this.closeConnection();
            }
}

    @Override
    public void elminarPA(int userid) throws Exception {
        try {
            this.getConnetion();
            PreparedStatement ps = this.conexion.prepareStatement("DELETE FROM Pasajero WHERE Id_Cliente = ?");
            ps.setInt(1, userid);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.closeConnection();
        }
    }

    @Override
    public List<Pasajeros> listarPA(String name) throws Exception {
        List<Pasajeros> lista = null;
        try {
            this.getConnetion();
            String query = name.isEmpty() ? "SELECT * FROM Pasajero" : "SELECT * FROM Pasajero WHERE Nombre like '%"+name+"%'";
            PreparedStatement ps = this.conexion.prepareStatement(query);
            
            lista = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Pasajeros p = new Pasajeros();
                p.setIdcliente(rs.getInt("Id_Cliente"));
                p.setNombre(rs.getString("Nombre"));
                p.setApellido(rs.getString("Apellido"));
                p.setEdad(rs.getInt("Edad"));
                p.setContacto(rs.getString("Contacto"));
                p.setEmail( rs.getString("Correo"));
                p.setDocumentos(rs.getString("Documento"));
                p.setDiscapacidad(rs.getString("Discapacidad"));
                p.setCheckeado(rs.getInt("Chekeado") == 1 ? true : false);
                if(rs.getString("Cod_Pasaje")!=null){
                    DAOPasaje daoP = new DAOPasajeIMPL();
                    Pasaje pasaje = daoP.getPasajebyCode(rs.getString("Cod_Pasaje"));
                    p.setPasaje(pasaje);
                }
                if(rs.getInt("Id_Maleta") != 0){
                    DAOMaleta daoM = new DAOMaletaIMPL();
                    Maleta maleta = daoM.getMaletabyId(rs.getInt("Id_Maleta"));
                    p.setMaleta(maleta);
                }
                if(rs.getInt("Id_Vuelo") != 0){
                    DAOVuelos daovu = new DAOVuelosIMPL();
                    Vuelos vuelo = daovu.getVuelobyId(rs.getInt("Id_Vuelo"));
                    p.setVuelos(vuelo);
                }
                lista.add(p);

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
    public List<Pasajeros> listarPAforVU(int idV) throws Exception {
        List<Pasajeros> lista = null;
        try {
            this.getConnetion();
            String query = "SELECT * FROM Pasajero WHERE Id_Vuelo = ?";
            PreparedStatement ps = this.conexion.prepareStatement(query);
            ps.setInt(1, idV);
            lista = new ArrayList<>();

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Pasajeros p = new Pasajeros();
                p.setIdcliente(rs.getInt("Id_Cliente"));
                p.setNombre(rs.getString("Nombre"));
                p.setApellido(rs.getString("Apellido"));
                p.setEdad(rs.getInt("Edad"));
                p.setContacto(rs.getString("Contacto"));
                p.setEmail( rs.getString("Correo"));
                p.setDocumentos(rs.getString("Documento"));
                p.setDiscapacidad(rs.getString("Discapacidad"));
                p.setCheckeado(rs.getInt("Chekeado") == 1 ? true : false);
                if(rs.getString("Cod_Pasaje")!=null){
                    DAOPasaje daoP = new DAOPasajeIMPL();
                    Pasaje pasaje = daoP.getPasajebyCode(rs.getString("Cod_Pasaje"));
                    p.setPasaje(pasaje);
                }
                if(rs.getInt("Id_Maleta") != 0){
                    DAOMaleta daoM = new DAOMaletaIMPL();
                    Maleta maleta = daoM.getMaletabyId(rs.getInt("Id_Maleta"));
                    p.setMaleta(maleta);
                }
                if(rs.getInt("Id_Vuelo") != 0){
                    DAOVuelos daovu = new DAOVuelosIMPL();
                    Vuelos vuelo = daovu.getVuelobyId(rs.getInt("Id_Vuelo"));
                    p.setVuelos(vuelo);
                }
                lista.add(p);

            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());;
        }finally{
            this.closeConnection();
        }
        return lista;
        }
    
    @Override
    public Pasajeros getPasajerobyId(int userid) throws Exception {
        Pasajeros p = new Pasajeros();
        try {
            this.getConnetion();
            PreparedStatement ps = this.conexion.prepareStatement("SELECT * FROM Pasajero WHERE Id_Cliente = ?");
            ps.setInt(1, userid);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                p.setIdcliente(rs.getInt("Id_Cliente"));
                p.setNombre(rs.getString("Nombre"));
                p.setApellido(rs.getString("Apellido"));
                p.setEdad(rs.getInt("Edad"));
                p.setContacto(rs.getString("Contacto"));
                p.setEmail( rs.getString("Correo"));
                p.setDocumentos(rs.getString("Documento"));
                p.setDiscapacidad(rs.getString("Discapacidad"));
                p.setCheckeado(rs.getInt("Chekeado") == 1 ? true : false);
                if(rs.getString("Cod_Pasaje")!=null){
                    DAOPasaje daoP = new DAOPasajeIMPL();
                    Pasaje pasaje = daoP.getPasajebyCode(rs.getString("Cod_Pasaje"));
                    p.setPasaje(pasaje);
                }
                if(rs.getInt("Id_Maleta") != 0){
                    DAOMaleta daoM = new DAOMaletaIMPL();
                    Maleta maleta = daoM.getMaletabyId(rs.getInt("Id_Maleta"));
                    p.setMaleta(maleta);
                }
                if(rs.getInt("Id_Vuelo") != 0){
                    DAOVuelos daovu = new DAOVuelosIMPL();
                    Vuelos vuelo = daovu.getVuelobyId(rs.getInt("Id_Vuelo"));
                    p.setVuelos(vuelo);
                }
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.closeConnection();
        }
        return p;    
    }

    @Override
    public Pasajeros getPasajeroForVU(String nombre, String apellido, String cod_Pasaje, String documento) throws Exception {
        Pasajeros p = new Pasajeros();
        try {
            this.getConnetion();
            PreparedStatement ps = this.conexion.prepareStatement("SELECT * FROM Pasajero WHERE Nombre = ? and Apellido = ? and Cod_Pasaje = ? and Documento = ?");
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, cod_Pasaje);
            ps.setString(4, documento);

            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                p.setIdcliente(rs.getInt("Id_Cliente"));
                p.setNombre(rs.getString("Nombre"));
                p.setApellido(rs.getString("Apellido"));
                p.setEdad(rs.getInt("Edad"));
                p.setContacto(rs.getString("Contacto"));
                p.setEmail( rs.getString("Correo"));
                p.setDocumentos(rs.getString("Documento"));
                p.setDiscapacidad(rs.getString("Discapacidad"));
                p.setCheckeado(rs.getInt("Chekeado") == 1 ? true : false);
                if(rs.getString("Cod_Pasaje")!=null){
                    DAOPasaje daoP = new DAOPasajeIMPL();
                    Pasaje pasaje = daoP.getPasajebyCode(rs.getString("Cod_Pasaje"));
                    p.setPasaje(pasaje);
                }
                if(rs.getInt("Id_Maleta") != 0){
                    DAOMaleta daoM = new DAOMaletaIMPL();
                    Maleta maleta = daoM.getMaletabyId(rs.getInt("Id_Maleta"));
                    p.setMaleta(maleta);
                }
                if(rs.getInt("Id_Vuelo") != 0){
                    DAOVuelos daovu = new DAOVuelosIMPL();
                    Vuelos vuelo = daovu.getVuelobyId(rs.getInt("Id_Vuelo"));
                    p.setVuelos(vuelo);
                }
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            this.closeConnection();
        }
        return p;    
    }
}
