package com.erivalaxl.utils;

import com.erivalaxl.db.ConnectionFactory;
import com.erivalaxl.model.Alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MotorInsertar {
    public static boolean updateQueriesExecution(String query, ArrayList<String> valores, String operacion) throws SQLException {
        int i = 0;
        System.out.println("Opcion " + operacion);
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.conectar();

        if (connection != null) {
            PreparedStatement insert = connection.prepareStatement(query);
            while ( i < valores.size()) {
                if(esNumero(valores.get(i))){
                    insert.setInt(i+1, Integer.parseInt(valores.get(i)));
                }else {
                    insert.setString(i+1, valores.get(i));
                }
                 i++;
            }
            insert.executeUpdate();
            insert.close();
            connection.close();
        }
        Listar();
        return true;
    }

    public static void Listar() throws SQLException {
        Scanner scanner = new Scanner(System.in);
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
        System.out.println("Preciona enter para continuar");
        scanner.nextLine();

    }

    public static boolean esNumero(String valorAProbar){
        try {

            Integer.parseInt(valorAProbar);
            return true;//si llego aqui es por que si es numero entero y regreso un true
        }catch(NumberFormatException e){
            return false;// si llego aqui no es un numero entero y regreso un false
        }
    }
}
