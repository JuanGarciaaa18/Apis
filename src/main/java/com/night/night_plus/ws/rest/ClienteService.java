package com.night.night_plus.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.night.night_plus.ws.dao.ClienteDao;
import com.night.night_plus.ws.vo.ClienteVo;

@RestController
@RequestMapping("/cliente")
public class ClienteService {

    @Autowired
    private ClienteDao clienteDao;

    @GetMapping("/listar")
    public ResponseEntity<List<ClienteVo>> listarClientes() {
        return ResponseEntity.ok(clienteDao.obtenerListaClientes());
    }

    @PostMapping("/registrar")
    public ResponseEntity<ClienteVo> registrarCliente(@RequestBody ClienteVo cliente) {
        return ResponseEntity.ok(clienteDao.registrarCliente(cliente));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<ClienteVo> actualizarCliente(@RequestBody ClienteVo cliente) {
        ClienteVo actualizado = clienteDao.actualizarCliente(cliente);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable int id) {
        if (clienteDao.eliminarCliente(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}