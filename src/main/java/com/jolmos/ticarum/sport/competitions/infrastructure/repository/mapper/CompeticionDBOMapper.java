package com.jolmos.ticarum.sport.competitions.infrastructure.repository.mapper;

import com.jolmos.ticarum.sport.competitions.domain.model.Competition;
import com.jolmos.ticarum.sport.competitions.infrastructure.repository.model.CompeticionDBO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompeticionDBOMapper {

    private final EquipoDBOMapper equipoDBOMapper;

    public CompeticionDBO map(Competition competition) {

        if (competition == null) {
            return null;
        }

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

    public Competition map(Optional<CompeticionDBO> competicionDBO) {

        if (competicionDBO.isEmpty()) {
            return null;
        }

        Competition competition = new Competition();
        competition.setId(competicionDBO.get().getId());
        competition.setNombre(competicionDBO.get().getNombre());
        competition.setDeporte(competicionDBO.get().getDeporte());
        competition.setFechaInicio(competicionDBO.get().getFechaInicio());
        competition.setFechaFin(competicionDBO.get().getFechaFin());
        competition.setPistasDisponibles(competicionDBO.get().getPistasDisponibles());
        competicionDBO.get().getEquipos().stream().map(equipoDBOMapper::map).forEach(competition::addEquipo);
        return competition;

    }


}
