/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import MODELS.Vuelos;
import java.util.List;

/**
 *
 * @author Samsung
 */
public interface DAOVuelos {
    public void registrarVU(Vuelos vuelo)throws Exception;
    public void modificarVU(Vuelos vuelo)throws Exception;
    public void elminarVU(int vueloid)throws Exception;
    public List<Vuelos> listarVU(String name)throws Exception;
    public Vuelos getVuelobyId(int vueloid)throws Exception;
 
}
