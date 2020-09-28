package com.uso.evaluacion1_2020.Adaptadores;

public class Estudiante {

    private String Nombre;
    private String Codigo;
    private String Materia;
    private Double Parcial1;
    private Double Parcial2;
    private Double Parcial3;
    private Double Promedio;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public Double getParcial1() {
        return Parcial1;
    }

    public void setParcial1(Double parcial1) {
        Parcial1 = parcial1;
    }

    public Double getParcial2() {
        return Parcial2;
    }

    public void setParcial2(Double parcial2) {
        Parcial2 = parcial2;
    }

    public Double getParcial3() {
        return Parcial3;
    }

    public void setParcial3(Double parcial3) {
        Parcial3 = parcial3;
    }

    public Double getPromedio() {
        return Promedio;
    }

    public void setPromedio(Double promedio) {
        Promedio = promedio;
    }

    public String getMateria() {
        return Materia;
    }

    public void setMateria(String materia) {
        Materia = materia;
    }
}
