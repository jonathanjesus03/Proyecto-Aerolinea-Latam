/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import Connectionbd.Connectiondb;
import Interfaces.DAOPasajero;
import MODELS.Avion;
import MODELS.Pasajeros;
import java.sql.PreparedStatement;
import java.util.List;
import Interfaces.DAOAviones;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Samsung
 */
public class DAOAvionesIMPL extends Connectiondb implements DAOAviones{

    @Override
    public void registrarAV(Avion avion) throws Exception {
        try {
            this.getConnetion();
            PreparedStatement ps = this.conexion.prepareStatement("INSERT INTO Avion(Nombre, Falla, Placa, Cantidad_Pasajeros_Maximos, Estado_Vuelo) VALUES(?,?,?,?,?)");
            ps.setString(1, avion.getNombre());
            ps.setString(2, avion.getFalla().isEmpty() ? "N/A" : avion.getFalla());
            ps.setString(3, avion.getPlaca());
            ps.setInt(4, avion.getCantpasajerosmax());
            ps.setInt(5, avion.isEstadoVuelo()? 1 : 0);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.err.println(e);
        }finally{
            this.closeConnection();
            }
    }

    @Override
    public void modificarAV(Avion avion) throws Exception {
         try {
            this.getConnetion();
            PreparedStatement ps = this.conexion.prepareStatement("UPDATE Avion SET Nombre = ?, Falla = ? ,Placa = ?, Cantidad_Pasajeros_Maximos = ?, Estado_Vuelo = ? WHERE Id_Avion = ?");
            ps.setString(1, avion.getNombre());
            ps.setString(2, avion.getFalla().isEmpty() ? "N/A" : avion.getFalla());
            ps.setString(3, avion.getPlaca());
            ps.setInt(4, avion.getCantpasajerosmax());
            ps.setInt(5, avion.isEstadoVuelo() ? 1 : 0);
            ps.setInt( 6, avion.getIdavion());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.err.println(e);
        }finally{
            this.closeConnection();
            }
    }

    @Override
    public void elminarAV(int avid) throws Exception {
        try {
            this.getConnetion();
            PreparedStatement ps = this.conexion.prepareStatement("DELETE FROM Avion WHERE Id_Avion = ?");
            ps.setInt(1, avid);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.closeConnection();
        }
    }

    @Override
    public List<Avion> listarAV(String name) throws Exception {
        List<Avion> lista = null;
        try {
            this.getConnetion();
            String query = name.isEmpty() ? "SELECT * FROM Avion" : "SELECT * FROM Avion WHERE Nombre like '%"+name+"%'";
            PreparedStatement ps = this.conexion.prepareStatement(query);
            
            lista = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Avion a = new Avion();
                a.setIdavion(rs.getInt("Id_Avion"));
                a.setNombre(rs.getString("Nombre"));
                a.setFalla(rs.getString("Falla"));
                a.setPlaca(rs.getString("Placa"));
                a.setCantpasajerosmax(rs.getInt("Cantidad_Pasajeros_Maximos"));
                a.setEstadoVuelo(rs.getInt("Estado_Vuelo") == 0 ? false : true);

                lista.add(a);
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
    public Avion getAvionbyId(int avid) throws Exception {
        Avion a = new Avion();
        try {
            this.getConnetion();
            PreparedStatement ps = this.conexion.prepareStatement("SELECT * FROM Avion WHERE Id_Avion = ?");
            ps.setInt(1, avid);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                a.setIdavion(rs.getInt("Id_Avion"));
                a.setNombre(rs.getString("Nombre"));
                a.setFalla(rs.getString("Falla"));
                a.setPlaca(rs.getString("Placa"));
                a.setCantpasajerosmax(rs.getInt("Cantidad_Pasajeros_Maximos"));
                a.setEstadoVuelo(rs.getInt("Estado_Vuelo") == 0 ? false : true);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.closeConnection();
        }
        return a;    
    }
    
}
