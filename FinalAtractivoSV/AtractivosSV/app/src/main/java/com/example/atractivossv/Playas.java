package com.example.atractivossv;

public class Playas {
    //Creacion de variables globales auxiliares
    public int codplayas;
    public int imagenplaya;
    public String nombreplaya;
    public String departamentoplaya;

    //Constructor que inicializa las variables
    public Playas(int codplayas, int imagenplaya, String nombreplaya, String departamentoplaya) {
        this.codplayas = codplayas;
        this.imagenplaya = imagenplaya;
        this.nombreplaya = nombreplaya;
        this.departamentoplaya = departamentoplaya;
    }

    //METODOS ACCESORES A LAS VARIABLES PRIVADAS
    public int getCodplayas() {
        return codplayas;
    }

    public void setCodplayas(int codplayas) {
        this.codplayas = codplayas;
    }

    public int getImagenplaya() {
        return imagenplaya;
    }

    public void setImagenplaya(int imagenplaya) {
        this.imagenplaya = imagenplaya;
    }

    public String getNombreplaya() {
        return nombreplaya;
    }

    public void setNombreplaya(String nombreplaya) {
        this.nombreplaya = nombreplaya;
    }

    public String getDepartamentoplaya() {
        return departamentoplaya;
    }

    public void setDepartamentoplaya(String departamentoplaya) {
        departamentoplaya = departamentoplaya;
    }
}
