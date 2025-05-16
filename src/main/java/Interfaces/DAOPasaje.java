/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import MODELS.Pasaje;
import java.util.List;

/**
 *
 * @author Samsung
 */
public interface DAOPasaje {
    public void registrarPasaje(Pasaje pasaje) throws Exception;
    public void eliminarPasaje(int idPasaje) throws Exception;
    public Pasaje getPasajebyCode(String CodigoP) throws Exception;
    public List<Pasaje> listarPasaje(String CodigoVU) throws Exception;
}
