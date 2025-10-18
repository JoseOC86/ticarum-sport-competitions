package com.jolmos.ticarum.sport.competitions.domain.repository;

import com.jolmos.ticarum.sport.competitions.domain.model.Competition;

import java.util.Optional;

public interface CompetitionRepository {

    Competition save(Competition competition);

    Optional<Competition> findById(Long id);

}
