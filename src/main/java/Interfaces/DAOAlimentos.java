/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import MODELS.Alimentos;

/**
 *
 * @author Samsung
 */
public interface DAOAlimentos {
    public void registrarAlimento(Alimentos alimento) throws Exception;
    public void eliminarAlimento(int idAlimento) throws Exception;
}
