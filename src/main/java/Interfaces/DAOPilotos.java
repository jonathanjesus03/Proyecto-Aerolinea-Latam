/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import MODELS.Piloto;
import java.util.List;

/**
 *
 * @author Samsung
 */
public interface DAOPilotos {
    public void registrarPaT(int idP, int idT)throws Exception;
    public void registrarPI(Piloto piloto)throws Exception;
    public void modificarPI(Piloto piloto)throws Exception;
    public void elminarPI(String codePI)throws Exception;
    public List<Piloto> listarPI(String name)throws Exception;
    public Piloto getPilotobyId(int idP)throws Exception;
    public Piloto getPilotobyCode(String codigo)throws Exception;

}
