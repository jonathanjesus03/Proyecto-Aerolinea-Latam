/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import Connectionbd.Connectiondb;
import Interfaces.DAOPasaje;
import MODELS.Maleta;
import MODELS.Pasaje;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Samsung
 */
public class DAOPasajeIMPL extends Connectiondb implements DAOPasaje{
    
    @Override
    public void registrarPasaje(Pasaje pasaje) throws Exception {
        try {
            this.getConnetion();
            PreparedStatement ps = this.conexion.prepareStatement("INSERT INTO Pasaje(Id_Pasajero, Codigo, CodVuelo, CodigoAsiento) VALUES(?,?,?,?)");
            ps.setInt(1, pasaje.getIdPasajero());
            ps.setString(2, pasaje.getCodigoPS());
            ps.setString(3, pasaje.getCodVuelo());
            ps.setString(4, pasaje.getCodAsiento());
            ps.executeUpdate();
            ps.close();
            } catch (SQLServerException e) {
            if (e.getMessage().contains("Violation of UNIQUE KEY constraint")) {
                throw new Exception("El pasaje ya existe en la base de datos");
            } else {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close your connection and other resources
            if (this.conexion != null) {
                try {
                    this.conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Override
    public void eliminarPasaje(int idPasaje) throws Exception {
        try {
            this.getConnetion();
            PreparedStatement ps = this.getConnetion().prepareStatement("DELETE FROM Pasaje WHERE Id_Pasaje = ?");
            ps.setInt(1, idPasaje);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.err.print(e);
        } finally{ this.conexion.close(); } 
    }

    
    @Override
    public List<Pasaje> listarPasaje(String CodigoVU) throws Exception {
        List<Pasaje> lista = null;
        try {
            this.getConnetion();
            String query = CodigoVU.isEmpty() ? "SELECT * FROM Pasaje" : "SELECT * FROM Pasaje WHERE CodVuelo like '"+CodigoVU+"'";
            PreparedStatement ps = this.conexion.prepareStatement(query);
            
            lista = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Pasaje p = new Pasaje();
                p.setCodAsiento(rs.getString("CodigoAsiento"));
                p.setCodVuelo(rs.getString("CodVuelo"));
                p.setCodigoPS(rs.getString("Codigo"));
                p.setIdPasaje(rs.getInt("Id_Pasaje"));
                p.setIdPasajero(rs.getInt("Id_Pasajero"));

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
    public Pasaje getPasajebyCode(String CodigoP) throws Exception {
        Pasaje pasaje = new Pasaje();
        try {
            this.getConnetion();
            PreparedStatement ps = this.conexion.prepareStatement("SELECT * FROM Pasaje WHERE Codigo = ?");
            ps.setString(1, CodigoP);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                pasaje.setIdPasaje(rs.getInt("Id_Pasaje"));
                pasaje.setIdPasajero(rs.getInt("Id_Pasajero"));
                pasaje.setCodVuelo(rs.getString("CodVuelo"));
                pasaje.setCodAsiento(rs.getString("CodigoAsiento"));
                pasaje.setCodigoPS(rs.getString("Codigo"));
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.print(e);
        } finally { this.closeConnection(); }
            return pasaje;
        }
    
}
