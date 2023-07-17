package com.example.atractivossv;

public class Montanias {
    //Creacion de variables globales auxiliares
    public int codmontania;
    public int imagenmontania;
    public String nombremontania;
    public String departamentomontania;

    //Constructor que inicializa las variables
    public Montanias(int codmontania, int imagenmontania, String nombremontania, String departamentomontania) {
        this.codmontania = codmontania;
        this.imagenmontania = imagenmontania;
        this.nombremontania = nombremontania;
        this.departamentomontania = departamentomontania;
    }

    //METODOS ACCESORES A LAS VARIABLES PRIVADAS
    public int getCodmontania() {
        return codmontania;
    }

    public void setCodmontania(int codmontania) {
        this.codmontania = codmontania;
    }

    public int getImagenmontania() {
        return imagenmontania;
    }

    public void setImagenmontania(int imagenmontania) {
        this.imagenmontania = imagenmontania;
    }

    public String getNombremontania() {
        return nombremontania;
    }

    public void setNombremontania(String nombremontania) {
        this.nombremontania = nombremontania;
    }

    public String getDepartamentomontania() {
        return departamentomontania;
    }

    public void setDepartamentomontania(String departamentomontania) {
        departamentomontania = departamentomontania;
    }
}
