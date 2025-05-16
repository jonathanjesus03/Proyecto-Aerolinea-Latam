/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELS;

import java.util.Scanner;
import java.time.LocalDate;//Importamos localdate para obtener la fecha actual
import java.time.format.DateTimeFormatter;//Importamos DateTimeFormatter para formatear la fecha.

/**
 *
 * @author cr075
 */
public class PROYECTO {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        //intanciar
        //clase nombre=new clase();

        //DefinirVuelos DefinirVu=new DefinirVuelos();
        int opcion;
        int[][] vuelos = {{11, 24, 30}, {32, 40, 20}, {20, 25, 12}};
        String[] lugar = {"0\tRio de Janeiro", "1\tCancún", "2\tMadrid"};
        String menu = """
                    |||||||||||||||||||||||AEROLINE|||||||||||||||||||||||
                    |               MENU DE OPCIONES                     |
                    |[1] Definir Vuelos                                  |
                    |[2] Ventas                                          |
                    |[3] MALETAS                                         |
                    |[4] PERMISOS                                        |
                    |[5] REPORTES                                        |
                    |[6] SALIR DEL PROGRAMA                              |                  
                    ||||||||||||||||||||||||||||||||||||||||||||||||||||||
                    """;
        do {

            System.out.print(menu);
            System.out.println("Ingrese la opcion");
            opcion = lector.nextInt();

            String variable = "";
            switch (opcion) {
                case 1 -> {
                    // llamar los metodos de las clases
                    System.out.println("Registrando definir vuelos...");
                    String tabladevuelos = """
                                ****************************TABLA DE VUELOS*********************
                                                                    0           1           2
                                                     \t\tMAÑANA\t    TARDE\t   NOCHE 
                                """;
                    System.out.print(tabladevuelos);
                    for (int i = 0; i < vuelos.length; i++) {
                        System.out.printf("%20s\t", lugar[i]);
                        for (int j = 0; j < vuelos[0].length; j++) {
                            System.out.printf("\t%2d\t", vuelos[i][j]);
                            //se va estar imprimiendo los asientos de los vuelos correspondientes 
                            //de acuerdo a las veces que se está reservando se va imprimiendo los asientos disponiblesnque quedan. 
                        }
                        System.out.println();
                    }
                    System.out.println("***************************************************************");
                    int destino, horario, asientos;
                    System.out.println("Ingrese el numero de destino: ");
                    destino = lector.nextInt();
                    System.out.println("Ingrese el horario: ");
                    horario = lector.nextInt();
                    System.out.println("Ingrese el numero de asientos: ");
                    asientos = lector.nextInt();
                    if (destino >= 0 && destino <= 2) {
                        if (horario >= 0 && horario <= 2) {
                            if (vuelos[destino][horario] >= asientos) {
                                System.out.println("Su reserva fue realizada con éxito");
                                vuelos[destino][horario] = vuelos[destino][horario] - asientos;
                                System.out.println("#########REPORTE DE VUELOS#############");
                                System.out.println("Destino\tHorario\t#Asientos\n");
                                System.out.printf("%d\t%d\t%d\n", destino, horario, asientos);
                                System.out.println("#######################################");
                            } else {
                                System.out.println("Disculpe, no se puedo completar su operación dado que no hay asientos disponibles");
                            }
                        } else {
                            System.out.println("Ingrese valores de horario entre 0 y 2");
                        }
                    } else {
                        System.out.println("Ingrese valores de destino entre 0 y 2");
                    }
                }
                case 2 -> {
                    System.out.println("Registrando ventas...");
                    LocalDate fechaActual = LocalDate.now();
                    DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String fechaFormateada = fechaActual.format(formateador);
                    String[] clicont = new String[15];
                    String[][] destpreo = new String[15][2];
                    double[] cantidad = new double[15];
                    int contadordeclientes = 0, contadordereservas = 0;
                    String tabladeprecios = """
                                          **************T**ABLA DE PRECIOS****************
                                                          Económica Ejecutiva PrimeraClase
                                          Rio de Janeiro    S/120    S/190      S/350
                                          Cancún            S/200    S/300      S/600
                                          Madrid            S/550    S/700      S/1000 
                                          ************************************************
                                          """;
                    String impresion1 = """
                                #########################################################################
                                                       BOLETO                       FECHA:%s          
                                #########################################################################
                                NombreCliente\t  Contacto\t  Destino\t  Precio\t  Cantidad
                                #########################################################################
                                """;
                    lector.nextLine();
                    while (!variable.equals("finish")) {
                        if (contadordeclientes < clicont.length) {
                            System.out.println("Ingrese el nombre del cliente:");
                            String nombrec = lector.nextLine();
                            System.out.println("Ingrese el contacto del cliente:");
                            String contacto = lector.nextLine();
                            clicont[contadordeclientes] = nombrec + " , " + contacto;
                            contadordeclientes++;
                            System.out.println("Cliente registrado con éxito");
                        } else {
                            System.out.println("Se ha alcanzado el limite de clientes registradas.");
                        }

                        if (contadordereservas < destpreo.length) {
                            System.out.print(tabladeprecios);
                            System.out.println("Ingrese el destino del viaje:");
                            String destino = lector.nextLine();
                            System.out.println("Ingrese el precio de acuerdo a las tres clases de vuelo:");
                            String precio = lector.nextLine();
                            System.out.println("Ingrese la cantidad de los pasajes");
                            cantidad[contadordereservas] = lector.nextDouble();
                            destpreo[contadordereservas][0] = destino;
                            destpreo[contadordereservas][1] = precio;
                            contadordereservas++;
                            System.out.println("Destino y precio registrado con éxito");
                        } else {
                            System.out.println("Se ha alcanzado el limite de  ventas por cliente registradas.");
                        }
                        lector.nextLine();
                        System.out.println("¿Desea terminar la venta/reserva? coloque finish para terminar");
                        variable = lector.nextLine();
                    }
                    System.out.printf(impresion1, fechaFormateada);
                    double ingresos, totalingresos = 0;

                    for (int i = 0; i < contadordeclientes; i++) {
                        String[] infocliente = clicont[i].split(",");
                        double precio = Double.parseDouble(destpreo[i][1]);
                        ingresos = precio * cantidad[i];
                        totalingresos += ingresos;
                        System.out.printf("# %-10s\t%-10s\t%-12s\t$%-4f\t%.2f\t #%n", infocliente[0], infocliente[1], destpreo[i][0], precio, cantidad[i]);
                        System.out.println("#                                         #");
                    }
                    System.out.printf("""
                                       #########################################################################
                                       Total: $%.2f
                                       #########################################################################
                                       """, totalingresos);
                }
            }
        } while (opcion != 6);
    }
}  
    
