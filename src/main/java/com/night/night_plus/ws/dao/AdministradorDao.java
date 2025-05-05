 package com.night.night_plus.ws.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.night.night_plus.ws.vo.AdministradorVo;

@Service
public class AdministradorDao {
    private List<AdministradorVo> listaAdministradores = new ArrayList<>();

    public List<AdministradorVo> obtenerListaAdministradores() {
        return listaAdministradores;
    }

    public AdministradorVo registrarAdministrador(AdministradorVo admin) {
        listaAdministradores.add(admin);
        return admin;
    }

    public AdministradorVo actualizarAdministrador(AdministradorVo admin) {
        for (AdministradorVo a : listaAdministradores) {
            if (a.getIdAdmin() == admin.getIdAdmin()) {
                a.setNombreAdmin(admin.getNombreAdmin());
                a.setTelefonoAdmin(admin.getTelefonoAdmin());
                a.setCorreoAdmin(admin.getCorreoAdmin());
                return a;
            }
        }
        return null;
    }

    public boolean eliminarAdministrador(int idAdmin) {
        return listaAdministradores.removeIf(a -> a.getIdAdmin() == idAdmin);
    }
}