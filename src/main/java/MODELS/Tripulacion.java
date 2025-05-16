/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELS;

import java.util.ArrayList;

/**
 *
 * @author cr075
 */
public class Tripulacion {
  private int idtripulacion;
  private ArrayList<Azafata> ListaAzafata;
  private ArrayList<Piloto> ListaPiloto;

    public Tripulacion() {
        ListaAzafata= new ArrayList();
        ListaPiloto= new ArrayList();
    }

    public Tripulacion(int idtripulacion) {
        this.idtripulacion=idtripulacion;
        ListaAzafata= new ArrayList();
        ListaPiloto= new ArrayList();
    }

    public ArrayList<Azafata> getListaAzafata() {
        return ListaAzafata;
    }

    public void setListaAzafata(ArrayList<Azafata> ListaAzafata) {
        this.ListaAzafata = ListaAzafata;
    }

    public ArrayList<Piloto> getListaPiloto() {
        return ListaPiloto;
    }

    public void setListaPiloto(ArrayList<Piloto> ListaPiloto) {
        this.ListaPiloto = ListaPiloto;
    }
    
    
   
    public void agregarAzafata(Azafata azafata){
        ListaAzafata.add(azafata);
    }
    
    public void agregarPiloto(Piloto piloto){
        ListaPiloto.add(piloto);
    }

    public int getIdtripulacion() {
        return idtripulacion;
    }

    public void setIdtripulacion(int idtripulacion) {
        this.idtripulacion = idtripulacion;
    }
    
    
   
  public void MostrarInformacionTripulacion(){
        System.out.println("Informacion de Los Tripulantes: ");
        for (int i = 0; i < ListaAzafata.size(); i++) {
            System.out.println("Azafata: " + ListaAzafata.get(i).getCodigo());
            System.out.println(ListaAzafata.get(i).getId());
            System.out.println(ListaAzafata.get(i).getNombre());
            System.out.println(ListaAzafata.get(i).getEdad());
            System.out.println(ListaAzafata.get(i).getJerarquia());
            System.out.println(ListaAzafata.get(i).getJerarquia()+"\n");
        }
        for (int i = 0; i < ListaPiloto.size(); i++) {
            System.out.println("Piloto: " + ListaPiloto.get(i).getCodigo());
            System.out.println(ListaPiloto.get(i).getId());
            System.out.println(ListaPiloto.get(i).getNombre());
            System.out.println(ListaPiloto.get(i).getEdad());
            System.out.println(ListaPiloto.get(i).getJerarquia());
            System.out.println(ListaPiloto.get(i).getJerarquia()+"\n");
        }
    }
   
    public Azafata obtenerAzafata(int index){
        if(index>=0 && index < ListaAzafata.size()){
           return ListaAzafata.get(index);
        }
        else{
            return null;
        }
    } 
    
     public Piloto obtenerPiloto(int index){
        if(index>=0 && index < ListaPiloto.size()){
           return ListaPiloto.get(index);
        }
        else{
            return null;
        }
    }
     
    public int TotalTripulantes(){
        return ListaAzafata.size() + ListaPiloto.size();
    }
}
