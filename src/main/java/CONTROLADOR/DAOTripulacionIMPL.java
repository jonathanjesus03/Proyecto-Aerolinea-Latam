/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import Connectionbd.Connectiondb;
import Interfaces.DAOAzafata;
import Interfaces.DAOPilotos;
import Interfaces.DAOTripulacion;
import MODELS.Azafata;
import MODELS.Piloto;
import MODELS.Tripulacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Samsung
 */
public class DAOTripulacionIMPL extends Connectiondb implements DAOTripulacion {

    
    @Override
    public void registrarT(Tripulacion tripu, int idv) throws Exception {
        PreparedStatement ps = null;
        this.getConnetion();
        try {            
            ps = this.conexion.prepareStatement("UPDATE Vuelos SET Id_Tripulacion = ? WHERE Id_Vuelo = ?");
            ps.setInt(1, tripu.getIdtripulacion());
            ps.setInt(2, idv);
            ps.executeUpdate();        
            
        } catch (Exception e) {
            throw new Exception("Error al registrar la tripulación", e);
        } finally {
            this.conexion.close();
            ps.close();
        }
    }
    
    @Override
    public void registrarTaV(int idv) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        this.getConnetion();
        try {
            
            ps = this.conexion.prepareStatement("INSERT INTO Tripulacion DEFAULT VALUES", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            int idTripulacion = 0;
            if (rs.next()){
                idTripulacion = rs.getInt(1); // Obtener el ID generado
            }
            
            ps = this.conexion.prepareStatement("UPDATE Vuelos SET Id_Tripulacion = ? WHERE Id_Vuelo = ?");
            ps.setInt(1, idTripulacion);
            ps.setInt(2, idv);
            ps.executeUpdate();        
            
        } catch (Exception e) {
            throw new Exception("Error al registrar la tripulación", e);
        } finally {
            this.conexion.close();
            ps.close();
            rs.close();
        }
    }

    @Override
    public void elminarT(int Tid) throws Exception {
        try {
            this.getConnetion();
                PreparedStatement ps = this.getConnetion().prepareStatement("DELETE FROM Tripulacion WHERE Id_Tripulacion = ?");
            ps.setInt(1, Tid);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
        System.err.print(e);
        } finally{ this.conexion.close(); }    
    }

    @Override
    public List<Tripulacion> listarT(String name) throws Exception {
        List<Tripulacion> tripulaciones = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            this.getConnetion();

            // Consultar las tripulaciones junto con los pilotos y azafatas
            String sql = "SELECT t.Id_Tripulacion, p.Id_Piloto, a.Id_Azafata FROM Tripulacion t LEFT JOIN Piloto_Tripulacion pt ON t.Id_Tripulacion = pt.Id_Tripulacion LEFT JOIN Piloto p ON pt.Id_Piloto = p.Id_Piloto LEFT JOIN Azafata_Tripulacion at ON t.Id_Tripulacion = at.Id_Tripulacion LEFT JOIN Azafata a ON at.Id_Azafata = a.Id_Azafata";

            ps = this.conexion.prepareStatement(sql);
            rs = ps.executeQuery();

            // Crear un mapa para agrupar pilotos y azafatas por tripulación
            Map<Integer, Tripulacion> tripulacionMap = new HashMap<>();

            while (rs.next()) {
                int idTripulacion = rs.getInt("Id_Tripulacion");
                int idPiloto = rs.getInt("Id_Piloto");
                int idAzafata = rs.getInt("Id_Azafata");

                Tripulacion tripulacion = tripulacionMap.get(idTripulacion);
                if (tripulacion == null) {
                    tripulacion = new Tripulacion(idTripulacion);

                    tripulacionMap.put(idTripulacion, tripulacion);
                }

                if (idPiloto != 0) {
                    DAOPilotos daop = new DAOPilotosIMPL();
                    Piloto pi = daop.getPilotobyId(idPiloto);
                    tripulacion.agregarPiloto(pi);
                }

                if (idAzafata != 0) {
                    DAOAzafata daoaz = new DAOAzafataIMPL();
                    Azafata az = daoaz.getAzafatabyId(idAzafata);
                    tripulacion.agregarAzafata(az);
                }
            }

            // Convertir el mapa a una lista
            tripulaciones.addAll(tripulacionMap.values());

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            rs.close();
            ps.close();
            this.closeConnection();
        }

        return tripulaciones;
    }
    
    @Override
    public Tripulacion getTripulacionById(int idT) throws Exception {
        Tripulacion tripulacion = new Tripulacion(idT);
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            this.getConnetion();

            // Consultar las tripulaciones junto con los pilotos y azafatas
            String sqlPI = "select * from Piloto_Tripulacion where Id_Tripulacion = ?";
            ps = this.conexion.prepareStatement(sqlPI);
            ps.setInt(1, idT);

            rs = ps.executeQuery();

            while (rs.next()) {
                int idTripulacion = rs.getInt("Id_Tripulacion");
                int idPiloto = rs.getInt("Id_Piloto");
                
                if(idTripulacion != 0){
                    tripulacion.setIdtripulacion(idTripulacion);
                }else{
                    System.err.println("Ocurrio un error en la BD || AUTO_INCREMENT = 0 || Tripulación encontrada en la bd");
                }

                if (idPiloto != 0) {
                    DAOPilotos daop = new DAOPilotosIMPL();
                    Piloto pi = daop.getPilotobyId(idPiloto);
                    tripulacion.agregarPiloto(pi);
                }
            }
            
            String sqlAZ = "select * from Azafata_Tripulacion where Id_Tripulacion = ?";
            ps = this.conexion.prepareStatement(sqlAZ);
            ps.setInt(1, idT);

            rs = ps.executeQuery();

            while (rs.next()) {
                int idTripulacion = rs.getInt("Id_Tripulacion");
                int idAzafata = rs.getInt("Id_Azafata");
                
                if(idTripulacion != 0){
                    tripulacion.setIdtripulacion(idTripulacion);
                }else{
                    System.err.println("Ocurrio un error en la BD || AUTO_INCREMENT = 0 || Tripulación encontrada en la bd"); 
                }

                if (idAzafata != 0) {
                    DAOAzafata daop = new DAOAzafataIMPL();
                    Azafata az = daop.getAzafatabyId(idAzafata);
                    tripulacion.agregarAzafata(az);
                }

            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (this.conexion != null) this.conexion.close();
        }

        return tripulacion;
    }
}
