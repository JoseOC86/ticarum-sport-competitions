package com.jolmos.ticarum.sport.competitions.domain.repository;

import com.jolmos.ticarum.sport.competitions.domain.model.Team;

import java.util.Optional;
import java.util.Set;

public interface TeamRepository {

    Optional<Team> findById(Long teamId);

    Set<Team> findByCompeticiones(Long competitionId);
}
