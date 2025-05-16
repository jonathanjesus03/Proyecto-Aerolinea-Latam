/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import Connectionbd.Connectiondb;
import Interfaces.DAOAlimentos;
import MODELS.Alimentos;
import java.sql.PreparedStatement;

/**
 *
 * @author Samsung
 */
public class DAOAlimentosIMPL extends Connectiondb implements DAOAlimentos{

    @Override
    public void registrarAlimento(Alimentos alimento) throws Exception {
        try {
            this.getConnetion();
            PreparedStatement ps = this.conexion.prepareStatement("INSERT INTO Alimentos(Cod_Vuelo, Nombre, Tipo) VALUES(?,?,?)");
            ps.setString(1, alimento.getRefvuelo());
            ps.setString(2, alimento.getNombre());
            ps.setString(3, alimento.getTipo());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.err.println(e);
        }finally{
            this.closeConnection();
            }
    }

    @Override
    public void eliminarAlimento(int idAlimento) throws Exception {
        try {
            this.getConnetion();
            PreparedStatement ps = this.getConnetion().prepareStatement("DELETE FROM Alimentos WHERE Id_Alimentos = ?");
            ps.setInt(1, idAlimento);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.err.print(e);
        } finally{ this.conexion.close(); }
    }
    
}
