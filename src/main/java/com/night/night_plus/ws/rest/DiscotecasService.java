package com.night.night_plus.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.night.night_plus.ws.dao.DiscotecasDao;
import com.night.night_plus.ws.vo.DiscotecasVo;

@RestController
@RequestMapping("/servicio")
public class DiscotecasService {

    @Autowired(required = true)
    private DiscotecasDao DiscotecasDao;

    @GetMapping("hola")
    public String saludo() {
        return "Este es el saludo de Discoteca web";
    }

    @GetMapping("discotecas")
    public ResponseEntity<DiscotecasVo> getDiscoteca(
            @RequestParam(value = "id", defaultValue = "0") String nit) {

        DiscotecasVo discotecas = DiscotecasDao.consultarPersonaIndividual(nit);

        if (discotecas == null) {
            discotecas = new DiscotecasVo();
        }

        return ResponseEntity.ok(discotecas);
    }

    @GetMapping("discotecas-list")
    public ResponseEntity<List<DiscotecasVo>> getDiscotecalist() {
        List<DiscotecasVo> discotecas = DiscotecasDao.obtenerlistaDiscotecas();
        return ResponseEntity.ok(discotecas);
    }

    @PostMapping("guardar")
    public ResponseEntity<DiscotecasVo> RegistrarDiscoteca(@RequestBody DiscotecasVo Discoteca){

        DiscotecasVo midiscoteca=DiscotecasDao.RegistrarDiscoteca(Discoteca);
        if(midiscoteca!=null) {
            return ResponseEntity.ok(midiscoteca);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("actualizar")
    public ResponseEntity<DiscotecasVo> actualizarUsuario(@RequestBody DiscotecasVo Discoteca) {

        DiscotecasVo midiscoteca = null;
        if (DiscotecasDao.consultarPersonaIndividual(Discoteca.getnit()) != null) {
            midiscoteca = DiscotecasDao.actualizarDiscoteca(Discoteca);
            if (midiscoteca != null) {
                return ResponseEntity.ok(midiscoteca);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable String id) {
        DiscotecasVo miPersona = DiscotecasDao.consultarPersonaIndividual(id);
        if (miPersona != null) {
            DiscotecasDao.eliminarPersona(miPersona);
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.notFound().build();
    }

}