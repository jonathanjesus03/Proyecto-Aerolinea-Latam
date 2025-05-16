/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connectionbd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Samsung
 */
public class Connectiondb {
    protected Connection conexion;
    private final String bd_url = "jdbc:sqlserver://localhost:1433;databaseName=ProyectoPooAeropuerto;encrypt=true;trustServerCertificate=true";
    private final String user = "JonaPoo";
    private final String password = "3101";
    private final String JDBC = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
    public Connection getConnetion() throws ClassNotFoundException{
        try {
        conexion = DriverManager.getConnection(this.bd_url,this.user, this.password);
        Class.forName(this.JDBC);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return conexion;
    }
    
    public void closeConnection() throws SQLException{
        if(conexion!=null){
            if(!conexion.isClosed()){
                conexion.close();
            }   
        }
    }
            
}
