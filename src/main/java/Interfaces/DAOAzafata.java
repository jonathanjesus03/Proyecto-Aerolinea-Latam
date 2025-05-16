/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import MODELS.Azafata;
import java.util.List;

/**
 *
 * @author Samsung
 */
public interface DAOAzafata {
    public void registrarAZaT(int idAZ, int idT)throws Exception;
    public void registrarAZ(Azafata azafata)throws Exception;
    public void modificarAZ(Azafata azafata)throws Exception;
    public void elminarAZ(String azID)throws Exception;
    public List<Azafata> listarAZ(String name)throws Exception;
    public Azafata getAzafatabyId(int userid)throws Exception;
    public Azafata getAzafatabyCode(String codigo)throws Exception;

}
