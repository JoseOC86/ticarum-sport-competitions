package com.jolmos.ticarum.sport.competitions.infrastructure.repository.mapper;

import com.jolmos.ticarum.sport.competitions.domain.model.Competition;
import com.jolmos.ticarum.sport.competitions.infrastructure.repository.model.CompeticionDBO;
import org.springframework.stereotype.Component;

@Component
public class CompeticionDBOMapper {

    public CompeticionDBO map(Competition competition) {

        CompeticionDBO competicionDBO = new CompeticionDBO();
        competicionDBO.setId(competition.getId());
        competicionDBO.setNombre(competition.getNombre());
        competicionDBO.setDeporte(competition.getDeporte());
        competicionDBO.setFechaInicio(competition.getFechaInicio());
        competicionDBO.setFechaFin(competition.getFechaFin());
        competicionDBO.setPistasDisponibles(competition.getPistasDisponibles());
        return competicionDBO;

    }

    public Competition map(CompeticionDBO competicionDBO) {

        Competition competition = new Competition();
        competition.setId(competicionDBO.getId());
        competition.setNombre(competicionDBO.getNombre());
        competition.setDeporte(competicionDBO.getDeporte());
        competition.setFechaInicio(competicionDBO.getFechaInicio());
        competition.setFechaFin(competicionDBO.getFechaFin());
        competition.setPistasDisponibles(competicionDBO.getPistasDisponibles());
        return competition;

    }


}
