/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import MODELS.Tripulacion;
import java.util.List;

/**
 *
 * @author Samsung
 */
public interface DAOTripulacion {
        public void registrarT(Tripulacion t, int idv) throws Exception;
        public void registrarTaV(int idv) throws Exception;
        public void elminarT(int Tid)throws Exception;
        public List<Tripulacion> listarT(String name)throws Exception;
        public Tripulacion getTripulacionById(int Tid) throws Exception;

}
