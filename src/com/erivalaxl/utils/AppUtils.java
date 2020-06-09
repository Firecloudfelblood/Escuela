package com.erivalaxl.utils;


import com.erivalaxl.db.ConnectionFactory;
import com.erivalaxl.model.Alumno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.erivalaxl.utils.MotorInsertar.*;

public class AppUtils {

    public static void opcionElegida(String opcionElegida) throws SQLException {
        switch(opcionElegida){
            case "1": {
                        updateQueriesExecution("insert into alumnos(nombre, email, edad, genero) values(?, ?, ?, ?);",
                        pedirValoresQuery("insert", new String[]{"nombre", "email", "edad", "genero"}), "insert");}break;
            case "2": {Listar();}break;

            case "3": {
                        updateQueriesExecution("UPDATE alumnos SET nombre = ?, email = ?, edad = ?, genero = ? where id = ?;",
                            pedirValoresQuery("update", new String[]{"nombre", "email", "edad", "genero", "id"}), "update");}break;
            case "4": {
                        updateQueriesExecution("DELETE FROM alumnos WHERE id=?",
                            pedirValoresQuery("delete", new String[]{"id"}), "delete");}break;
            case "5": break;
            default: {
                System.out.println("Valor fuera del rango intenta de nuevo");
            }break;
        }
    }

    public static ArrayList<String>  pedirValoresQuery(String operacion, String[] campos){
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> parametros = new ArrayList<>();
        System.out.println("Dame los campos necesarios para poder realizar la operacion " + operacion);
        while ( i < campos.length) {
            System.out.println("introduce el valor para el campo "+campos[i]);
            parametros.add(scanner.nextLine());
            i++;
        }

    return parametros;
    }
}
