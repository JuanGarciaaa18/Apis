package com.night.night_plus.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.night.night_plus.ws.dao.DiscotecasDao;
import com.night.night_plus.ws.entity.Discoteca;

@RestController
@RequestMapping("/servicio")
public class DiscotecasService {

    @Autowired
    private DiscotecasDao discotecasDao;

    @GetMapping("discotecas")
    public ResponseEntity<Discoteca> getDiscoteca(@RequestParam(value = "id", defaultValue = "0") String nit) {
        Discoteca discoteca = discotecasDao.consultarDiscotecaIndividual(nit);
        if (discoteca == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(discoteca);
    }

    @GetMapping("discotecas-list")
    public ResponseEntity<List<Discoteca>> getDiscotecaList() {
        List<Discoteca> discotecas = discotecasDao.obtenerListaDiscotecas();
        return ResponseEntity.ok(discotecas);
    }

    @PostMapping("guardar")
    public ResponseEntity<Discoteca> registrarDiscoteca(@RequestBody Discoteca discoteca) {
        Discoteca nuevaDiscoteca = discotecasDao.registrarDiscoteca(discoteca);
        return ResponseEntity.ok(nuevaDiscoteca);
    }

    @PutMapping("actualizar")
    public ResponseEntity<Discoteca> actualizarDiscoteca(@RequestBody Discoteca discoteca) {
        Discoteca discotecaActualizada = discotecasDao.actualizarDiscoteca(discoteca);
        if (discotecaActualizada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(discotecaActualizada);
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<Void> eliminarDiscoteca(@PathVariable String id) {
        discotecasDao.eliminarDiscoteca(id);
        return ResponseEntity.ok().build();
    }
}