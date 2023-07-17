package com.example.atractivossv;

public class Arqueologico {
    //Creacion de variables globales auxiliares
    public int codarqueologico;
    public int imagenarqueologico;
    public String nombrearqueologico;
    public String departamentoarqueologico;

    //Constructor que inicializa las variables
    public Arqueologico(int codarqueologico, int imagenarqueologico, String nombrearqueologico, String departamentoarqueologico) {
        this.codarqueologico = codarqueologico;
        this.imagenarqueologico = imagenarqueologico;
        this.nombrearqueologico = nombrearqueologico;
        this.departamentoarqueologico = departamentoarqueologico;
    }

    //METODOS ACCESORES A LAS VARIABLES PRIVADAS
    public int getCodarqueologico() {
        return codarqueologico;
    }

    public void setCodarqueologico(int codarqueologico) {
        this.codarqueologico = codarqueologico;
    }

    public int getImagenarqueologico() {
        return imagenarqueologico;
    }

    public void setImagenarqueologico(int imagenarqueologico) {
        this.imagenarqueologico = imagenarqueologico;
    }

    public String getNombrearqueologico() {
        return nombrearqueologico;
    }

    public void setNombrearqueologico(String nombrearqueologico) {
        this.nombrearqueologico = nombrearqueologico;
    }

    public String getDepartamentoarqueologico() {
        return departamentoarqueologico;
    }

    public void setDepartamentoarqueologico(String departamentoarqueologico) {
        departamentoarqueologico = departamentoarqueologico;
    }
}
