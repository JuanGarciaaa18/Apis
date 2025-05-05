package com.night.night_plus.ws.utilidades;

import java.util.ArrayList;
import java.util.List;

import com.night.night_plus.ws.vo.AdministradorVo;

public class AdministradorUtilidades {
    public static List<AdministradorVo> listaAdministradores = new ArrayList<>();

    public static void inicializarAdministradores() {
        listaAdministradores.add(new AdministradorVo(1, "Admin1", "123456789", "sadas"));
        listaAdministradores.add(new AdministradorVo(2, "Admin2", "987654321", "admin2@example.com"));
    }
}