package com.erivalaxl.utils;


import com.erivalaxl.db.ConnectionFactory;
import com.erivalaxl.model.Alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    private static void Eliminar() {
        System.out.println("Eliminar");
    }

    private static void Actualizar() {
        System.out.println("Actualizar");
    }

    private static void Listar() throws SQLException {
        System.out.println("Listar");
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
    }

    private static void Agregar() {
        System.out.println("Agregar");
    }


}
