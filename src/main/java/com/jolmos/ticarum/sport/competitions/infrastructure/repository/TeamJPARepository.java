package com.jolmos.ticarum.sport.competitions.infrastructure.repository;

import com.jolmos.ticarum.sport.competitions.infrastructure.repository.model.TeamDBO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamJPARepository extends JpaRepository<TeamDBO, Long> {

    List<TeamDBO> findByCompeticionesId(Long competitionId);
}
