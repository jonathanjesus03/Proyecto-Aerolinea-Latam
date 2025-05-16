/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import MODELS.Pasajeros;
import java.util.List;

/**
 *
 * @author Samsung
 */
public interface DAOPasajero {
    public void registrarPA(Pasajeros pasajero)throws Exception;
    public void modificarPA(Pasajeros pasajero)throws Exception;
    public void elminarPA(int userid)throws Exception;
    public List<Pasajeros> listarPA(String name)throws Exception;
    public List<Pasajeros> listarPAforVU(int idV)throws Exception;
    public Pasajeros getPasajerobyId(int userid)throws Exception;
    public Pasajeros getPasajeroForVU(String nombre, String apellido, String cod_Pasaje,String documento)throws Exception;
}
