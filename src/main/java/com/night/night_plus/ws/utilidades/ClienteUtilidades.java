package com.night.night_plus.ws.utilidades;

import java.util.ArrayList;
import java.util.List;

import com.night.night_plus.ws.vo.ClienteVo;

public class ClienteUtilidades {
    public static List<ClienteVo> listaClientes = new ArrayList<>();

    public static void inicializarClientes() {
        listaClientes.add(new ClienteVo(1, "Cliente1", 25, "123456789", "cliente1@example.com", "password1"));
        listaClientes.add(new ClienteVo(2, "Cliente2", 30, "987654321", "cliente2@example.com", "password2"));
    }
}