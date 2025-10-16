package com.jolmos.ticarum.sport.competitions.infrastructure.repository;

import com.jolmos.ticarum.sport.competitions.domain.model.Competicion;
import com.jolmos.ticarum.sport.competitions.domain.repository.CompetitionRepository;
import com.jolmos.ticarum.sport.competitions.infrastructure.repository.mapper.CompeticionDBOMapper;
import com.jolmos.ticarum.sport.competitions.infrastructure.repository.model.CompeticionDBO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CompetitionH2Repository implements CompetitionRepository {
    private final CompetitionJPARepository competitionJPARepository;
    private final CompeticionDBOMapper competicionDBOMapper;

    @Override
    public Competicion save(Competicion competicion) {
        CompeticionDBO competitionDBO = this.competitionJPARepository.save(this.competicionDBOMapper.map(competicion));
        return this.competicionDBOMapper.map(competitionDBO);
    }
}
