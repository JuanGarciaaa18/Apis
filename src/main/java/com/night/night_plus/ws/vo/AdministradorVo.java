 package com.night.night_plus.ws.vo;

public class AdministradorVo {
    private int idAdmin;
    private String nombreAdmin;
    private String telefonoAdmin;
    private String correoAdmin;

    public AdministradorVo(int idAdmin, String nombreAdmin, String telefonoAdmin, String correoAdmin) {
        this.idAdmin = idAdmin;
        this.nombreAdmin = nombreAdmin;
        this.telefonoAdmin = telefonoAdmin;
        this.correoAdmin = correoAdmin;
    }


    // Getters y Setters
    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNombreAdmin() {
        return nombreAdmin;
    }

    public void setNombreAdmin(String nombreAdmin) {
        this.nombreAdmin = nombreAdmin;
    }

    public String getTelefonoAdmin() {
        return telefonoAdmin;
    }

    public void setTelefonoAdmin(String telefonoAdmin) {
        this.telefonoAdmin = telefonoAdmin;
    }

    public String getCorreoAdmin() {
        return correoAdmin;
    }

    public void setCorreoAdmin(String correoAdmin) {
        this.correoAdmin = correoAdmin;
    }
}
