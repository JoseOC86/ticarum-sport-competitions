package com.jolmos.ticarum.sport.competitions.infrastructure.repository;

import com.jolmos.ticarum.sport.competitions.domain.model.Competition;
import com.jolmos.ticarum.sport.competitions.domain.repository.CompetitionRepository;
import com.jolmos.ticarum.sport.competitions.infrastructure.repository.mapper.CompeticionDBOMapper;
import com.jolmos.ticarum.sport.competitions.infrastructure.repository.model.CompeticionDBO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CompetitionH2Repository implements CompetitionRepository {
    private final CompetitionJPARepository competitionJPARepository;
    private final CompeticionDBOMapper competicionDBOMapper;

    @Override
    public Competition save(Competition competition) {
        CompeticionDBO competitionDBO = this.competitionJPARepository.save(this.competicionDBOMapper.map(competition));
        return this.competicionDBOMapper.map(Optional.of(competitionDBO));
    }

    @Override
    public Optional<Competition> findById(Long id) {
        return Optional.ofNullable(this.competicionDBOMapper.map(this.competitionJPARepository.findById(id)));
    }
}
