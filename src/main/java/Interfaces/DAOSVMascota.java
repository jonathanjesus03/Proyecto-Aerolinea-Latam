/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import MODELS.ServicioMascota;
import MODELS.ServiciosEspeciales;
import java.util.List;

/**
 *
 * @author Samsung
 */
public interface DAOSVMascota {
    public void registrarSV(ServiciosEspeciales sv, int idp) throws Exception;
    public void EliminarSV(int idP) throws Exception;
    public ServicioMascota getSVbyID(int idp) throws Exception;
    public List<ServicioMascota> listarForVU(int idVU) throws Exception;


}
