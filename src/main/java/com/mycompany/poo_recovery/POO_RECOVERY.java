/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.poo_recovery;

import CONTROLADOR.Controlador;
import Login.login;
import VIEW1.Dashboard;
import VIEW1.VIEW2.*;
import VIEW1.VIEW2.Pax_ctrl.*;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Samsung
 */
public class POO_RECOVERY {

    public static void main(String[] args) {
        FlatMaterialLighterIJTheme.setup();
        //Login
        login log = new login();

        //Creando los obejtos de cada interfaz Grafica Inicial
        Dashboard dash = new Dashboard();
        Eleccion_vuelo EV = new Eleccion_vuelo();
        Eleccion_pasajero EP = new Eleccion_pasajero();
        Eleccion_reporte ER = new Eleccion_reporte();

        //Creando las ventanas funcionales 
        Pax_control Pax = new Pax_control();
        Administracion_pasajero AdminP = new Administracion_pasajero();
        fondSV fondSV = new fondSV();
        Gestion_vuelo GestionV = new Gestion_vuelo();

        //Ventanas para Gestion de Vuelos
        VerSVEspeciales verSV = new VerSVEspeciales();

        //Creando las ventanas de Reporte
        Reportes_aviones RA = new Reportes_aviones();
        Reportes_pasajeros RP = new Reportes_pasajeros();
        Reportes_vuelos RV = new Reportes_vuelos();

        //Ventanas Funcionales del Pax Control
        Asignar_alimentos Asignar_a = new Asignar_alimentos();
        Asignar_avion Asignar_av = new Asignar_avion();
        Asignar_pasajero Asignar_p = new Asignar_pasajero();
        Asignar_piloto Asignar_pi = new Asignar_piloto();
        Ver_Tripulacion Hora_a = new Ver_Tripulacion();
        Asignar_azafata Asignar_az = new Asignar_azafata();
        Asignar_Tripulacion asignar_T = new Asignar_Tripulacion();
        PrincipalPax principalPax = new PrincipalPax();

        //Ventanas de Registro
        nuevo_avion nuevo_a = new nuevo_avion();
        nuevo_vuelo nuevo_v = new nuevo_vuelo();
        nuevo_pasajero nuevo_p = new nuevo_pasajero();
        editar_pasajero editar_p = new editar_pasajero();

        AsignarPasaje asignarPasaje = new AsignarPasaje();

        log.setVisible(true);

        Controlador ctrl = new Controlador(log, dash, EV, EP, ER, Pax, AdminP, GestionV, RA, RP, RV, Asignar_a, Asignar_av,
                Asignar_p, Asignar_pi, Hora_a, Asignar_az, nuevo_a, nuevo_v, nuevo_p,
                editar_p, asignarPasaje, asignar_T, verSV, principalPax);
        ctrl.iniciar();
    }
}
