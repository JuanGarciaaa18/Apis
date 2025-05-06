package com.night.night_plus.ws.dao;

import java.util.List;

import org.springframework.stereotype.Service;
import com.night.night_plus.ws.utilidades.DiscotecasUtilidades;
import com.night.night_plus.ws.vo.DiscotecasVo;

@Service
public class DiscotecasDao {

    public DiscotecasDao() {
        DiscotecasUtilidades.iniciarLista();
    }

    public DiscotecasVo consultarPersonaIndividual(String nit) {
        DiscotecasVo discotecasVo = null;
        for (DiscotecasVo p : DiscotecasUtilidades.listaDiscotecas) {
            if (p.getNit().equals(nit)) {
                discotecasVo = new DiscotecasVo();
                discotecasVo.setNit(p.getNit());
                discotecasVo.setNombre(p.getNombre());
                discotecasVo.setUbicacion(p.getUbicacion());
                discotecasVo.setCapacidad(p.getCapacidad());
                discotecasVo.setImagen(p.getImagen()); // Agregar imagen
            }
        }
        return discotecasVo;
    }

    public List<DiscotecasVo> obtenerlistaDiscotecas() {
        return (List<DiscotecasVo>) DiscotecasUtilidades.listaDiscotecas;
    }

    public DiscotecasVo RegistrarDiscoteca(DiscotecasVo discotecasVo) {
        boolean existe = false;

        for (DiscotecasVo obj : DiscotecasUtilidades.listaDiscotecas) {
            if (obj.getUbicacion().equals(discotecasVo.getNit())) {
                existe = true;
                break;
            }
        }
        if (!existe) {
            discotecasVo.setNit(discotecasVo.getNit());
            DiscotecasUtilidades.listaDiscotecas.add(discotecasVo);
            return discotecasVo;
        } else {
            return null;
        }
    }

    public DiscotecasVo actualizarDiscoteca(DiscotecasVo Discoteca) {
        DiscotecasVo DiscotecaVo = null;
        for (DiscotecasVo obj : DiscotecasUtilidades.listaDiscotecas) {
            if (obj.getNit().equals(Discoteca.getNit())) {
                obj.setNit(Discoteca.getNit());
                obj.setNombre(Discoteca.getNombre());
                obj.setUbicacion(Discoteca.getUbicacion());
                obj.setCapacidad(Discoteca.getCapacidad());
                obj.setImagen(Discoteca.getImagen()); // Actualizar imagen
                DiscotecaVo = obj;
                break;
            }
        }
        return DiscotecaVo;
    }

    public void eliminarPersona(DiscotecasVo Discoteca) {
        for (DiscotecasVo obj : DiscotecasUtilidades.listaDiscotecas) {
            if (obj.getNit().equals(Discoteca.getNit())) {
                DiscotecasUtilidades.listaDiscotecas.remove(obj);
                break;
            }
        }
    }
}