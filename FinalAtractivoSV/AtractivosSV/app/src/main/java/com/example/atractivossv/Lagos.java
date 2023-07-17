package com.example.atractivossv;

public class Lagos {
    //Creacion de variables globales auxiliares
    public int codlago;
    public int imagenlago;
    public String nombrelago;
    public String departamentolago;

    //Constructor que inicializa las variables
    public Lagos(int codlago, int imagenlago, String nombrelago, String departamentolago) {
        this.codlago = codlago;
        this.imagenlago = imagenlago;
        this.nombrelago = nombrelago;
        this.departamentolago = departamentolago;
    }

    //METODOS ACCESORES A LAS VARIABLES PRIVADAS
    public int getCodlago() {
        return codlago;
    }

    public void setCodlago(int codlago) {
        this.codlago = codlago;
    }

    public int getImagenlago() {
        return imagenlago;
    }

    public void setImagenlago(int imagenlago) {
        this.imagenlago = imagenlago;
    }

    public String getNombrelago() {
        return nombrelago;
    }

    public void setNombrelago(String nombrelago) {
        this.nombrelago = nombrelago;
    }

    public String getDepartamentolago() {
        return departamentolago;
    }

    public void setDepartamentolago(String departamentolago) {
        departamentolago = departamentolago;
    }
}
