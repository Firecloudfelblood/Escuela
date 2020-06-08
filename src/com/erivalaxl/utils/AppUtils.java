package com.erivalaxl.utils;


import com.erivalaxl.db.ConnectionFactory;
import com.erivalaxl.model.Alumno;

import java.lang.reflect.Array;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.erivalaxl.utils.MotorInsertar.*;

public class AppUtils {

    public static void opcionElegida(String opcionElegida) throws SQLException {
        switch(opcionElegida){
            case "1": {updateQueriesExecution("insert into alumnos(nombre, email, edad, genero) values(?, ?, ?, ?);",
                    pedirValoresQuery("delete", 4), "delete");}break;
            case "2": {Listar();}break;
            case "3": {updateQueriesExecution("",
                    pedirValoresQuery("update",4), "update");}break;
            case "4": {updateQueriesExecution("DELETE FROM alumnos WHERE id=?",
                    pedirValoresQuery("delete", 1), "delete");}break;
            case "5": break;
            default: {
                System.out.println("Valor fuera del rango intenta de nuevo");
            }break;
        }
    }

    private static void Actualizar() {
        System.out.println("Actualizar");
    }


    public static ArrayList<String>  pedirValoresQuery(String operacion, int numeroParametros){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> parametros = new ArrayList<>();
        System.out.println("Dame los " + numeroParametros + " parametros para poder realizar la operacion " + operacion);
        numeroParametros = scanner.nextInt();
        for (int i = 0; i < numeroParametros; i++) {
            System.out.println("introduce el parametro");
            parametros.add(scanner.next());
        }

    return parametros;
    }
}
