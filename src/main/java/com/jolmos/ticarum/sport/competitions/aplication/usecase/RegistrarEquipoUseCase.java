package com.jolmos.ticarum.sport.competitions.aplication.usecase;

import com.jolmos.ticarum.sport.competitions.domain.model.Team;
import com.jolmos.ticarum.sport.competitions.domain.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegistrarEquipoUseCase {
    private final TeamRepository teamRepository;

    public Team execute(Team team) {
        return teamRepository.save(team);
    }
}
