package com.jolmos.ticarum.sport.competitions.aplication.usecase;

import com.jolmos.ticarum.sport.competitions.domain.model.Team;
import com.jolmos.ticarum.sport.competitions.domain.service.CompetitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegistrarEquipoUseCase {

    private final CompetitionService competitionService;

    public Team execute(Team team, Long competitionId) {
        return this.competitionService.registrarEquipo(competitionId, team);
    }
}
