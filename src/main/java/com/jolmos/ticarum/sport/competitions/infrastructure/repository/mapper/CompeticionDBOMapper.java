package com.jolmos.ticarum.sport.competitions.infrastructure.repository.mapper;

import com.jolmos.ticarum.sport.competitions.domain.model.Competicion;
import com.jolmos.ticarum.sport.competitions.infrastructure.repository.model.CompeticionDBO;
import org.springframework.stereotype.Component;

@Component
public class CompeticionDBOMapper {

    public CompeticionDBO map(Competicion competicion) {

        CompeticionDBO competicionDBO = new CompeticionDBO();
        competicionDBO.setId(competicion.getId());
        competicionDBO.setNombre(competicion.getNombre());
        competicionDBO.setDeporte(competicion.getDeporte());
        competicionDBO.setFechaInicio(competicion.getFechaInicio());
        competicionDBO.setFechaFin(competicion.getFechaFin());
        competicionDBO.setPistasDisponibles(competicion.getPistasDisponibles());
        return competicionDBO;

    }

    public Competicion map(CompeticionDBO competicionDBO) {

        Competicion competicion = new Competicion();
        competicion.setId(competicionDBO.getId());
        competicion.setNombre(competicionDBO.getNombre());
        competicion.setDeporte(competicionDBO.getDeporte());
        competicion.setFechaInicio(competicionDBO.getFechaInicio());
        competicion.setFechaFin(competicionDBO.getFechaFin());
        competicion.setPistasDisponibles(competicionDBO.getPistasDisponibles());
        return competicion;

    }


}
