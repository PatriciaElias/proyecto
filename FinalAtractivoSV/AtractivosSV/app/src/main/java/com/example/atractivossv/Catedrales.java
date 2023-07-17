package com.example.atractivossv;

public class Catedrales {
    //Creacion de variables globales auxiliares
    public int codcatedral;
    public int imagencatedral;
    public String nombrecatedral;
    public String departamentocatedral;

    //Constructor que inicializa las variables
    public Catedrales(int codcatedral, int imagencatedral, String nombrecatedral, String departamentocatedral) {
        this.codcatedral = codcatedral;
        this.imagencatedral = imagencatedral;
        this.nombrecatedral = nombrecatedral;
        this.departamentocatedral = departamentocatedral;
    }

    //METODOS ACCESORES A LAS VARIABLES PRIVADAS
    public int getCodcatedral() {
        return codcatedral;
    }

    public void setCodcatedral(int codcatedral) {
        this.codcatedral = codcatedral;
    }

    public int getImagencatedral() {
        return imagencatedral;
    }

    public void setImagencatedral(int imagencatedral) {
        this.imagencatedral = imagencatedral;
    }

    public String getNombrecatedral() {
        return nombrecatedral;
    }

    public void setNombrecatedral(String nombrecatedral) {
        this.nombrecatedral = nombrecatedral;
    }

    public String getDepartamentocatedral() {
        return departamentocatedral;
    }

    public void setDepartamentocatedral(String departamentocatedral) {
        this.departamentocatedral = departamentocatedral;
    }
}
