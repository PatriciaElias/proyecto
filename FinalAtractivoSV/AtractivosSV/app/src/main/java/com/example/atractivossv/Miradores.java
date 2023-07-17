package com.example.atractivossv;

public class Miradores {
    //Creacion de variables globales auxiliares
    public int codmirador;
    public int imagenmirador;
    public String nombremirador;
    public String departamentomirador;

    //Constructor que inicializa las variables
    public Miradores(int codmirador, int imagenmirador, String nombremirador, String departamentomirador) {
        this.codmirador = codmirador;
        this.imagenmirador = imagenmirador;
        this.nombremirador = nombremirador;
        this.departamentomirador = departamentomirador;
    }

    //METODOS ACCESORES A LAS VARIABLES PRIVADAS
    public int getCodmirador() {
        return codmirador;
    }

    public void setCodmirador(int codmirador) {
        this.codmirador = codmirador;
    }

    public int getImagenmirador() {
        return imagenmirador;
    }

    public void setImagenmirador(int imagenmirador) {
        this.imagenmirador = imagenmirador;
    }

    public String getNombremirador() {
        return nombremirador;
    }

    public void setNombremirador(String nombremirador) {
        this.nombremirador = nombremirador;
    }

    public String getDepartamentomirador() {
        return departamentomirador;
    }

    public void setDepartamentomirador(String departamentomirador) {
        departamentomirador = departamentomirador;
    }
}
