/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import Connectionbd.Connectiondb;
import Interfaces.DAOSVDiscapacidad;
import MODELS.ServiciosEspeciales;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Samsung
 */
public class DAOSVDiscapacidadIMPL extends Connectiondb implements DAOSVDiscapacidad{

    @Override
    public void registrarSV(ServiciosEspeciales sv,int idP) throws Exception {
        try {
            this.getConnetion();
            PreparedStatement ps = this.getConnetion().prepareStatement("INSERT INTO ServicioDiscapacidad(Id_Pasajero, Tipo, Descripcion) VALUES(?,?,?)");
            ps.setInt(1, idP);
            ps.setString(2, sv.getTipo());
            ps.setString(3, sv.getDescripcion());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.err.print(e);
        } finally{ this.conexion.close(); }
    }

    @Override
    public void EliminarSV(int idP) throws Exception {
        try {
            this.getConnetion();
            PreparedStatement ps = this.getConnetion().prepareStatement("DELETE FROM ServicioDiscapacidad WHERE Id_Pasajero = ?");
            ps.setInt(1, idP);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
        System.err.print(e);
        } finally{ this.conexion.close(); }
    }

    @Override
    public ServiciosEspeciales getSVbyID(int idP) throws Exception {
        ServiciosEspeciales SV = new ServiciosEspeciales();
        try {
            this.getConnetion();
            PreparedStatement ps = this.conexion.prepareStatement("SELECT * FROM ServicioDiscapacidad WHERE Id_Pasajero = ?");
            ps.setInt(1, idP);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                SV.setId(rs.getInt("Id_ServicioDiscapacidad"));
                SV.setTipo(rs.getString("Tipo"));
                SV.setDescripcion(rs.getString("Descripcion"));
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.print(e);
        } finally { this.closeConnection(); }
        return SV;
    }

    @Override
    public List<ServiciosEspeciales> listarForVU(int idVU) throws Exception {
        List<ServiciosEspeciales> listSVesp = new ArrayList<>();
        try {
            this.getConnetion();
            String query = """
                           SELECT 
                                   	sd.Id_ServicioDiscapacidad,
                                       'Servicio Discapacidad' AS TipoServicio,
                                       sd.Tipo,
                                       sd.Descripcion,
                                   	p.Id_Cliente,
                                       p.Nombre AS NombrePasajero,
                                       p.Apellido AS ApellidoPasajero,
                                       v.Id_Vuelo,
                                       v.Codigo AS CodigoVuelo
                                   FROM 
                                       ServicioDiscapacidad sd
                                   JOIN 
                                       Pasajero p ON sd.Id_Pasajero = p.Id_Cliente
                                   JOIN 
                                       Vuelos v ON p.Id_Vuelo = v.Id_Vuelo
                                   WHERE 
                                       v.Id_Vuelo = ?""";
            PreparedStatement ps = this.conexion.prepareStatement(query);
            ps.setInt(1, idVU);

            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                ServiciosEspeciales svesp = new ServiciosEspeciales();
                svesp.setId(rs.getInt("Id_ServicioDiscapacidad"));
                svesp.setDescripcion(rs.getString("Tipo")+" - Requerimientos: "+rs.getString("Descripcion"));
                svesp.setTipo(rs.getString("TipoServicio"));
                svesp.setIdPasajero(rs.getInt("Id_Cliente"));
                listSVesp.add(svesp);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            this.closeConnection();
        }
        return listSVesp;
    }
}
