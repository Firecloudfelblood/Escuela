package com.erivalaxl.utils;


import com.erivalaxl.db.ConnectionFactory;
import com.erivalaxl.model.Alumno;

import java.lang.reflect.Array;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppUtils {

    public static void opcionElegida(String opcionElegida) throws SQLException {
        switch(opcionElegida){
            case "1": {Agregar();}break;
            case "2": {Listar();}break;
            case "3": {Actualizar();}break;
            case "4": {Eliminar();}break;
            case "5": break;
            default: {
                System.out.println("Valor fuera del rango intenta de nuevo");
            }break;
        }
    }

    private static void Eliminar() throws SQLException {
        System.out.println("Opcion Eliminar");
        ArrayList<String> parametros = new ArrayList<>(pedirValoresQuery("Eliminar"));
        if (updateQueriesExecution("DELETE FROM alumnos WHERE id=?", parametros)){
            System.out.println("Datos eliminados correctamente");
            Listar();
        }else{
            System.err.println("Error al intentar eliminar datos");
        }
    }

    private static void Actualizar() {
        System.out.println("Actualizar");
    }

    private static void Listar() throws SQLException {
        System.out.println("Opcion Listar");
        List<Alumno> alumnos = new ArrayList<>();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.conectar();

        if (connection != null){
            String query = "SELECT * FROM alumnos";
            PreparedStatement select = connection.prepareStatement(query);
            ResultSet rs = select.executeQuery();

            if (rs != null) {
                while (rs.next()){
                    Alumno alumno = new Alumno();
                    alumno.setId(rs.getInt("id"));
                    alumno.setName(rs.getString("nombre"));
                    alumno.setEmail(rs.getString("email"));
                    alumno.setEdad(rs.getInt("edad"));
                    alumno.setGenero(rs.getString("genero") != null? rs.getString("genero").charAt(0): ' ');//use operador terneario para validad que no este nulo el genero
                    alumnos.add(alumno);
                }

                for (Alumno alumno: alumnos){
                    System.out.println(alumno.toString());
                }
            }
        }
        connection.close();
    }

    private static void Agregar() throws SQLException {
        System.out.println("Opcion Agregar");
        ArrayList<String> parametros = new ArrayList<>(pedirValoresQuery("Agregar"));
        if(updateQueriesExecution("insert into alumnos(nombre, email, edad, genero) values(?, ?, ?, ?);", parametros)){
            System.out.println("Datos agregados correctamente");
            Listar();
        }else{
            System.err.println("Error al intentar agregar datos");
        }
    }

    /***
     * Como los metodos para update, insert y delite repetirian codigo,
     * lo saque a un metodo que recibe el query en un string y los parametros en un array
     * @param query
     * @param valores
     * @return
     * @throws SQLException
     */
    public static boolean updateQueriesExecution(String query, ArrayList<String> valores) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.conectar();

        if (connection != null) {
            PreparedStatement insert = connection.prepareStatement(query);
            for (int i = 0; i < valores.size(); i++) {
                if(esNumero(valores.get(i))){
                    insert.setInt(i+1, Integer.parseInt(valores.get(i)));
                }else {
                    insert.setString(i+1, valores.get(i));
                }
            }
            insert.executeUpdate();
            insert.close();
            connection.close();
        }
        return true;
    }

    public static boolean esNumero(String valorAProbar){
        try {

            Integer.parseInt(valorAProbar);
            return true;//si llego aqui es por que si es numero entero y regreso un true
        }catch(NumberFormatException e){
            return false;// si llego aqui no es un numero entero y regreso un false
        }
    }

    public static ArrayList<String>  pedirValoresQuery(String operacion){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> parametros = new ArrayList<>();
        int numeroParametros;
        System.out.println("Cuantos parametros deceas incluir");
        numeroParametros = scanner.nextInt();
        for (int i = 0; i < numeroParametros; i++) {
            System.out.println("introduce el parametro");
            parametros.add(scanner.next());
        }

    return parametros;
    }
}
