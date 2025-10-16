package com.jolmos.ticarum.sport.competitions.infrastructure.controller.mapper;

import com.jolmos.ticarum.sport.competitions.domain.model.Competicion;
import com.jolmos.ticarum.sport.competitions.infrastructure.controller.dto.CompetitionDTO;
import com.jolmos.ticarum.sport.competitions.infrastructure.repository.model.CompeticionDBO;
import org.springframework.stereotype.Component;

@Component
public class CompetitionDTOMapper {

    public CompetitionDTO toCompetitionDTO(Competicion competicion) {
        return new CompetitionDTO(competicion.getId(), competicion.getNombre(), competicion.getDeporte(), competicion.getFechaInicio(), competicion.getFechaFin(), competicion.getPistasDisponibles());

    }

    public Competicion toCompeticion(CompetitionDTO competitionDTO) {

        Competicion competicion = new Competicion();
        competicion.setId(competitionDTO.id());
        competicion.setNombre(competitionDTO.nombre());
        competicion.setDeporte(competitionDTO.deporte());
        competicion.setFechaInicio(competitionDTO.fechaInicio());
        competicion.setFechaFin(competitionDTO.fechaFin());
        competicion.setPistasDisponibles(competitionDTO.pistasDisponibles());
        return competicion;

    }
}
