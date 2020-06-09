package com.erivalaxl.model;

public class Alumno {
    private int id;
    private String name;
    private String email;
    private int edad;
    private char genero;

    public Alumno() {
    }

    public Alumno(int id, String name, String email, int edad, char genero) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.edad = edad;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", edad=" + edad +
                ", genero=" + genero +
                '}';
    }
}
