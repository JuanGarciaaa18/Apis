package com.night.night_plus.ws.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.night.night_plus.ws.vo.ClienteVo;

@Service
public class ClienteDao {
    private List<ClienteVo> listaClientes = new ArrayList<>();

    public List<ClienteVo> obtenerListaClientes() {
        return listaClientes;
    }

    public ClienteVo registrarCliente(ClienteVo cliente) {
        listaClientes.add(cliente);
        return cliente;
    }

    public ClienteVo actualizarCliente(ClienteVo cliente) {
        for (ClienteVo c : listaClientes) {
            if (c.getIdClien() == cliente.getIdClien()) {
                c.setNombreCliente(cliente.getNombreCliente());
                c.setEdad(cliente.getEdad());
                c.setTelefonoCliente(cliente.getTelefonoCliente());
                c.setCorreoCliente(cliente.getCorreoCliente());
                c.setContrasenaCliente(cliente.getContrasenaCliente());
                return c;
            }
        }
        return null;
    }

    public boolean eliminarCliente(int idClien) {
        return listaClientes.removeIf(c -> c.getIdClien() == idClien);
    }
}