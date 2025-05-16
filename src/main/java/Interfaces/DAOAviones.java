/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import MODELS.Avion;
import MODELS.Pasajeros;
import java.util.List;

/**
 *
 * @author Samsung
 */
public interface DAOAviones {
    public void registrarAV(Avion avion)throws Exception;
    public void modificarAV(Avion avion)throws Exception;
    public void elminarAV(int avid)throws Exception;
    public List<Avion> listarAV(String name)throws Exception;
    public Avion getAvionbyId(int avid)throws Exception;

}
