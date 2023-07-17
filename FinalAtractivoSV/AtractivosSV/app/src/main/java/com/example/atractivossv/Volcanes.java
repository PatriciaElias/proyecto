package com.example.atractivossv;

public class Volcanes {
    //Creacion de variables globales auxiliares
    public int codvolcan;
    public int imagenvolcan;
    public String nombrevolcan;
    public String departamentovolcan;

    //Constructor que inicializa las variables
    public Volcanes(int codvolcan, int imagenvolcan, String nombrevolcan, String departamentovolcan) {
        this.codvolcan = codvolcan;
        this.imagenvolcan = imagenvolcan;
        this.nombrevolcan = nombrevolcan;
        this.departamentovolcan = departamentovolcan;
    }

    //METODOS ACCESORES A LAS VARIABLES PRIVADAS
    public int getCodvolcan() {
        return codvolcan;
    }

    public void setCodvolcan(int codvolcan) {
        this.codvolcan = codvolcan;
    }

    public int getImagenvolcan() {
        return imagenvolcan;
    }

    public void setImagenvolcan(int imagenvolcan) {
        this.imagenvolcan = imagenvolcan;
    }

    public String getNombrevolcan() {
        return nombrevolcan;
    }

    public void setNombrevolcan(String nombrevolcan) {
        this.nombrevolcan = nombrevolcan;
    }


    public String getDepartamentovolcan() {
        return departamentovolcan;
    }

    public void setDepartamentovolcan(String departamentovolcan) {
        this.departamentovolcan = departamentovolcan;
    }
}
