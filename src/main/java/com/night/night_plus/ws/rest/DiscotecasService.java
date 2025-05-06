package com.night.night_plus.ws.rest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.night.night_plus.ws.dao.DiscotecasDao;
import com.night.night_plus.ws.vo.DiscotecasVo;

@RestController
@RequestMapping("/servicio")
public class DiscotecasService {

    @Autowired(required = true)
    private DiscotecasDao DiscotecasDao;

    private static final String DIRECTORIO_IMAGENES = "imagenes/";

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
    public ResponseEntity<DiscotecasVo> RegistrarDiscoteca(@RequestBody DiscotecasVo Discoteca) {

        DiscotecasVo midiscoteca = DiscotecasDao.RegistrarDiscoteca(Discoteca);
        if (midiscoteca != null) {
            return ResponseEntity.ok(midiscoteca);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("actualizar")
    public ResponseEntity<DiscotecasVo> actualizarUsuario(@RequestBody DiscotecasVo Discoteca) {

        DiscotecasVo midiscoteca = null;
        if (DiscotecasDao.consultarPersonaIndividual(Discoteca.getNit()) != null) {
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

    @PostMapping("subir-imagen/{nit}")
    public ResponseEntity<String> subirImagen(@PathVariable String nit, @RequestParam("archivo") MultipartFile archivo) {
        DiscotecasVo discoteca = DiscotecasDao.consultarPersonaIndividual(nit);
        if (discoteca == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Discoteca no encontrada");
        }

        try {
            File directorio = new File(DIRECTORIO_IMAGENES);
            if (!directorio.exists()) {
                directorio.mkdirs();
            }

            String rutaArchivo = DIRECTORIO_IMAGENES + archivo.getOriginalFilename();
            archivo.transferTo(new File(rutaArchivo));

            discoteca.setImagen(rutaArchivo);
            DiscotecasDao.actualizarDiscoteca(discoteca);

            return ResponseEntity.ok("Imagen subida correctamente: " + rutaArchivo);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir la imagen");
        }
    }
}