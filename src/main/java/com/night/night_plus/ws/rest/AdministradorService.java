 package com.night.night_plus.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.night.night_plus.ws.dao.AdministradorDao;
import com.night.night_plus.ws.vo.AdministradorVo;

@RestController
@RequestMapping("/administrador")
public class AdministradorService {

    @Autowired
    private AdministradorDao administradorDao;

    @GetMapping("/listar")
    public ResponseEntity<List<AdministradorVo>> listarAdministradores() {
        return ResponseEntity.ok(administradorDao.obtenerListaAdministradores());
    }

    @PostMapping("/registrar")
    public ResponseEntity<AdministradorVo> registrarAdministrador(@RequestBody AdministradorVo admin) {
        return ResponseEntity.ok(administradorDao.registrarAdministrador(admin));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<AdministradorVo> actualizarAdministrador(@RequestBody AdministradorVo admin) {
        AdministradorVo actualizado = administradorDao.actualizarAdministrador(admin);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarAdministrador(@PathVariable int id) {
        if (administradorDao.eliminarAdministrador(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
