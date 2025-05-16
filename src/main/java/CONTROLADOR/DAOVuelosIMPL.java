/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import Connectionbd.Connectiondb;
import Interfaces.DAOAviones;
import Interfaces.DAOPasajero;
import Interfaces.DAOTripulacion;
import Interfaces.DAOVuelos;
import MODELS.Avion;
import MODELS.Pasajeros;
import MODELS.Tripulacion;
import MODELS.Vuelos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Samsung
 */
public class DAOVuelosIMPL extends Connectiondb implements DAOVuelos{

    @Override
    public void registrarVU(Vuelos vuelo) throws Exception {
        java.sql.Date fechaSql = null;                    
        try {
            this.getConnetion();
            PreparedStatement ps = this.conexion.prepareStatement("	INSERT INTO Vuelos( Codigo, Destino, Origen, Estado, Fecha, Hora_Llegada, Hora_Salida) VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, vuelo.getCodigo());
            ps.setString(2, vuelo.getDestino());
            ps.setString(3, vuelo.getOrigen());
            ps.setString(4, vuelo.getEstado());
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date date = sdf.parse(vuelo.getFecha());
            fechaSql = new java.sql.Date(date.getTime());
            
            ps.setDate(5,fechaSql);
            ps.setString(6, vuelo.getHorallegada());
            ps.setString(7, vuelo.getHorasalida());

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.err.println(e);
        }finally{
            this.closeConnection();
        }
    }

    @Override
    public void modificarVU(Vuelos vuelo) throws Exception {
         try {
            this.getConnetion();
            PreparedStatement ps = this.conexion.prepareStatement("UPDATE Vuelos SET Codigo = ?, Destino = ? , Origen = ?, Estado = ?, Fecha = ?, Hora_Llegada = ?, Hora_Salida = ?, Id_Avion = ?, Cantidad_Pasajeros = ? WHERE Id_Vuelo = ?");
            ps.setString(1, vuelo.getCodigo());
            ps.setString(2, vuelo.getDestino());
            ps.setString(3, vuelo.getOrigen());
            ps.setString(4, vuelo.getEstado());
            ps.setString(5, vuelo.getFecha());
            ps.setString(6, vuelo.getHorallegada());
            ps.setString(7, vuelo.getHorasalida());
            ps.setObject(8, vuelo.getAvion() != null ? vuelo.getAvion().getIdavion() : null);
            ps.setObject(9, vuelo.getListaPasajeros() != null ? vuelo.getCantidadpasajeros() : null);
            ps.setInt( 10, vuelo.getIdvuelo());

            
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.err.println(e);
        }finally{
            this.closeConnection();
            }
    }

    @Override
    public void elminarVU(int vueloid) throws Exception {
        try {
            this.getConnetion();
            PreparedStatement ps = this.conexion.prepareStatement("DELETE FROM Vuelos WHERE Id_Vuelo= ?");
            ps.setInt(1, vueloid);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.closeConnection();
        }
    }

    @Override
    public List<Vuelos> listarVU(String codi) throws Exception {
        List<Vuelos> lista = null;
        try {
            this.getConnetion();
            String query = codi.isEmpty() ? "SELECT * FROM Vuelos" : "SELECT * FROM Vuelos WHERE Codigo like '%"+codi+"%'";
            PreparedStatement ps = this.conexion.prepareStatement(query);
            
            lista = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Vuelos v = new Vuelos();
                ArrayList<Pasajeros> listap = new ArrayList<>();
                v.setIdvuelo(rs.getInt("Id_Vuelo"));
                v.setCodigo(rs.getString("Codigo"));
                v.setEstado(rs.getString("Estado"));
                v.setDestino(rs.getString("Destino"));
                v.setOrigen(rs.getString("Origen"));
                v.setHorallegada(rs.getString("Hora_Llegada"));
                v.setHorasalida(rs.getString("Hora_Salida"));
                v.setFecha(rs.getString("Fecha"));
                v.setCantidadpasajeros(rs.getInt("Cantidad_Pasajeros"));
                v.setListaPasajeros(listap);
                if(rs.getInt("Id_Tripulacion") != 0){
                    DAOTripulacion daot = new DAOTripulacionIMPL();
                    Tripulacion tripu = daot.getTripulacionById(rs.getInt("Id_Tripulacion"));
                    v.setTripulacion(tripu);
                }
                if(rs.getInt("Id_Avion") != 0){
                    DAOAviones daov = new DAOAvionesIMPL();
                    Avion av = daov.getAvionbyId(rs.getInt("Id_Avion"));
                    v.setAvion(av);
                }
                lista.add(v);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.closeConnection();
        }
        return lista; }

    @Override
    public Vuelos getVuelobyId(int vueloid) throws Exception {
        Vuelos v = new Vuelos();
        try {
            this.getConnetion();
            PreparedStatement ps = this.conexion.prepareStatement("SELECT * FROM Vuelos WHERE Id_Vuelo = ?");
            ps.setInt(1, vueloid);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                v.setIdvuelo(rs.getInt("Id_Vuelo"));
                v.setCodigo(rs.getString("Codigo"));
                v.setEstado(rs.getString("Estado"));
                v.setDestino(rs.getString("Destino"));
                v.setOrigen(rs.getString("Origen"));
                v.setHorallegada(rs.getString("Hora_Llegada"));
                v.setHorasalida(rs.getString("Hora_Salida"));
                v.setFecha(rs.getString("Fecha"));
                v.setCantidadpasajeros(rs.getInt("Cantidad_Pasajeros"));
                if(rs.getInt("Id_Tripulacion") != 0){
                    DAOTripulacion daot = new DAOTripulacionIMPL();
                    Tripulacion tripu = daot.getTripulacionById(rs.getInt("Id_Tripulacion"));
                    v.setTripulacion(tripu);
                }
                if(rs.getInt("Id_Avion") != 0){
                    DAOAviones daov = new DAOAvionesIMPL();
                    Avion av = daov.getAvionbyId(rs.getInt("Id_Avion"));
                    v.setAvion(av);
                }
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }finally{
            this.closeConnection();
        }
        return v;    
    }
}
