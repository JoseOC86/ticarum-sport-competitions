package com.jolmos.ticarum.sport.competitions.aplication.usecase;

import com.jolmos.ticarum.sport.competitions.domain.model.Competition;
import com.jolmos.ticarum.sport.competitions.domain.service.CompetitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegistrarCompeticionUseCase {

    private final CompetitionService competitionService;

    public Competition execute(Competition competition) {
        return this.competitionService.registrar(competition);
    }
}
