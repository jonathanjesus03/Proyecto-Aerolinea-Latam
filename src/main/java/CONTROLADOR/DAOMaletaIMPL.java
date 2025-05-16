/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import Connectionbd.Connectiondb;
import Interfaces.DAOMaleta;
import MODELS.Maleta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Samsung
 */
public class DAOMaletaIMPL extends Connectiondb implements DAOMaleta{

    @Override
    public void registrarMaleta(Maleta maleta) throws Exception {
        try {
            this.getConnetion();
            PreparedStatement ps = this.conexion.prepareStatement("INSERT INTO Maleta(Alto, Ancho, Base, Peso, Id_Pasajero) VALUES(?,?,?,?,?)");
            ps.setInt(1, maleta.getDimension()[2]);
            ps.setInt(2, maleta.getDimension()[1]);
            ps.setInt(3, maleta.getDimension()[0]);
            ps.setFloat(4, maleta.getPeso());
            ps.setInt(5, maleta.getIdPasajero());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.err.println(e);
        }finally{
            this.closeConnection();
            }
    }

    @Override
    public void eliminarMaleta(int idMaleta) throws Exception {
        try {
            this.getConnetion();
            PreparedStatement ps = this.getConnetion().prepareStatement("DELETE FROM Maleta WHERE Id_Maleta = ?");
            ps.setInt(1, idMaleta);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
        System.err.print(e);
        } finally{ this.conexion.close(); }    }

    @Override
    public Maleta getMaletabyId(int idP) throws Exception {
        Maleta maleta = new Maleta();
        try {
            this.getConnetion();
            PreparedStatement ps = this.conexion.prepareStatement("SELECT * FROM Maleta WHERE Id_Pasajero = ?");
            ps.setInt(1, idP);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                maleta.setId(rs.getInt("Id_Maleta"));
                maleta.setPeso(rs.getFloat("Peso"));
                int dimentions[] = {rs.getInt("Base"), rs.getInt("Ancho"),rs.getInt("Alto")};
                maleta.setDimension(dimentions);
                maleta.setIdPasajero(rs.getInt("Id_Pasajero"));
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.print(e);
        } finally { this.closeConnection(); }
        return maleta;
    }   
}
