package com.example.atractivossv;

public class Balnearios {
    //Creacion de variables globales auxiliares
    public int codbalneario;
    public int imagenbalneario;
    public String nombrebalneario;
    public String departamentobalneario;

    //Constructor que inicializa las variables
    public Balnearios(int codbalneario, int imagenbalneario, String nombrebalneario, String departamentobalneario) {
        this.codbalneario = codbalneario;
        this.imagenbalneario = imagenbalneario;
        this.nombrebalneario = nombrebalneario;
        this.departamentobalneario = departamentobalneario;
    }

    //METODOS ACCESORES A LAS VARIABLES PRIVADAS
    public int getCodbalneario() {
        return codbalneario;
    }

    public void setCodbalneario(int codbalneario) {
        this.codbalneario = codbalneario;
    }

    public int getImagenbalneario() {
        return imagenbalneario;
    }

    public void setImagenbalneario(int imagenbalneario) {
        this.imagenbalneario = imagenbalneario;
    }

    public String getNombrebalneario() {
        return nombrebalneario;
    }

    public void setNombrebalneario(String nombrebalneario) {
        this.nombrebalneario = nombrebalneario;
    }

    public String getDepartamentobalneario() {
        return departamentobalneario;
    }

    public void setDepartamentobalneario(String departamentobalneario) {
        departamentobalneario = departamentobalneario;
    }
}
