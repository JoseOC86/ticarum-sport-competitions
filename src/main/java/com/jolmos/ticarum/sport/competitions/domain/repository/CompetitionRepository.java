package com.jolmos.ticarum.sport.competitions.domain.repository;

import com.jolmos.ticarum.sport.competitions.domain.model.Competition;

public interface CompetitionRepository {

    Competition save(Competition competition);

}
