package com.jolmos.ticarum.sport.competitions.infrastructure.repository;

import com.jolmos.ticarum.sport.competitions.domain.model.Team;
import com.jolmos.ticarum.sport.competitions.domain.repository.TeamRepository;
import com.jolmos.ticarum.sport.competitions.infrastructure.repository.mapper.EquipoDBOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TeamH2Repository implements TeamRepository {
    private final TeamJPARepository teamJPARepository;
    private final EquipoDBOMapper equipoDBOMapper;

    @Override
    public Optional<Team> findById(Long id) {
        return Optional.ofNullable(this.equipoDBOMapper.map(this.teamJPARepository.findById(id).get()));
    }
}
