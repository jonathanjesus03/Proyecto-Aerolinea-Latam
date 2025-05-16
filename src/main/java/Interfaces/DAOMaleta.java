/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import MODELS.Maleta;

/**
 *
 * @author Samsung
 */
public interface DAOMaleta {
    public void registrarMaleta(Maleta maleta) throws Exception;
    public void eliminarMaleta(int idMaleta) throws Exception;
    public Maleta getMaletabyId(int idP) throws Exception;
}
