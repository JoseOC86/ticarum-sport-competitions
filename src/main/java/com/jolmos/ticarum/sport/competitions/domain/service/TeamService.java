package com.jolmos.ticarum.sport.competitions.domain.service;

import com.jolmos.ticarum.sport.competitions.domain.model.Team;
import com.jolmos.ticarum.sport.competitions.domain.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TeamService {


    private final TeamRepository teamRepository;

    /**
     * Busca equipo identificador.
     * @param teamId Identificador del equipo.
     * @return Un optional que contiene el equipo o esta vacio si el equipo no existe.
     */
    public Optional<Team> findById(Long teamId) {
        if (teamId == null) {
            return Optional.empty();
        }
        return this.teamRepository.findById(teamId);
    }

    /**
     * Busca el conjunto de equipos para una competición. Si la competición no existe se devolvera un conjunto vacio.
     * @param competitionId Identificador de competición.
     * @return Devuelve el conjunto de equipos registrados para la competición.
     */
    public Set<Team> findByCompetition(Long competitionId) {
        return this.teamRepository.findByCompeticiones(competitionId);
    }
}