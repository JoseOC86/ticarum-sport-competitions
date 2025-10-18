package com.jolmos.ticarum.sport.competitions.infrastructure.repository;

import com.jolmos.ticarum.sport.competitions.infrastructure.repository.model.TeamDBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamJPARepository extends JpaRepository<TeamDBO, Long> {
}
