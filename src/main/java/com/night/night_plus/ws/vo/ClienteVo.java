package com.night.night_plus.ws.vo;

public class ClienteVo {
    private int idClien;
    private String nombreCliente;
    private int edad;
    private String telefonoCliente;
    private String correoCliente;
    private String contrasenaCliente;

public ClienteVo(int idClien, String nombreCliente, int edad, String telefonoCliente, String correoCliente, String contrasenaCliente) {
        this.idClien = idClien;
        this.nombreCliente = nombreCliente;
        this.edad = edad;
        this.telefonoCliente = telefonoCliente;
        this.correoCliente = correoCliente;
        this.contrasenaCliente = contrasenaCliente;
    }
    // Getters y Setters
    public int getIdClien() {
        return idClien;
    }

    public void setIdClien(int idClien) {
        this.idClien = idClien;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String getContrasenaCliente() {
        return contrasenaCliente;
    }

    public void setContrasenaCliente(String contrasenaCliente) {
        this.contrasenaCliente = contrasenaCliente;
    }
}