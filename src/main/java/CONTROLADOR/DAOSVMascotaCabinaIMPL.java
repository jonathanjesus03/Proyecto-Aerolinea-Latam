/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import MODELS.ServiciosEspeciales;
import java.sql.PreparedStatement;
import Connectionbd.Connectiondb;
import Interfaces.DAOSVMascotaCabina;
import MODELS.ServicioMascotaCabina;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Samsung
 */
public class DAOSVMascotaCabinaIMPL extends Connectiondb implements DAOSVMascotaCabina{
      @Override
    public void registrarSV(ServiciosEspeciales sv, int idP) throws Exception {
        try {
            this.getConnetion();
            PreparedStatement ps = this.getConnetion().prepareStatement("INSERT INTO ServicioMascotaCabina(Id_Pasajero, Descripcion) VALUES(?,?)");
            ps.setInt(1, idP);
            ps.setString(2, sv.getDescripcion());
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
            PreparedStatement ps = this.getConnetion().prepareStatement("DELETE FROM ServicioMascotaCabina WHERE Id_Pasajero = ?");
            ps.setInt(1, idP);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
        System.err.print(e);
        } finally{ this.conexion.close(); }    }

    @Override
    public ServicioMascotaCabina getSVbyID(int idP) throws Exception {
        ServicioMascotaCabina SV = new ServicioMascotaCabina();
        try {
            this.getConnetion();
            PreparedStatement ps = this.conexion.prepareStatement("SELECT * FROM ServicioMascotaCabina WHERE Id_Pasajero = ?");
            ps.setInt(1, idP);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                SV.setId(rs.getInt("Id_ServicioMascotaCabina"));
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
    public List<ServicioMascotaCabina> listarForVU(int idVU) throws Exception {
        List<ServicioMascotaCabina> listSVmc = new ArrayList<>();
        try {
            this.getConnetion();
            String query = """
                           SELECT 
                               	smc.Id_ServicioMascotaCabina,
                                   'Servicio Mascota Cabina' AS TipoServicio,
                                   smc.Descripcion,
                                   p.Id_Cliente,
                                   p.Nombre AS NombrePasajero,
                                   p.Apellido AS ApellidoPasajero,
                                   v.Id_Vuelo,
                                   v.Codigo AS CodigoVuelo
                               FROM 
                                   ServicioMascotaCabina smc
                               JOIN 
                                   Pasajero p ON smc.Id_Pasajero = p.Id_Cliente
                               JOIN 
                                   Vuelos v ON p.Id_Vuelo = v.Id_Vuelo
                               WHERE 
                                   v.Id_Vuelo = ?""";
            PreparedStatement ps = this.conexion.prepareStatement(query);
            ps.setInt(1, idVU);

            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                ServicioMascotaCabina svmc = new ServicioMascotaCabina();
                svmc.setId(rs.getInt("Id_ServicioMascotaCabina"));
                svmc.setDescripcion(rs.getString("Descripcion"));
                svmc.setTipo(rs.getString("TipoServicio"));
                svmc.setIdPasajero(rs.getInt("Id_Cliente"));
                listSVmc.add(svmc);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            this.closeConnection();
        }
        return listSVmc;
    }
}