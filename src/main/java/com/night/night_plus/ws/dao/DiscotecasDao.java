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
            if (p.getnit().equals(nit)) {
                discotecasVo = new DiscotecasVo();
                discotecasVo.setnit(p.getnit());
                discotecasVo.setNombre(p.getNombre());
                discotecasVo.setubicacion(p.getubicacion());
                discotecasVo.setcapacidad(p.getcapacidad());
            }
        }
        return discotecasVo;
    }

    public List<DiscotecasVo> obtenerlistaDiscotecas() {
        return (List<DiscotecasVo>) DiscotecasUtilidades.listaDiscotecas;
    }


    public DiscotecasVo RegistrarDiscoteca(DiscotecasVo discotecasVo) {
        boolean existe=false;

        for (DiscotecasVo obj : DiscotecasUtilidades.listaDiscotecas) {
            if(obj.getubicacion().equals(discotecasVo.getnit())) {
                existe=true;
                break;
            }
        }
        if(existe==false) {
            discotecasVo.setnit(discotecasVo.getnit());
            DiscotecasUtilidades.listaDiscotecas.add(discotecasVo);
            return discotecasVo;
        }else {
            return null;
        }
    }

    public DiscotecasVo actualizarDiscoteca(DiscotecasVo Discoteca) {
        DiscotecasVo DiscotecaVo = null;
        for (DiscotecasVo obj : DiscotecasUtilidades.listaDiscotecas) {
            if (obj.getnit().equals(Discoteca.getnit())) {
                obj.setnit(Discoteca.getnit());
                obj.setNombre(Discoteca.getNombre());
                obj.setubicacion(Discoteca.getubicacion());
                obj.setcapacidad(Discoteca.getcapacidad());
                DiscotecaVo = obj;
                break;
            }
        }
        return DiscotecaVo;
    }

    public void eliminarPersona(DiscotecasVo Discoteca) {
        for (DiscotecasVo obj : DiscotecasUtilidades.listaDiscotecas) {
            if (obj.getnit().equals(Discoteca.getnit())) {
                DiscotecasUtilidades.listaDiscotecas.remove(obj);
                break;
            }
        }
    }
}

