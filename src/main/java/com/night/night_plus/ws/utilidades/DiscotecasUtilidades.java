package com.night.night_plus.ws.utilidades;

import java.util.ArrayList;
import java.util.List;

import com.night.night_plus.ws.vo.DiscotecasVo;

public class DiscotecasUtilidades {

    public final static int TIPO_ADMIN = 1;
    public final static int TIPO_EMPLEADO = 2;
    static int bandera = 0;

    public static List<DiscotecasVo> listaDiscotecas = new ArrayList<DiscotecasVo>();

    public static void iniciarLista() {
        if (bandera == 0) {
            listaDiscotecas.add(new DiscotecasVo("111", "Fonda La Floresta", "calle 30", 300, "imagenes/fonda_la_floresta.jpg"));
            listaDiscotecas.add(new DiscotecasVo("222", "Tropical Club", "cr 14 calle 12", 250, "imagenes/tropical_club.jpg"));
            bandera = 1;
        }
    }
}