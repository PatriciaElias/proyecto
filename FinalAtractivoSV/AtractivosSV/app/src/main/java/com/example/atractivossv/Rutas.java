package com.example.atractivossv;

public class Rutas {
    //Creacion de variables globales auxiliares
    public int codruta;
    public int imagenruta;
    public String nombreruta;
    public String departamentoruta;

    //Constructor que inicializa las variables
    public Rutas(int codruta, int imagenruta, String nombreruta, String departamentoruta) {
        this.codruta = codruta;
        this.imagenruta = imagenruta;
        this.nombreruta = nombreruta;
        this.departamentoruta = departamentoruta;
    }

    //METODOS ACCESORES A LAS VARIABLES PRIVADAS
    public int getCodruta() {
        return codruta;
    }

    public void setCodruta(int codruta) {
        this.codruta = codruta;
    }

    public int getImagenruta() {
        return imagenruta;
    }

    public void setImagenruta(int imagenruta) {
        this.imagenruta = imagenruta;
    }

    public String getNombreruta() {
        return nombreruta;
    }

    public void setNombreruta(String nombreruta) {
        this.nombreruta = nombreruta;
    }


    public String getDepartamentoruta() {
        return departamentoruta;
    }

    public void setDepartamentoruta(String departamentoruta) {
        this.departamentoruta = departamentoruta;
    }
}
