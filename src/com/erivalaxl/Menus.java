package com.erivalaxl;

import java.util.Scanner;

public class Menus {
    public void menuPrincipal(){
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
            do {
                try {
                    respuesta = scanner.nextLine();
                    Integer.parseInt(respuesta);
                    esNumero =true;
                }catch(NumberFormatException e){
                    esNumero = false;
                }
            }while(!esNumero);
            
        } while (!respuesta.equals("5"));

    }



}
