/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import Interfaces.DAOAlimentos;
import Interfaces.DAOAviones;
import Interfaces.DAOAzafata;
import Interfaces.DAOCredenciales;
import Interfaces.DAOMaleta;
import Interfaces.DAOPasaje;
import Interfaces.DAOPasajero;
import Interfaces.DAOPilotos;
import Interfaces.DAOSVDiscapacidad;
import Interfaces.DAOSVMascota;
import Interfaces.DAOSVMascotaCabina;
import Interfaces.DAOTripulacion;
import Interfaces.DAOVuelos;
import VIEW1.Dashboard;
import VIEW1.VIEW2.*;
import VIEW1.VIEW2.Pax_ctrl.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Login.login;
import MODELS.Alimentos;
import MODELS.Avion;
import MODELS.Azafata;
import MODELS.Maleta;
import MODELS.Pasaje;
import MODELS.Pasajeros;
import MODELS.Piloto;
import MODELS.ServicioMascota;
import MODELS.ServicioMascotaCabina;
import MODELS.ServiciosEspeciales;
import MODELS.Tripulacion;
import MODELS.Vuelos;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.ErrorManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.management.Query.value;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener {
    private login log;
    private Dashboard dash;

    private Principal Inicio;
    private Eleccion_vuelo EV;
    private Eleccion_pasajero EP;
    private Eleccion_reporte ER;

    private Pax_control Pax;
    private Administracion_pasajero Adminp;
    private Gestion_vuelo GestionV;

    private VerSVEspeciales verSVs;
    
    private Reportes_aviones RA;
    private Reportes_pasajeros RP;
    private Reportes_vuelos RV;

    private Asignar_alimentos Asignar_a;
    private Asignar_avion Asignar_av;
    private Asignar_pasajero Asignar_p;
    private Asignar_piloto Asignar_pi;
    private Ver_Tripulacion Ver_trupulacion;
    private Asignar_azafata Asignar_az;
    private Asignar_Tripulacion Asignar_T;
    private PrincipalPax principalPax;
    
    private AsignarPasaje AsignarPasaje;
    
    private nuevo_avion nuevo_a;
    private nuevo_pasajero nuevo_p;
    private nuevo_vuelo nuevo_v;
    private editar_pasajero editar_p;
    
    private Map<Object, Runnable[]> actionMap;

    public Controlador(login log, Dashboard dash, Eleccion_vuelo EV, Eleccion_pasajero EP, Eleccion_reporte ER, 
                        Pax_control Pax, Administracion_pasajero AdminP, Gestion_vuelo GestionV, Reportes_aviones RA, 
                        Reportes_pasajeros RP, Reportes_vuelos RV, Asignar_alimentos Asignar_a, Asignar_avion Asignar_av, 
                        Asignar_pasajero Asignar_p, Asignar_piloto Asignar_pi, Ver_Tripulacion Ver_tripulacion, 
                        Asignar_azafata Asignar_az, nuevo_avion nuevo_a, nuevo_vuelo nuevo_v, 
                        nuevo_pasajero nuevo_p, editar_pasajero editar_p, AsignarPasaje asignarPasaje, Asignar_Tripulacion Asignar_T,
                        VerSVEspeciales verSVs, PrincipalPax principalPax) {
        this.log = log;
        this.dash = dash;
        this.EV = EV;
        this.EP = EP;
        this.ER = ER;
        this.Pax = Pax;
        this.Adminp = AdminP;
        this.GestionV = GestionV;
        this.RA = RA;
        this.RP = RP;
        this.RV = RV;
        this.Asignar_a = Asignar_a;
        this.Asignar_av = Asignar_av;
        this.Asignar_p = Asignar_p;
        this.Asignar_pi = Asignar_pi;
        this.Ver_trupulacion = Ver_tripulacion;
        this.Asignar_az = Asignar_az;
        this.nuevo_a = nuevo_a;
        this.nuevo_v = nuevo_v;
        this.nuevo_p = nuevo_p;
        this.editar_p = editar_p;
        this.AsignarPasaje = asignarPasaje;
        this.Asignar_T = Asignar_T;
        this.verSVs = verSVs;
        this.principalPax = principalPax;
        initializeActionMap();
        addListeners();
        addMouseListeners();
    }

    private void initializeActionMap() {
    actionMap = new HashMap<>();

        // Login Button
    actionMap.put(log.bt_login, new Runnable[]{this::handleLogin, null});

    // Dashboard Buttons
    actionMap.put(dash.bt_pax_control, new Runnable[]{this::handlepax, null});
    actionMap.put(dash.bt_administracion_pasajeros, new Runnable[]{() -> handleEleccionP(), null});
    actionMap.put(dash.bt_gestion_vuelos, new Runnable[]{this::handlegestionv, null});
    actionMap.put(dash.bt_informes_estadisticas, new Runnable[]{this::handleER, null});

    // Election Buttons
    actionMap.put(EV.bt_elegir_vuelo, new Runnable[]{this::handleElegirVuelo, null});
    actionMap.put(EP.bt_eleccion_pasajero, new Runnable[]{() -> getPasajeroId(), null});
    
    // Administration Buttons
    actionMap.put(Adminp.bt_Maleta, new Runnable[]{() -> asignarMaleta(), null});
    actionMap.put(Adminp.bt_verificar, new Runnable[]{() -> verificarP(), null});
    actionMap.put(Adminp.bt_mascota, new Runnable[]{this::asignarSVMascota, this::quitarSVMascota});
    actionMap.put(Adminp.bt_diacapacidad, new Runnable[]{this::asignarSVDiscapacidad, this::quitarSVDiscapacidad});
    actionMap.put(Adminp.bt_mascota_cabina, new Runnable[]{this::asignarSVMascotaCabina, this::quitarSVMascotaCabina});
    actionMap.put(Adminp.bt_descartarSV, new Runnable[]{()-> eliminarSVs(), null});
    actionMap.put(Adminp.SP, new Runnable[]{this::SVno, this::SVsi});
            
    // Report Buttons
    actionMap.put(ER.bt_reporte_aviones, new Runnable[]{this::RAventana, null});
    actionMap.put(ER.bt_reporte_pasajeros, new Runnable[]{this::RPventana, null});
    actionMap.put(ER.bt_reporte_vuelos, new Runnable[]{this::RVventana, null});
    actionMap.put(ER.bt_graficos, new Runnable[]{this::Graficos, null});

    // Passenger Control Buttons
    actionMap.put(Pax.bt_asignar_al, new Runnable[]{() -> Pax.showJPanel(Asignar_a), null});
    actionMap.put(Pax.bt_asignar_av, new Runnable[]{() -> VentanaAsignarAV(), null});
    actionMap.put(Pax.bt_asignar_pa, new Runnable[]{() -> Pax.showJPanel(Asignar_p), null});
    actionMap.put(Pax.bt_asignar_pi, new Runnable[]{() -> Pax.showJPanel(Asignar_pi), null});
    actionMap.put(Pax.bt_verTripulacion, new Runnable[]{() -> VerTripulacion(), null});
    actionMap.put(Pax.bt_asignar_Az, new Runnable[]{() -> Pax.showJPanel(Asignar_az), null});
    actionMap.put(Pax.bt_asignar_Tripu, new Runnable[]{() -> VentanaAsignarTripulacion(), null});
    actionMap.put(Pax.bt_verificar_estadoVU, new Runnable[]{() -> VerificarEstado(), null});

        //Buttons Control Pax
        actionMap.put(Asignar_pi.bt_asignarP, new Runnable[]{() -> AsignarPiloto(), null});
        actionMap.put(Asignar_pi.bt_newP, new Runnable[]{() -> CrearPiloto(), null});
        actionMap.put(Asignar_az.bt_asignarAz, new Runnable[]{() -> AsignarAzafata(), null});
        actionMap.put(Asignar_az.bt_newA, new Runnable[]{() -> CrearAzafata(), null});
        actionMap.put(Asignar_T.bt_Nueva_T, new Runnable[]{() -> NuevaTripu(), null});
        actionMap.put(Asignar_T.bt_asignarT, new Runnable[]{() -> AsignarTripu(), null});
        actionMap.put(Asignar_p.bt_asignarP, new Runnable[]{() -> AsignarPAaVU(), null});
        actionMap.put(Asignar_T.bt_borrarT, new Runnable[]{() -> BorrarTripulacion(), null});
        actionMap.put(Ver_trupulacion.bt_borrarA, new Runnable[]{() -> BorrarAzafata(), null});
        actionMap.put(Ver_trupulacion.bt_borrarP, new Runnable[]{() -> BorrarPiloto(), null});
        actionMap.put(Asignar_a.btPreparar, new Runnable[]{() -> asignarAlimentos(), null});
        actionMap.put(Asignar_av.bt_asignarAvion, new Runnable[]{() -> asignarAvion(), null});
        

    //Botones para Gestion de Vuelos    
    actionMap.put(GestionV.bt_docT, new Runnable[]{() -> VerificarTripulantebyDoc(), null});
    actionMap.put(GestionV.bt_nameT, new Runnable[]{() -> VerificarTripulantebyName(), null});
    actionMap.put(GestionV.bt_docPA, new Runnable[]{() -> VerificarPasajero(), null});
    actionMap.put(GestionV.bt_asientosDisp, new Runnable[]{() -> calcAsientos(), null});
    actionMap.put(GestionV.bt_svEspeciales, new Runnable[]{() -> calcSVEspeciales(), null});
    actionMap.put(verSVs.bt_borrarSV, new Runnable[]{() -> borrarSV(), null});

        
    // Airplane Report Buttons
    actionMap.put(RA.bt_borrar, new Runnable[]{() -> eliminarAvion(), null});
    actionMap.put(RA.bt_nuevo_avion, new Runnable[]{() -> nuevoaVentana(), null});
    actionMap.put(RA.bt_editar, new Runnable[]{() -> editarAvion(), null});
    actionMap.put(RA.bt_search, new Runnable[]{() -> buscarAvion(), null});

    // Flight Report Buttons
    actionMap.put(RV.bt_nuevo_vuelo, new Runnable[]{() -> nuevovVentana(), null});
    actionMap.put(RV.bt_search, new Runnable[]{() -> buscarVuelo(), null});
    actionMap.put(RV.bt_editar, new Runnable[]{() -> editarVuelo(), null});
    actionMap.put(RV.bt_borrar, new Runnable[]{() -> eliminarVuelo(), null});

    // Passenger Report Buttons
    actionMap.put(RP.bt_search, new Runnable[]{() -> buscarPasajero(), null});
    actionMap.put(RP.bt_nuevo_pasajero, new Runnable[]{() -> dash.showJPanel(nuevo_p), null});
    actionMap.put(RP.bt_editar, new Runnable[]{() -> editarPasajero(), null});
    actionMap.put(RP.bt_borrar, new Runnable[]{() -> eliminarPasajero(), null});

    // Registration Buttons
    actionMap.put(nuevo_a.btnRegistrar, new Runnable[]{() -> registrarNuevoAvion(), null});
    actionMap.put(nuevo_p.btnRegistrar, new Runnable[]{() -> registrarNuevoPasajero(), null});
    actionMap.put(nuevo_v.btnRegistrar, new Runnable[]{() -> registrarNuevoVuelo(), null});

    // Update Passenger Buttons
    actionMap.put(editar_p.bt_actualizar, new Runnable[]{() -> actualizarPasajero(), null});
    actionMap.put(editar_p.bt_AsignarPasaje, new Runnable[]{() -> asignarPasaje(), null});
    actionMap.put(AsignarPasaje.bt_pasaje, new Runnable[]{() -> btAPASAJE(), null});

    }
    
    private void addListeners() {
    for (Object component : actionMap.keySet()) {
        if (component instanceof AbstractButton) {
            ((AbstractButton) component).addActionListener(this::actionPerformed);
        }
    }
}
    @Override
public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    if (actionMap.containsKey(source)) {
        Runnable[] actions = actionMap.get(source);
        if (source instanceof JToggleButton) {
            JToggleButton toggleButton = (JToggleButton) source;
            if (toggleButton.isSelected()) {
                if (actions[0] != null) {
                    actions[0].run();
                }
            } else {
                if (actions[1] != null) {
                    actions[1].run();
                }
            }
        } else if (actions[0] != null) {
            actions[0].run();
        }
    }
}
    
    private void addMouseListeners(){
        Pax.lb_back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dash.showJPanel(EV);
            }
        });
        
        Adminp.lb_back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dash.showJPanel(EP);
            }
        });

        GestionV.lb_back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dash.showJPanel(EV);
            }
        });

        RA.lb_back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dash.showJPanel(ER);
                RA.listarAviones();
                RP.listarUsuarios();
                RV.listarVuelos();
            }
        });
        
        RP.lb_back.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                dash.showJPanel(ER);
                dash.showJPanel(ER);
                RA.listarAviones();
                RP.listarUsuarios();
                RV.listarVuelos();
            }
                });
     
        RV.lb_back.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                dash.showJPanel(ER);
                dash.showJPanel(ER);
                RA.listarAviones();
                RP.listarUsuarios();
                RV.listarVuelos();
            };
        });
        
        nuevo_p.lb_back.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                dash.showJPanel(RP);
            }
        });
        
        nuevo_v.lb_back.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                dash.showJPanel(RV);
            }
        });
         
        nuevo_a.lb_back.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                dash.showJPanel(RA);
            };
        });
         
        editar_p.lb_back.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                dash.showJPanel(RP);
            }
        });
        verSVs.lb_back.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                dash.showJPanel(GestionV);
            }
        });
        AsignarPasaje.lb_back.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                dash.showJPanel(editar_p);
            }
        });
        
        Asignar_T.lb_back.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                Pax.showJPanel(principalPax);
            }
        });
        
        Asignar_a.lb_back.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                Pax.showJPanel(principalPax);
            }
        });
        
        Asignar_av.lb_back.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                Pax.showJPanel(principalPax);
            }
        });
        
        Asignar_az.lb_back.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                Pax.showJPanel(principalPax);
            }
        });
        
        Asignar_p.lb_back.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                Pax.showJPanel(principalPax);
            }
        });
        
        Asignar_pi.lb_back.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                Pax.showJPanel(principalPax);
            }
        });
        
        Ver_trupulacion.lb_back.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                Pax.showJPanel(principalPax);
            }
        });    
    }
    
