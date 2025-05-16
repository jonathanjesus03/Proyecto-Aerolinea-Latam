/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import Connectionbd.Connectiondb;
import Interfaces.DAOSVMascota;
import MODELS.ServicioMascota;
import MODELS.ServicioMascotaCabina;
import MODELS.ServiciosEspeciales;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Samsung
 */
public class DAOSVMascotaIMPL extends Connectiondb implements DAOSVMascota{

    @Override
    public void registrarSV(ServiciosEspeciales sv, int idP) throws Exception {
        try {
            this.getConnetion();
            PreparedStatement ps = this.getConnetion().prepareStatement("INSERT INTO ServicioMascota(Id_Pasajero, Descripcion) VALUES(?,?)");
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
            PreparedStatement ps = this.getConnetion().prepareStatement("DELETE FROM ServicioMascota WHERE Id_Pasajero = ?");
            ps.setInt(1, idP);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
        System.err.print(e);
        } finally{ this.conexion.close(); }    }
    
    @Override
    public ServicioMascota getSVbyID(int idP) throws Exception {
        ServicioMascota SV = new ServicioMascota();
        try {
            this.getConnetion();
            PreparedStatement ps = this.conexion.prepareStatement("SELECT * FROM ServicioMascota WHERE Id_Pasajero = ?");
            ps.setInt(1, idP);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                SV.setId(rs.getInt("Id_ServicioMascota"));
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
    public List<ServicioMascota> listarForVU(int idVU) throws Exception {
        List<ServicioMascota> listSVm = new ArrayList<>();
        try {
            this.getConnetion();
            String query = """
                           SELECT 
                               sm.Id_ServicioMascota,
                               'Servicio Mascota' AS TipoServicio,
                               sm.Descripcion,
                               p.Id_Cliente,
                               p.Nombre AS NombrePasajero,
                               p.Apellido AS ApellidoPasajero,
                               v.Id_Vuelo,
                               v.Codigo AS CodigoVuelo
                           FROM 
                               ServicioMascota sm
                           JOIN 
                               Pasajero p ON sm.Id_Pasajero = p.Id_Cliente
                           JOIN 
                               Vuelos v ON p.Id_Vuelo = v.Id_Vuelo
                           WHERE 
                               v.Id_Vuelo = ?""";
            PreparedStatement ps = this.conexion.prepareStatement(query);
            ps.setInt(1, idVU);

            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                ServicioMascota svm = new ServicioMascota();
                svm.setId(rs.getInt("Id_ServicioMascota"));
                svm.setDescripcion(rs.getString("Descripcion"));
                svm.setTipo(rs.getString("TipoServicio"));
                svm.setIdPasajero(rs.getInt("Id_Cliente"));
                listSVm.add(svm);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            this.closeConnection();
        }
        return listSVm;
    }
    
}
