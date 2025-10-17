package com.jolmos.ticarum.sport.competitions.infrastructure.repository.mapper;

import com.jolmos.ticarum.sport.competitions.domain.model.Competition;
import com.jolmos.ticarum.sport.competitions.infrastructure.repository.model.CompeticionDBO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompeticionDBOMapper {

    private final EquipoDBOMapper equipoDBOMapper;

    public CompeticionDBO map(Competition competition) {

        CompeticionDBO competicionDBO = new CompeticionDBO();
        competicionDBO.setId(competition.getId());
        competicionDBO.setNombre(competition.getNombre());
        competicionDBO.setDeporte(competition.getDeporte());
        competicionDBO.setFechaInicio(competition.getFechaInicio());
        competicionDBO.setFechaFin(competition.getFechaFin());
        competicionDBO.setPistasDisponibles(competition.getPistasDisponibles());
        competicionDBO.setEquipos(competition.getEquipos().stream().map(equipoDBOMapper::map).collect(Collectors.toSet()));
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
        competicionDBO.getEquipos().stream().map(equipoDBOMapper::map).forEach(competition::addEquipo);
        return competition;

    }


}
