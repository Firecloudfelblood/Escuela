package com.erivalaxl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Menus menu = new Menus();
        try {
            menu.menuPrincipal();
        }catch (SQLException e){
            System.err.println("Base de datos no disponible por el momento por vafor intenta mas tarde");
        }
        System.out.println(" Gracias por usar mi aplicacion! :) ");

    }
}
