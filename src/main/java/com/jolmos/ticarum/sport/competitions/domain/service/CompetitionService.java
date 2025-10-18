package com.jolmos.ticarum.sport.competitions.domain.service;

import com.jolmos.ticarum.sport.competitions.domain.model.Competition;
import com.jolmos.ticarum.sport.competitions.domain.model.Team;
import com.jolmos.ticarum.sport.competitions.domain.model.exception.CompetitionNotFoundException;
import com.jolmos.ticarum.sport.competitions.domain.model.exception.TeamAlreadyExist;
import com.jolmos.ticarum.sport.competitions.domain.repository.CompetitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompetitionService {


    private final CompetitionRepository competitionRepository;
    private final TeamService teamService;

    public Competition registrar(Competition competition) {
        return this.competitionRepository.save(competition);
    }

    public Team registrarEquipo (Long competitionId, Team team) {
        Optional<Competition> competition = this.competitionRepository.findById(competitionId);
        if (competition.isEmpty()) {
            throw new CompetitionNotFoundException("Competition not found " +  competitionId);
        }
        Optional<Team> storedTeam = this.teamService.findById(team.getId());

        if (!competition.get().addEquipo(storedTeam.isPresent() ? storedTeam.get() : team)){
            throw new TeamAlreadyExist("Team already exist");
        };
        return this.competitionRepository.save(competition.get()).getEquipos().stream().filter(c->c.getNombre().equals(team.getNombre())).findFirst().get();
    }

}


