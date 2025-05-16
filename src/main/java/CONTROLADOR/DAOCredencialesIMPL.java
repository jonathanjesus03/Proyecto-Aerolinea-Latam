/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import Connectionbd.Connectiondb;
import Interfaces.DAOCredenciales;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Samsung
 */
public class DAOCredencialesIMPL implements DAOCredenciales {
    private final String url = "jdbc:sqlserver://localhost:1433;databaseName=PooCredenciales;encrypt=true;trustServerCertificate=true";
    private final String users = "JonaPoo";
    private final String passwords = "3101";
    private final String ClassJDBC = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    @Override
    public List<Map<String, String>> obtenerCredenciales() {
        Connection NewConexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<Map<String, String>> ListCredenciales = new ArrayList<>();
        try {
            Class.forName(ClassJDBC);
            NewConexion = DriverManager.getConnection(url, users, passwords);
            ps = NewConexion.prepareStatement("Select * from Credenciales");
            rs = ps.executeQuery();
            while(rs.next()){
                Map<String, String> Credenciales = new HashMap<>();
                Credenciales.put("User", rs.getString("Users"));
                Credenciales.put("Password", rs.getString("Passwords"));
                ListCredenciales.add(Credenciales);

            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }finally {
            // Cierre de ResultSet
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // Cierre de PreparedStatement
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // Cierre de Connection
            if (NewConexion != null) {
                try {
                    NewConexion.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return ListCredenciales;
    }
}
