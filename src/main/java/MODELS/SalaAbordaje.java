/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELS;

import java.util.ArrayList;

/**
 *
 * @author Samsung
 */
public class SalaAbordaje {
    private ArrayList<Vuelos> listavuelos;
    
    public SalaAbordaje(){}
      
        //Esto no ah sido definido en la GUI pero es un metodo util para verificar los objetos de la clase Tripulacion en un vuelo
        public boolean VerificarTripulación(String refvuelo, Tripulacion tripulacion){
        boolean bool=false;
        boolean vuel=false;
        for(int i=0;i<listavuelos.size();i++){
            
            if(listavuelos.get(i).getCodigo().equalsIgnoreCase(refvuelo)){
               vuel=true;
               if( listavuelos.get(i).getTripulacion().getIdtripulacion() == (tripulacion.getIdtripulacion())){
                   bool = true;
               }else{System.out.println("[!] Tripulacion ingresada no registrada en el vuelo especificado");}
               break;
            }
        }
        if(!vuel){System.err.println("[!] No se logro encontrar un vuelo con la referencia del codigo de vuelo ingresado");}
        return bool;
        }    
    
        //Verificación de los pilotos en un vuelo por el codigo
        public boolean VerificarTripulacionCodigo(String refvuelo, String codigo){
        boolean bool=false;
        boolean vuel=false;
            for(int i = 0; i<listavuelos.size();i++){
                if(listavuelos.get(i).getCodigo().equalsIgnoreCase(codigo)){
                   
                    vuel=true;
                    ArrayList<Piloto> listp = listavuelos.get(i).getTripulacion().getListaPiloto();
                    for(int e=0; e<listp.size(); e++){
                        if(listp.get(e).getCodigo().equalsIgnoreCase(codigo)){
                            bool=true;
                            break;
                        }
                    }
                    if(!bool){System.out.println("[!] Codigo de Piloto no registrado");}
                    break;
                }
            }
            if(!vuel){System.err.println("[!] No se logro encontrar un vuelo con la referencia del codigo de vuelo ingresado");}
            return bool;
        }
        
        //Verificación de los pilotos en un vuelo por el nombre
        public boolean VerificarTripulacionNombre(String refvuelo, String nombrec){
        boolean bool=false;
        boolean vuel=false;
            for(int i = 0; i<listavuelos.size();i++){
                if(listavuelos.get(i).getCodigo().equalsIgnoreCase(refvuelo)){
                    
                    vuel=true;
                    ArrayList<Piloto> listp = listavuelos.get(i).getTripulacion().getListaPiloto();
                    for(int e=0; e<listp.size(); e++){
                        String pnombrec = listp.get(e).getNombre().trim()+" "+listp.get(e).getApellido().trim(); 
                        if(pnombrec.equalsIgnoreCase(nombrec.trim())){
                            bool=true;
                            break;
                        }
                    }
                    if(!bool){System.out.println("[!]El nombre ingresado no pertenece a ni un piloto");}
                    break;
                }
            }
            if(!vuel){System.err.println("[!]No se logro encontrar un vuelo con la referencia del codigo de vuelo ingresado");}
            return bool;
        }
        
        //Verificación de las Aazafatas en un vuelo por el codigo
        public boolean VerificarAzafatasCodigo(String refvuelo, String codigo){
        boolean bool=false;
        boolean vuel=false;
            for(int i = 0; i<listavuelos.size();i++){
                if(listavuelos.get(i).getCodigo().equalsIgnoreCase(refvuelo)){
                    
                    vuel=true;
                    ArrayList<Azafata> lista = listavuelos.get(i).getTripulacion().getListaAzafata();
                    for(int e=0; e<lista.size(); e++){
                        if(lista.get(e).getCodigo().equalsIgnoreCase(codigo)){
                            bool=true;
                            break;
                        }
                    }
                    if(!bool){System.out.println("[!] Codigo de Azafata no registrado");}
                    break;
                } 
            }
            if(!vuel){System.err.println("[!]No se logro encontrar un vuelo con la referencia del codigo de vuelo ingresado");}
            return bool;
        }
        
        
        //Verificación de las Azafatas en un vuelo por el nombre
        public boolean VerificarAzafatasNombre(String refvuelo, String nombrec){
        boolean bool=false;
        boolean vuel=false;
            for(int i = 0; i<listavuelos.size();i++){
                if(listavuelos.get(i).getCodigo().equalsIgnoreCase(refvuelo)){
                    
                    vuel=true;
                    ArrayList<Azafata> lista = listavuelos.get(i).getTripulacion().getListaAzafata();
                    for(int e=0; e<lista.size(); e++){
                        String pnombrec = lista.get(e).getNombre().trim()+" "+lista.get(e).getApellido().trim(); 
                        if(pnombrec.equalsIgnoreCase(nombrec.trim())){
                        bool=true;
                            break;
                        }
                    }
                    if(!bool){System.out.println("[!]El nombre ingresado no pertenece a ni una Azafata");}
                    break;
                }
            }
            if(!vuel){System.err.println("[!]No se logro encontrar un vuelo con la referencia del codigo de vuelo ingresado");}
            return bool;
        }
        
        
        public int VerificarDisponibilidadSillas(String refvuelo){
        int sillasd=0;
        
        for(int i = 0; i<listavuelos.size();i++){
            if(listavuelos.get(i).getCodigo().equalsIgnoreCase(refvuelo)){
                int asientosmax = listavuelos.get(i).getAvion().getCantpasajerosmax();
                int pasajeros = listavuelos.get(i).getListaPasajeros().size();
                int azafatas = listavuelos.get(i).getTripulacion().getListaAzafata().size();
                int pilotos = listavuelos.get(i).getTripulacion().getListaPiloto().size();
                sillasd = asientosmax - pasajeros - azafatas - pilotos;
                break;
            }
        }
        return sillasd;
        }
        
        public ArrayList<Integer> VerificarServiciosEspeciales(String refvuelo){
        ArrayList<Integer> listasv = new ArrayList<>();
            for(int i = 0; i<listavuelos.size();i++){
                if(listavuelos.get(i).getCodigo().equalsIgnoreCase(refvuelo)){
                    int m=0,mc=0,sr=0;
                    ArrayList<Pasajeros> listpa = listavuelos.get(i).getListaPasajeros();
                    for(int e = 0; e<listpa.size();e++){
                        if(listpa.get(e).getServicioEspeciales()!= null){ m+=1; }
                        //if(listpa.get(e).getMascota() != null){ m+=1; }
                        //if(listpa.get(e).getMascotacabina()!= null){ mc+=1;}
                        //if(listpa.get(e).getSillaRuedas()!= null){ sr+=1;}
                    }
                    listasv.add(0,m);
                    break;
                }
            }
        return listasv;
        }
        
    
}

