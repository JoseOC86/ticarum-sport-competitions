package com.jolmos.ticarum.sport.competitions.aplication.usecase;

import com.jolmos.ticarum.sport.competitions.domain.model.Competicion;
import com.jolmos.ticarum.sport.competitions.domain.service.CompetitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegistrarCompeticionUseCase {

    private final CompetitionService competitionService;

    public Competicion execute(Competicion competicion) {
        return this.competitionService.registrar(competicion);
    }
}
