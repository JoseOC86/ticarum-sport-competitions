package com.jolmos.ticarum.sport.competitions.domain.service;

import com.jolmos.ticarum.sport.competitions.domain.model.Competition;
import com.jolmos.ticarum.sport.competitions.domain.model.Team;
import com.jolmos.ticarum.sport.competitions.domain.model.exception.CompetitionNotFoundException;
import com.jolmos.ticarum.sport.competitions.domain.model.exception.TeamAlreadyExistException;
import com.jolmos.ticarum.sport.competitions.domain.repository.CompetitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompetitionService {


    private final CompetitionRepository competitionRepository;
    private final TeamService teamService;

    /**
     * Registra una competición.
     * @param competition Competición a registrar.
     * @return Competición registrada.
     */
    public Competition registrar(Competition competition) {
        return this.competitionRepository.save(competition);
    }

    /**
     * Registra equipo en una competición. La competición debe de existir y el equipo no debe de estar registraado
     * previamente en la competición. Si el equipo se registro previamente en otra competición se inscribira ese mismo
     * equipo en la competición que se pasa como parametro.
     * @param competitionId id de la competición en la que se quiere registrar el equipo.
     * @param team equipo que se quiere registrar.
     * @return equipo registrado.
     * @throws CompetitionNotFoundException Si la competición en la que se quiere registrar el equipo no existe.
     * @throws TeamAlreadyExistEsxeption Si el equipo ya estaba registrado en la competición.
     */
    public Team registrarEquipo (Long competitionId, Team team) {
        Optional<Competition> competition = this.competitionRepository.findById(competitionId);
        if (competition.isEmpty()) {
            throw new CompetitionNotFoundException("Competition not found " +  competitionId);
        }
        Optional<Team> storedTeam = this.teamService.findById(team.getId());

        if (!competition.get().addEquipo(storedTeam.isPresent() ? storedTeam.get() : team)){
            throw new TeamAlreadyExistException("Team already exist");
        };
        return this.competitionRepository.save(competition.get()).getEquipos().stream().filter(c->c.getNombre().equals(team.getNombre())).findFirst().get();
    }

}


