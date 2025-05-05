package com.night.night_plus.ws.vo;

public class DiscotecasVo {

    private String nit; 
    private String nombre;
    private String ubicacion;
    private int capacidad;

    public DiscotecasVo(String nit, String nombre, String ubicacion, int capacidad) {
        super();
        this.nit = nit;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
    }

    public DiscotecasVo() {
    }

    public String getnit() {
        return nit;
    }

    public void setnit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getubicacion() {
        return ubicacion;
    }

    public void setubicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public int getcapacidad() {
        return capacidad;
    }

    public void setcapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}