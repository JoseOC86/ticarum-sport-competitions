package com.jolmos.ticarum.sport.competitions.infrastructure.repository;

import com.jolmos.ticarum.sport.competitions.infrastructure.repository.model.CompeticionDBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionJPARepository extends JpaRepository<CompeticionDBO, Long> {
}
