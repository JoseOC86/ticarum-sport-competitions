package com.jolmos.ticarum.sport.competitions.aplication.usecase;

import com.jolmos.ticarum.sport.competitions.domain.model.Competition;
import com.jolmos.ticarum.sport.competitions.domain.model.Team;
import com.jolmos.ticarum.sport.competitions.domain.repository.CompetitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegistrarEquipoUseCase {

    private final CompetitionRepository competitionRepository;

    public Team execute(Team team, Long competitionId) {
        Competition competition = this.competitionRepository.findById(competitionId);
        competition.addEquipo(team);
        return this.competitionRepository.save(competition).getEquipos().stream().filter(c->c.getNombre().equals(team.getNombre())).findFirst().get();
    }
}
