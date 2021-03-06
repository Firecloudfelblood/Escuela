package com.erivalaxl;

import com.erivalaxl.utils.AppUtils;
import com.erivalaxl.utils.MotorInsertar;

import java.sql.SQLException;
import java.util.Scanner;

public class Menus {
    /***
     * presenta el menu principal
     */
    public void menuPrincipal() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String respuesta ="";
        boolean esNumero = false;
        do {
            System.out.println("******************************************************");
            System.out.println("* Hola bienvenido a mi aplicacion de control escolar *");
            System.out.println("******************************************************");
            System.out.println("* Elige el numero de la opcion                       *");
            System.out.println("******************************************************");
            System.out.println("                    1.- Agregar                       ");
            System.out.println("                    2.- Listar                        ");
            System.out.println("                    3.- Actualizar                    ");
            System.out.println("                    4.- Eliminar                      ");
            System.out.println("                    5.- Salir                         ");
            do {//en caso de introducir un valor no esperado continuo el ciclo hasta recibir una opcion valida

                    respuesta = scanner.nextLine();
                   esNumero = MotorInsertar.esNumero(respuesta);
            }while(!esNumero);// valido que la opcion introducida sea un numero valido
            AppUtils.opcionElegida(respuesta);
        } while (!respuesta.equals("5"));

    }



}
