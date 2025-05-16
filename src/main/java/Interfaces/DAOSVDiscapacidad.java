/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import MODELS.ServiciosEspeciales;
import java.util.List;

/**
 *
 * @author Samsung
 */
public interface DAOSVDiscapacidad {
    public void registrarSV(ServiciosEspeciales sv, int idp) throws Exception;
    public void EliminarSV(int idP) throws Exception;
    public ServiciosEspeciales getSVbyID (int idP) throws Exception;
    public List<ServiciosEspeciales> listarForVU(int idVU) throws Exception;

}