//INIT DASHBOARD
    public void iniciar() {
        dash.setTitle("Dashboard");
        dash.setLocationRelativeTo(null);
    }

   
    
//LOGIN Y VENTANAS
    private void handleLogin() {
        boolean InicioSucces = false;
        String user = log.txt_enter_user.getText();
        String password = String.valueOf(log.txt_enter_password.getText());
        DAOCredenciales daoC = new DAOCredencialesIMPL();
        try {
            if (user.isEmpty() || password.isEmpty() || user.equals("Ingrese sú nombre de usuario") || password.equals("**********")) {
                javax.swing.JOptionPane.showMessageDialog(log, "Usuario o Contraseña Invalidos!", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
            } 
            List<Map<String, String>> ListCredenciales = daoC.obtenerCredenciales();
            for(Map<String, String> credents : ListCredenciales){
                String UserBD = credents.get("User");
                String PasswordBD = credents.get("Password");
                if(UserBD.equals(user) && PasswordBD.equals(password)){
                    log.setVisible(false);
                    dash.setVisible(true);
                    InicioSucces = true;
                    break;
                }
            }
            if(!InicioSucces){
                javax.swing.JOptionPane.showMessageDialog(log, "Usuario o Contraseña Incorrectos !!!", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
//VENTANAS DE ELECCIONES 
    public void VentanaAsignarAV(){
        Asignar_av.listarAviones();
        Pax.showJPanel(Asignar_av);
    }
   
    private void handlepax(){Pax.paxc=true; EV.listarVuelos() ;dash.showJPanel(EV);}
    
    public void handleEleccionP(){
        EP.listarUsuarios(); dash.showJPanel(EP);
    }
    
    private void handlegestionv(){Pax.paxc=false; EV.listarVuelos() ;dash.showJPanel(EV);}
    
    private void handleER(){ 
                RA.listarAviones();
                RP.listarUsuarios();
                RV.listarVuelos();
                dash.showJPanel(ER);
    };
    
//PAX CONTROL O GESTION DE VUELO
    private void handleElegirVuelo() {    
        if(Pax.paxc){
            DAOVuelos daov = new DAOVuelosIMPL();
            DAOPasajero daop = new DAOPasajeroIMPL();
            try {
                if(EV.searchField.getText().isBlank() || !EV.searchField.getText().matches("\\d+")){
                    JOptionPane.showMessageDialog(EV, "Porfavor coloque un ID válido","Aviso", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int idV = Integer.parseInt(EV.searchField.getText());
                if(daov.getVuelobyId(idV).getCodigo()!= null){
                    Pax.vuelo = daov.getVuelobyId(idV);
                    ArrayList<Pasajeros> ListaPasajeros = (ArrayList<Pasajeros>) daop.listarPAforVU(idV);
                    Pax.vuelo.setListaPasajeros(ListaPasajeros);
                    //List passengers on View_Crew
                    try {
                        Ver_trupulacion.listarPilotos(Pax.vuelo.getTripulacion().getIdtripulacion());
                        Ver_trupulacion.listarAzafatas(Pax.vuelo.getTripulacion().getIdtripulacion());
                    } catch (Exception e) {
                        System.out.println("Vuelo sin Tripulación: "+e.getMessage());
                        DefaultTableModel mdAZ =  (DefaultTableModel) Ver_trupulacion.tableAzafatas.getModel();
                        mdAZ.setRowCount(0);
                        DefaultTableModel mdPI =  (DefaultTableModel) Ver_trupulacion.tablePilotos.getModel();
                        mdPI.setRowCount(0);
                    }
                        
                    Pax.lbRef.setText("Ref. vuelo: "+Pax.vuelo.getCodigo());
                    Pax.lbforchange.setText("- Asigna un tripulante nuevo al vuelo "+Pax.vuelo.getCodigo());
                    //List Planes
                    Asignar_av.listarAviones();

                    
                    //Clean entries (INPUTS)
                    
                    Asignar_av.searchField.setText("");
                    Asignar_a.txtNalimento.setText("");
                    Asignar_a.txtTalimento.setText("");
                    Asignar_T.SearchID.setText("");
                   
                    Asignar_pi.codigoAsignar.setText("");
                    Asignar_pi.txtApellido.setText("");
                    Asignar_pi.txtCodigo.setText("");
                    Asignar_pi.txtContacto.setText("");
                    Asignar_pi.txtCorreo.setText("");
                    Asignar_pi.txtDocumento.setText("");
                    Asignar_pi.txtEdad.setText("");
                    Asignar_pi.txtJerarquia.setText("");
                    Asignar_pi.txtNombre.setText("");
                    Asignar_pi.txtRol.setText("");
                    Asignar_pi.txtSueldo.setText("");
                    
                    Asignar_az.codigoAsignar.setText("");
                    Asignar_az.txtApellido.setText("");
                    Asignar_az.txtCodigo.setText("");
                    Asignar_az.txtContacto.setText("");
                    Asignar_az.txtCorreo.setText("");
                    Asignar_az.txtDocumento.setText("");
                    Asignar_az.txtEdad.setText("");
                    Asignar_az.txtJerarquia.setText("");
                    Asignar_az.txtNombre.setText("");
                    Asignar_az.txtRol.setText("");
                    Asignar_az.txtSueldo.setText("");
                    
                    Asignar_p.txtNombre.setText("");
                    Asignar_p.txtApellido.setText("");
                    Asignar_p.txtCodigoP.setText("");
                    Asignar_p.txtDocumento.setText("");

                    dash.showJPanel(Pax);
                }else{
                    JOptionPane.showMessageDialog(EP, "Porfavor coloque un ID existente","Aviso", JOptionPane.ERROR_MESSAGE);
                }
            }catch (Exception e) {
                System.err.print(e);
            }
        }else{
            DAOVuelos daov = new DAOVuelosIMPL();
            DAOPasajero daop = new DAOPasajeroIMPL();

            try {
                if(EV.searchField.getText().isBlank() || !EV.searchField.getText().matches("\\d+")){
                    JOptionPane.showMessageDialog(EV, "Porfavor coloque un ID válido","Aviso", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int idV = Integer.parseInt(EV.searchField.getText());
                if(daov.getVuelobyId(idV).getCodigo()!= null){
                    GestionV.vuelo = daov.getVuelobyId(idV);
                    ArrayList<Pasajeros> ListaPasajeros = (ArrayList<Pasajeros>) daop.listarPAforVU(idV);
                    GestionV.vuelo.setListaPasajeros(ListaPasajeros);
                    
                    GestionV.lbVuelo.setText("Vuelo : "+GestionV.vuelo.getCodigo());
                    dash.showJPanel(GestionV);
                    if(GestionV.vuelo.getTripulacion() == null){
                        JOptionPane.showMessageDialog(EV, "El vuelo "+GestionV.vuelo.getIdvuelo()+" no tiene una tripulación asignada aún","Aviso", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(EV, "Porfavor coloque un ID existente","Aviso", JOptionPane.ERROR_MESSAGE);
                }
            }catch (Exception e) {
                System.err.print(e);
            }
        }
    }
    
//PAX CONTROL
    public void VentanaAsignarTripulacion(){
        Asignar_T.listarTripus();
        Pax.showJPanel(Asignar_T);
    }
    
    //Button para cargar tablas de pilotos y azafatas
    public void VerTripulacion(){
        String idT = "N/A";
        if(Pax.vuelo.getTripulacion() != null){
            idT = String.valueOf(Pax.vuelo.getTripulacion().getIdtripulacion());
            Ver_trupulacion.listarPilotos(Pax.vuelo.getTripulacion().getIdtripulacion());
            Ver_trupulacion.listarAzafatas(Pax.vuelo.getTripulacion().getIdtripulacion());
            Ver_trupulacion.lbidT.setText("Id Tripulación:  "+idT);
            Pax.showJPanel(Ver_trupulacion);
        }else{
            JOptionPane.showMessageDialog(Pax, "El vuelo no tiene una tripulacion asignada","Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    //Button para asignar alimentos
    public void asignarAlimentos(){
        String Nalimento = Asignar_a.txtNalimento.getText();
        String tipo = Asignar_a.txtTalimento.getText();
        Alimentos alimento = new Alimentos(Pax.vuelo.getCodigo(), tipo, Nalimento);
        DAOAlimentos dao = new DAOAlimentosIMPL();
        try {
            dao.registrarAlimento(alimento);
            JOptionPane.showMessageDialog(Pax, "Alimento Agregado Exitosamente","Aviso", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            System.out.print(e);
        }    
    }
    
    //Button para asignar avion a un vuelo
    public void asignarAvion(){
        DAOAviones daoAV = new DAOAvionesIMPL();
        DAOVuelos dao = new DAOVuelosIMPL();
        if(Asignar_av.searchField.getText().isBlank() || !Asignar_av.searchField.getText().matches("\\d+")){
            JOptionPane.showMessageDialog(Asignar_av, "Por favor, Ingrese un ID válido","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int idAvion = Integer.parseInt(Asignar_av.searchField.getText());
        try {
            if(daoAV.getAvionbyId(idAvion).getNombre() == null){
                JOptionPane.showMessageDialog(Asignar_av, "Por favor, Ingrese un ID Existente","Error", JOptionPane.ERROR_MESSAGE);
            return;
            }
            Pax.vuelo.setAvion(daoAV.getAvionbyId(idAvion));
            dao.modificarVU(Pax.vuelo);
            JOptionPane.showMessageDialog(nuevo_p, "Avion Asignado Exitosamente","Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.err.print(e);
        }
    }
    
    //Button para crear nueva tripulación 
    public void NuevaTripu(){
        DAOTripulacion dao = new DAOTripulacionIMPL();
        DAOVuelos daoVU = new DAOVuelosIMPL();
        
        try {
            dao.registrarTaV(Pax.vuelo.getIdvuelo());
            Pax.vuelo = daoVU.getVuelobyId(Pax.vuelo.getIdvuelo());
            Asignar_T.listarTripus();
            JOptionPane.showMessageDialog(Pax, "Nueva Tripulación agregada Exitosamente","Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
        
        }
    }
    
    public void BorrarTripulacion(){
        if (!Asignar_T.SearchID.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(Asignar_pi, "Ingrese un ID válido","Aviso", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int idT = Integer.parseInt(Asignar_T.SearchID.getText());
        DAOTripulacion daot = new DAOTripulacionIMPL();
        try {
            daot.elminarT(idT);
            Asignar_T.listarTripus();
            JOptionPane.showMessageDialog(Asignar_T, "Tripulación eliminadaExitosamente","Aviso", JOptionPane.INFORMATION_MESSAGE);
            Asignar_T.SearchID.setText("");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
   }
    
    //Button para Asignar una Tripulacion
    public void AsignarTripu(){
        if (!Asignar_T.SearchID.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(Asignar_pi, "Ingrese un ID válido","Aviso", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int idT = Integer.parseInt(Asignar_T.SearchID.getText());
        DAOTripulacion dao = new DAOTripulacionIMPL();
        try {
            Tripulacion tripu = dao.getTripulacionById(idT);
            Pax.vuelo.setTripulacion(tripu);
            dao.registrarT(tripu, Pax.vuelo.getIdvuelo());
            JOptionPane.showMessageDialog(Asignar_T, "Tripulación agregada Exitosamente","Aviso", JOptionPane.INFORMATION_MESSAGE);
            Asignar_T.SearchID.setText("");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    //Asignar Pasajero a vuelo
    public void AsignarPAaVU(){
        String nombrep = Asignar_p.txtNombre.getText();
        String codigop = Asignar_p.txtCodigoP.getText();
        String DocumentoP = Asignar_p.txtDocumento.getText();
        String Apellido = Asignar_p.txtApellido.getText();
        DAOPasajero daoPA = new DAOPasajeroIMPL();
        DAOVuelos daoVU = new DAOVuelosIMPL();
        try {
            if(Pax.vuelo.getAvion() == null){
                JOptionPane.showMessageDialog(Pax, "El vuelo no tiene un avion asignado, Por favor asigne uno antes de registrar a un pasajero","Aviso", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(nombrep.isEmpty() || codigop.isEmpty() || DocumentoP.isEmpty() || Apellido.isEmpty()){
                JOptionPane.showMessageDialog(Pax, "Por favor rellene todos los campos","Aviso", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(daoPA.getPasajeroForVU(nombrep, Apellido, codigop, DocumentoP).getNombre() == null){
                JOptionPane.showMessageDialog(Pax, "Por favor ingrese un pasajero existente","Aviso", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Pasajeros pa = daoPA.getPasajeroForVU(nombrep, Apellido, codigop, DocumentoP);
            Pax.vuelo.getListaPasajeros().add(pa);
            Pax.vuelo.setCantidadpasajeros(Pax.vuelo.getListaPasajeros().size());
            pa.setVuelos(Pax.vuelo);
            
            if(pa.getPasaje().getCodVuelo()== null){
                JOptionPane.showMessageDialog(Pax, "Ingrese un pasaje que corresponda al vuelo","Aviso", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(!pa.getPasaje().getCodVuelo().equalsIgnoreCase(Pax.vuelo.getCodigo())){
                JOptionPane.showMessageDialog(Pax, "Ingrese un pasaje que corresponda al vuelo","Aviso", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            daoVU.modificarVU(Pax.vuelo);
            daoPA.modificarPA(pa);
            JOptionPane.showMessageDialog(Pax, "Pasajero registrado exitosamente al vuelo: "+Pax.vuelo.getCodigo(),"Aviso", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    //Verificar estado Avion
    public void VerificarEstado(){
        if(Pax.vuelo.getAvion() == null){
            JOptionPane.showMessageDialog(Pax, "El vuelo no tiene un avion registrado","Aviso", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String falla = JOptionPane.showInputDialog( "¿El avion presenta algun fallo?\t (si no es así deje vacio el espacio)");
        String estadovu = JOptionPane.showInputDialog("¿Cuál es el estado del vuelo?\n");
        String  estadoav = JOptionPane.showInputDialog("¿El Avion esta en vuelo?\t 1 - Sí    |    2 - No");
        if(estadovu == null|| estadoav == null){
            JOptionPane.showMessageDialog(Pax, "Porfavor llene los dos ultimos campos","Aviso", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!estadoav.matches("\\d+")){
            JOptionPane.showMessageDialog(Pax, "Porfavor ingrese un numero válido 1 -> Sí t| 2-> No","Aviso", JOptionPane.ERROR_MESSAGE);
            return;
        }
        DAOAviones daoVU = new DAOAvionesIMPL();
        DAOVuelos daov = new DAOVuelosIMPL();
        
        Pax.vuelo.getAvion().setFalla(falla);
        Pax.vuelo.setEstado(estadovu);
        switch (estadoav) {
            case "1" -> {
                Pax.vuelo.getAvion().setEstadoVuelo(false);
                try {
                    daoVU.modificarAV(Pax.vuelo.getAvion());
                } catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }       
                JOptionPane.showMessageDialog(Pax, "!Vuelo en proceso!","Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
            case "2" -> {
                Pax.vuelo.getAvion().setEstadoVuelo(true);
                try {
                    daoVU.modificarAV(Pax.vuelo.getAvion());
                } catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }   JOptionPane.showMessageDialog(Pax, "!Vuelo aun en tierra!","Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
            default -> {
                JOptionPane.showMessageDialog(Pax, "Porfavor ingrese un numero entre 1 y 2","Aviso", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        try {
            daov.modificarVU(Pax.vuelo);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    
    public void AsignarPiloto(){
        if(Pax.vuelo.getTripulacion() == null){
                JOptionPane.showMessageDialog(Asignar_az, "No hay ni una tripulacion asignada al vuelo","Aviso", JOptionPane.ERROR_MESSAGE);            
                return;
            }
        
        if (Asignar_pi.codigoAsignar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(Asignar_az, "Porfavor ingrese un codigo de Piloto válido","Aviso", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String Codigopi = Asignar_pi.codigoAsignar.getText();
        DAOTripulacion daot = new DAOTripulacionIMPL();
        DAOPilotos daoPI = new DAOPilotosIMPL();
        try {
            if(daoPI.getPilotobyCode(Codigopi) == null){
                JOptionPane.showMessageDialog(Asignar_pi, "Porfavor ingrese un codigo de Piloto existente","Aviso", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Piloto pi = daoPI.getPilotobyCode(Codigopi);
            daoPI.registrarPaT(pi.getId(),Pax.vuelo.getTripulacion().getIdtripulacion());
            
            Tripulacion tripu = daot.getTripulacionById(Pax.vuelo.getTripulacion().getIdtripulacion());
            Pax.vuelo.setTripulacion(tripu);
            JOptionPane.showMessageDialog(Asignar_pi, "! Piloto "+pi.getNombre()+" "+pi.getApellido()+" agregado Exitosamente !","Aviso", JOptionPane.INFORMATION_MESSAGE);

            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public void CrearPiloto(){

        String nombre = Asignar_pi.txtNombre.getText();
        String apellido = Asignar_pi.txtApellido.getText();
        String contacto = Asignar_pi.txtContacto.getText();
        String correo = Asignar_pi.txtCorreo.getText();
        String codigo = Asignar_pi.txtCodigo.getText();
        String documento = Asignar_pi.txtDocumento.getText();
        String edadText = Asignar_pi.txtEdad.getText();
        String rol = Asignar_pi.txtRol.getText();
        String sueldoText = Asignar_pi.txtSueldo.getText();
        String Jerarquia = Asignar_pi.txtJerarquia.getText();
        
        if(Pax.vuelo.getTripulacion() == null){
                JOptionPane.showMessageDialog(Asignar_pi, "No hay ni una tripulacion asignada al vuelo","Aviso", JOptionPane.ERROR_MESSAGE);            
                return;
            }
        
        if (nombre.isEmpty() || apellido.isEmpty() || contacto.isEmpty() || correo.isEmpty() ||
            codigo.isEmpty() || documento.isEmpty() || edadText.isEmpty() || rol.isEmpty() || Jerarquia.isEmpty()) {
            JOptionPane.showMessageDialog(Asignar_pi, "Porfavor llene todos los campos","Aviso", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!edadText.matches("\\d+")) {
            JOptionPane.showMessageDialog(Asignar_pi, "Ingrese una edad válida","Aviso", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int edad = Integer.parseInt(edadText);

        if (!sueldoText.matches("\\d+")) {
            JOptionPane.showMessageDialog(Asignar_pi, "Ingrese un monto de sueldo válido","Aviso", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int sueldo = Integer.parseInt(sueldoText);
        
        if (!correo.matches("^[A-Za-z0-9+#'!_.-]+@[A-Za-z0-9+#'!.-]+\\.[A-Za-z]+$")) {
            JOptionPane.showMessageDialog(Asignar_pi, "Ingrese correo válido","Aviso", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        for(Piloto i : Pax.vuelo.getTripulacion().getListaPiloto()){
            if(i.getCodigo().equalsIgnoreCase(codigo)){
                JOptionPane.showMessageDialog(Asignar_az, "Piloto yá registrado con este código","Aviso", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(i.getDocumentos().equalsIgnoreCase(documento)){
                JOptionPane.showMessageDialog(Asignar_az, "Piloto yá registrada con este numero de Documento","Aviso", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        
        DAOPilotos dao = new DAOPilotosIMPL();
        DAOTripulacion daot = new DAOTripulacionIMPL();
        try {
            Piloto pi = new Piloto(nombre, apellido, contacto, correo, edad, documento, rol, codigo, sueldo, Jerarquia);
            dao.registrarPI(pi);
            pi = dao.getPilotobyCode(codigo);
            dao.registrarPaT(pi.getId(),Pax.vuelo.getTripulacion().getIdtripulacion());
            
            Tripulacion tripu = daot.getTripulacionById(Pax.vuelo.getTripulacion().getIdtripulacion());
            Pax.vuelo.setTripulacion(tripu);
            
            JOptionPane.showMessageDialog(Asignar_pi, "Piloto Registrado Existosamente!!!","Aviso", JOptionPane.INFORMATION_MESSAGE);
            Asignar_pi.txtNombre.setText("");
            Asignar_pi.txtApellido.setText("");
            Asignar_pi.txtContacto.setText("");
            Asignar_pi.txtCorreo.setText("");
            Asignar_pi.txtCodigo.setText("");
            Asignar_pi.txtDocumento.setText("");
            Asignar_pi.txtEdad.setText("");
            Asignar_pi.txtRol.setText("");
            Asignar_pi.txtSueldo.setText("");
            Asignar_pi.txtJerarquia.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Asignar_pi, "Ocurrió un error al registrar el Piloto","Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void BorrarPiloto(){
        if (Ver_trupulacion.tablePilotos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(Asignar_pi, "Seleccione el piloto a eliminar","Aviso", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(Pax.vuelo.getTripulacion() == null){
                JOptionPane.showMessageDialog(Asignar_pi, "No hay ni una tripulacion asignada al vuelo","Aviso", JOptionPane.ERROR_MESSAGE);            
                return;
            }
        
        String codePi = Ver_trupulacion.tablePilotos.getValueAt(Ver_trupulacion.tablePilotos.getSelectedRow(), 0).toString();
        DAOPilotos daop = new DAOPilotosIMPL();
        try {
            daop.elminarPI(codePi);
            Ver_trupulacion.listarPilotos(Pax.vuelo.getTripulacion().getIdtripulacion());
            JOptionPane.showMessageDialog(Asignar_T, "Piloto eliminado Exitosamente!","Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    
    public void AsignarAzafata(){
        if(Pax.vuelo.getTripulacion() == null){
                JOptionPane.showMessageDialog(Asignar_az, "No hay ni una tripulacion asignada al vuelo","Aviso", JOptionPane.ERROR_MESSAGE);            
                return;
            }
        
        if (Asignar_az.codigoAsignar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(Asignar_az, "Porfavor ingrese un codigo de Azafata válido","Aviso", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String Codigoaz = Asignar_az.codigoAsignar.getText();
        DAOTripulacion daot = new DAOTripulacionIMPL();
        DAOAzafata daoAZ = new DAOAzafataIMPL();
        try {
            if(daoAZ.getAzafatabyCode(Codigoaz) == null){
                JOptionPane.showMessageDialog(Asignar_az, "Porfavor ingrese un codigo de Azafata existente","Aviso", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Azafata az = daoAZ.getAzafatabyCode(Codigoaz);
            daoAZ.registrarAZaT(az.getId(),Pax.vuelo.getTripulacion().getIdtripulacion());
            
            Tripulacion tripu = daot.getTripulacionById(Pax.vuelo.getTripulacion().getIdtripulacion());
            Pax.vuelo.setTripulacion(tripu);
            JOptionPane.showMessageDialog(Asignar_az, "! Azafata "+az.getNombre()+" "+az.getApellido()+" agregada Exitosamente !","Aviso", JOptionPane.INFORMATION_MESSAGE  );

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void CrearAzafata(){
        String nombre = Asignar_az.txtNombre.getText();
        String apellido = Asignar_az.txtApellido.getText();
        String contacto = Asignar_az.txtContacto.getText();
        String correo = Asignar_az.txtCorreo.getText();
        String codigo = Asignar_az.txtCodigo.getText();
        String documento = Asignar_az.txtDocumento.getText();
        String edadText = Asignar_az.txtEdad.getText();
        String rol = Asignar_az.txtRol.getText();
        String sueldoText = Asignar_az.txtSueldo.getText();
        String Jerarquia = Asignar_az.txtJerarquia.getText();
        
        if(Pax.vuelo.getTripulacion() == null){
                JOptionPane.showMessageDialog(Asignar_pi, "No hay ni una tripulacion asignada al vuelo","Aviso", JOptionPane.ERROR_MESSAGE);            
                return;
            }
        
        if (nombre.isEmpty() || apellido.isEmpty() || contacto.isEmpty() || correo.isEmpty() ||
            codigo.isEmpty() || documento.isEmpty() || edadText.isEmpty() || rol.isEmpty() || Jerarquia.isEmpty()) {
            JOptionPane.showMessageDialog(Asignar_az, "Porfavor llene todos los campos","Aviso", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!edadText.matches("\\d+")) {
            JOptionPane.showMessageDialog(Asignar_az, "Ingrese una edad válida","Aviso", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int edad = Integer.parseInt(edadText);

        if (!sueldoText.matches("\\d+")) {
            JOptionPane.showMessageDialog(Asignar_az, "Ingrese un monto de sueldo válido","Aviso", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int sueldo = Integer.parseInt(sueldoText);
        
        if (!correo.matches("^[A-Za-z0-9+#'!_.-]+@[A-Za-z0-9+#'!.-]+\\.[A-Za-z]+$")) {
            JOptionPane.showMessageDialog(Asignar_az, "Ingrese correo válido","Aviso", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        for(Azafata i : Pax.vuelo.getTripulacion().getListaAzafata()){
            if(i.getCodigo().equalsIgnoreCase(codigo)){
                JOptionPane.showMessageDialog(Asignar_az, "Azafata yá registrada con este código","Aviso", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(i.getDocumentos().equalsIgnoreCase(documento)){
                JOptionPane.showMessageDialog(Asignar_az, "Azafata yá registrada con este numero de Documento","Aviso", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        DAOAzafata dao = new DAOAzafataIMPL();
        DAOTripulacion daot = new DAOTripulacionIMPL();
        try {
            Azafata az = new Azafata(nombre, apellido, contacto, correo, edad, documento, rol, codigo, sueldo, Jerarquia);
            dao.registrarAZ(az);
            az = dao.getAzafatabyCode(codigo);
            
            dao.registrarAZaT(az.getId(),Pax.vuelo.getTripulacion().getIdtripulacion());
            
            Tripulacion tripu = daot.getTripulacionById(Pax.vuelo.getTripulacion().getIdtripulacion());
            Pax.vuelo.setTripulacion(tripu);
            
            JOptionPane.showMessageDialog(Asignar_az, "Azafata Registrada Existosamente!!!","Aviso", JOptionPane.INFORMATION_MESSAGE);
            Asignar_az.txtNombre.setText("");
            Asignar_az.txtApellido.setText("");
            Asignar_az.txtContacto.setText("");
            Asignar_az.txtCorreo.setText("");
            Asignar_az.txtCodigo.setText("");
            Asignar_az.txtDocumento.setText("");
            Asignar_az.txtEdad.setText("");
            Asignar_az.txtRol.setText("");
            Asignar_az.txtSueldo.setText("");
            Asignar_az.txtJerarquia.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Asignar_az, "Ocurrió un error al registrar la Azafata","Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void BorrarAzafata(){
        if (Ver_trupulacion.tableAzafatas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(Ver_trupulacion, "Ingrese un ID válido","Aviso", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(Pax.vuelo.getTripulacion() == null){
                JOptionPane.showMessageDialog(Ver_trupulacion, "No hay ni una tripulacion asignada al vuelo","Aviso", JOptionPane.ERROR_MESSAGE);            
                return;
            }
        
        String idAz = Ver_trupulacion.tableAzafatas.getValueAt(Ver_trupulacion.tableAzafatas.getSelectedRow(), 0).toString();
        DAOAzafata daoaz = new DAOAzafataIMPL();
        try {
            daoaz.elminarAZ(idAz);
            Ver_trupulacion.listarAzafatas(Pax.vuelo.getTripulacion().getIdtripulacion());
            JOptionPane.showMessageDialog(Asignar_T, "Azafata eliminada Exitosamene!","Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    
    
//ADMINISTRADOR DE PASAJEROS
    //Boton select Pasajero deacuerdo al ID
    public void SVsi(){
        Adminp.SP.setText("|  SI");
            Adminp.SP.setBackground(Color.GREEN);
            Adminp.bgSV.setVisible(true);
            Adminp.SP.repaint();
    }
    public void SVno(){
         Adminp.SP.setText("NO  |");
            Adminp.SP.setBackground(Color.RED);
            Adminp.bgSV.setVisible(false);
            Adminp.SP.repaint();
    }
    
    public void getPasajeroId(){
        
        if(EP.searchField.getText().isBlank() || !EP.searchField.getText().matches("\\d+")){
            JOptionPane.showMessageDialog(EP, "Porfavor coloque un ID válido","Aviso", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int uid = Integer.parseInt(EP.searchField.getText());
        Adminp.pasajeroId = uid;
        DAOPasajero dao = new DAOPasajeroIMPL();
        DAOSVDiscapacidad daoSVDisc = new DAOSVDiscapacidadIMPL();
        DAOSVMascota daoSVMa = new DAOSVMascotaIMPL();
        DAOSVMascotaCabina daoSVMaCabina = new DAOSVMascotaCabinaIMPL();
        
        //Clenar entries (inputs)
        Adminp.codigoVtxt.setText("");
        Adminp.documentotxt.setText("");
        Adminp.idPasajetxt.setText("");

        
        DAOMaleta daom = new DAOMaletaIMPL();
        try {
            if(dao.getPasajerobyId(uid).getNombre() != null){
                Pasajeros p = dao.getPasajerobyId(uid);
                Adminp.pasajero = p ;
                Adminp.tittle.setText("Pasajero           -  "+p.getNombre()+" "+p.getApellido()+"        ID: "+uid);
                dash.showJPanel(Adminp);
            }else{
                JOptionPane.showMessageDialog(EP, "Porfavor coloque un ID existente","Aviso", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if(daom.getMaletabyId(Adminp.pasajeroId).getDimension() != null){
                Maleta ma =  daom.getMaletabyId(Adminp.pasajeroId);
                Adminp.lbpeso.setText("Peso:   "+ma.getPeso()+"  Kg");
                Adminp.lblongitud.setText("Longitud: "+ma.getDimension()[0]+" cm");
                Adminp.lbancho.setText("Ancho: "+ma.getDimension()[1]+" cm");
                Adminp.lbaltura.setText("Alto: "+ma.getDimension()[2]+" cm");
                Adminp.pasajero.setMaleta(ma);
            }else{
                Adminp.lbpeso.setText("Peso: N/A");
                Adminp.lblongitud.setText("Longitud: N/A");
                Adminp.lbancho.setText("Ancho: N/A");
                Adminp.lbaltura.setText("Alto: N/A");
            }
            
            
            //Aca se trabaja con el estado del botón SP por estética en true por que tiene un tono mas oscuro en el color y
            //el false tiene un tono mas claro al momento de clickearlos
            Adminp.SP.setSelected(true);
            
            if(daoSVDisc.getSVbyID(uid).getId() != 0){
                Adminp.bt_diacapacidad.setSelected(true);
                Adminp.SP.setSelected(false);
            }else{             
                Adminp.bt_diacapacidad.setSelected(false);  
            }
            if(daoSVMa.getSVbyID(uid).getId() != 0){
                Adminp.bt_mascota.setSelected(true);
                Adminp.SP.setSelected(false);
            }else{           
                Adminp.bt_mascota.setSelected(false);
            }
            if(daoSVMaCabina.getSVbyID(uid).getId() != 0){
                Adminp.bt_mascota_cabina.setSelected(true);
                Adminp.SP.setSelected(false);
            }else{             
                Adminp.bt_mascota_cabina.setSelected(false);
            }
            
            if(Adminp.SP.isSelected()){  SVno();  }else{  SVsi(); }
            
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
    }    
    
    //Crear y quitar Servicios de Mascota
    public void asignarSVMascota(){
        ServicioMascota sm = new ServicioMascota("Mascota", "Mascota a cargo");
        Adminp.pasajero.setServicioEspecial(sm);
        DAOSVMascota dao = new DAOSVMascotaIMPL();
        try {
            dao.registrarSV(sm, Adminp.pasajeroId);
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
    
    private void quitarSVMascota() {
        DAOSVMascota daosv = new DAOSVMascotaIMPL();
        try {
            daosv.EliminarSV(Adminp.pasajeroId);
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Crear y quitar Servicios de Mascota en Cabina
    public void asignarSVMascotaCabina(){
        ServicioMascotaCabina smc = new ServicioMascotaCabina("Mascota en cabina", "Mascota a cargo en cabina");
        Adminp.pasajero.setServicioEspecial(smc);
        DAOSVMascotaCabina dao = new DAOSVMascotaCabinaIMPL();
        try {
            dao.registrarSV(smc, Adminp.pasajeroId);
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
    
    private void quitarSVMascotaCabina() {
        DAOSVMascotaCabina daosv = new DAOSVMascotaCabinaIMPL();
        try {
            daosv.EliminarSV(Adminp.pasajeroId);
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Crear y quitar Servicios de discapacidad
    public void asignarSVDiscapacidad(){
        String tipo = JOptionPane.showInputDialog( "¿Que discapacidad presenta?\n");
        String descripcion = JOptionPane.showInputDialog("¿Que se necesitará?\n");
        ServiciosEspeciales sp = new ServiciosEspeciales(tipo, descripcion);
        if(tipo == null || descripcion == null ||tipo.isEmpty()|| descripcion.isEmpty()){
            JOptionPane.showMessageDialog(Adminp, "Rellene correctamente los campos!","Aviso", JOptionPane.ERROR_MESSAGE);
            Adminp.bt_diacapacidad.setSelected(false);
            return;
        }
        Adminp.pasajero.setDiscapacidad(tipo);
        Adminp.pasajero.setServicioEspecial(sp);
        DAOPasajero dao = new DAOPasajeroIMPL();
        DAOSVDiscapacidad daosv = new DAOSVDiscapacidadIMPL();
        try {
            dao.modificarPA(Adminp.pasajero);
            daosv.registrarSV(sp, Adminp.pasajeroId);
            JOptionPane.showMessageDialog(Adminp, "Discapacidad Registrada!","Aviso", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
    
    private void quitarSVDiscapacidad() {
        DAOSVDiscapacidad daosv = new DAOSVDiscapacidadIMPL();
        try {
            daosv.EliminarSV(Adminp.pasajeroId);
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarSVs(){
        Adminp.bt_diacapacidad.setSelected(false);
        Adminp.bt_mascota.setSelected(false);
        Adminp.bt_mascota_cabina.setSelected(false);
        DAOSVDiscapacidad daoSVD = new DAOSVDiscapacidadIMPL();
        DAOSVMascota daoSVM = new DAOSVMascotaIMPL();
        DAOSVMascotaCabina daoSVMC = new DAOSVMascotaCabinaIMPL();
        try {
            daoSVD.EliminarSV(Adminp.pasajeroId);
            daoSVM.EliminarSV(Adminp.pasajeroId);
            daoSVMC.EliminarSV(Adminp.pasajeroId);

        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void verificarP(){
        String codV = Adminp.codigoVtxt.getText();
        String documento = Adminp.documentotxt.getText();
        String codPS = Adminp.idPasajetxt.getText();
        Pasajeros p = Adminp.pasajero;
        DAOPasajero dao = new DAOPasajeroIMPL();
        try {
            if(p.getDocumentos().equalsIgnoreCase(documento) && p.getVuelos().getCodigo().equalsIgnoreCase(codV)
            && p.getPasaje().getCodigoPS().equalsIgnoreCase(codPS)){
               Adminp.pasajero.setCheckeado(true);
               dao.modificarPA(Adminp.pasajero);
               JOptionPane.showMessageDialog(Adminp, "Usuario verificado Exitosamente!!!","Aviso", JOptionPane.INFORMATION_MESSAGE);

            }else{
                JOptionPane.showMessageDialog(Adminp, "Datos invalidos, No se logró verificar al Usuario","Aviso", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.err.print(e);
        }
    }
    
    public void asignarMaleta(){
        DAOMaleta dao = new DAOMaletaIMPL();
        DAOPasajero daop = new DAOPasajeroIMPL();
        
        try {
            if(dao.getMaletabyId(Adminp.pasajeroId).getDimension() != null){
                Maleta ma =  dao.getMaletabyId(Adminp.pasajeroId);
                dao.eliminarMaleta(ma.getId());
            }
            String pes = JOptionPane.showInputDialog( "Ingrese el Peso(kg) de la Maleta");
            String lon = JOptionPane.showInputDialog("Ingrese la longitud de la maleta (cm)\n");
            String an = JOptionPane.showInputDialog( "Ingrese el Ancho de la maleta (cm)\n");
            String al = JOptionPane.showInputDialog( "Ingrese la Altura de la maleta (cm)\n");
            
            if(!pes.matches("\\d+")|!lon.matches("\\d+")|!an.matches("\\d+")|!al.matches("\\d+")){
                JOptionPane.showMessageDialog(Adminp, "Por favor, ingrese solo números.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                return; 
            }
            
            int peso = Integer.parseInt(pes);
            int Longitud = Integer.parseInt(lon );
            int Ancho = Integer.parseInt(an);
            int Altura = Integer.parseInt(al);
            int[] dimentions = {Longitud,Ancho,Altura};
            
            Maleta maleta = new Maleta(Adminp.pasajeroId, dimentions, peso);
            Adminp.lbpeso.setText("Peso:   "+peso+"  Kg");
            Adminp.lblongitud.setText("Longitud: "+dimentions[0]+" cm");
            Adminp.lbancho.setText("Ancho: "+dimentions[1]+" cm");
            Adminp.lbaltura.setText("Alto: "+dimentions[2]+" cm");
            //Registrandola a la bd 
            dao.registrarMaleta(maleta);
            //Obtenemos la maleta registradad en la bd
            Maleta m = dao.getMaletabyId(Adminp.pasajeroId);
            //Actualizando el pasajero con su maleta
            Adminp.pasajero.setMaleta(m);
            daop.modificarPA(Adminp.pasajero);
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarSV(){
        if(verSVs.tablaSV.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(Ver_trupulacion, "Por favor, Seleccione algun servicio para eliminar", "Error de entrada", 
                    JOptionPane.ERROR_MESSAGE);
            return; 
        }
        int idSV = verSVs.tablaSV.getSelectedRow();
        
        DAOSVDiscapacidad daoDIS = new DAOSVDiscapacidadIMPL();
        DAOSVMascota daoMA = new DAOSVMascotaIMPL();
        DAOSVMascotaCabina daoMAC = new DAOSVMascotaCabinaIMPL();
        
        try {
            int idp = (int) verSVs.tablaSV.getValueAt(verSVs.tablaSV.getSelectedRow(), 1);
            if(daoDIS.getSVbyID(idp).getDescripcion()!=null){
                daoDIS.EliminarSV(idp);
            }
            else if(daoMA.getSVbyID(idp).getDescripcion()!=null){
                daoMA.EliminarSV(idp);
            }
            else if(daoMAC.getSVbyID(idp).getDescripcion()!=null){
                daoMAC.EliminarSV(idp);
            }else{
                JOptionPane.showMessageDialog(verSVs, "Ocurrio un error al borrar el servicio", "Aviso", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            verSVs.listarSVs(GestionV.vuelo.getIdvuelo());
            JOptionPane.showMessageDialog(verSVs, "Servicio Eliminado Exitosamente!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
    }

//GESTION DE VUELO
    public void calcSVEspeciales(){
        verSVs.listarSVs(GestionV.vuelo.getIdvuelo());
        verSVs.lbSVrellenar.setText("Vuelo : "+GestionV.vuelo.getCodigo());
        dash.showJPanel(verSVs);
    }
    
    public void calcAsientos(){
        if(GestionV.vuelo.getAvion() == null){
            JOptionPane.showMessageDialog(GestionV, "El vuelo no tiene un avión asignado ","Aviso", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Avion av = GestionV.vuelo.getAvion();
        int asientosDisp = av.getCantpasajerosmax() - GestionV.vuelo.getListaPasajeros().size();
        JOptionPane.showMessageDialog(GestionV, 
                "Datos de Vuelo "+GestionV.vuelo.getCodigo()+"\n"+
                "Id Avion: "+av.getIdavion()+"\n"+
                "Avion: "+av.getNombre()+"\n"+
                "Placa: "+av.getPlaca()+"\n"+
                "Afoto Maximo: "+av.getCantpasajerosmax()+"\n"+
                "Asientos Ocupados: "+GestionV.vuelo.getListaPasajeros().size()+"\n"+
                "Asientos Disponibles: "+asientosDisp+"\n"
                ,"Aviso",JOptionPane.INFORMATION_MESSAGE);

    }
    
    public void VerificarTripulantebyName(){
        if(GestionV.vuelo.getTripulacion()== null){
            JOptionPane.showMessageDialog(GestionV, "El vuelo "+GestionV.vuelo.getIdvuelo()+" no tiene una tripulación asignada aún","Aviso", 
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        String name = GestionV.txtNombre.getText();
        
        Tripulacion tripu = GestionV.vuelo.getTripulacion();
        
        for(Piloto pi : tripu.getListaPiloto()){
            if(pi.getNombre().equals(name)){
                JOptionPane.showMessageDialog(
                GestionV, 
                "El vuelo " + GestionV.vuelo.getIdvuelo() + "\n" +
                "Tripulante - Id: "+pi.getId()+"\n"+
                "Nombre: " + pi.getNombre() + "\n" + 
                "Edad: " + pi.getEdad()+"\n"+
                "Jerarquía: " + pi.getJerarquia()+"\n"+
                "Rol: " + pi.getJerarquia()+"\n"+
                "Correo: " + pi.getEmail()+"\n"+
                "Numero: " + pi.getContacto()+"\n"+
                "Sueldo: " + pi.getSueldo()+"\n"+
                "Tripulacion: " + GestionV.vuelo.getTripulacion().getIdtripulacion()+"\n",
                "Aviso", 
                JOptionPane.INFORMATION_MESSAGE
                );
                return;
            }
        }
        for(Azafata az : tripu.getListaAzafata()){
            if(az.getNombre().equals(name)){
                JOptionPane.showMessageDialog(
                GestionV, 
                "El vuelo " + GestionV.vuelo.getIdvuelo() + "\n" +
                "Tripulante - Id: "+az.getId()+"\n"+
                "Nombre: " + az.getNombre() + "\n" + 
                "Edad: " + az.getEdad()+"\n"+
                "Jerarquía: " + az.getJerarquia()+"\n"+
                "Rol: " + az.getJerarquia()+"\n"+
                "Correo: " + az.getEmail()+"\n"+
                "Numero: " + az.getContacto()+"\n"+
                "Sueldo: " + az.getSueldo()+"\n"+
                "Tripulacion: " + GestionV.vuelo.getTripulacion().getIdtripulacion()+"\n", 
                "Aviso",
                JOptionPane.INFORMATION_MESSAGE
                );
                return;
            }
        }
        JOptionPane.showMessageDialog(GestionV, "Tripulante no existente!","Aviso",JOptionPane.ERROR_MESSAGE);

    }

    public void VerificarTripulantebyDoc(){
        if(GestionV.vuelo.getTripulacion()== null){
            JOptionPane.showMessageDialog(GestionV, "El vuelo "+GestionV.vuelo.getIdvuelo()+" no tiene una tripulación asignada aún",
                    "Aviso", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String doc = GestionV.txtDocTr.getText();
        
        Tripulacion tripu = GestionV.vuelo.getTripulacion();
        
        for(Piloto pi : tripu.getListaPiloto()){
            if(pi.getDocumentos().equals(doc)){
                JOptionPane.showMessageDialog(
                GestionV, 
                "El vuelo " + GestionV.vuelo.getIdvuelo() + "\n" +
                "Tripulante - Id: "+pi.getId()+"\n"+
                "Nombre: " + pi.getNombre() + "\n" + 
                "Edad: " + pi.getEdad()+"\n"+
                "Jerarquía: " + pi.getJerarquia()+"\n"+
                "Rol: " + pi.getJerarquia()+"\n"+
                "Correo: " + pi.getEmail()+"\n"+
                "Numero: " + pi.getContacto()+"\n"+
                "Sueldo: " + pi.getSueldo()+"\n"+
                "Tripulacion: " + GestionV.vuelo.getTripulacion().getIdtripulacion()+"\n", 
                "Aviso", 
                JOptionPane.INFORMATION_MESSAGE
                );
                return;
            }
        }
        for(Azafata az : tripu.getListaAzafata()){
            if(az.getDocumentos().equals(doc)){
                JOptionPane.showMessageDialog(
                GestionV, 
                "El vuelo " + GestionV.vuelo.getIdvuelo() + "\n" +
                "Tripulante - Id: "+az.getId()+"\n"+
                "Nombre: " + az.getNombre() + "\n" + 
                "Edad: " + az.getEdad()+"\n"+
                "Jerarquía: " + az.getJerarquia()+"\n"+
                "Rol: " + az.getJerarquia()+"\n"+
                "Correo: " + az.getEmail()+"\n"+
                "Numero: " + az.getContacto()+"\n"+
                "Sueldo: " + az.getSueldo()+"\n"+
                "Tripulacion: " + GestionV.vuelo.getTripulacion().getIdtripulacion()+"\n", 
                "Aviso", 
                JOptionPane.INFORMATION_MESSAGE
                );
                return;
            }
        }
        JOptionPane.showMessageDialog(GestionV, "Tripulante no existente!","Aviso",JOptionPane.ERROR_MESSAGE);

    }    
    
    public void VerificarPasajero(){
       if(GestionV.vuelo.getListaPasajeros() == null){
            JOptionPane.showMessageDialog(GestionV, "El vuelo "+GestionV.vuelo.getIdvuelo()+" no tiene Pasajeros asignados aún",
                    "Aviso", JOptionPane.ERROR_MESSAGE);
            return;
       }
        String docPA = GestionV.txtDocPa.getText();
        for(Pasajeros pa : GestionV.vuelo.getListaPasajeros()){
             if(pa.getDocumentos().equals(docPA)){
                JOptionPane.showMessageDialog(
                GestionV, 
                "El vuelo " + GestionV.vuelo.getIdvuelo() + "\n" +
                "Pasajero- Id: "+pa.getIdcliente()+"\n"+
                "Nombre: " + pa.getNombre() + "\n" + 
                "Edad: " + pa.getEdad()+"\n"+
                "Contacto: " + pa.getContacto()+"\n"+
                "Correo: " + pa.getEmail()+"\n"+
                "Discapacidad: " + pa.getDiscapacidad()+"\n"+
                "Vuelo: " + pa.getPasaje().getCodVuelo()+"\n"+
                "Pasaje: " + pa.getPasaje().getCodigoPS()+"\n"+
                "Asiento: " + pa.getPasaje().getCodAsiento()+"\n",
                "Aviso", 
                
                JOptionPane.INFORMATION_MESSAGE
                );
                return;
            }
        }
        JOptionPane.showMessageDialog(GestionV, "Pasajero no existente!","Aviso",JOptionPane.ERROR_MESSAGE);
    }

   
    
//reportes

//GRAFICO DE REPORTES:
    public void Graficos(){
        int cv = RV.tabla_vuelos.getRowCount();
        int cp = RP.tabla_pasajeros.getRowCount();
        int ca = RA.tabla_aviones.getRowCount();
        ER.initGraphics(cv, cp, ca);
        ER.txtvuelos.setText("Vuelos: "+String.valueOf(cv));
        ER.txtpasajeros.setText("Pasajeros: "+String.valueOf(cp));
        ER.txtaviones.setText("Aviones: "+String.valueOf(ca));
    }
    
    
    
//REPORTE PASAJEROS:    
    private void RPventana(){
        dash.showJPanel(RP);
        RP.listarUsuarios();
    }
    
    // REGISTRO DE NUEVOS USUARIOS
    private void registrarNuevoPasajero() {
        String nombre = nuevo_p.Nombrestxt.getText();
        String apellido = nuevo_p.Apellidostxt.getText();
        String contacto = nuevo_p.Contactotxt.getText();
        String email = nuevo_p.Emailtxt.getText();
        String documento = nuevo_p.Documentotxt.getText();
        
        if(nombre.isBlank()|| apellido.isBlank()|| contacto.isBlank()|| email.isBlank()|| documento.isBlank()|| nuevo_p.edadtxt.getText().isBlank()){
            JOptionPane.showMessageDialog(nuevo_p, "Porfavor llene los campos solicitados","Aviso", JOptionPane.ERROR_MESSAGE);
            nuevo_p.Nombrestxt.requestFocus();
            return;
        }
        
        if (!email.matches("^[A-Za-z0-9+#'!_.-]+@[A-Za-z0-9+#'!.-]+\\.[A-Za-z]+$")) {
            JOptionPane.showMessageDialog(Asignar_pi, "Ingrese correo válido","Aviso", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!nuevo_p.edadtxt.getText().matches("\\d+")) { // Verifica si el texto contiene solo dígitos
        JOptionPane.showMessageDialog(null, "Por favor, ingrese una edad válida (solo números).", "Error de entrada", 
                JOptionPane.ERROR_MESSAGE);
        return; 
        }
        int edad = Integer.parseInt(nuevo_p.edadtxt.getText());
        
        try {
            DAOPasajero dao = new DAOPasajeroIMPL();
            //Here Updating            
            //Updating verify of seems passengers
            List<Pasajeros> listPA = dao.listarPA(""); 
            for(Pasajeros pasajero: listPA){
                if(pasajero.getDocumentos().equalsIgnoreCase(documento)){
                    JOptionPane.showMessageDialog(null, "Yá existe un Pasajero con el mismo numero de Documento.", "Error de entrada", 
                    JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            RP.barra_busqueda.setText("");
            
            
            Pasajeros p = new Pasajeros(nombre, apellido, contacto, email, documento, edad);
            if(!nuevo_p.discapacidadtxt.getText().isBlank()){
            p.setDiscapacidad(nuevo_p.discapacidadtxt.getText());}
            
            
            
            dao.registrarPA(p);
            JOptionPane.showMessageDialog(nuevo_p, "Usuario Registrado Exitosamente","Aviso", JOptionPane.INFORMATION_MESSAGE);
            nuevo_p.Nombrestxt.setText("");
            nuevo_p.Apellidostxt.setText("");
            nuevo_p.Contactotxt.setText("");
            nuevo_p.Documentotxt.setText("");
            nuevo_p.Emailtxt.setText("");
            nuevo_p.discapacidadtxt.setText("");
            nuevo_p.edadtxt.setText("");
            RP.listarUsuarios();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(nuevo_p, "Ocurrió un problema al registrar el usuario","Aviso", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());   
        }
    }
    
    //ELIMINAR PASAJERO
    public void eliminarPasajero(){
        if(RP.tabla_pasajeros.getSelectedRows().length > 0){
            DAOPasajero dao = new DAOPasajeroIMPL();
            DefaultTableModel model = (DefaultTableModel) RP.tabla_pasajeros.getModel();
            for(int i : RP.tabla_pasajeros.getSelectedRows()){
                try {
                    dao.elminarPA((int) RP.tabla_pasajeros.getValueAt(i, 0));
                    model.removeRow(i);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }else{
            javax.swing.JOptionPane.showMessageDialog(RP, "Debes seleccionar almenos un Pasajero para eliminar.\n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    //APARICION DE LA VENTANA DE EDICION DE PASAJEROS
    private void editarPasajero() {
        if (RP.tabla_pasajeros.getSelectedRow() > -1) {
            try {
                dash.showJPanel(editar_p);
                int userId = (Integer) RP.tabla_pasajeros.getValueAt(RP.tabla_pasajeros.getSelectedRow(), 0);
                DAOPasajero dao = new DAOPasajeroIMPL();
                Pasajeros pa = dao.getPasajerobyId(userId);
                
                // Rellenar los campos del formulario con los datos del pasajero
                editar_p.Nombrestxt.setText(pa.getNombre());
                editar_p.Apellidostxt.setText(pa.getApellido());
                editar_p.Edadtxt.setText(String.valueOf(pa.getEdad()));
                editar_p.Documentotxt.setText(pa.getDocumentos());
                editar_p.Contactotxt.setText(pa.getContacto());
                editar_p.Emailtxt.setText(pa.getEmail());
                if(pa.getDiscapacidad() == null){ pa.setDiscapacidad("N/A");}
                editar_p.Discapacidadtxt.setText(pa.getDiscapacidad().equals("N/A")? "" : pa.getDiscapacidad());
                editar_p.idPasajero = pa.getIdcliente();
                
            } catch (SQLException e) {
                // Manejar específicamente errores de la base de datos
                System.out.println("Error de base de datos: " + e.getMessage());
                javax.swing.JOptionPane.showMessageDialog(RP, "Ocurrió un error al acceder a la base de datos.\n", "Error", 
                        javax.swing.JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException e) {
                // Manejar específicamente errores de formato de número
                System.out.println("Error de formato: " + e.getMessage());
                javax.swing.JOptionPane.showMessageDialog(RP, "Ocurrió un error al procesar el número de identificación.\n", "Error", 
                        javax.swing.JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                // Manejar otros tipos de excepciones
                System.out.println("Error inesperado: " + e.getMessage());
                javax.swing.JOptionPane.showMessageDialog(RP, "Ocurrió un error inesperado.\n", "Error", 
                        javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(RP, "Debes seleccionar al menos un pasajero para editar.\n", 
                    "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //BOTON DE ACTUALIZACION PARA EDITAR PASAJEROS:
    private void actualizarPasajero(){
        String nombre = editar_p.Nombrestxt.getText();
        String apellido = editar_p.Apellidostxt.getText();
        String contacto = editar_p.Contactotxt.getText();
        String email = editar_p.Emailtxt.getText();
        String documento = editar_p.Documentotxt.getText();
        
        if(nombre.isBlank()|| apellido.isBlank()|| contacto.isBlank()|| email.isBlank()|| documento.isBlank()|| editar_p.Edadtxt.getText().isBlank()){
            JOptionPane.showMessageDialog(editar_p, "Porfavor llene los campos solicitados","Aviso", JOptionPane.ERROR_MESSAGE);
            editar_p.Nombrestxt.requestFocus();
            return;
        }
        if (!email.matches("^[A-Za-z0-9+#'!_.-]+@[A-Za-z0-9+#'!.-]+\\.[A-Za-z]+$")) {
            JOptionPane.showMessageDialog(Asignar_pi, "Ingrese correo válido","Aviso", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!editar_p.Edadtxt.getText().matches("\\d+")) { // Verifica si el texto contiene solo dígitos
        JOptionPane.showMessageDialog(null, "Por favor, ingrese una edad válida (solo números).", "Error de entrada", JOptionPane.ERROR_MESSAGE);
        return; 
        }
        int edad = Integer.parseInt(editar_p.Edadtxt.getText());
        
        try {
            DAOPasajero dao = new DAOPasajeroIMPL();
            Pasajeros p = dao.getPasajerobyId(editar_p.idPasajero);
            //Here Updating            
            //Updating verify of seems passengers
            List<Pasajeros> listPA = dao.listarPA(""); 
            for(Pasajeros pasajero: listPA){
                if(pasajero.getDocumentos().equalsIgnoreCase(documento) && !p.getDocumentos().equalsIgnoreCase(pasajero.getDocumentos())){
                    JOptionPane.showMessageDialog(null, "Yá existe un Pasajero con el mismo numero de Documento.", "Error de entrada", 
                    JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            RP.barra_busqueda.setText("");
            
            
            p.setNombre(nombre);
            p.setApellido(apellido);
            p.setContacto(contacto);
            p.setEmail(email);
            p.setDocumentos(documento);
            p.setEdad(edad);
            p.setIdcliente(editar_p.idPasajero);
            if(!editar_p.Discapacidadtxt.getText().isBlank()){
                p.setDiscapacidad(editar_p.Discapacidadtxt.getText());}
            else{
                p.setDiscapacidad(null);}
            dao.modificarPA(p);
            JOptionPane.showMessageDialog(editar_p, "Uusario Editado Exitosamente","Aviso", JOptionPane.INFORMATION_MESSAGE);
            RP.listarUsuarios();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(editar_p, "Ocurrió un problema al registrar el usuario","Aviso", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());   
        }
    }
    
    //BUSQUEDA POR NOMBRE DE PASAJEROS
    public void buscarPasajero(){
        RP.listarUsuarios();
    }
    
    //ASIGNAR PASAJE AL PASAJERO
    private void asignarPasaje() {
        dash.showJPanel(AsignarPasaje);
    }
        //BOTON REGISTRO DEL PASAJE
        public void btAPASAJE(){
            String codP = AsignarPasaje.txt_codigo.getText();
            String vuelo = AsignarPasaje.txt_vuelo.getText();
            String asiento = AsignarPasaje.txt_asiento.getText();
            int idP = editar_p.idPasajero;
            Pasaje pasaje = new Pasaje();
            pasaje.setIdPasajero(idP);
            pasaje.setCodigoPS(codP);
            pasaje.setCodVuelo(vuelo);
            pasaje.setCodAsiento(asiento);
            DAOPasaje dao = new DAOPasajeIMPL();
            DAOPasajero daop = new DAOPasajeroIMPL();
            DAOVuelos daov = new DAOVuelosIMPL();
            
        try {
            boolean verify = false;
            for(Vuelos vu : daov.listarVU("")){
                if(vu.getCodigo().equalsIgnoreCase(vuelo)){
                    verify = true;
                }
            }
            
            //Verifying passages with the same code
            //Updating verify of seems planes
            List<Pasaje> listPAS = dao.listarPasaje(""); 
            for(Pasaje pas : listPAS){
                if(pas.getCodigoPS().equalsIgnoreCase(codP)){
                    JOptionPane.showMessageDialog(null, "Yá existe un Pasaje con el mismo Código registrado.", "Error de entrada", 
                    JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
            //Verifying if there are any fly with the code registered 
            if(!verify){
                JOptionPane.showMessageDialog(AsignarPasaje, "No existe ni un vuelo con el codigo "+vuelo, "Error de entrada", 
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            List<Pasaje> listPas = dao.listarPasaje(vuelo);
                        
            //Veryfying if the seat in the fly is bussy
            if(!listPas.isEmpty()){
                for(Pasaje ps : listPas){
                        if(ps.getCodAsiento().equalsIgnoreCase(asiento)){
                            JOptionPane.showMessageDialog(AsignarPasaje, "Asiento ya ocupado en el vuelo "+vuelo, "Error de entrada", 
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                }
            }

            //Veryfing if the passenger already had a passage
            if(daop.getPasajerobyId(idP).getPasaje()!=null){
                dao.eliminarPasaje(daop.getPasajerobyId(idP).getPasaje().getIdPasaje());
            }
            
            Pasajeros pasajero = daop.getPasajerobyId(idP);
            
            dao.registrarPasaje(pasaje);
           
            pasajero.setPasaje(dao.getPasajebyCode(codP));
            daop.modificarPA(pasajero);
            JOptionPane.showMessageDialog(AsignarPasaje, "Pasaje agregado Exitosamente","Aviso", JOptionPane.INFORMATION_MESSAGE);            
            AsignarPasaje.txt_asiento.setText("");
            AsignarPasaje.txt_codigo.setText("");
            AsignarPasaje.txt_vuelo.setText("");
            
            RP.listarUsuarios();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(AsignarPasaje, "El Pasaje ya existe en la Base de datos","Aviso", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.getMessage());}
        }

    
//REPORTE AVIONES
    private void RAventana(){
        RA.listarAviones();
        dash.showJPanel(RA);
    }
    private void nuevoaVentana(){
        nuevo_a.InitRegister();
        dash.showJPanel(nuevo_a);
    }
    
    //BOTON REGISTRAR O ACTUALIZAR
    private void registrarNuevoAvion(){
        String nombre = nuevo_a.nametxt.getText();
        String placa = nuevo_a.placatxt.getText();
        String falla = nuevo_a.fallatxt.getText();
        String totalpasajeros = nuevo_a.totalpasajerostxt.getText();
        
        if(nombre.isBlank()|| placa.isBlank()|| totalpasajeros.isBlank()){
            JOptionPane.showMessageDialog(nuevo_a, "Porfavor llene los campos solicitados","Aviso", JOptionPane.ERROR_MESSAGE);
            nuevo_a.nametxt.requestFocus();
            return;
        }
        
        if (!nuevo_a.totalpasajerostxt.getText().matches("\\d+")) { // Verifica si el texto contiene solo dígitos
            JOptionPane.showMessageDialog(null, "Por favor, ingrese una cantidad apropiada (solo números).", "Error de entrada",
            JOptionPane.ERROR_MESSAGE);
        return; 
        }
        
        int cantidadp = Integer.parseInt(nuevo_a.totalpasajerostxt.getText());
        
        try {
            DAOAviones dao = new DAOAvionesIMPL();
            
            //Updating verify of seems planes
            List<Avion> listAV = dao.listarAV(""); 
            for(Avion avion : listAV){
                if(avion.getPlaca().strip().equalsIgnoreCase(placa.strip())){
                    if(nuevo_a.isEdition){
                       if(!nuevo_a.avionEdition.getPlaca().strip().equalsIgnoreCase(avion.getPlaca().strip())){
                           JOptionPane.showMessageDialog(null, "Yá existe un Avion con el mismo numero de Placa yá registrado.", "Error de entrada", 
                    JOptionPane.ERROR_MESSAGE);
                        return;
                       }
                    }else{
                        JOptionPane.showMessageDialog(null, "Yá existe un Avion con el mismo numero de Placa yá registrado.", "Error de entrada", 
                    JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }
            
            
            RA.barra_busqueda.setText("");
            
            Avion a =  nuevo_a.isEdition ? nuevo_a.avionEdition : new Avion();
            a.setNombre(nombre);
            a.setPlaca(placa);
            a.setFalla(falla);
            a.setCantpasajerosmax(cantidadp);
            if(nuevo_a.isEdition){
                dao.modificarAV(a);
            }else{ dao.registrarAV(a); 
                nuevo_a.nametxt.setText("");
                nuevo_a.placatxt.setText("");
                nuevo_a.fallatxt.setText("");
                nuevo_a.totalpasajerostxt.setText("");
                
            }            
            String succesMessage = nuevo_a.isEdition ? "Editado" : "Registrado";
            JOptionPane.showMessageDialog(nuevo_a, "Avion "+succesMessage+" Exitosamente","Aviso", JOptionPane.INFORMATION_MESSAGE);
            
            RA.listarAviones();
        } catch (Exception e) {                        
            String errorMessage = nuevo_a.isEdition ? "Editado" : "Registrado";
            JOptionPane.showMessageDialog(nuevo_a, "Ocurrió un problema al "+errorMessage+" el avion","Aviso", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());   
        }
    }
    
    public void eliminarAvion(){
        if(RA.tabla_aviones.getSelectedRows().length > 0){
            DAOAviones dao = new DAOAvionesIMPL();
            DefaultTableModel model = (DefaultTableModel) RA.tabla_aviones.getModel();
            for(int i : RA.tabla_aviones.getSelectedRows()){
                try {
                    dao.elminarAV((int) RA.tabla_aviones.getValueAt(i, 0));
                    model.removeRow(i);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }else{
            javax.swing.JOptionPane.showMessageDialog(null, "Debes seleccionar almenos un Avion para eliminar.\n", "AVISO", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    
    public void editarAvion(){
            if(RA.tabla_aviones.getSelectedRows().length > 0){
                try {
                    DAOAviones dao = new DAOAvionesIMPL();
                    int avid = (int )RA.tabla_aviones.getValueAt(RA.tabla_aviones.getSelectedRow(), 0);
                    nuevo_a.InitEdition(dao.getAvionbyId(avid));
                    dash.showJPanel(nuevo_a);
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }else{
                javax.swing.JOptionPane.showMessageDialog(null, "Debes seleccionar almenos un Avion para editar.\n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
            }         
    }
    
    public void buscarAvion(){
            RA.listarAviones();
    }
    
    
    
//REPORTE VUELOS
private void RVventana(){
        RV.listarVuelos();
        dash.showJPanel(RV);
    }
private void nuevovVentana(){
           nuevo_v.InitRegister();
           dash.showJPanel(nuevo_v);
    }
    //BUTTON REGISTRO DE NUEVO VUELO
    public void registrarNuevoVuelo(){
        
        String codigo = nuevo_v.txtcodigo.getText();
        String Estado = nuevo_v.txtestado.getText();
        String Destino  = nuevo_v.txtdestino.getText();
        String Origen = nuevo_v.txtorigen.getText();
        String fecha = nuevo_v.txtfecha.getText();
        String horallegada = nuevo_v.txthoraLlegada.getText();
        String horasalida= nuevo_v.txthoraSalida.getText();
        
        if (!fecha.matches("\\d{4}[-/]\\d{2}[-/]\\d{2}") && !fecha.matches("\\d{2}[-/]\\d{2}[-/]\\d{4}")) {
            JOptionPane.showMessageDialog(nuevo_v, "Formato de fecha inválido. Usa YYYY-MM-DD, DD/MM/YYYY, o YYYY/MM/DD", "Error", JOptionPane.ERROR_MESSAGE);
            nuevo_v.txtfecha.requestFocus();
            return;
        }
        
        // Verificar que ciertos campos no contengan letras
        if ((!horallegada.matches("\\d{2}:\\d{2}(:\\d{2}(\\.\\d{1,7})?)?") && !horallegada.matches("\\d{2}:\\d{2}")) || 
            (!horasalida.matches("\\d{2}:\\d{2}(:\\d{2}(\\.\\d{1,7})?)?") && !horasalida.matches("\\d{2}:\\d{2}"))) {
            JOptionPane.showMessageDialog(nuevo_v, "Formato de fecha u hora inválido (Hora: 00:00 | Fecha DD.MM-YYYY)", "Aviso", JOptionPane.ERROR_MESSAGE);
            nuevo_v.txtfecha.requestFocus();
            return;
        }

        // Verificar que los campos "Destino" y "Origen" no contengan números
        if (!Destino.matches("[a-zA-Z1-9\\s\\-]+") || !Origen.matches("[a-zA-Z1-9\\s\\-]+")) {
            JOptionPane.showMessageDialog(nuevo_v, "Destino y Origen no deben contener simbolos o tildes", "Aviso", JOptionPane.ERROR_MESSAGE);
            nuevo_v.txtdestino.requestFocus();
            return;
        }
        
        try {            
            DAOVuelos dao = new DAOVuelosIMPL();

            //Updating verify of seems planes
            List<Vuelos> listVU = dao.listarVU(""); 
            for(Vuelos vuelo: listVU){
                if(vuelo.getCodigo().strip().equalsIgnoreCase(codigo.strip())){
                    if(nuevo_v.isEdition){
                        if(!nuevo_v.vueloEdition.getCodigo().strip().equalsIgnoreCase(codigo.strip())){
                            JOptionPane.showMessageDialog(null, "Yá existe un vuelo con el mismo Código yá registrado.", "Error de entrada", 
                            JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Yá existe un vuelo con el mismo Código yá registrado.", "Error de entrada", 
                        JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }
            
            RV.barra_busqueda.setText("");
             
            Vuelos v =  nuevo_v.isEdition ? nuevo_v.vueloEdition : new Vuelos();
            v.setCodigo(codigo);
            v.setEstado(Estado);
            v.setDestino(Destino);
            v.setOrigen(Origen);
            v.setHorallegada(horallegada);
            v.setHorasalida(horasalida);
            v.setFecha(fecha);
            
            if(nuevo_v.isEdition){
                dao.modificarVU(v);
            }else{ dao.registrarVU(v); 
                nuevo_v.txtcodigo.setText("");
                nuevo_v.txtestado.setText("");
                nuevo_v.txtdestino.setText("");
                nuevo_v.txtorigen.setText("");
                nuevo_v.txtfecha.setText("");
                nuevo_v.txthoraLlegada.setText("");
                nuevo_v.txthoraSalida.setText("");
            }
            
            
            String succesMessage = nuevo_v.isEdition ? "Editado" : "Registrado";
            JOptionPane.showMessageDialog(nuevo_v, "Vuelo "+succesMessage+" Exitosamente","Aviso", JOptionPane.INFORMATION_MESSAGE);
            
            RV.listarVuelos();
        } catch (Exception e) {                        
            String errorMessage = nuevo_v.isEdition ? "Editado" : "Registrado";
            JOptionPane.showMessageDialog(nuevo_v, "Ocurrió un problema al "+errorMessage+" el vuelo","Aviso", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());   
        }
    }
    
    public void eliminarVuelo(){
        if(RV.tabla_vuelos.getSelectedRows().length > 0){
            DAOVuelos dao = new DAOVuelosIMPL();
            DefaultTableModel model = (DefaultTableModel) RV.tabla_vuelos.getModel();
            for(int i : RV.tabla_vuelos.getSelectedRows()){
                try {
                    dao.elminarVU((int) RV.tabla_vuelos.getValueAt(i, 0));
                    model.removeRow(i);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }else{
            javax.swing.JOptionPane.showMessageDialog(null, "Debes seleccionar almenos un Vuelo para eliminar.\n", "AVISO", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    //Aparación de la ventana de edicíon
    public void editarVuelo(){
            if(RV.tabla_vuelos.getSelectedRows().length > 0){
                try {
                    DAOVuelos dao = new DAOVuelosIMPL();
                    int vueloid = (int )RV.tabla_vuelos.getValueAt(RV.tabla_vuelos.getSelectedRow(), 0);
                    nuevo_v.InitEdition(dao.getVuelobyId(vueloid));
                    dash.showJPanel(nuevo_v);
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }else{
                javax.swing.JOptionPane.showMessageDialog(null, "Debes seleccionar almenos un Vuelo para editar.\n", "AVISO", 
                        javax.swing.JOptionPane.ERROR_MESSAGE);
            }         
    }
    
    public void buscarVuelo(){
            RV.listarVuelos();
    }
}    
